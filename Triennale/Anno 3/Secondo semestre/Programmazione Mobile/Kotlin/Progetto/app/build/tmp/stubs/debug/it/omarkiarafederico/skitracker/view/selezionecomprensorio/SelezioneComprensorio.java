package it.omarkiarafederico.skitracker.view.selezionecomprensorio;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0014J\u0012\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\nX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2 = {"Lit/omarkiarafederico/skitracker/view/selezionecomprensorio/SelezioneComprensorio;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "skiAreaAdapter", "Lit/omarkiarafederico/skitracker/view/selezionecomprensorio/SkiAreaAdapter;", "skiAreaItemList", "Ljava/util/ArrayList;", "Lit/omarkiarafederico/skitracker/view/selezionecomprensorio/SkiAreaItem;", "Lkotlin/collections/ArrayList;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateOptionsMenu", "", "menu", "Landroid/view/Menu;", "app_debug"})
public final class SelezioneComprensorio extends androidx.appcompat.app.AppCompatActivity {
    private androidx.recyclerview.widget.RecyclerView recyclerView;
    private java.util.ArrayList<it.omarkiarafederico.skitracker.view.selezionecomprensorio.SkiAreaItem> skiAreaItemList;
    private it.omarkiarafederico.skitracker.view.selezionecomprensorio.SkiAreaAdapter skiAreaAdapter;
    
    public SelezioneComprensorio() {
        super();
    }
    
    @java.lang.Override
    protected void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override
    public boolean onCreateOptionsMenu(@org.jetbrains.annotations.Nullable
    android.view.Menu menu) {
        return false;
    }
}