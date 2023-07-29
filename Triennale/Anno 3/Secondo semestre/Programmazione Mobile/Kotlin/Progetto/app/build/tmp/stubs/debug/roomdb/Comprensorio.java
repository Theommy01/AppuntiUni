package roomdb;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0006\n\u0002\b:\b\u0087\b\u0018\u00002\u00020\u0001B\u0007\b\u0016\u00a2\u0006\u0002\u0010\u0002Bo\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0004\u0012\u0006\u0010\n\u001a\u00020\u0004\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u0012\u0006\u0010\f\u001a\u00020\b\u0012\u0006\u0010\r\u001a\u00020\b\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u0004\u0012\u0006\u0010\u0012\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0014J\t\u00107\u001a\u00020\u0004H\u00c6\u0003J\t\u00108\u001a\u00020\u000fH\u00c6\u0003J\t\u00109\u001a\u00020\u0004H\u00c6\u0003J\t\u0010:\u001a\u00020\u0004H\u00c6\u0003J\t\u0010;\u001a\u00020\u0004H\u00c6\u0003J\t\u0010<\u001a\u00020\u0006H\u00c6\u0003J\t\u0010=\u001a\u00020\bH\u00c6\u0003J\t\u0010>\u001a\u00020\u0004H\u00c6\u0003J\t\u0010?\u001a\u00020\u0004H\u00c6\u0003J\t\u0010@\u001a\u00020\u0006H\u00c6\u0003J\t\u0010A\u001a\u00020\bH\u00c6\u0003J\t\u0010B\u001a\u00020\bH\u00c6\u0003J\t\u0010C\u001a\u00020\u000fH\u00c6\u0003J\u008b\u0001\u0010D\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00042\b\b\u0002\u0010\n\u001a\u00020\u00042\b\b\u0002\u0010\u000b\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\b2\b\b\u0002\u0010\r\u001a\u00020\b2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u00042\b\b\u0002\u0010\u0012\u001a\u00020\u00042\b\b\u0002\u0010\u0013\u001a\u00020\u0004H\u00c6\u0001J\u0013\u0010E\u001a\u00020\b2\b\u0010F\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010G\u001a\u00020\u0004H\u00d6\u0001J\t\u0010H\u001a\u00020\u0006H\u00d6\u0001R\u001e\u0010\u0007\u001a\u00020\b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010\u0010\u001a\u00020\u000fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u001e\"\u0004\b\"\u0010 R\u001a\u0010\u0011\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u001a\"\u0004\b$\u0010\u001cR\u001a\u0010\u0012\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u001a\"\u0004\b&\u0010\u001cR\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\'\u0010(\"\u0004\b)\u0010*R\u001a\u0010\n\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u001a\"\u0004\b,\u0010\u001cR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u001a\"\u0004\b.\u0010\u001cR\u001e\u0010\r\u001a\u00020\b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u0016\"\u0004\b0\u0010\u0018R\u001e\u0010\f\u001a\u00020\b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u0016\"\u0004\b2\u0010\u0018R\u001a\u0010\u000b\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b3\u0010(\"\u0004\b4\u0010*R\u001e\u0010\u0013\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u001a\"\u0004\b6\u0010\u001c\u00a8\u0006I"}, d2 = {"Lroomdb/Comprensorio;", "", "()V", "id", "", "nome", "", "aperto", "", "numPiste", "numImpianti", "website", "snowpark", "pisteNotturne", "lat", "", "long", "maxAltitudine", "minAltitudine", "zoom", "(ILjava/lang/String;ZIILjava/lang/String;ZZDDIII)V", "getAperto", "()Z", "setAperto", "(Z)V", "getId", "()I", "setId", "(I)V", "getLat", "()D", "setLat", "(D)V", "getLong", "setLong", "getMaxAltitudine", "setMaxAltitudine", "getMinAltitudine", "setMinAltitudine", "getNome", "()Ljava/lang/String;", "setNome", "(Ljava/lang/String;)V", "getNumImpianti", "setNumImpianti", "getNumPiste", "setNumPiste", "getPisteNotturne", "setPisteNotturne", "getSnowpark", "setSnowpark", "getWebsite", "setWebsite", "getZoom", "setZoom", "component1", "component10", "component11", "component12", "component13", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "app_debug"})
@androidx.room.Entity(tableName = "Comprensorio")
public final class Comprensorio {
    @androidx.room.PrimaryKey(autoGenerate = true)
    private int id;
    @org.jetbrains.annotations.NotNull
    private java.lang.String nome;
    @androidx.room.ColumnInfo(defaultValue = "0")
    private boolean aperto;
    private int numPiste;
    private int numImpianti;
    @org.jetbrains.annotations.NotNull
    private java.lang.String website;
    @androidx.room.ColumnInfo(defaultValue = "0")
    private boolean snowpark;
    @androidx.room.ColumnInfo(defaultValue = "0")
    private boolean pisteNotturne;
    private double lat;
    private int maxAltitudine;
    private int minAltitudine;
    @androidx.room.ColumnInfo(defaultValue = "16")
    private int zoom;
    
    public Comprensorio(int id, @org.jetbrains.annotations.NotNull
    java.lang.String nome, boolean aperto, int numPiste, int numImpianti, @org.jetbrains.annotations.NotNull
    java.lang.String website, boolean snowpark, boolean pisteNotturne, double lat, double p9_1663806, int maxAltitudine, int minAltitudine, int zoom) {
        super();
    }
    
    public final int getId() {
        return 0;
    }
    
    public final void setId(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getNome() {
        return null;
    }
    
    public final void setNome(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    public final boolean getAperto() {
        return false;
    }
    
    public final void setAperto(boolean p0) {
    }
    
    public final int getNumPiste() {
        return 0;
    }
    
    public final void setNumPiste(int p0) {
    }
    
    public final int getNumImpianti() {
        return 0;
    }
    
    public final void setNumImpianti(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getWebsite() {
        return null;
    }
    
    public final void setWebsite(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    public final boolean getSnowpark() {
        return false;
    }
    
    public final void setSnowpark(boolean p0) {
    }
    
    public final boolean getPisteNotturne() {
        return false;
    }
    
    public final void setPisteNotturne(boolean p0) {
    }
    
    public final double getLat() {
        return 0.0;
    }
    
    public final void setLat(double p0) {
    }
    
    public final double getLong() {
        return 0.0;
    }
    
    public final void setLong(double p0) {
    }
    
    public final int getMaxAltitudine() {
        return 0;
    }
    
    public final void setMaxAltitudine(int p0) {
    }
    
    public final int getMinAltitudine() {
        return 0;
    }
    
    public final void setMinAltitudine(int p0) {
    }
    
    public final int getZoom() {
        return 0;
    }
    
    public final void setZoom(int p0) {
    }
    
    public Comprensorio() {
        super();
    }
    
    public final int component1() {
        return 0;
    }
    
    public final double component10() {
        return 0.0;
    }
    
    public final int component11() {
        return 0;
    }
    
    public final int component12() {
        return 0;
    }
    
    public final int component13() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component2() {
        return null;
    }
    
    public final boolean component3() {
        return false;
    }
    
    public final int component4() {
        return 0;
    }
    
    public final int component5() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component6() {
        return null;
    }
    
    public final boolean component7() {
        return false;
    }
    
    public final boolean component8() {
        return false;
    }
    
    public final double component9() {
        return 0.0;
    }
    
    @org.jetbrains.annotations.NotNull
    public final roomdb.Comprensorio copy(int id, @org.jetbrains.annotations.NotNull
    java.lang.String nome, boolean aperto, int numPiste, int numImpianti, @org.jetbrains.annotations.NotNull
    java.lang.String website, boolean snowpark, boolean pisteNotturne, double lat, double p9_1663806, int maxAltitudine, int minAltitudine, int zoom) {
        return null;
    }
    
    @java.lang.Override
    public boolean equals(@org.jetbrains.annotations.Nullable
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override
    public int hashCode() {
        return 0;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public java.lang.String toString() {
        return null;
    }
}