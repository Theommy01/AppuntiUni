package model

import android.content.Context
import androidx.room.Room
import roomdb.Comprensorio
import roomdb.LocalDB
import java.io.Serializable

class Comprensorio(private var id: Int, name: String): Serializable{
    private var nome:String = name

    private var aperto:Boolean = false
    private var website:String = ""

    private var numPiste:Int = 0
    private var numImpianti:Int = 0

    private var presenteSnowpark:Boolean = false
    private var presentiPisteNotturne:Boolean = false

    private var latitudine: Double = 0.0
    private var longitudine: Double = 0.0

    private var minAltitudine: Int = 0
    private var maxAltitudine: Int = 0

    private var zoom: Int = 16
    private var listaPiste = ArrayList<Pista>()

    constructor(skiAreaFromDb: Comprensorio) : this(skiAreaFromDb.id, skiAreaFromDb.nome) {
        this.aperto = skiAreaFromDb.aperto
        this.website = skiAreaFromDb.website
        this.numPiste = skiAreaFromDb.numPiste
        this.numImpianti = skiAreaFromDb.numImpianti
        this.presenteSnowpark = skiAreaFromDb.snowpark
        this.presentiPisteNotturne = skiAreaFromDb.pisteNotturne
        this.latitudine = skiAreaFromDb.lat
        this.longitudine = skiAreaFromDb.long
        this.minAltitudine = skiAreaFromDb.minAltitudine
        this.maxAltitudine = skiAreaFromDb.maxAltitudine
        this.zoom = skiAreaFromDb.zoom
    }

    fun getId(): Int {
        return this.id
    }

    fun getNome(): String {
        return this.nome
    }

    fun getNumPiste(): Int {
        return this.numPiste
    }

    fun getNumImpianti(): Int {
        return this.numImpianti
    }

    fun getMinAlt(): Int {
        return this.minAltitudine
    }

    fun getMaxAlt(): Int {
        return this.maxAltitudine
    }

    fun getWebSite(): String {
        return this.website
    }

    fun getSnowPark(): Boolean {
        return this.presenteSnowpark
    }

    fun getNight(): Boolean {
        return this.presentiPisteNotturne
    }

    fun isOperativo(): Boolean {
        return this.aperto
    }

    fun getLatitudine(): Double {
        return this.latitudine
    }

    fun getLongitudine(): Double {
        return this.longitudine
    }

    fun getZoomLevel(): Int {
        return this.zoom
    }

    fun getListaPiste(): ArrayList<Pista> {
        return this.listaPiste
    }

    fun getPistaById(id: Int): Pista? {
        return this.listaPiste.find { it.getId() == id }
    }

    fun convertToEntityClass(): Comprensorio {
        return Comprensorio(this.id, this.nome, this.aperto, this.numPiste, this.numImpianti,
            this.website, this.presenteSnowpark, this.presentiPisteNotturne, this.latitudine,
            this.longitudine, this.maxAltitudine, this.minAltitudine, this.zoom)
    }

    fun diminiusciZoom() {
        if (this.zoom > 1)
            this.zoom -= 1
    }

    fun aumentaZoom() {
        if (this.zoom < 18)
            this.zoom += 1
    }

    fun updateZoom(appContext: Context) {
        val db = Room.databaseBuilder(appContext, LocalDB::class.java, "LocalDatabase")
            .allowMainThreadQueries().build()
        db.localDatabaseDao().updateZoomLevel(this.zoom, this.id)
    }

    fun setListaPiste(lista: ArrayList<roomdb.Pista>, context: Context) {
        for (pistaDB in lista) {
            val pistaDaAggiungere = Pista(pistaDB, context)
            this.listaPiste.add(pistaDaAggiungere)
        }
    }

    override fun toString(): String {
        return this.getNome()
    }
}