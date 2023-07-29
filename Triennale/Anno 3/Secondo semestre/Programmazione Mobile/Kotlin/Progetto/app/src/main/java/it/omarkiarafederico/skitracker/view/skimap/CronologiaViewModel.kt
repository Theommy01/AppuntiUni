package it.omarkiarafederico.skitracker.view.skimap

import androidx.lifecycle.ViewModel
import model.Comprensorio
import model.Tracciamento
import java.time.LocalDateTime
import kotlin.math.roundToInt

class CronologiaViewModel: ViewModel() {
    private var selectedSkiAreaID: Int = 0
    private val listaComprensori = ArrayList<Comprensorio>()
    private var listaTracciamenti = ArrayList<Tracciamento>()

    fun setListaComprensori(listaFromDb: List<roomdb.Comprensorio>) {
        for (skiArea in listaFromDb)
            this.listaComprensori.add(Comprensorio(skiArea))
    }

    fun setListaTracciamenti(lista: List<Tracciamento>) {
        this.listaTracciamenti = lista as ArrayList<Tracciamento>
    }

    fun getListaComprensori(): ArrayList<Comprensorio> {
        return this.listaComprensori
    }

    fun setSelectedSkiAreaID(id: Int) {
        this.selectedSkiAreaID = id
    }

    fun prepareTracciamentiForRecyclerView(): ArrayList<TracciamentoItem> {
        val itemList = ArrayList<TracciamentoItem>()

        for (tracciamento in this.listaTracciamenti)
            itemList.add(
                TracciamentoItem(tracciamento.pistaNome, tracciamento.pistaDifficolta,
                tracciamento.velocita.roundToInt(), tracciamento.getDurationString(), tracciamento.distanza.roundToInt(),
                tracciamento.dislivello, LocalDateTime.now())
            )

        return itemList
    }
}