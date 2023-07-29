package it.omarkiarafederico.skitracker.view.tutorial

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.FragmentTransaction
import it.omarkiarafederico.skitracker.R

class Guida1Fragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_guida1, container, false)

        val nextBtn = view.findViewById<Button>(R.id.firstTutorialNextBtn)
        val prevBtn = view.findViewById<Button>(R.id.firstTutorialBackBtn)

        nextBtn.setOnClickListener{
            val fragment = Guida2Fragment()
            val fragmentManager = activity?.supportFragmentManager
            val fragmentTransaction = fragmentManager?.beginTransaction()
            // vado a inserire il fragment corrente nel back stack, in modo tale che posso tornare
            // al passo precedente anche solamente premendo il tasto Back di android
            fragmentTransaction?.addToBackStack("tutorialFragment1")
            // imposto una transizione durante il cambio di fragment
            fragmentTransaction?.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
            // vado a rimpiazzare il fragment corrente (passo 1) con quello nuovo (passo 2)
            fragmentTransaction?.replace(R.id.tutorialFragmentsContainerView, fragment)?.commit()
        }

        prevBtn.setOnClickListener{
            // se è presente un fragment all'interno del back stack, lo vado a recuperare,
            // sostituendolo a quello corrente e togliendolo dal back stack.
            val fragmentManager = activity?.supportFragmentManager
            if (fragmentManager?.backStackEntryCount!! > 0) {
                fragmentManager.popBackStack()
            }
        }

        return view
    }
}