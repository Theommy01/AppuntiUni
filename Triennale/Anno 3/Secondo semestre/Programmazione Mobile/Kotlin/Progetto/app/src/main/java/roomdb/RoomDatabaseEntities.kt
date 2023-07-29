/**************************************************************************************************
 * RoomDatabaseEntities
 * Questo file contiene tutte le entità del database interno all'applicazione, realizzato
 * tramite Android Room, un'implementazione semplificata di SQLite apposita per Android.
 * Tutte le entità presenti all'interno del seguente file sono trattate come delle classi Kotlin.
 *************************************************************************************************/

package roomdb

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

// NOTA: la tabella utente conterrà solamente 1 utente, ovvero quello locale che viene rappresentato
// dall'ID del dispositivo
@Entity(tableName = "Utente",
    foreignKeys = [
        ForeignKey(entity = Comprensorio::class, parentColumns = ["id"],
            childColumns = ["idComprensorio"], onDelete = ForeignKey.SET_NULL, onUpdate = ForeignKey.CASCADE)
    ])
data class Utente(
    @PrimaryKey val id: String,
    val tutorialCompletato: Boolean = false,
    val idComprensorio: Int?
)

@Entity(tableName = "Tracciamento",
    foreignKeys = [
        ForeignKey(entity = Utente::class, parentColumns = ["id"], childColumns = ["idUtente"],
            onDelete = ForeignKey.CASCADE, onUpdate = ForeignKey.CASCADE),
        ForeignKey(entity = Pista::class, parentColumns = ["id"], childColumns = ["idPista"],
            onDelete = ForeignKey.CASCADE, onUpdate = ForeignKey.CASCADE)
    ])
data class Tracciamento (
    @PrimaryKey(autoGenerate = true) val id: Int,
    val distanza: Float,
    val velocita: Float,
    val dislivello: Int,
    val dataOraInizio: Long,
    val dataOraFine: Long,
    val idUtente: String,
    val idPista: Int
)

@Entity(tableName = "Pista",
    foreignKeys = [
        ForeignKey(entity = Comprensorio::class, parentColumns = ["id"], childColumns = ["idComprensorio"],
            onDelete = ForeignKey.CASCADE, onUpdate = ForeignKey.CASCADE)
    ],
    indices = [Index(value = ["nome"], unique = true)]
)
data class Pista (
    @PrimaryKey(autoGenerate = true) val id: Int,
    val nome: String,
    val difficolta: String,
    val idComprensorio: Int
)

// NOTA - in seguito ad errori di compilazione di Gradle, emersi durante lo sviluppo di questo file,
// è stato necessario aggiungere il costruttore vuoto in basso
@Entity(tableName = "Comprensorio")
data class Comprensorio (
    @PrimaryKey(autoGenerate = true) var id: Int,
    var nome: String,
    @ColumnInfo(defaultValue = "0") var aperto: Boolean,
    var numPiste: Int,
    var numImpianti: Int,
    var website: String,
    @ColumnInfo(defaultValue = "0") var snowpark: Boolean,
    @ColumnInfo(defaultValue = "0") var pisteNotturne: Boolean,
    var lat: Double,
    var long: Double,
    var maxAltitudine: Int,
    var minAltitudine: Int,
    @ColumnInfo(defaultValue = "16") var zoom: Int = 16
){
    constructor() : this(0, "", false, 0, 0, "",
        false, false, 0.0, 0.0, 0, 0, 16)
}

@Entity(primaryKeys = ["idTracciamento", "idPuntoMappa"],
    foreignKeys = [
        ForeignKey(entity = Tracciamento::class, parentColumns = ["id"], childColumns = ["idTracciamento"],
            onDelete = ForeignKey.CASCADE, onUpdate = ForeignKey.CASCADE),
        ForeignKey(entity = PuntoMappa::class, parentColumns = ["id"], childColumns = ["idPuntoMappa"],
            onDelete = ForeignKey.CASCADE, onUpdate = ForeignKey.CASCADE),
    ])
data class PuntiMappaTracciamenti (
    val idTracciamento: Int,
    val idPuntoMappa: Int,
    val timestamp: Long
)

@Entity
data class PuntoMappa (
    @PrimaryKey(autoGenerate = true) val id: Int,
    val latitudine: Double,
    val longitudine: Double
)