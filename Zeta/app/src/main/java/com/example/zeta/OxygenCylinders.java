package com.example.zeta;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
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

    ArrayList<String> numberlist = new ArrayList<>();
    ArrayList<String> agencylist = new ArrayList<>();
    ArrayList<String> namelist = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oxygen_cylinders);

        //agencyName=(TextView) findViewById(R.id.agency_name);
        //personName=(TextView) findViewById(R.id.person_name);
        //contactNumber=(TextView) findViewById(R.id.contact_number);
        //city=(TextView) findViewById(R.id.city);
        parseJSON();
    }

    public void parseJSON(){
        String json;
        try{
            InputStream is=getAssets().open("oxygenCylinders.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();

            json = new String(buffer,"UTF-8");
            JSONArray jsonArray=new JSONArray(json);

            for(int i=0; i<jsonArray.length(); i++){
                JSONObject obj=jsonArray.getJSONObject(i);

                if(obj.getString("City").equals("Bangalore")){
                    numberlist.add(obj.getString("Phone number"));
                    agencylist.add(obj.getString("Agency name"));
                    namelist.add(obj.getString("Name"));
                }
            }

            //Toast.makeText(getApplicationContext(), numberlist.toString(),Toast.LENGTH_LONG).show();


        } catch (IOException e){
            e.printStackTrace();
        } catch(JSONException e){
            e.printStackTrace();
        }
    }
}