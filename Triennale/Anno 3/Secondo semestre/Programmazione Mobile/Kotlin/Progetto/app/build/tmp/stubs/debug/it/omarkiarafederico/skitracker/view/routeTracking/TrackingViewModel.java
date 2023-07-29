package it.omarkiarafederico.skitracker.view.routeTracking;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0015J\u0016\u0010\u001e\u001a\u0012\u0012\u0004\u0012\u00020\u001f0\u0004j\b\u0012\u0004\u0012\u00020\u001f` J\u0006\u0010!\u001a\u00020\u0005J\u0006\u0010\"\u001a\u00020\u0013J\u0006\u0010#\u001a\u00020\u0005J\u0006\u0010$\u001a\u00020\u0011J\b\u0010%\u001a\u0004\u0018\u00010\u0018J\u0006\u0010\u001a\u001a\u00020\nJ\u000e\u0010&\u001a\u00020\u001c2\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\'\u001a\u00020\u001c2\u0006\u0010(\u001a\u00020\u0013J\u000e\u0010)\u001a\u00020\u001c2\u0006\u0010*\u001a\u00020\u0011J\u000e\u0010+\u001a\u00020\u001c2\u0006\u0010,\u001a\u00020\u0005J\u000e\u0010-\u001a\u00020\u001c2\u0006\u0010.\u001a\u00020\nJ\u000e\u0010/\u001a\u00020\u001c2\u0006\u00100\u001a\u00020\nR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.\u00a2\u0006\u0002\n\u0000R(\u0010\b\u001a\u0010\u0012\f\u0012\n \u000b*\u0004\u0018\u00010\n0\n0\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\n0\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0017\u001a\n \u000b*\u0004\u0018\u00010\u00180\u0018X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001f\u0010\u0019\u001a\u0010\u0012\f\u0012\n \u000b*\u0004\u0018\u00010\n0\n0\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\r\u00a8\u00061"}, d2 = {"Lit/omarkiarafederico/skitracker/view/routeTracking/TrackingViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "altitudesArray", "Ljava/util/ArrayList;", "", "chrono", "Landroid/widget/Chronometer;", "instantSpeed", "Landroidx/lifecycle/MutableLiveData;", "", "kotlin.jvm.PlatformType", "getInstantSpeed", "()Landroidx/lifecycle/MutableLiveData;", "setInstantSpeed", "(Landroidx/lifecycle/MutableLiveData;)V", "myPista", "Lmodel/Pista;", "mySkiArea", "Lmodel/Comprensorio;", "pointsArray", "Landroid/location/Location;", "speedArray", "startDateTime", "Ljava/time/LocalDateTime;", "totalDistance", "getTotalDistance", "addPointToList", "", "p", "convertLocationsToPuntiMappa", "Lroomdb/PuntoMappa;", "Lkotlin/collections/ArrayList;", "getAverageSpeed", "getComprensorio", "getDislivello", "getPista", "getStartDateTime", "setChrono", "setComprensorio", "comp", "setPista", "pista", "updateAltitudes", "altitude", "updateDistance", "distance", "updateSpeed", "speed", "app_debug"})
public final class TrackingViewModel extends androidx.lifecycle.ViewModel {
    private model.Comprensorio mySkiArea;
    private model.Pista myPista;
    @org.jetbrains.annotations.NotNull
    private final java.util.ArrayList<java.lang.Float> speedArray = null;
    @org.jetbrains.annotations.NotNull
    private final java.util.ArrayList<java.lang.Double> altitudesArray = null;
    @org.jetbrains.annotations.NotNull
    private final java.util.ArrayList<android.location.Location> pointsArray = null;
    @org.jetbrains.annotations.NotNull
    private androidx.lifecycle.MutableLiveData<java.lang.Float> instantSpeed;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<java.lang.Float> totalDistance = null;
    private android.widget.Chronometer chrono;
    private final java.time.LocalDateTime startDateTime = null;
    
    public TrackingViewModel() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<java.lang.Float> getInstantSpeed() {
        return null;
    }
    
    public final void setInstantSpeed(@org.jetbrains.annotations.NotNull
    androidx.lifecycle.MutableLiveData<java.lang.Float> p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.MutableLiveData<java.lang.Float> getTotalDistance() {
        return null;
    }
    
    public final void setComprensorio(@org.jetbrains.annotations.NotNull
    model.Comprensorio comp) {
    }
    
    public final void setPista(@org.jetbrains.annotations.NotNull
    model.Pista pista) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final model.Comprensorio getComprensorio() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final model.Pista getPista() {
        return null;
    }
    
    public final void updateSpeed(float speed) {
    }
    
    public final void updateDistance(float distance) {
    }
    
    public final void updateAltitudes(double altitude) {
    }
    
    public final void setChrono(@org.jetbrains.annotations.NotNull
    android.widget.Chronometer chrono) {
    }
    
    public final void addPointToList(@org.jetbrains.annotations.NotNull
    android.location.Location p) {
    }
    
    public final float getTotalDistance() {
        return 0.0F;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.time.LocalDateTime getStartDateTime() {
        return null;
    }
    
    public final double getAverageSpeed() {
        return 0.0;
    }
    
    public final double getDislivello() {
        return 0.0;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.ArrayList<roomdb.PuntoMappa> convertLocationsToPuntiMappa() {
        return null;
    }
}