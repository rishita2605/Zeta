package com.example.zeta;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class Services extends AppCompatActivity {
  LinearLayout pharm, menh, chis, bedvac,oxycyl;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services);

        pharm=findViewById(R.id.pharm);
        oxycyl=(LinearLayout)findViewById(R.id.oxycyl);
        menh=(LinearLayout) findViewById(R.id.menh);
        chis=(LinearLayout)findViewById(R.id.chis);
        bedvac=(LinearLayout)findViewById(R.id.bedvac);

        Bundle b=getIntent().getExtras();
        String loc=b.getString("Location");
        //Toast.makeText(getBaseContext(), loc, Toast.LENGTH_SHORT).show();

        oxycyl.setOnClickListener(new View.OnClickListener(){
            public void onClick(View arg) {
                openoc();
                //Toast.makeText(getBaseContext(), "Success", Toast.LENGTH_SHORT).show();
            }
        });
        menh.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg) {
                //Toast.makeText(getBaseContext(), "Success", Toast.LENGTH_SHORT).show();
                openmh();
            }
        });
        chis.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg) {
                opencc();
            }
        });
        bedvac.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg) {
                openbv();
                //Toast.makeText(getBaseContext(), "Success", Toast.LENGTH_SHORT).show();
            }
        });

        pharm.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg) {
                Intent viewIntent =
                        new Intent("android.intent.action.VIEW",
                                Uri.parse("https://www.medicineindia.org/pharmacies-chemists-drugstores-in-india"));
                startActivity(viewIntent);
            }
        });



    }

    public void openoc()
    {

        Bundle b=getIntent().getExtras();
        Intent intent = new Intent(this, OxygenCylinders.class);
        intent.putExtras(b);
        startActivity(intent);
    }
    public void openmh()
    {
        //Toast.makeText(getBaseContext(), "Success", Toast.LENGTH_SHORT).show();
        Bundle b=getIntent().getExtras();
        String loc=b.getString("Location");
        Intent intent = new Intent(Services.this, MentalHealth.class);
        intent.putExtras(b);
        startActivity(intent);
    }
    public void openbv()
    {
        //Toast.makeText(getBaseContext(), "Successfool", Toast.LENGTH_SHORT).show();
        Bundle bundle = new Bundle();
        Intent intent = new Intent(this, Bedvaccancy.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }
    public void opencc()
    {
        Bundle b=getIntent().getExtras();
        Intent intent = new Intent(Services.this, Childcare.class);
        intent.putExtras(b);
        startActivity(intent);
    }
}