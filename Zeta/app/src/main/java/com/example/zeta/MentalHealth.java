package com.example.zeta;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class MentalHealth extends AppCompatActivity {

    //TextView agencyName, personName, contactNumber, city;

    ArrayList<String> emaillist = new ArrayList<>();
    ArrayList<String> psychiatristlist = new ArrayList<>();
    ArrayList<String> numberlist = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mental_health);
        parseJSON();
    }

    public void parseJSON(){
        String json;
        try{
            InputStream is=getAssets().open("mentalhealth.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();

            json = new String(buffer,"UTF-8");
            JSONArray jsonArray=new JSONArray(json);

            for(int i=0; i<jsonArray.length(); i++){
                JSONObject obj=jsonArray.getJSONObject(i);

                if(obj.getString("City").equals("Bangalore")){
                    numberlist.add(obj.getString("Contact Number"));
                    psychiatristlist.add(obj.getString("Name of the Psychiatrist"));
                    emaillist.add(obj.getString("E-Mail Address"));
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