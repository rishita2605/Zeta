package com.example.zeta;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Location extends AppCompatActivity {
    EditText locationstr;
    Button conti;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);
        conti=findViewById(R.id.conti);
        locationstr=findViewById(R.id.locationinput);

        conti.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                //Toast.makeText(getBaseContext(), "Success", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(Location.this, Services.class);
                intent.putExtra("Location", locationstr.getText().toString());
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });


    }


    public String  getlocation() {

        locationstr = findViewById(R.id.locationinput);
        String loci=""+locationstr;
        return loci;


    }
}