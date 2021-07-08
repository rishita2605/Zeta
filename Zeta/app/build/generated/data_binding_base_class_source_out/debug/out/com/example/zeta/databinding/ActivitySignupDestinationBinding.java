// Generated by view binder compiler. Do not edit!
package com.example.zeta.databinding;

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
import com.example.zeta.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivitySignupDestinationBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final ImageView imageView11;

  @NonNull
  public final Button logout;

  @NonNull
  public final TextView textView3;

  @NonNull
  public final TextView textView6;

  private ActivitySignupDestinationBinding(@NonNull ConstraintLayout rootView,
      @NonNull ImageView imageView11, @NonNull Button logout, @NonNull TextView textView3,
      @NonNull TextView textView6) {
    this.rootView = rootView;
    this.imageView11 = imageView11;
    this.logout = logout;
    this.textView3 = textView3;
    this.textView6 = textView6;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivitySignupDestinationBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivitySignupDestinationBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_signup_destination, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivitySignupDestinationBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.imageView11;
      ImageView imageView11 = rootView.findViewById(id);
      if (imageView11 == null) {
        break missingId;
      }

      id = R.id.logout;
      Button logout = rootView.findViewById(id);
      if (logout == null) {
        break missingId;
      }

      id = R.id.textView3;
      TextView textView3 = rootView.findViewById(id);
      if (textView3 == null) {
        break missingId;
      }

      id = R.id.textView6;
      TextView textView6 = rootView.findViewById(id);
      if (textView6 == null) {
        break missingId;
      }

      return new ActivitySignupDestinationBinding((ConstraintLayout) rootView, imageView11, logout,
          textView3, textView6);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
