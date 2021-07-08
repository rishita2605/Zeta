package com.example.zeta;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class OxygenCylinders extends AppCompatActivity {

    //TextView agencyName, personName, contactNumber, city;
    TextView out, locfield;
//    ArrayList<String> numberlist = new ArrayList<>();
//    ArrayList<String> agencylist = new ArrayList<>();
//    ArrayList<String> namelist = new ArrayList<>();
    Button oxychangeloc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oxygen_cylinders);
        out=findViewById(R.id.out);
        oxychangeloc=findViewById(R.id.oxychangeloc);
        locfield=findViewById(R.id.oxylocfield);

        oxychangeloc.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                //Toast.makeText(getBaseContext(), "Success", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(OxygenCylinders.this, Location.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        parseJSON();
    }

    public void parseJSON(){

        //String place=bundle.getString("loc");
        String place="Bangalore";
        String json;
        try{
            InputStream is=getAssets().open("oxygenCylinders.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();

            json = new String(buffer,"UTF-8");
            JSONArray jsonArray=new JSONArray(json);
            int flag=0;
            Bundle b=getIntent().getExtras();
            String loc=b.getString("Location").toLowerCase();
            locfield.setText("Location: "+b.getString("Location"));

            for(int i=0; i<jsonArray.length(); i++){

                JSONObject obj = jsonArray.getJSONObject(i);
                if(obj.getString("City").toLowerCase().equals(loc)){
                    flag=1;
                    int Phone = obj.getInt("Phone number");
                    String Agency = obj.getString("Agency name");
                    String Name = obj.getString("Name");
                    out.append("Name: "+Name+"\nAgency: "+ Agency +"\nPhone Number: "+Phone+"\n\n");
                }

            }

            if(flag==0){
                Bundle bundle= new Bundle();
                Intent intent=new Intent(OxygenCylinders.this, Error.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
            //Toast.makeText(getApplicationContext(), numberlist.toString(),Toast.LENGTH_LONG).show();


        } catch (IOException e){
            e.printStackTrace();
        } catch(JSONException e){
            e.printStackTrace();
        }
    }
}