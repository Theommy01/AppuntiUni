package it.omarkiarafederico.skitracker.view.routeTracking

import android.annotation.SuppressLint
import android.content.Context.LOCATION_SERVICE
import android.content.Intent
import android.location.Location
import android.location.LocationManager
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.SystemClock
import android.provider.Settings
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Chronometer
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import it.omarkiarafederico.skitracker.R
import it.omarkiarafederico.skitracker.view.skimap.MapActivity
import model.Pista
import org.osmdroid.util.GeoPoint
import org.osmdroid.views.CustomZoomButtonsController
import org.osmdroid.views.MapView
import org.osmdroid.views.overlay.mylocation.GpsMyLocationProvider
import org.osmdroid.views.overlay.mylocation.MyLocationNewOverlay
import roomdb.PuntiMappaTracciamenti
import roomdb.RoomHelper
import roomdb.Tracciamento
import utility.ApplicationDialog
import utility.MyLocationListener
import java.time.LocalDateTime
import java.time.ZoneOffset
import kotlin.math.roundToInt

class TrackingFragment : Fragment() {
    private var myViewModel: TrackingViewModel? = null
    private lateinit var selectedPista: Pista

    private lateinit var mapView: MapView
    private lateinit var myLocationOverlay: MyLocationNewOverlay

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // ottengo il riferimento al viewmodel
        myViewModel = activity?.let {
            ViewModelProvider(it)[TrackingViewModel::class.java]
        }

        // preparo l'activity: Metto un titolo diverso e disabilito il tasto Back nella titleBar
        val myActivity = this.activity as RouteTrackingActivity
        myActivity.supportActionBar?.title = getString(R.string.tracciamentoPercorsoTitle)
        myActivity.supportActionBar?.subtitle = ""
        myActivity.supportActionBar?.setDisplayHomeAsUpEnabled(false)

        // eseguo l'inflating del layout sul fragment
        return inflater.inflate(R.layout.fragment_tracking, container, false)
    }

    // NOTA: ho messo questo suppress perchè il controllo dei permessi viene fatto nella home page
    @SuppressLint("MissingPermission")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        // metodo padre
        super.onViewCreated(view, savedInstanceState)

        // ottengo la pista selezionata dal view model
        myViewModel?.let { viewModel ->
            this.selectedPista = viewModel.getPista()
        }

        // mappo i tasti della view
        val stopTrackingButton = view.findViewById<Button>(R.id.trackingFragmentCancelBtn)
        val finishTrackingButton = view.findViewById<Button>(R.id.trackingFragmentEndBtn)
        stopTrackingButton.setOnClickListener {
            this.stopTracking()
        }
        finishTrackingButton.setOnClickListener {
            this.finishTracking()
        }

        // visualizzo nome e difficoltà della pista sul fragment
        val pistaNomeTextView = view.findViewById<TextView>(R.id.trackPistaName)
        val pistaDifficultyTextView = view.findViewById<TextView>(R.id.trackPistaDifficulty)
        pistaNomeTextView.text = this.selectedPista.getNome()
        pistaDifficultyTextView.text = this.selectedPista.getDifficolta()
        this.changeDifficultyIndicatorColor(pistaDifficultyTextView, this.selectedPista.getDifficolta())

        // inizializzazione della mappa
        this.mapView = view.findViewById(R.id.trackingMap)
        mapView.setMultiTouchControls(true)
        mapView.zoomController?.setVisibility(CustomZoomButtonsController.Visibility.NEVER)
        mapView.isTilesScaledToDpi = true

        // creo l'overlay della posizione
        myLocationOverlay = MyLocationNewOverlay(GpsMyLocationProvider(requireContext()), mapView)
        mapView.overlays.add(myLocationOverlay)
        myLocationOverlay.enableMyLocation()

        // ottengo l'ultima posizione nota: se è presente, allora centro la mappa su di questa
        val lastKnownLocation: Location? = myLocationOverlay.lastFix
        if (lastKnownLocation != null) {
            mapView.controller.setCenter(GeoPoint(lastKnownLocation.latitude, lastKnownLocation.longitude))
        } else {
            Toast.makeText(requireContext(), getString(R.string.lookingForGPS), Toast.LENGTH_LONG).show()
        }

        // individuo la posizione in cui giace l'utente: una volta individuata, faccio un po' di cose
        myLocationOverlay.runOnFirstFix {
            // Ottieni le nuove coordinate della posizione
            val newLocation: Location? = myLocationOverlay.lastFix
            val newLatitude: Double = newLocation?.latitude ?: 0.0
            val newLongitude: Double = newLocation?.longitude ?: 0.0

            // Crea un oggetto GeoPoint con le nuove coordinate
            val newPoint = GeoPoint(newLatitude, newLongitude)

            // Aggiorna la posizione della mappa e faccio partire il cronometro in questa
            // area particolare, che permette di modificare gli elementi nella view direttamente dal
            // thread che le ha create
            Handler(Looper.getMainLooper()).post {
                // imposto il punto di partenza nella mappa e mi ci zoommo
                mapView.controller.setCenter(newPoint)
                mapView.controller.animateTo(newPoint, 16.0, 1200)

                // faccio partire il cronometro
                val chrono = view.findViewById<Chronometer>(R.id.trackTime)
                this.myViewModel?.setChrono(chrono)
                chrono.base = SystemClock.elapsedRealtime()
                chrono.start()
            }
        }

        // istanzio il LocationManager, che mi servirà per monitorare il cambiamento della posizione
        // tramite l'uso del MyLocationListener, che viene programmato per intercettare cambiamenti
        // se ci sono spostamenti di almeno 3 metri da un punto ad un altro, per motivi di efficienza
        val locationManager = requireActivity()
            .applicationContext.getSystemService(LOCATION_SERVICE) as LocationManager
        val locationListener = myViewModel?.let { MyLocationListener(mapView, it) }
        if (locationListener != null) {
            locationManager.requestLocationUpdates(
                LocationManager.GPS_PROVIDER,
                0L,
                3f,
                locationListener
            )
        }

        // preparo gli Observers per la velocità e l'altitudine
        myViewModel?.totalDistance?.observe(viewLifecycleOwner) {
            this.updateInstantData(R.id.trackDistance, "${it.roundToInt()} mt", view)
        }
        myViewModel?.instantSpeed?.observe(viewLifecycleOwner) {
            this.updateInstantData(R.id.trackSpeed, "${it.roundToInt()} km/h", view)
        }
    }

    private fun changeDifficultyIndicatorColor(textView: TextView, diff: String) {
        when(diff) {
            getString(R.string.pistaFacile) -> textView.setBackgroundResource(R.color.pistaFacile)
            getString(R.string.pistaMedia) -> textView.setBackgroundResource(R.color.pistaMedia)
            getString(R.string.pistaDifficile) -> textView.setBackgroundResource(R.color.black)
        }
    }

    fun stopTracking() {
        // chiedo all'utente se vuole fermare il tracciamento
        val dialog = ApplicationDialog(requireContext())
        dialog.setListener(object : ApplicationDialog.YesNoDialogListener {
            override fun onYesClicked() {
                requireActivity().finishAffinity()
            }

            override fun onNoClicked() {
                // non fa nulla
            }
        })
        dialog.openYesNoDialog(getString(R.string.stopTrackingDialog), requireContext() as AppCompatActivity)
    }

    private fun updateInstantData(textViewId: Int, value: String, view: View) {
        val textView = view.findViewById<TextView>(textViewId)
        textView.text = value
    }

    private fun finishTracking() {
        // connessione al database
        val dbCon = RoomHelper().getDatabaseObject(requireContext())

        // salvo il tracciamento
        val distanza = this.myViewModel?.getTotalDistance()
        val velocita = this.myViewModel?.getAverageSpeed()?.toFloat()
        val dislivello = this.myViewModel?.getDislivello()?.roundToInt()
        val dataOraInizio = this.myViewModel?.getStartDateTime()?.toEpochSecond(ZoneOffset.UTC)
        val dataOraFine = LocalDateTime.now().toEpochSecond(ZoneOffset.UTC)
        val idPista = this.myViewModel?.getPista()?.getId()
        val userId = Settings.Secure.getString(requireActivity().contentResolver, Settings.Secure.ANDROID_ID)

        val trackForDB = Tracciamento(0, distanza!!, velocita!!, dislivello!!, dataOraInizio!!, dataOraFine, userId, idPista!!)
        val insertedTrackingID = dbCon.localDatabaseDao().insertNewTracciamento(trackForDB)

        // salvo tutti i punti della mappa
        val puntiMappa = this.myViewModel?.convertLocationsToPuntiMappa()
        val puntiMappaIds = puntiMappa?.let { dbCon.localDatabaseDao().insertPuntiMappa(it) }

        // salvo le tuple idTracciamento - idPuntoMappa nell'apposita entità
        if (puntiMappaIds != null) {
            for (puntoId in puntiMappaIds)
                dbCon.localDatabaseDao()
                    .insertPuntoMappaForTrack(PuntiMappaTracciamenti(insertedTrackingID.toInt(), puntoId.toInt(), 0))
        }

        // ritorno all'activity della mappa
        this.activity?.finishAffinity()
        val intent = Intent(requireContext(), MapActivity::class.java)
        startActivity(intent)
    }
}