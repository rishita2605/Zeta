// Generated by view binder compiler. Do not edit!
package com.example.zeta.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.example.zeta.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityBedvaccancyBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final TextView childout2;

  @NonNull
  public final TextView textView26;

  private ActivityBedvaccancyBinding(@NonNull ConstraintLayout rootView,
      @NonNull TextView childout2, @NonNull TextView textView26) {
    this.rootView = rootView;
    this.childout2 = childout2;
    this.textView26 = textView26;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityBedvaccancyBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityBedvaccancyBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_bedvaccancy, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityBedvaccancyBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.childout2;
      TextView childout2 = rootView.findViewById(id);
      if (childout2 == null) {
        break missingId;
      }

      id = R.id.textView26;
      TextView textView26 = rootView.findViewById(id);
      if (textView26 == null) {
        break missingId;
      }

      return new ActivityBedvaccancyBinding((ConstraintLayout) rootView, childout2, textView26);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
