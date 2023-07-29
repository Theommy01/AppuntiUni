package it.omarkiarafederico.skitracker.view.skimap

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import it.omarkiarafederico.skitracker.R
import roomdb.RoomHelper

class CronologiaFragment : Fragment() {
    private var myViewModel: CronologiaViewModel? = null
    private lateinit var recyclerView: RecyclerView
    private lateinit var tracciamentoAdapter: TracciamentoAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // ottengo il riferimento al viewmodel
        myViewModel = activity?.let {ViewModelProvider(it)[CronologiaViewModel::class.java]}

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cronologia, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        // metodo padre
        super.onViewCreated(view, savedInstanceState)

        // ottengo la lista dei comprensori disponibili
        val dbCon = RoomHelper().getDatabaseObject(requireContext())
        val skiAreasFromDb = dbCon.localDatabaseDao().getComprensoriConTracciamenti()
        this.myViewModel?.setListaComprensori(skiAreasFromDb)

        // vado ad inserire i comprensori all'interno dello Spinner
        val spinner = view.findViewById<Spinner>(R.id.skiAreaSelectionSpinner)
        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, this.myViewModel!!.getListaComprensori())
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter

        // definisco la recycler view
        recyclerView = view.findViewById(R.id.historyRecyclerView)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        // evento di quando vado a fare click su un elemento dello Spinner
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                // questo è l'elemento selezionato
                val selectedItem = myViewModel!!.getListaComprensori()[position]
                myViewModel!!.setSelectedSkiAreaID(selectedItem.getId())

                // ottengo la lista di registrazioni per questo comprensorio
                val listaTracciamenti = dbCon.localDatabaseDao().getTracciamentiByComprensorio(selectedItem.getId())
                myViewModel!!.setListaTracciamenti(listaTracciamenti)

                // preparo la lista dei TracciamentoItem da visualizzare sul RecyclerView
                val tracciamentiItem = myViewModel!!.prepareTracciamentiForRecyclerView()
                tracciamentoAdapter = TracciamentoAdapter(tracciamentiItem, requireContext())
                recyclerView.adapter = tracciamentoAdapter
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // nessun elemento selezionato!
            }
        }
    }
}