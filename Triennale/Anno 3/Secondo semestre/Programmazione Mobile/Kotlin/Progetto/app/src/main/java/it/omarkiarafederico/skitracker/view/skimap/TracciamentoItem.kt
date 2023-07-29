package it.omarkiarafederico.skitracker.view.skimap

import java.time.LocalDateTime

data class TracciamentoItem(
    val nome: String, val difficolta: String, val velocitaMedia: Int,
    val durata: String, val lunghezza: Int, val dislivello: Int,
    val dataOra: LocalDateTime)
