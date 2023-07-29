package it.omarkiarafederico.skitracker.view.skimap;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0014J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0010\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\b\u0010\u0017\u001a\u00020\nH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2 = {"Lit/omarkiarafederico/skitracker/view/skimap/MapActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "binding", "Lit/omarkiarafederico/skitracker/databinding/ActivityMapBinding;", "myViewModel", "Lit/omarkiarafederico/skitracker/view/skimap/SkiMapViewModel;", "toggle", "Landroidx/appcompat/app/ActionBarDrawerToggle;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onOptionsItemSelected", "", "item", "Landroid/view/MenuItem;", "replaceFragment", "fragmentDaVisualizzare", "Landroidx/fragment/app/Fragment;", "tag", "", "setActivityTitle", "setSelectedSkiArea", "app_debug"})
public final class MapActivity extends androidx.appcompat.app.AppCompatActivity {
    @org.jetbrains.annotations.Nullable
    private it.omarkiarafederico.skitracker.view.skimap.SkiMapViewModel myViewModel;
    private it.omarkiarafederico.skitracker.databinding.ActivityMapBinding binding;
    private androidx.appcompat.app.ActionBarDrawerToggle toggle;
    
    public MapActivity() {
        super();
    }
    
    @java.lang.Override
    protected void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override
    public boolean onOptionsItemSelected(@org.jetbrains.annotations.NotNull
    android.view.MenuItem item) {
        return false;
    }
    
    private final void replaceFragment(androidx.fragment.app.Fragment fragmentDaVisualizzare, java.lang.String tag) {
    }
    
    private final void setSelectedSkiArea() {
    }
    
    private final void setActivityTitle(java.lang.String tag) {
    }
}