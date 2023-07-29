package model;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006B\u0015\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u00a2\u0006\u0002\u0010\u000bJ\u0006\u0010\r\u001a\u00020\nJ\u0006\u0010\u000e\u001a\u00020\bJ\u0006\u0010\u000f\u001a\u00020\nR\u000e\u0010\f\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Lmodel/Pista;", "Ljava/io/Serializable;", "pistaFromDb", "Lroomdb/Pista;", "context", "Landroid/content/Context;", "(Lroomdb/Pista;Landroid/content/Context;)V", "id", "", "nome", "", "(ILjava/lang/String;)V", "difficolta", "getDifficolta", "getId", "getNome", "app_debug"})
public final class Pista implements java.io.Serializable {
    private int id;
    @org.jetbrains.annotations.NotNull
    private java.lang.String nome;
    private java.lang.String difficolta;
    
    public Pista(int id, @org.jetbrains.annotations.NotNull
    java.lang.String nome) {
        super();
    }
    
    public Pista(@org.jetbrains.annotations.NotNull
    roomdb.Pista pistaFromDb, @org.jetbrains.annotations.NotNull
    android.content.Context context) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getNome() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getDifficolta() {
        return null;
    }
    
    public final int getId() {
        return 0;
    }
}