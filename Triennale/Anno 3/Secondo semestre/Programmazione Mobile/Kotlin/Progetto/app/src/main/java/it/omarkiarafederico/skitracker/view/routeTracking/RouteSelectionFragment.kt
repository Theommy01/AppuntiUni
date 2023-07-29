package it.omarkiarafederico.skitracker.view.routeTracking

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import it.omarkiarafederico.skitracker.R
import it.omarkiarafederico.skitracker.view.skimap.PistaAdapter
import it.omarkiarafederico.skitracker.view.skimap.PistaItem
import utility.ALERT_INFO
import utility.ApplicationDialog

class RouteSelectionFragment : Fragment() {
    private var myViewModel: TrackingViewModel? = null

    private lateinit var recyclerView: RecyclerView
    private lateinit var pistaAdapter: PistaAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // ottengo il riferimento al viewmodel
        myViewModel = activity?.let {
            ViewModelProvider(it)[TrackingViewModel::class.java]
        }

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_route_selection, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        // esecuzione del metodo padre
        super.onViewCreated(view, savedInstanceState)

        // impostazione della recyclerview
        recyclerView = view.findViewById(R.id.trackingPistaSelectionRecyclerView)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this.requireContext())

        // vado a popolare la lista delle piste da visualizzare nella recyclerview
        val skiArea = myViewModel?.getComprensorio()
        val pisteItemList = ArrayList<PistaItem>()
        if (skiArea != null) {
            for (pistaItem in skiArea.getListaPiste())
                pisteItemList.add(PistaItem(pistaItem.getNome(), pistaItem.getDifficolta(), pistaItem.getId()))
        }

        // preparo l'adapter e visualizzo a schermo la recyclerview
        pistaAdapter = PistaAdapter(pisteItemList, requireContext())
        recyclerView.adapter = pistaAdapter

        // cosa succede se clicco su un elemento
        pistaAdapter.onItemClick = {
            val selectedPista = skiArea?.getPistaById(it.id)
            if (selectedPista != null) {
                // questa è la pista selezionata, che la vado ad impostare sul viewmodel
                myViewModel?.setPista(selectedPista)

                // avviso all'utente che per far si che il tracciamento vada avanti, non bisogna assolutamente
                // abbandonare l'activity
                ApplicationDialog(requireContext()).openDialog(
                    ALERT_INFO, getString(R.string.trackingStartWarningDialog).format(skiArea.getNome()),
                    requireContext() as AppCompatActivity, false)

                // vado ad aprire il fragment per il tracking della pista
                val fragmentManager = parentFragmentManager
                fragmentManager.commit {
                    replace(R.id.route_sel_fragment_container, TrackingFragment())
                }
            }
        }
    }
}