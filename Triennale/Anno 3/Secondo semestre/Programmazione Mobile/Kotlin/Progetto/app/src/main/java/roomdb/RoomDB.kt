/***************************************************************************************************
 * RoomDB
 * Questo file contiene la classe dedicata all'interfacciamento con il database (realizzato in Room)
 * tramite l'uso del DAO (Data Access Object); in sostanza, funge da interprete tra il DAO stesso
 * e il resto del codice che ne va a fare uso.
 **************************************************************************************************/

package roomdb

import androidx.room.*

@Database(entities = [
    Utente::class,
    Tracciamento::class,
    Pista::class,
    Comprensorio::class,
    PuntoMappa::class,
    PuntiMappaTracciamenti::class
], version = 8)
abstract class LocalDB: RoomDatabase() {
    abstract fun localDatabaseDao(): LocalDatabaseDao
}