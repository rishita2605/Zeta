package com.example.zeta;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Text;

public class Signup extends AppCompatActivity {
    EditText mname, memail, mpassword, mphone, mlocation;
    Button msignupBtn;
    TextView mloginBtn;
    FirebaseAuth fAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        mname = findViewById(R.id.name);
        memail = findViewById(R.id.email);
        mpassword = findViewById(R.id.password);
        mphone = findViewById(R.id.phone);
        mlocation = findViewById(R.id.location);
        msignupBtn = findViewById(R.id.signupbtn);
        mloginBtn = findViewById(R.id.sloginbtn);
        fAuth = FirebaseAuth.getInstance();

        //if(fAuth.getCurrentUser() != null){
            //startActivity(new Intent(getApplicationContext(),MainActivity.class));
            //finish();
        //}

        msignupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String email = memail.getText().toString().trim();
                String password = mpassword.getText().toString().trim();
                final String location = mlocation.getText().toString().trim();
                final String phone = mphone.getText().toString().trim();
                final String name = mname.getText().toString().trim();

                if(TextUtils.isEmpty(email)){
                    memail.setError("Email required.");
                    return;
                }
                if(TextUtils.isEmpty(password)){
                    mpassword.setError("Password id required.");
                    return;
                }
                if(TextUtils.isEmpty(location)){
                    mlocation.setError("Location is required");
                }
                if(TextUtils.isEmpty(phone)){
                    mphone.setError("Phone number is required");
                }
                if(TextUtils.isEmpty(name)){
                    mname.setError("Name is required");
                }
                if(password.length()<6){
                    mpassword.setError("Password must contain at least 6 characters. ");
                    return;
                }







                //register user in firebase

                fAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            User user = new User(
                                    name,
                                    email,
                                    location,
                                    phone
                            );

                            FirebaseDatabase.getInstance().getReference("Users")
                                    .child(FirebaseAuth.getInstance().getCurrentUser().getUid()).
                                    setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if(task.isSuccessful()){
                                        Toast.makeText(Signup.this, "Signed up successfully", Toast.LENGTH_SHORT).show();
                                        startActivity(new Intent(getApplicationContext(),SignupDestination.class));
                                    }
                                    else {
                                        Toast.makeText(Signup.this, "Error! "+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });

                        }
                        else{
                            Toast.makeText(Signup.this, "Error! "+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });

                //fAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                //@Override
                //public void onComplete(@NonNull Task<AuthResult> task) {
                //if(task.isSuccessful()){
                //Toast.makeText(Signup.this, "User Created.", Toast.LENGTH_SHORT).show();
                //startActivity(new Intent(getApplicationContext(),MainActivity.class));
                //}
                //else{
                //Toast.makeText(Signup.this, "Error! "+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                //}
                //}
                //});
            }
        });
    }

}