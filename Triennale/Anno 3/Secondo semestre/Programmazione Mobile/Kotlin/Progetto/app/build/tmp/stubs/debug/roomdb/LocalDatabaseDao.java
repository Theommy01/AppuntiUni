package roomdb;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bg\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\'J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\'J\u000f\u0010\b\u001a\u0004\u0018\u00010\u0007H\'\u00a2\u0006\u0002\u0010\tJ\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00032\u0006\u0010\f\u001a\u00020\u0007H\'J\u000e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\'J\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00032\u0006\u0010\f\u001a\u00020\u0007H\'J\u0016\u0010\u0010\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0003H\'J\u0010\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0004H\'J\u0010\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u0017H\'J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\'J\u001c\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00190\u00032\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\u0003H\'J\u0010\u0010\u001f\u001a\u00020\u00112\u0006\u0010 \u001a\u00020!H\'J\b\u0010\"\u001a\u00020\u0007H\'J\u0010\u0010#\u001a\u00020\u00112\u0006\u0010$\u001a\u00020\u0007H\'J\u0018\u0010%\u001a\u00020\u00112\u0006\u0010&\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0007H\'\u00a8\u0006\'"}, d2 = {"Lroomdb/LocalDatabaseDao;", "", "getComprensoriConTracciamenti", "", "Lroomdb/Comprensorio;", "getDettagliComprensorio", "skiAreaId", "", "getIdComprensorio", "()Ljava/lang/Integer;", "getSkiAreaPiste", "Lroomdb/Pista;", "id", "getSkiAreasList", "getTracciamentiByComprensorio", "Lmodel/Tracciamento;", "inserisciPiste", "", "order", "insertNewComprensorio", "comp", "insertNewLocalUserInfo", "user", "Lroomdb/Utente;", "insertNewTracciamento", "", "track", "Lroomdb/Tracciamento;", "insertPuntiMappa", "points", "Lroomdb/PuntoMappa;", "insertPuntoMappaForTrack", "point", "Lroomdb/PuntiMappaTracciamenti;", "isTutorialCompletato", "modificaComprensorioSelezionato", "newSkiAreaId", "updateZoomLevel", "zoom", "app_debug"})
@androidx.room.Dao
public abstract interface LocalDatabaseDao {
    
    @androidx.room.Insert(entity = roomdb.Utente.class)
    public abstract void insertNewLocalUserInfo(@org.jetbrains.annotations.NotNull
    roomdb.Utente user);
    
    @androidx.room.Query(value = "SELECT tutorialCompletato FROM Utente")
    public abstract int isTutorialCompletato();
    
    @androidx.room.Query(value = "SELECT idComprensorio FROM Utente")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Integer getIdComprensorio();
    
    @androidx.room.Insert(entity = roomdb.Comprensorio.class)
    public abstract void insertNewComprensorio(@org.jetbrains.annotations.NotNull
    roomdb.Comprensorio comp);
    
    @androidx.room.Query(value = "UPDATE Utente SET idComprensorio = :newSkiAreaId")
    public abstract void modificaComprensorioSelezionato(int newSkiAreaId);
    
    @androidx.room.Query(value = "SELECT * FROM Comprensorio WHERE id = :skiAreaId")
    @org.jetbrains.annotations.NotNull
    public abstract roomdb.Comprensorio getDettagliComprensorio(int skiAreaId);
    
    @androidx.room.Query(value = "UPDATE Comprensorio SET zoom = :zoom WHERE id = :id")
    public abstract void updateZoomLevel(int zoom, int id);
    
    @androidx.room.Query(value = "SELECT * FROM Comprensorio")
    @org.jetbrains.annotations.NotNull
    public abstract java.util.List<roomdb.Comprensorio> getSkiAreasList();
    
    @androidx.room.Insert(onConflict = 1)
    public abstract void inserisciPiste(@org.jetbrains.annotations.NotNull
    java.util.List<roomdb.Pista> order);
    
    @androidx.room.Query(value = "SELECT * FROM Pista WHERE idComprensorio = :id")
    @org.jetbrains.annotations.NotNull
    public abstract java.util.List<roomdb.Pista> getSkiAreaPiste(int id);
    
    @androidx.room.Insert(entity = roomdb.Tracciamento.class)
    public abstract long insertNewTracciamento(@org.jetbrains.annotations.NotNull
    roomdb.Tracciamento track);
    
    @androidx.room.Insert(entity = roomdb.PuntoMappa.class)
    @org.jetbrains.annotations.NotNull
    public abstract java.util.List<java.lang.Long> insertPuntiMappa(@org.jetbrains.annotations.NotNull
    java.util.List<roomdb.PuntoMappa> points);
    
    @androidx.room.Insert(entity = roomdb.PuntiMappaTracciamenti.class)
    public abstract void insertPuntoMappaForTrack(@org.jetbrains.annotations.NotNull
    roomdb.PuntiMappaTracciamenti point);
    
    @androidx.room.Query(value = "SELECT DISTINCT Comprensorio.* FROM Comprensorio JOIN Pista ON Pista.idComprensorio = Comprensorio.id JOIN Tracciamento ON Tracciamento.idPista = Pista.id")
    @org.jetbrains.annotations.NotNull
    public abstract java.util.List<roomdb.Comprensorio> getComprensoriConTracciamenti();
    
    @androidx.room.Query(value = "SELECT tracciamento.id AS id, tracciamento.distanza AS distanza, tracciamento.velocita AS velocita, tracciamento.dislivello AS dislivello, tracciamento.dataOraInizio AS dataOraInizio, tracciamento.dataOraFine AS dataOraFine, pista.nome AS pistaNome, pista.difficolta AS pistaDifficolta FROM tracciamento JOIN pista ON tracciamento.idPista = pista.id JOIN comprensorio ON pista.idComprensorio = comprensorio.id WHERE comprensorio.id = :id")
    @org.jetbrains.annotations.NotNull
    public abstract java.util.List<model.Tracciamento> getTracciamentiByComprensorio(int id);
}