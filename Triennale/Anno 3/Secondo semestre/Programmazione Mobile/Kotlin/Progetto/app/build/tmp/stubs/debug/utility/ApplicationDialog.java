package utility;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0013B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J&\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0016\u0010\u0010\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Lutility/ApplicationDialog;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "yesNoListener", "Lutility/ApplicationDialog$YesNoDialogListener;", "openDialog", "", "type", "", "msg", "activityContext", "Landroidx/appcompat/app/AppCompatActivity;", "autoclose", "", "openYesNoDialog", "setListener", "listener", "YesNoDialogListener", "app_debug"})
public final class ApplicationDialog {
    @org.jetbrains.annotations.NotNull
    private final android.content.Context context = null;
    private utility.ApplicationDialog.YesNoDialogListener yesNoListener;
    
    public ApplicationDialog(@org.jetbrains.annotations.NotNull
    android.content.Context context) {
        super();
    }
    
    public final void openDialog(@org.jetbrains.annotations.NotNull
    java.lang.String type, @org.jetbrains.annotations.NotNull
    java.lang.String msg, @org.jetbrains.annotations.NotNull
    androidx.appcompat.app.AppCompatActivity activityContext, boolean autoclose) {
    }
    
    public final void openYesNoDialog(@org.jetbrains.annotations.NotNull
    java.lang.String msg, @org.jetbrains.annotations.NotNull
    androidx.appcompat.app.AppCompatActivity activityContext) {
    }
    
    public final void setListener(@org.jetbrains.annotations.NotNull
    utility.ApplicationDialog.YesNoDialogListener listener) {
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&\u00a8\u0006\u0005"}, d2 = {"Lutility/ApplicationDialog$YesNoDialogListener;", "", "onNoClicked", "", "onYesClicked", "app_debug"})
    public static abstract interface YesNoDialogListener {
        
        public abstract void onYesClicked();
        
        public abstract void onNoClicked();
    }
}