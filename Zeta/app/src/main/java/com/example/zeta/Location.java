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
        conti.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                //Toast.makeText(getBaseContext(), "Success", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(Location.this, Services.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }


    public void getlocation(View view) {
        locationstr = findViewById(R.id.loc);
        Intent pc=new Intent(this, Childcare.class);
        Intent pm=new Intent(this, MentalHealth.class);
        Intent pb=new Intent(this, Bedvaccancy.class);
        Intent po=new Intent(this, OxygenCylinders.class);
        pc.putExtra("loc", String.valueOf(locationstr.getText()));
        pb.putExtra("loc", String.valueOf(locationstr.getText()));
        pm.putExtra("loc", String.valueOf(locationstr.getText()));
        po.putExtra("loc", String.valueOf(locationstr.getText()));
        startActivity(pc);
        startActivity(pb);
        startActivity(pm);
        startActivity(po);
    }
}