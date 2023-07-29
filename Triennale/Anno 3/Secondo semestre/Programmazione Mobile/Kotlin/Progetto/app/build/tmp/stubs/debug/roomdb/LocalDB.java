package roomdb;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\'\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&\u00a8\u0006\u0005"}, d2 = {"Lroomdb/LocalDB;", "Landroidx/room/RoomDatabase;", "()V", "localDatabaseDao", "Lroomdb/LocalDatabaseDao;", "app_debug"})
@androidx.room.Database(entities = {roomdb.Utente.class, roomdb.Tracciamento.class, roomdb.Pista.class, roomdb.Comprensorio.class, roomdb.PuntoMappa.class, roomdb.PuntiMappaTracciamenti.class}, version = 8)
public abstract class LocalDB extends androidx.room.RoomDatabase {
    
    public LocalDB() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public abstract roomdb.LocalDatabaseDao localDatabaseDao();
}