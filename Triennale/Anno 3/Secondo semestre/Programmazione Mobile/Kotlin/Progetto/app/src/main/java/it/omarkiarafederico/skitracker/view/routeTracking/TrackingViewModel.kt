package it.omarkiarafederico.skitracker.view.routeTracking

import android.location.Location
import android.widget.Chronometer
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import model.Comprensorio
import model.Pista
import roomdb.PuntoMappa
import java.time.LocalDateTime


class TrackingViewModel : ViewModel() {
    private lateinit var mySkiArea: Comprensorio
    private lateinit var myPista: Pista

    private val speedArray = ArrayList<Float>()
    private val altitudesArray = ArrayList<Double>()
    private val pointsArray = ArrayList<Location>()

    var instantSpeed = MutableLiveData(0.0F)
    val totalDistance = MutableLiveData(0.0F)

    private lateinit var chrono: Chronometer
    private val startDateTime = LocalDateTime.now()

    fun setComprensorio(comp: Comprensorio) {
        this.mySkiArea = comp
    }

    fun setPista(pista: Pista) {
        this.myPista = pista
    }

    fun getComprensorio(): Comprensorio {
        return this.mySkiArea
    }

    fun getPista(): Pista {
        return this.myPista
    }

    fun updateSpeed(speed: Float) {
        this.instantSpeed.value = speed
        this.speedArray.add(speed)
    }

    fun updateDistance(distance: Float) {
        this.totalDistance.value = distance
    }

    fun updateAltitudes(altitude: Double) {
        this.altitudesArray.add(altitude)
    }

    fun setChrono(chrono: Chronometer) {
        this.chrono = chrono
    }

    fun addPointToList(p: Location) {
        this.pointsArray.add(p)
    }

    fun getTotalDistance(): Float {
        var distance = 0.0F

        // se l'array è vuoto o c'è solo 1 elemento, la differenza di distanza è 0
        // vado a fare i calcoli solamente se l'array è più grande
        if (this.pointsArray.size > 1) {
            for (i in 0 until pointsArray.size) {
                if (i < this.pointsArray.size - 1)
                    distance = distance.plus(pointsArray[i+1].distanceTo(pointsArray[i]))
            }
        }

        return distance
    }

    fun getStartDateTime(): LocalDateTime? {
        return this.startDateTime
    }

    fun getAverageSpeed(): Double {
        return this.speedArray.average()
    }

    fun getDislivello(): Double {
        return this.altitudesArray.max() - this.altitudesArray.min()
    }

    fun convertLocationsToPuntiMappa(): ArrayList<PuntoMappa> {
        val puntiMappaArray = ArrayList<PuntoMappa>()

        for (location in this.pointsArray)
            puntiMappaArray.add(PuntoMappa(0, location.latitude, location.longitude))

        return puntiMappaArray
    }
}