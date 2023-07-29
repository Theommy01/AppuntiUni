package utility

import android.location.Location
import android.location.LocationListener
import android.os.Handler
import android.os.Looper
import it.omarkiarafederico.skitracker.view.routeTracking.TrackingViewModel
import org.osmdroid.util.GeoPoint
import org.osmdroid.views.MapView

class MyLocationListener(private val mapView: MapView, private val viewModel: TrackingViewModel) : LocationListener {
    override fun onLocationChanged(location: Location) {
        // vado ad aggiungere il nuovo punto all'interno dell'array di punti contenuto nel ViewModel
        viewModel.addPointToList(location)

        // creo il punto fatto dalle coordinate della location trovata
        val newPoint = GeoPoint(location.latitude, location.longitude)

        // vado ad impostare i valori istantanei di velocità e distanza sul viewModel
        viewModel.updateSpeed(location.speed)
        viewModel.updateDistance(viewModel.getTotalDistance())
        viewModel.updateAltitudes(location.altitude)

        // Aggiorna la posizione della mappa sul thread principale
        Handler(Looper.getMainLooper()).post {
            mapView.controller.animateTo(newPoint)
        }
    }
}