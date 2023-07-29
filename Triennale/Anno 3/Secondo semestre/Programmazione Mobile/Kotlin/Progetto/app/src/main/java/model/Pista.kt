package model

import android.content.Context
import it.omarkiarafederico.skitracker.R
import roomdb.Pista
import java.io.Serializable

class Pista(private var id: Int, private var nome: String): Serializable {
    private lateinit var difficolta: String

    constructor(pistaFromDb: Pista, context: Context): this(pistaFromDb.id, pistaFromDb.nome) {
        when(pistaFromDb.difficolta) {
            "easy" -> this.difficolta = context.getString(R.string.pistaFacile)
            "intermediate" -> this.difficolta = context.getString(R.string.pistaMedia)
            "advanced" -> this.difficolta = context.getString(R.string.pistaDifficile)
            "novice" -> this.difficolta = context.getString(R.string.pistaNovizio)
        }
    }

    fun getNome(): String {
        return this.nome
    }

    fun getDifficolta(): String {
        return this.difficolta
    }

    fun getId(): Int {
        return this.id
    }
}