package model;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004B\u0015\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0002\u0010\tJ\u0006\u0010\u001b\u001a\u00020\u001cJ\u0006\u0010\u001d\u001a\u00020\u0003J\u0006\u0010\u001e\u001a\u00020\u001cJ\u0006\u0010\u001f\u001a\u00020\u0006J\u0006\u0010 \u001a\u00020\rJ\u0016\u0010!\u001a\u0012\u0012\u0004\u0012\u00020\u00100\u000fj\b\u0012\u0004\u0012\u00020\u0010`\"J\u0006\u0010#\u001a\u00020\rJ\u0006\u0010$\u001a\u00020\u0006J\u0006\u0010%\u001a\u00020\u0006J\u0006\u0010&\u001a\u00020\u000bJ\u0006\u0010\'\u001a\u00020\bJ\u0006\u0010(\u001a\u00020\u0006J\u0006\u0010)\u001a\u00020\u0006J\u0010\u0010*\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0005\u001a\u00020\u0006J\u0006\u0010+\u001a\u00020\u000bJ\u0006\u0010,\u001a\u00020\bJ\u0006\u0010-\u001a\u00020\u0006J\u0006\u0010.\u001a\u00020\u000bJ&\u0010/\u001a\u00020\u001c2\u0016\u00100\u001a\u0012\u0012\u0004\u0012\u0002010\u000fj\b\u0012\u0004\u0012\u000201`\"2\u0006\u00102\u001a\u000203J\b\u00104\u001a\u00020\bH\u0016J\u000e\u00105\u001a\u00020\u001c2\u0006\u00106\u001a\u000203R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u00067"}, d2 = {"Lmodel/Comprensorio;", "Ljava/io/Serializable;", "skiAreaFromDb", "Lroomdb/Comprensorio;", "(Lroomdb/Comprensorio;)V", "id", "", "name", "", "(ILjava/lang/String;)V", "aperto", "", "latitudine", "", "listaPiste", "Ljava/util/ArrayList;", "Lmodel/Pista;", "longitudine", "maxAltitudine", "minAltitudine", "nome", "numImpianti", "numPiste", "presenteSnowpark", "presentiPisteNotturne", "website", "zoom", "aumentaZoom", "", "convertToEntityClass", "diminiusciZoom", "getId", "getLatitudine", "getListaPiste", "Lkotlin/collections/ArrayList;", "getLongitudine", "getMaxAlt", "getMinAlt", "getNight", "getNome", "getNumImpianti", "getNumPiste", "getPistaById", "getSnowPark", "getWebSite", "getZoomLevel", "isOperativo", "setListaPiste", "lista", "Lroomdb/Pista;", "context", "Landroid/content/Context;", "toString", "updateZoom", "appContext", "app_debug"})
public final class Comprensorio implements java.io.Serializable {
    private int id;
    @org.jetbrains.annotations.NotNull
    private java.lang.String nome;
    private boolean aperto = false;
    @org.jetbrains.annotations.NotNull
    private java.lang.String website = "";
    private int numPiste = 0;
    private int numImpianti = 0;
    private boolean presenteSnowpark = false;
    private boolean presentiPisteNotturne = false;
    private double latitudine = 0.0;
    private double longitudine = 0.0;
    private int minAltitudine = 0;
    private int maxAltitudine = 0;
    private int zoom = 16;
    @org.jetbrains.annotations.NotNull
    private java.util.ArrayList<model.Pista> listaPiste;
    
    public Comprensorio(int id, @org.jetbrains.annotations.NotNull
    java.lang.String name) {
        super();
    }
    
    public Comprensorio(@org.jetbrains.annotations.NotNull
    roomdb.Comprensorio skiAreaFromDb) {
        super();
    }
    
    public final int getId() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getNome() {
        return null;
    }
    
    public final int getNumPiste() {
        return 0;
    }
    
    public final int getNumImpianti() {
        return 0;
    }
    
    public final int getMinAlt() {
        return 0;
    }
    
    public final int getMaxAlt() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getWebSite() {
        return null;
    }
    
    public final boolean getSnowPark() {
        return false;
    }
    
    public final boolean getNight() {
        return false;
    }
    
    public final boolean isOperativo() {
        return false;
    }
    
    public final double getLatitudine() {
        return 0.0;
    }
    
    public final double getLongitudine() {
        return 0.0;
    }
    
    public final int getZoomLevel() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.ArrayList<model.Pista> getListaPiste() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final model.Pista getPistaById(int id) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final roomdb.Comprensorio convertToEntityClass() {
        return null;
    }
    
    public final void diminiusciZoom() {
    }
    
    public final void aumentaZoom() {
    }
    
    public final void updateZoom(@org.jetbrains.annotations.NotNull
    android.content.Context appContext) {
    }
    
    public final void setListaPiste(@org.jetbrains.annotations.NotNull
    java.util.ArrayList<roomdb.Pista> lista, @org.jetbrains.annotations.NotNull
    android.content.Context context) {
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public java.lang.String toString() {
        return null;
    }
}