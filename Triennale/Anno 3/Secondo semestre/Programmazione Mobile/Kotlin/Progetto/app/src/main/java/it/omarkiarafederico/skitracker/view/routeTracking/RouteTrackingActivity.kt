package it.omarkiarafederico.skitracker.view.routeTracking

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import it.omarkiarafederico.skitracker.R
import model.Comprensorio

class RouteTrackingActivity : AppCompatActivity() {
    private lateinit var myViewModel: TrackingViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        // inizializzazione activity
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_route_tracking)

        // imposto il titolo all'activity e metto il tasto Indietro nella TitleBar
        supportActionBar?.title = getString(R.string.tracciamentoSelPistaTitle)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // NOTA: ho utilizzato la versione deprecata del metodo getSerializableExtra perchè in alternativa
        // avrei dovuto mettere come versione minima delle SDK di Android la 13, riducendo drasticamente
        // l'utenza supportata dall'app.
        val mySkiArea = intent.getSerializableExtra("selectedSkiArea") as Comprensorio
        supportActionBar?.subtitle = "${mySkiArea.getNome()}, IT"

        myViewModel = ViewModelProvider(this)[TrackingViewModel::class.java]
        myViewModel.setComprensorio(mySkiArea)
    }

    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        val fragment = supportFragmentManager.findFragmentById(R.id.route_sel_fragment_container)
        if (fragment is TrackingFragment) {
            fragment.stopTracking()
        } else {
            super.onBackPressed()
        }
    }
}