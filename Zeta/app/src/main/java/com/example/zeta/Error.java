package com.example.zeta;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Error extends AppCompatActivity {
    Button locationbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_error);
        locationbtn = (Button)findViewById(R.id.locationbtn);

        locationbtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                //Toast.makeText(getBaseContext(), "Success", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(Error.this, Location.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }
}