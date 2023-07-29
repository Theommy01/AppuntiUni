package model;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0016\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\f\u00a2\u0006\u0002\u0010\u000eJ\u0006\u0010!\u001a\u00020\fR\u000e\u0010\n\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0012R\u001a\u0010\r\u001a\u00020\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001a\"\u0004\b\u001e\u0010\u001cR\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0014\"\u0004\b \u0010\u0016\u00a8\u0006\""}, d2 = {"Lmodel/Tracciamento;", "", "id", "", "distanza", "", "velocita", "dislivello", "dataOraInizio", "", "dataOraFine", "pistaNome", "", "pistaDifficolta", "(IFFIJJLjava/lang/String;Ljava/lang/String;)V", "getDislivello", "()I", "setDislivello", "(I)V", "getDistanza", "()F", "setDistanza", "(F)V", "getId", "setId", "getPistaDifficolta", "()Ljava/lang/String;", "setPistaDifficolta", "(Ljava/lang/String;)V", "getPistaNome", "setPistaNome", "getVelocita", "setVelocita", "getDurationString", "app_debug"})
public final class Tracciamento {
    private int id;
    private float distanza;
    private float velocita;
    private int dislivello;
    private long dataOraInizio;
    private long dataOraFine;
    @org.jetbrains.annotations.NotNull
    private java.lang.String pistaNome;
    @org.jetbrains.annotations.NotNull
    private java.lang.String pistaDifficolta;
    
    public Tracciamento(int id, float distanza, float velocita, int dislivello, long dataOraInizio, long dataOraFine, @org.jetbrains.annotations.NotNull
    java.lang.String pistaNome, @org.jetbrains.annotations.NotNull
    java.lang.String pistaDifficolta) {
        super();
    }
    
    public final int getId() {
        return 0;
    }
    
    public final void setId(int p0) {
    }
    
    public final float getDistanza() {
        return 0.0F;
    }
    
    public final void setDistanza(float p0) {
    }
    
    public final float getVelocita() {
        return 0.0F;
    }
    
    public final void setVelocita(float p0) {
    }
    
    public final int getDislivello() {
        return 0;
    }
    
    public final void setDislivello(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getPistaNome() {
        return null;
    }
    
    public final void setPistaNome(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getPistaDifficolta() {
        return null;
    }
    
    public final void setPistaDifficolta(@org.jetbrains.annotations.NotNull
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getDurationString() {
        return null;
    }
}