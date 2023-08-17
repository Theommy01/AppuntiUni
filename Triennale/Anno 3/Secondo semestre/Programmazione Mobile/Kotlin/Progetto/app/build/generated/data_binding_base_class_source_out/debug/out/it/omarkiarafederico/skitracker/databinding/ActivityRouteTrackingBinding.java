// Generated by view binder compiler. Do not edit!
package it.omarkiarafederico.skitracker.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentContainerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import it.omarkiarafederico.skitracker.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityRouteTrackingBinding implements ViewBinding {
  @NonNull
  private final FrameLayout rootView;

  @NonNull
  public final FragmentContainerView routeSelFragmentContainer;

  @NonNull
  public final FrameLayout routeSelFrameLayout;

  private ActivityRouteTrackingBinding(@NonNull FrameLayout rootView,
      @NonNull FragmentContainerView routeSelFragmentContainer,
      @NonNull FrameLayout routeSelFrameLayout) {
    this.rootView = rootView;
    this.routeSelFragmentContainer = routeSelFragmentContainer;
    this.routeSelFrameLayout = routeSelFrameLayout;
  }

  @Override
  @NonNull
  public FrameLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityRouteTrackingBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityRouteTrackingBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_route_tracking, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityRouteTrackingBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.route_sel_fragment_container;
      FragmentContainerView routeSelFragmentContainer = ViewBindings.findChildViewById(rootView, id);
      if (routeSelFragmentContainer == null) {
        break missingId;
      }

      FrameLayout routeSelFrameLayout = (FrameLayout) rootView;

      return new ActivityRouteTrackingBinding((FrameLayout) rootView, routeSelFragmentContainer,
          routeSelFrameLayout);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}