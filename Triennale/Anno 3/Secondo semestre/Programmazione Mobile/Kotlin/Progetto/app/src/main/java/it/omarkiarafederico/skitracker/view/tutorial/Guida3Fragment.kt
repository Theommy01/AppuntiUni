package it.omarkiarafederico.skitracker.view.tutorial

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import it.omarkiarafederico.skitracker.R

class Guida3Fragment : Fragment() {
    private lateinit var activity: WelcomeActivity
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activity = this.getActivity() as WelcomeActivity
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_guida3, container, false)

        val startBtn = view.findViewById<Button>(R.id.thirdTutorialStartBtn)
        val prevBtn = view.findViewById<Button>(R.id.thirdTutorialBtnBack)

        startBtn.setOnClickListener{
            this.activity.finishTutorial()
        }

        prevBtn.setOnClickListener{
            // se è presente un fragment all'interno del back stack, lo vado a recuperare,
            // sostituendolo a quello corrente e togliendolo dal back stack.
            val fragmentManager = activity.supportFragmentManager
            if (fragmentManager.backStackEntryCount > 0) {
                fragmentManager.popBackStack()
            }
        }

        return view
    }
}