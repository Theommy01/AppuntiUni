package it.omarkiarafederico.skitracker.view.skimap

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.text.method.LinkMovementMethod
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import it.omarkiarafederico.skitracker.R
import model.Pista
import roomdb.RoomHelper

class InfoPisteFragment : Fragment() {
    private var myViewModel: SkiMapViewModel? = null
    private lateinit var recyclerView: RecyclerView
    private lateinit var pisteItemList: ArrayList<PistaItem>
    private lateinit var pistaAdapter: PistaAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // metodo padre
        super.onCreate(savedInstanceState)

        // impostazione ViewModel
        myViewModel = activity?.let { ViewModelProvider(it)[SkiMapViewModel::class.java]}

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_info_piste, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val skiArea = this.myViewModel?.getSkiArea()

        val titolo: TextView = view.findViewById(R.id.titolo)
        val numPiste: TextView = view.findViewById(R.id.numPiste)
        val impiantiRisalita: TextView = view.findViewById(R.id.impiantiRisalita)
        val max: TextView = view.findViewById(R.id.altMax)
        val min: TextView = view.findViewById(R.id.altMin)
        val sito: TextView = view.findViewById(R.id.website)

        val url = skiArea?.getWebSite()

        if (skiArea != null) {
            titolo.text = skiArea.getNome()
            numPiste.text = "${skiArea.getNumPiste()}"
            impiantiRisalita.text = "${skiArea.getNumImpianti()}"
            max.text = getString(R.string.altitude).format(skiArea.getMaxAlt())
            min.text = getString(R.string.altitude).format(skiArea.getMinAlt())
        }

        //aggiungo link al sito
        sito.movementMethod = LinkMovementMethod.getInstance()
        sito.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(intent)
        }


        //Personalizzo la scritta che indica se quel comprensorio è aperto o chiuso
        val stato = view.findViewById<TextView>(R.id.stato)
        val aperto = skiArea?.isOperativo()

        if (aperto == true) {
            stato.text = getString(R.string.skiAreaOpen)
            context?.let { ContextCompat.getColor(it, R.color.comprensorioAperto) }
                ?.let { stato.setBackgroundColor(it) }
        } else {
            stato.text = getString(R.string.skiAreaClose)
            context?.let { ContextCompat.getColor(it, R.color.comprensorioChiuso) }
                ?.let { stato.setBackgroundColor(it) }
        }

        //gestisco le scritte snowpark e piste notturne

        val snowpark = view.findViewById<TextView>(R.id.snowpark)
        val night = view.findViewById<TextView>(R.id.piste_notturne)

        val showsnow = skiArea?.getSnowPark()
        val shownight = skiArea?.getNight()

        if (showsnow == true) {
            snowpark.visibility = View.VISIBLE
        } else {
            snowpark.visibility = View.GONE
        }

        if (shownight == true) {
            night.visibility = View.VISIBLE
        } else {
            night.visibility = View.GONE
        }


        //ELENCO PISTE DISPONIBILI. Con RecyclerView.
        lateinit var listaPiste: List<roomdb.Pista>
        pisteItemList = ArrayList()

        recyclerView = view.findViewById(R.id.piste_recycler_view)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(context)

        // ottengo la lista delle piste del comprensorio dal database

        val dbConnection = RoomHelper().getDatabaseObject(requireActivity())
        if (skiArea != null) {
            listaPiste = dbConnection.localDatabaseDao().getSkiAreaPiste(skiArea.getId())
        }

        // aggiungo i comprensori ottenuti alla lista da visualizzare con la RecyclerView
        for (pistaFromDb in listaPiste) {
            val pista = Pista(pistaFromDb, requireContext())
            pisteItemList.add(PistaItem(pista.getNome(), pista.getDifficolta(), pista.getId()))
        }

        // creo l'Adapter per la RecyclerView
        pistaAdapter = PistaAdapter(pisteItemList, requireContext())
        recyclerView.adapter = pistaAdapter
    }
}