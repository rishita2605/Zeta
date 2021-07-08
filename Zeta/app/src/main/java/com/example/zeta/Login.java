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

public class Login extends AppCompatActivity {

    EditText memail, mpassword;
    Button mloginbtn;
    TextView msigntxt;
    FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        memail=findViewById(R.id.lemail);
        mpassword=findViewById(R.id.lpassword);
        fAuth=FirebaseAuth.getInstance();
        mloginbtn=findViewById(R.id.loginbtn);
        msigntxt=findViewById(R.id.lsignup);

        mloginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String email = memail.getText().toString().trim();
                String password = mpassword.getText().toString().trim();


                if(TextUtils.isEmpty(email)){
                    memail.setError("Email required.");
                    return;
                }
                if(TextUtils.isEmpty(password)){
                    mpassword.setError("Password id required.");
                    return;
                }

                if(password.length()<6){
                    mpassword.setError("Password must contain at least 6 characters. ");
                    return;
                }

                //authenticate user

                fAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull  Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(Login.this, "Logged in successfully", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),SignupDestination.class));
                        }
                        else{
                            Toast.makeText(Login.this, "Error! "+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });


                msigntxt.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(getApplicationContext(), Signup.class));
                    }
                });


            }
        });
    }

}