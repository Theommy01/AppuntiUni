package it.omarkiarafederico.skitracker.view.skimap;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u000bJ\u0016\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\r0\u0004j\b\u0012\u0004\u0012\u00020\r`\u000bJ\u0014\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011J\u0014\u0010\u0013\u001a\u00020\u000f2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00070\u0011J\u000e\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\tR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2 = {"Lit/omarkiarafederico/skitracker/view/skimap/CronologiaViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "listaComprensori", "Ljava/util/ArrayList;", "Lmodel/Comprensorio;", "listaTracciamenti", "Lmodel/Tracciamento;", "selectedSkiAreaID", "", "getListaComprensori", "Lkotlin/collections/ArrayList;", "prepareTracciamentiForRecyclerView", "Lit/omarkiarafederico/skitracker/view/skimap/TracciamentoItem;", "setListaComprensori", "", "listaFromDb", "", "Lroomdb/Comprensorio;", "setListaTracciamenti", "lista", "setSelectedSkiAreaID", "id", "app_debug"})
public final class CronologiaViewModel extends androidx.lifecycle.ViewModel {
    private int selectedSkiAreaID = 0;
    @org.jetbrains.annotations.NotNull
    private final java.util.ArrayList<model.Comprensorio> listaComprensori = null;
    @org.jetbrains.annotations.NotNull
    private java.util.ArrayList<model.Tracciamento> listaTracciamenti;
    
    public CronologiaViewModel() {
        super();
    }
    
    public final void setListaComprensori(@org.jetbrains.annotations.NotNull
    java.util.List<roomdb.Comprensorio> listaFromDb) {
    }
    
    public final void setListaTracciamenti(@org.jetbrains.annotations.NotNull
    java.util.List<model.Tracciamento> lista) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.ArrayList<model.Comprensorio> getListaComprensori() {
        return null;
    }
    
    public final void setSelectedSkiAreaID(int id) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.ArrayList<it.omarkiarafederico.skitracker.view.skimap.TracciamentoItem> prepareTracciamentiForRecyclerView() {
        return null;
    }
}