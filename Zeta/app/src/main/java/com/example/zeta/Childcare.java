package com.example.zeta;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.util.ArrayList;

public class Childcare extends AppCompatActivity {

    ArrayList<String> addresslist= new ArrayList<>();
    ArrayList<String> namelist= new ArrayList<>();
    ArrayList<String> pincodelist= new ArrayList<>();
    ArrayList<String> phonelist= new ArrayList<>();
    ArrayList<String> emaillist= new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_childcare);
        parseJson();
    }
    public void parseJson()
    {
        try
        {
            InputStream inputStream=getAssets().open("childcare.json");
            int size= inputStream.available();
            byte[] data=new byte[size];
            inputStream.read(data);
            String readData=new String(data);
            JSONArray jsonarray= new JSONArray(readData);

            for(int i=0; i<jsonarray.length(); i++)
            {
                JSONObject jsonObject= jsonarray.getJSONObject(i);

                if(jsonObject.getString("City").equals(""))
                    addresslist.add(jsonObject.getString("Address"));
                namelist.add(jsonObject.getString("Address"));
                phonelist.add(jsonObject.getString("Address"));
                pincodelist.add(jsonObject.getString("Address"));
                emaillist.add(jsonObject.getString("Address"));

            }



        }
        catch (Exception e)
        {e.printStackTrace();}
    }

}
