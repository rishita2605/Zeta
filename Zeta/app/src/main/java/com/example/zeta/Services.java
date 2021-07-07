package com.example.zeta;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class Services extends AppCompatActivity {
  LinearLayout pharm, oxycyl, menh, chis, bedvac;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services);
        pharm=findViewById(R.id.pharm);
        oxycyl=findViewById(R.id.oxycyl);
        menh=findViewById(R.id.menh);
        chis=findViewById(R.id.chis);
        bedvac=findViewById(R.id.bedvac);

        oxycyl.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                openoc();
            }
        });
        menh.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                openmh();
            }
        });
        chis.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                opencc();
            }
        });
        bedvac.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                openbv();
            }
        });
        pharm.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Intent viewIntent =
                        new Intent("android.intent.action.VIEW",
                                Uri.parse("https://www.medicineindia.org/pharmacies-chemists-drugstores-in-india"));
                startActivity(viewIntent);
            }
        });



    }

    public void openoc()
    {
        Intent intent = new Intent(this, OxygenCylinders.class);
        startActivity(intent);
    }
    public void openmh()
    {
        Intent intent = new Intent(this, MentalHealth.class);
        startActivity(intent);
    }
    public void openbv()
    {
        Intent intent = new Intent(this, Bedvaccancy.class);
        startActivity(intent);
    }
    public void opencc()
    {
        Intent intent = new Intent(this, Childcare.class);
        startActivity(intent);
    }
}