package it.omarkiarafederico.skitracker.view.skimap;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0002J\n\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0002J\u0012\u0010\t\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0017J&\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u001a\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\r2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J \u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0006\u0010\u001a\u001a\u00020\u0006R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001b"}, d2 = {"Lit/omarkiarafederico/skitracker/view/skimap/MappaFragment;", "Landroidx/fragment/app/Fragment;", "()V", "myViewModel", "Lit/omarkiarafederico/skitracker/view/skimap/SkiMapViewModel;", "getCurrentLocation", "", "getMap", "Lorg/osmdroid/views/MapView;", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "renderKMLskiArea", "lat", "", "long", "zoomLevel", "", "zoomRegulation", "app_debug"})
public final class MappaFragment extends androidx.fragment.app.Fragment {
    @org.jetbrains.annotations.Nullable
    private it.omarkiarafederico.skitracker.view.skimap.SkiMapViewModel myViewModel;
    
    public MappaFragment() {
        super();
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @java.lang.Override
    public void onViewCreated(@org.jetbrains.annotations.NotNull
    android.view.View view, @org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    private final org.osmdroid.views.MapView getMap() {
        return null;
    }
    
    @java.lang.Override
    @java.lang.Deprecated
    public void onActivityCreated(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    private final void getCurrentLocation() {
    }
    
    private final void renderKMLskiArea(double lat, double p1_1663806, int zoomLevel) {
    }
    
    public final void zoomRegulation() {
    }
}