// Generated by view binder compiler. Do not edit!
package it.omarkiarafederico.skitracker.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import it.omarkiarafederico.skitracker.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentGuida1Binding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final Button firstTutorialBackBtn;

  @NonNull
  public final ImageView firstTutorialImg;

  @NonNull
  public final Button firstTutorialNextBtn;

  @NonNull
  public final TextView firstTutorialText;

  @NonNull
  public final ConstraintLayout guida1;

  private FragmentGuida1Binding(@NonNull ConstraintLayout rootView,
      @NonNull Button firstTutorialBackBtn, @NonNull ImageView firstTutorialImg,
      @NonNull Button firstTutorialNextBtn, @NonNull TextView firstTutorialText,
      @NonNull ConstraintLayout guida1) {
    this.rootView = rootView;
    this.firstTutorialBackBtn = firstTutorialBackBtn;
    this.firstTutorialImg = firstTutorialImg;
    this.firstTutorialNextBtn = firstTutorialNextBtn;
    this.firstTutorialText = firstTutorialText;
    this.guida1 = guida1;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentGuida1Binding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentGuida1Binding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_guida1, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentGuida1Binding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.firstTutorialBackBtn;
      Button firstTutorialBackBtn = ViewBindings.findChildViewById(rootView, id);
      if (firstTutorialBackBtn == null) {
        break missingId;
      }

      id = R.id.firstTutorialImg;
      ImageView firstTutorialImg = ViewBindings.findChildViewById(rootView, id);
      if (firstTutorialImg == null) {
        break missingId;
      }

      id = R.id.firstTutorialNextBtn;
      Button firstTutorialNextBtn = ViewBindings.findChildViewById(rootView, id);
      if (firstTutorialNextBtn == null) {
        break missingId;
      }

      id = R.id.firstTutorialText;
      TextView firstTutorialText = ViewBindings.findChildViewById(rootView, id);
      if (firstTutorialText == null) {
        break missingId;
      }

      ConstraintLayout guida1 = (ConstraintLayout) rootView;

      return new FragmentGuida1Binding((ConstraintLayout) rootView, firstTutorialBackBtn,
          firstTutorialImg, firstTutorialNextBtn, firstTutorialText, guida1);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
