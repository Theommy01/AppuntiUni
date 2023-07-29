package it.omarkiarafederico.skitracker

import android.content.Intent
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import it.omarkiarafederico.skitracker.view.skimap.AboutUsActivity
import it.omarkiarafederico.skitracker.view.skimap.MapActivity
import org.junit.After
import org.junit.Test
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.Intents.intended
import androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent
import org.junit.Assert

import org.junit.Assert.*
import org.junit.Before
import org.junit.runner.RunWith
import roomdb.LocalDB
import roomdb.LocalDatabaseDao
import roomdb.Pista
import roomdb.RoomHelper
import roomdb.Utente

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }
}

@RunWith(AndroidJUnit4::class)
class MyActivityTest {


    lateinit var roomDB: LocalDB
    lateinit var roomDAO: LocalDatabaseDao

    @Before
    fun setUp() {
        roomDB =  Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            LocalDB::class.java
        ).allowMainThreadQueries().build()
        roomDAO = roomDB.localDatabaseDao()

    }

    @Test
    fun testPistaInComprensorio() {
        val pista = Pista(1, "Belladonna", "Medio", 9)
        assertEquals(pista.idComprensorio, 9)
    }

    @Test
    fun testTutorialCompletato() {
        val utente = Utente("id", true , 9)
        assertEquals(utente.tutorialCompletato, true)
    }

    @After
    fun tearDown() {
        roomDB.close()
    }

}

