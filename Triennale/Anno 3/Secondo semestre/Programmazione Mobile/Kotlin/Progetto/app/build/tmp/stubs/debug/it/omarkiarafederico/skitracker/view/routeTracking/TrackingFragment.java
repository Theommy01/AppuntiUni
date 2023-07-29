package it.omarkiarafederico.skitracker.view.routeTracking;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\b\u0010\u0011\u001a\u00020\fH\u0002J&\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u001a\u0010\u001a\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u00132\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0017J\u0006\u0010\u001c\u001a\u00020\fJ \u0010\u001d\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u0013H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006!"}, d2 = {"Lit/omarkiarafederico/skitracker/view/routeTracking/TrackingFragment;", "Landroidx/fragment/app/Fragment;", "()V", "mapView", "Lorg/osmdroid/views/MapView;", "myLocationOverlay", "Lorg/osmdroid/views/overlay/mylocation/MyLocationNewOverlay;", "myViewModel", "Lit/omarkiarafederico/skitracker/view/routeTracking/TrackingViewModel;", "selectedPista", "Lmodel/Pista;", "changeDifficultyIndicatorColor", "", "textView", "Landroid/widget/TextView;", "diff", "", "finishTracking", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "stopTracking", "updateInstantData", "textViewId", "", "value", "app_debug"})
public final class TrackingFragment extends androidx.fragment.app.Fragment {
    @org.jetbrains.annotations.Nullable
    private it.omarkiarafederico.skitracker.view.routeTracking.TrackingViewModel myViewModel;
    private model.Pista selectedPista;
    private org.osmdroid.views.MapView mapView;
    private org.osmdroid.views.overlay.mylocation.MyLocationNewOverlay myLocationOverlay;
    
    public TrackingFragment() {
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
    @android.annotation.SuppressLint(value = {"MissingPermission"})
    public void onViewCreated(@org.jetbrains.annotations.NotNull
    android.view.View view, @org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    private final void changeDifficultyIndicatorColor(android.widget.TextView textView, java.lang.String diff) {
    }
    
    public final void stopTracking() {
    }
    
    private final void updateInstantData(int textViewId, java.lang.String value, android.view.View view) {
    }
    
    private final void finishTracking() {
    }
}