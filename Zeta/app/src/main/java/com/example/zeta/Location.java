package com.example.zeta;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Location extends AppCompatActivity {
    EditText locationstr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);
    }


    public void getlocation(View view) {
        locationstr = findViewById(R.id.loc);
        Intent pc=new Intent(this, Childcare.class);
        Intent pm=new Intent(this, MentalHealth.class);
        Intent pb=new Intent(this, Bedvaccancy.class);
        Intent po=new Intent(this, OxygenCylinders.class);
        pc.putExtra("loc", String.valueOf(locationstr));
        pb.putExtra("loc", String.valueOf(locationstr));
        pm.putExtra("loc", String.valueOf(locationstr));
        po.putExtra("loc", String.valueOf(locationstr));
        startActivity(pc);
        startActivity(pb);
        startActivity(pm);
        startActivity(po);
    }
}