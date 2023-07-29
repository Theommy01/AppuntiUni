/**************************************************************************************************
 * RoomDAO
 * Questo file contiene l'interfaccia del Data Access Object (DAO), che si occupa dell'interazione
 * con il database fornendo metodi per poterne manipolare i dati contenuti.
 *************************************************************************************************/

package roomdb

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query


@Dao
interface LocalDatabaseDao {
    // prende in input l'oggetto di tipo Utente (tipo di dato definito nelle entità del database)
    // e lo inserisce
    @Insert(entity = Utente::class)
    fun insertNewLocalUserInfo(user: Utente)

    // ottiene unicamente il valore "tutorialCompletato": se questo è true (1), l'utente ha già
    // seguito il tutorial; in caso negativo, l'utente dovrà consultare il tutorial prima di usare
    // l'app
    @Query("SELECT tutorialCompletato FROM Utente")
    fun isTutorialCompletato(): Int

    // ottiene l'ID del comprensorio selezionato. Se non è stato selezionato alcun comprensorio,
    // verrà ritornato NULL.
    @Query("SELECT idComprensorio FROM Utente")
    fun getIdComprensorio(): Int?

    // prende in input l'oggetto di tipo Comprensorio (tipo di dato definito nelle entità del database)
    // e lo inserisce
    @Insert(entity = Comprensorio::class)
    fun insertNewComprensorio(comp: Comprensorio)

    // quando l'utente va a selezionare un (nuovo) comprensorio, l'id del comprensorio selezionato
    // viene aggiornato con questa query
    @Query("UPDATE Utente SET idComprensorio = :newSkiAreaId")
    fun modificaComprensorioSelezionato(newSkiAreaId: Int)

    // ottiene i dettagli del comprensorio avente l'id fornito
    @Query("SELECT * FROM Comprensorio WHERE id = :skiAreaId")
    fun getDettagliComprensorio(skiAreaId: Int): Comprensorio

    // modifica il livello di zoom di un comprensorio
    @Query("UPDATE Comprensorio SET zoom = :zoom WHERE id = :id")
    fun updateZoomLevel(zoom: Int, id: Int)

    // ottiene la lista di tutti i comprensori memorizzati nel database
    @Query("SELECT * FROM Comprensorio")
    fun getSkiAreasList(): List<Comprensorio>

    // aggiunge una lista di piste appartenenti ad un certo comprensorio
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun inserisciPiste(order: List<Pista>)

    // ottengo la lista di piste di un certo comprensorio
    @Query("SELECT * FROM Pista WHERE idComprensorio = :id")
    fun getSkiAreaPiste(id: Int): List<Pista>

    // inserisce un nuovo Tracciamento.
    @Insert(entity = Tracciamento::class)
    fun insertNewTracciamento(track: Tracciamento): Long

    // Inserisce un elenco di punti che compongono un tracciamento.
    @Insert(entity = PuntoMappa::class)
    fun insertPuntiMappa(points: List<PuntoMappa>): List<Long>

    // Inserisce una corrispondenza tra il tracciamento e uno dei punti da cui è composto.
    @Insert(entity = PuntiMappaTracciamenti::class)
    fun insertPuntoMappaForTrack(point: PuntiMappaTracciamenti)

    // Ottiene la lista di comprensori che compaiono in almeno un tracciamento.
    @Query(
        "SELECT DISTINCT Comprensorio.* FROM Comprensorio " +
        "JOIN Pista ON Pista.idComprensorio = Comprensorio.id " +
        "JOIN Tracciamento ON Tracciamento.idPista = Pista.id"
    )
    fun getComprensoriConTracciamenti(): List<Comprensorio>

    // Ottiene le registrazioni effettuate in un comprensorio.
    @Query(
        "SELECT tracciamento.id AS id, tracciamento.distanza AS distanza, tracciamento.velocita AS velocita, tracciamento.dislivello AS dislivello, " +
            "tracciamento.dataOraInizio AS dataOraInizio, tracciamento.dataOraFine AS dataOraFine, " +
            "pista.nome AS pistaNome, pista.difficolta AS pistaDifficolta FROM tracciamento " +
        "JOIN pista ON tracciamento.idPista = pista.id " +
        "JOIN comprensorio ON pista.idComprensorio = comprensorio.id " +
        "WHERE comprensorio.id = :id"
    )
    fun getTracciamentiByComprensorio(id: Int): List<model.Tracciamento>
}