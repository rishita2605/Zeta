package com.example.zeta;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.util.ArrayList;

public class Bloodbank extends AppCompatActivity {
    ArrayList<String> addresslist= new ArrayList<>();
    ArrayList<String> namelist= new ArrayList<>();
    ArrayList<String> pincodelist= new ArrayList<>();
    ArrayList<String> phonelist= new ArrayList<>();
    ArrayList<String> emaillist= new ArrayList<>();
    TextView childout2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bloodbank);
        parseJson();
    }
    public void parseJson()
    {   Bundle bundle=getIntent().getExtras();
        //String place=bundle.getString("loc");
         String place="Kadiri";
        //Location l=new Location();
        //String place=l.getlocation();

        try
        {
            InputStream inputStream=getAssets().open("bloodBanks.json");
            int size= inputStream.available();
            byte[] data=new byte[size];
            inputStream.read(data);
            String readData=new String(data,"UTF-8");
            JSONArray jsonarray= new JSONArray(readData);

            for(int i=0; i<jsonarray.length(); i++)
            {
                JSONObject jsonObject= jsonarray.getJSONObject(i);

                if(jsonObject.getString("__city").equals(place)) {
                    String addresslist = (jsonObject.getString("__address"));
                    String namelist = (jsonObject.getString("_blood_bank_name"));
                    String phonelist = (jsonObject.getString("_mobile"));
                    String pincodelist = (jsonObject.getString("__pincode"));
                    String emaillist = (jsonObject.getString(" _email"));
                    childout2.append(addresslist+" - "+namelist+" - "+phonelist+" - "+pincodelist+" - "+emaillist+"\n");
                }
            }



        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}