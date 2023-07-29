package it.omarkiarafederico.skitracker.view.skimap

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import it.omarkiarafederico.skitracker.R
import it.omarkiarafederico.skitracker.view.routeTracking.RouteTrackingActivity
import org.osmdroid.config.Configuration
import org.osmdroid.tileprovider.tilesource.TileSourceFactory
import org.osmdroid.util.GeoPoint
import org.osmdroid.views.CustomZoomButtonsController
import org.osmdroid.views.MapView
import org.osmdroid.views.overlay.ScaleBarOverlay
import org.osmdroid.views.overlay.gestures.RotationGestureOverlay
import org.osmdroid.views.overlay.mylocation.GpsMyLocationProvider
import org.osmdroid.views.overlay.mylocation.MyLocationNewOverlay
import utility.ALERT_ERROR
import utility.ApplicationDialog
import utility.OsmXmlAnalyzer


class MappaFragment : Fragment() {
    private var myViewModel: SkiMapViewModel? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // metodo padre
        super.onCreate(savedInstanceState)

        // impostazione ViewModel
        myViewModel = activity?.let { ViewModelProvider(it)[SkiMapViewModel::class.java]}

        // ritorno il layout
        return inflater.inflate(R.layout.fragment_mappa, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        // metodo padre
        super.onViewCreated(view, savedInstanceState)

        // inizializzazione mappa
        val mySkiArea = this.myViewModel?.getSkiArea()
        val map = getMap()
        if (map != null) {
            map.setTileSource(TileSourceFactory.MAPNIK)
            map.setMultiTouchControls(true)
            map.zoomController?.setVisibility(CustomZoomButtonsController.Visibility.NEVER)
            map.isTilesScaledToDpi = true
        }
        Configuration.getInstance().userAgentValue = "skitracker"

        // aggiungo la possibilità di poter ruotare la mappa con due dita
        val mRotationGestureOverlay = RotationGestureOverlay(map)
        mRotationGestureOverlay.isEnabled = true
        if (map != null) {
            map.overlays?.add(mRotationGestureOverlay)
        }

        // aggiungo la barra della scala della dimensione in km reali nella mappa.
        val scaleBarOverlay = ScaleBarOverlay(map)
        scaleBarOverlay.setCentred(true)
        scaleBarOverlay.setScaleBarOffset(200, 10)
        map?.overlays?.add(scaleBarOverlay)

        // creo un controller della mappa per impostare una posizione iniziale
        if (mySkiArea != null) {
            renderKMLskiArea(mySkiArea.getLatitudine(), mySkiArea.getLongitudine(),
                mySkiArea.getZoomLevel())
        }

        val mapController = map?.controller
        val startPoint = mySkiArea?.let { GeoPoint(it.getLatitudine(), mySkiArea.getLongitudine()) }
        mapController?.setCenter(startPoint)
        mapController?.animateTo(startPoint, 16.0, 1200)

        // gestione del FAB per la geolocalizzazione manuale
        val centerToPositionFAB = view.findViewById<FloatingActionButton>(R.id.getPositionFAB)
        centerToPositionFAB.setOnClickListener {
            // Azione da eseguire quando l'utente preme il pulsante
            val locationOverlay = map?.overlays?.get(map.overlays.lastIndex) as MyLocationNewOverlay

            if (locationOverlay.myLocation == null) {
                Toast.makeText(this.context, getString(R.string.lookingForGPS),
                    Toast.LENGTH_SHORT).show()
                getCurrentLocation()
            }
            else
                mapController?.setCenter(locationOverlay.myLocation)
        }
        // gestione del FAB per la creazione di un nuovo tracciamento di percorso
        val newTrackFAB = view.findViewById<FloatingActionButton>(R.id.addRecordFAB)
        newTrackFAB.setOnClickListener {
            // apro l'activity per il tracciamento
            val trackActivityIntent = Intent(this.activity, RouteTrackingActivity::class.java)
            trackActivityIntent.putExtra("selectedSkiArea", mySkiArea)
            startActivity(trackActivityIntent)
        }

        // uso gli snackbar per chiedere all'utente se si vede tutto nella mappa o bisogna regolare
        // lo zoom
        val snackbar = Snackbar.make(view, getString(R.string.snackBarMapProblems), Snackbar.LENGTH_LONG)
        snackbar.setAction(getString(R.string.zoomRegulationSnackbarButton)) {
            // l'utente ha richiesto di regolare lo zoom della mappa
            this.zoomRegulation()
        }
        snackbar.show()
    }

    // ottiene l'istanza della mappa di OSM presente in questo fragment.
    private fun getMap(): MapView? {
        return view?.findViewById(R.id.trackingMap)
    }

    // quando viene caricata l'activity completamente, viene richiesta la geolocalizzazione.
    @Deprecated("Deprecated in Java")
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        getCurrentLocation()
    }

    // vado ad ottenere le coordinate precise della mia posizione (tramite GPS); una volta ottenute,
    // vado a creare un elemento grafico (overlay) che rappresenta la mia posizione sulla mappa.
    private fun getCurrentLocation() {
        val map = getMap()
        val locationOverlay = MyLocationNewOverlay(GpsMyLocationProvider(context), map)
        locationOverlay.enableMyLocation()

        map?.overlays?.add(locationOverlay)
    }

    // la funzione prende le coordinate del comprensorio e il livello di zoom per ottenere il KML
    // document che contiene i punti del comprensorio e rappresentarlo sulla mappa
    // NOTA: la funzione andrà anche ad aggiungere i comprensori
    private fun renderKMLskiArea(lat: Double, long: Double, zoomLevel: Int) {
        try {
            // ottengo l'osm xml del comprensorio
            val skiAreaOsmXml = SkiAreaFullMap().ottieniXmlMappaComprensorio(lat, long, zoomLevel)

            // ottengo l'overlay dei vari polyline delle piste del comprensorio
            val mapOverlay = OsmXmlAnalyzer().getSkiAreaOverlay(skiAreaOsmXml)

            // le visualizzo nella mappa
            val map = getMap()
            map?.overlays?.add(mapOverlay)
            map?.invalidate()
        } catch (e: Exception) {
            ApplicationDialog(requireContext()).openDialog(ALERT_ERROR, getString(R.string.mapXMLloadingError),
                requireContext() as AppCompatActivity, false)
        }
    }

    // questa funzione permette di regolare lo zoom della mappa.
    fun zoomRegulation() {
        // chiedo all'utente (tramite un dialog) qual'è il problema, quindi se vede troppe piste
        // o ne vede troppo poche
        val mySkiArea = this.myViewModel?.getSkiArea()
        val builder = AlertDialog.Builder(requireContext())
        builder.setTitle(getString(R.string.zoomRegulationDialogTitle))

        val items = arrayOf(getString(R.string.increaseZoomRequest), getString(R.string.decreaseZoomRequest))
        var selectedItem = 0

        builder.setSingleChoiceItems(items, selectedItem) {_, which ->
            selectedItem = which
        }
        builder.setPositiveButton("OK") { _, _ ->
            // l'utente ha fatto la sua scelta, vado a controllare cosa ha scelto
            if (selectedItem == 0) {
                // vado a ridurre lo zoom
                mySkiArea?.diminiusciZoom()
                mySkiArea?.updateZoom(requireContext())
            } else if (selectedItem == 1) {
                // vado ad aumentare lo zoom
                mySkiArea?.aumentaZoom()
                mySkiArea?.updateZoom(requireContext())
            }

            // vado a renderizzare la mappa con lo zoom nuovo
            Log.i("SkiTracker Map Management", "New zoom level for map: ${mySkiArea?.getZoomLevel()}")

            if (mySkiArea != null) {
                renderKMLskiArea(mySkiArea.getLatitudine(), mySkiArea.getLongitudine(),
                    mySkiArea.getZoomLevel())
            }
        }
        builder.setNegativeButton(getString(R.string.cancel)) { _, _ ->
            // non succede nulla
        }

        val dialog = builder.create()
        dialog.show()
    }
}
