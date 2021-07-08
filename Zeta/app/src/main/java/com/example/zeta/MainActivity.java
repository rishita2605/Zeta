package com.example.zeta;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button needhelpbtn, helpbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        needhelpbtn = (Button) findViewById(R.id.needhelpbtn);
        helpbtn = (Button) findViewById(R.id.helpbtn);

        helpbtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                //Toast.makeText(getBaseContext(), "Success", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(MainActivity.this, Signup.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        needhelpbtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Bundle bundle=new Bundle();
                //Toast.makeText(getBaseContext(), "Success", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(MainActivity.this, Location.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }
}