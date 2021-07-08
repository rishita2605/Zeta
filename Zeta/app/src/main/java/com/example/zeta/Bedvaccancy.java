package com.example.zeta;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.util.ArrayList;

public class Bedvaccancy extends AppCompatActivity {
    ArrayList<String> addresslist= new ArrayList<>();
    ArrayList<String> namelist= new ArrayList<>();
    ArrayList<String> zipcodelist= new ArrayList<>();
    TextView childout3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bedvaccancy);
        childout3=findViewById(R.id.childout2);
        parseJson();
    }
    public void parseJson()
    {  Bundle bundle=getIntent().getExtras();
        String place=bundle.getString("loc");
        try
        {
            InputStream inputStream=getAssets().open("bedvaccancy.json");
            int size= inputStream.available();
            byte[] data=new byte[size];
            inputStream.read(data);
            String readData=new String(data,"UTF-8");
            JSONArray jsonarray= new JSONArray(readData);

            for(int i=0; i<jsonarray.length(); i++)
            {
                JSONObject jsonObject= jsonarray.getJSONObject(i);

                if(jsonObject.getString("city").equals(place))
                    addresslist.add(jsonObject.getString("street_address"));
                namelist.add(jsonObject.getString("name"));

                zipcodelist.add(jsonObject.getString("zip_code"));
                childout3.append(addresslist+" - "+namelist+" - "+zipcodelist+"\n");


            }



        }
        catch (Exception e)
        {e.printStackTrace();}
    }
}