package utility;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lutility/MyLocationListener;", "Landroid/location/LocationListener;", "mapView", "Lorg/osmdroid/views/MapView;", "viewModel", "Lit/omarkiarafederico/skitracker/view/routeTracking/TrackingViewModel;", "(Lorg/osmdroid/views/MapView;Lit/omarkiarafederico/skitracker/view/routeTracking/TrackingViewModel;)V", "onLocationChanged", "", "location", "Landroid/location/Location;", "app_debug"})
public final class MyLocationListener implements android.location.LocationListener {
    @org.jetbrains.annotations.NotNull
    private final org.osmdroid.views.MapView mapView = null;
    @org.jetbrains.annotations.NotNull
    private final it.omarkiarafederico.skitracker.view.routeTracking.TrackingViewModel viewModel = null;
    
    public MyLocationListener(@org.jetbrains.annotations.NotNull
    org.osmdroid.views.MapView mapView, @org.jetbrains.annotations.NotNull
    it.omarkiarafederico.skitracker.view.routeTracking.TrackingViewModel viewModel) {
        super();
    }
    
    @java.lang.Override
    public void onLocationChanged(@org.jetbrains.annotations.NotNull
    android.location.Location location) {
    }
}