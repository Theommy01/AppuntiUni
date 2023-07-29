package it.omarkiarafederico.skitracker

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import it.omarkiarafederico.skitracker.view.routeTracking.RouteTrackingActivity
import it.omarkiarafederico.skitracker.view.skimap.InfoPisteFragment
import it.omarkiarafederico.skitracker.view.skimap.MapActivity
import it.omarkiarafederico.skitracker.view.skimap.MappaFragment
import androidx.fragment.app.testing.launchFragmentInContainer
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */

private lateinit var activityScenario: ActivityScenario<MapActivity>


@RunWith(AndroidJUnit4::class)
class MyTest {

    @get:Rule
    val activityTestRule = ActivityTestRule(MapActivity::class.java)

    @Test
    fun testFragmentChange() { // Testa il cambio di Fragment cliccando sulla Bottom Navigation Bar
        val fragmentManager: FragmentManager = getActivity()?.supportFragmentManager
            ?: throw IllegalStateException("FragmentManager is null")

        val currentFragment = getCurrentFragment(fragmentManager)
        val newFragment = InfoPisteFragment()


        // Esegui la transazione del Fragment
        fragmentManager.beginTransaction()
            .replace(R.id.mappaFragment, newFragment)
            .addToBackStack(null)
            .commit()
    }

    private fun getActivity(): FragmentActivity? {
        return activityTestRule.activity
    }

    private fun getCurrentFragment(fragmentManager: FragmentManager): Fragment? {
        return fragmentManager.findFragmentById(R.id.mappaFragment)
    }

    @Before
    fun setup() {
        activityScenario = ActivityScenario.launch(MapActivity::class.java)
    }

    @Test
    fun fabClicTest() { //Test per verificare il corretto passaggio all'Activity di tracciamento
        // Avvia il fragment in un contenitore
        val scenario = launchFragmentInContainer<MappaFragment>()

        // Simula un clic sul FAB
        onView(withId(R.id.addRecordFAB)).perform(click())

        // Verifica che la navigazione sia avvenuta correttamente utilizzando un Intent
        activityScenario.onActivity { activity ->
            val intent = activity.intent
            assertEquals(RouteTrackingActivity::class.java.name, intent.component?.className)
        }

    }

}
