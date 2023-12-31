// Generated by view binder compiler. Do not edit!
package it.omarkiarafederico.skitracker.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import it.omarkiarafederico.skitracker.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;
import org.osmdroid.views.MapView;

public final class FragmentMappaBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final FloatingActionButton addRecordFAB;

  @NonNull
  public final FloatingActionButton getPositionFAB;

  @NonNull
  public final ConstraintLayout mappaFragment;

  @NonNull
  public final MapView trackingMap;

  private FragmentMappaBinding(@NonNull ConstraintLayout rootView,
      @NonNull FloatingActionButton addRecordFAB, @NonNull FloatingActionButton getPositionFAB,
      @NonNull ConstraintLayout mappaFragment, @NonNull MapView trackingMap) {
    this.rootView = rootView;
    this.addRecordFAB = addRecordFAB;
    this.getPositionFAB = getPositionFAB;
    this.mappaFragment = mappaFragment;
    this.trackingMap = trackingMap;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentMappaBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentMappaBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_mappa, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentMappaBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.addRecordFAB;
      FloatingActionButton addRecordFAB = ViewBindings.findChildViewById(rootView, id);
      if (addRecordFAB == null) {
        break missingId;
      }

      id = R.id.getPositionFAB;
      FloatingActionButton getPositionFAB = ViewBindings.findChildViewById(rootView, id);
      if (getPositionFAB == null) {
        break missingId;
      }

      ConstraintLayout mappaFragment = (ConstraintLayout) rootView;

      id = R.id.trackingMap;
      MapView trackingMap = ViewBindings.findChildViewById(rootView, id);
      if (trackingMap == null) {
        break missingId;
      }

      return new FragmentMappaBinding((ConstraintLayout) rootView, addRecordFAB, getPositionFAB,
          mappaFragment, trackingMap);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
