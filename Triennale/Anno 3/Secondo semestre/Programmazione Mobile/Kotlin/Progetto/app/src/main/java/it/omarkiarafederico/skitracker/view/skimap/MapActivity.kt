package it.omarkiarafederico.skitracker.view.skimap

import android.Manifest
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room
import com.google.android.material.navigation.NavigationView
import it.omarkiarafederico.skitracker.R
import it.omarkiarafederico.skitracker.databinding.ActivityMapBinding
import it.omarkiarafederico.skitracker.view.selezionecomprensorio.SelezioneComprensorio
import it.omarkiarafederico.skitracker.view.tutorial.WelcomeActivity
import model.Comprensorio
import roomdb.LocalDB
import roomdb.Pista
import roomdb.RoomHelper
import java.lang.NullPointerException


class MapActivity : AppCompatActivity() {
    private var myViewModel: SkiMapViewModel? = null
    private lateinit var binding: ActivityMapBinding
    private lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        // creazione activity
        super.onCreate(savedInstanceState)
        binding = ActivityMapBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // ottenimento riferimento al viewModel
        myViewModel = this.let { ViewModelProvider(it)[SkiMapViewModel::class.java]}

        // controllo se l'utente ha già visto il tutorial e/o ha già selezionato il comprensorio
        // se non ha fatto almeno una delle due cose, lo redirigo alle varie activities
        val db = RoomHelper().getDatabaseObject(this.applicationContext)
        var intent: Intent? = null

        // controllo se il tutorial è stato completato e se il comprensorio è stato scelto
        if (db.localDatabaseDao().isTutorialCompletato() != 1)
            intent = Intent(this.applicationContext, WelcomeActivity::class.java)
        else if (db.localDatabaseDao().getIdComprensorio() == null)
            intent = Intent(this.applicationContext, SelezioneComprensorio::class.java)

        // se necessario, apro la activity che serve
        if (intent != null) {
            // svuoto il back stack per evitare bug
            finishAffinity()
            // avvio la activity che serve
            startActivity(intent)
        }

        // vado a controllare se ci sono i permessi per poter accedere al GPS. se non ci sono, li
        // vado a richiedere.
        val locationPermissionRequest = registerForActivityResult(
            ActivityResultContracts.RequestMultiplePermissions()
        ) { permissions ->
            when {
                permissions.getOrDefault(Manifest.permission.ACCESS_FINE_LOCATION, false) -> {
                    Log.i("SkiTracker GPS Location", "Fine Location Allowed")
                }
                permissions.getOrDefault(Manifest.permission.ACCESS_COARSE_LOCATION, false) -> {
                    Log.i("SkiTracker GPS Location", "Coarse Location Allowed")
                } else -> {
                    Log.w("SkiTracker GPS Location", "User denied GPS access authorization")
                }
            }
        }
        Log.i("SkiTracker GPS Location", "Trying to get GPS location.")
        locationPermissionRequest.launch(arrayOf(
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_COARSE_LOCATION))

        // questi sono i miei fragment
        val mapFragment = MappaFragment()
        val infoFragment = InfoPisteFragment()
        val historyFragment = CronologiaFragment()

        // vado a popolare il comprensorio selezionato dall'utente con cui avrà a che fare l'intero
        // programma
        // NOTA: aggiungo un try per evitare un bug che causa il crash immediato dell'app in alcuni
        // casi sporadici
        try {
            setSelectedSkiArea()
        } catch (_: NullPointerException) {}

        // visualizzo il fragment della mappa, che è quello di default
        replaceFragment(mapFragment, "map")

        // implemento la navigazione tra fragment con i bottoni nel bottomNavigationBar
        binding.bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.bottomNavMapItem -> replaceFragment(mapFragment, "map")
                R.id.bottomNavInformationItem -> replaceFragment(infoFragment, "info")
                R.id.bottomNavHistoryItem -> replaceFragment(historyFragment, "history")
                else -> {}
            }
            true
        }

        // Creazione e configurazione hamburger menù
        val drawerLayout: DrawerLayout = findViewById(R.id.homeActivity)
        val navView: NavigationView = findViewById(R.id.nav_view)

        toggle = ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close)
        toggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        navView.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.zoom_regulation_item -> {
                    val mapFragment: MappaFragment = supportFragmentManager.findFragmentByTag("map") as MappaFragment
                    mapFragment.zoomRegulation()
                }
                R.id.change_skiarea_item -> {
                    val intent = Intent(this, SelezioneComprensorio::class.java)
                    startActivity(intent)
                }
                R.id.about_us_item -> {
                    val intent = Intent(this, AboutUsActivity::class.java)
                    startActivity(intent)
                }
            }
            true
        }
    }

    // configurazione funzioni del menù a tendina
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    // funzione per il cambio di fragment dopo i click su bottom navigation bar
    // basato sull'uso del FragmentManager
    private fun replaceFragment(fragmentDaVisualizzare: Fragment, tag: String) {
        val fragmentManager: FragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()

        val fragmentPrecedente = fragmentManager.findFragmentByTag(this.myViewModel?.getSelectedFragmentTag())

        if (fragmentManager.findFragmentByTag(tag) == null) {
            fragmentTransaction.add(R.id.frame_layout, fragmentDaVisualizzare, tag)
        } else {
            if (fragmentPrecedente != null) {
                fragmentTransaction.hide(fragmentPrecedente)
                fragmentTransaction.show(fragmentDaVisualizzare)
            }
        }

        this.myViewModel?.updateSelectedFragmentTag(tag)
        this.setActivityTitle(tag)
        fragmentTransaction.commit()
    }

    // questa funzione va ad impostare il Comprensorio che l'utente ha selezionato.
    private fun setSelectedSkiArea() {
        // ottengo l'id del comprensorio selezionato dall'utente.
        val db = Room.databaseBuilder(applicationContext, LocalDB::class.java, "LocalDatabase")
            .allowMainThreadQueries().build()
        val selectedSkiAreaId = db.localDatabaseDao().getIdComprensorio()

        if (selectedSkiAreaId != null) {
            // ottengo i dettagli del comprensorio
            val skiAreaFromDb: roomdb.Comprensorio = db.localDatabaseDao()
                .getDettagliComprensorio(selectedSkiAreaId)

            // ottengo le piste del comprensorio
            val skiAreaPisteList = db.localDatabaseDao().getSkiAreaPiste(skiAreaFromDb.id)

            // vado a popolare l'oggetto comprensorio con i dettagli ottenuti dal db
            val skiArea = Comprensorio(skiAreaFromDb)
            skiArea.setListaPiste(skiAreaPisteList as ArrayList<Pista>, applicationContext)

            this.myViewModel?.setSkiArea(skiArea)
            supportActionBar?.subtitle = "${skiArea.getNome()}, IT"
        }
    }

    // imposta il titolo dell'activity
    private fun setActivityTitle(tag: String) {
        var title = ""
        var subtitle = ""
        val skiArea = this.myViewModel?.getSkiArea()

        if (skiArea != null) {
            if (tag == "map") {
                title = getString(R.string.app_name)
                subtitle = "${skiArea.getNome()}, IT"
            } else if (tag == "info") {
                title = getString(R.string.infoPisteFragmentTitle)
                subtitle = "${skiArea.getNome()}, IT"
            } else if (tag == "history") {
                title = getString(R.string.historyFragmentTitle)
                subtitle = ""
            }
        }

        this.supportActionBar?.title = title
        this.supportActionBar?.subtitle = subtitle
    }
}