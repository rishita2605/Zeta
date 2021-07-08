// Generated by view binder compiler. Do not edit!
package com.example.zeta.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.example.zeta.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityMentalHealthBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final TextView mentout;

  @NonNull
  public final Button oxychangeloc;

  @NonNull
  public final TextView oxylocfield;

  @NonNull
  public final TextView textView26;

  private ActivityMentalHealthBinding(@NonNull ConstraintLayout rootView, @NonNull TextView mentout,
      @NonNull Button oxychangeloc, @NonNull TextView oxylocfield, @NonNull TextView textView26) {
    this.rootView = rootView;
    this.mentout = mentout;
    this.oxychangeloc = oxychangeloc;
    this.oxylocfield = oxylocfield;
    this.textView26 = textView26;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityMentalHealthBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityMentalHealthBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_mental_health, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityMentalHealthBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.mentout;
      TextView mentout = rootView.findViewById(id);
      if (mentout == null) {
        break missingId;
      }

      id = R.id.oxychangeloc;
      Button oxychangeloc = rootView.findViewById(id);
      if (oxychangeloc == null) {
        break missingId;
      }

      id = R.id.oxylocfield;
      TextView oxylocfield = rootView.findViewById(id);
      if (oxylocfield == null) {
        break missingId;
      }

      id = R.id.textView26;
      TextView textView26 = rootView.findViewById(id);
      if (textView26 == null) {
        break missingId;
      }

      return new ActivityMentalHealthBinding((ConstraintLayout) rootView, mentout, oxychangeloc,
          oxylocfield, textView26);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
