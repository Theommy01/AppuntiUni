package it.omarkiarafederico.skitracker.view.tutorial

import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import androidx.appcompat.app.AppCompatActivity
import it.omarkiarafederico.skitracker.R
import it.omarkiarafederico.skitracker.view.selezionecomprensorio.SelezioneComprensorio
import roomdb.RoomHelper
import roomdb.Utente

class WelcomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        // nascondo la titleBar (che sarebbe posta in alto)
        // (notare il "?", che viene messo per evitare che il programma crashi nel caso la
        // title bar non dovesse essere presente e si avrebbe quindi una NullPointerException)
        supportActionBar?.hide()
    }

    fun finishTutorial() {
        // svuoto il back stack, in modo tale che se premo indietro non ritorno al tutorial
        this.finishAffinity()

        // scrivo sul database le info sull'utente locale che sta eseguendo l'app (id del
        // telefono e il fatto che abbia già visto il tutorial)
        val db = RoomHelper().getDatabaseObject(applicationContext)

        val intent = Intent(this, SelezioneComprensorio::class.java)
        val phoneId = Settings.Secure.getString(this.contentResolver, Settings.Secure.ANDROID_ID)

        db.localDatabaseDao().insertNewLocalUserInfo(Utente(phoneId, true, null))

        startActivity(intent)
    }
}