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
    TextView childout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_childcare);
        childout=findViewById(R.id.childout);
        parseJson();
    }
    public void parseJson()
    {   Bundle bundle=getIntent().getExtras();
        //String place=bundle.getString("loc");
        String place="Panjim";

        try
        {
            InputStream inputStream=getAssets().open("childcare.json");
            int size= inputStream.available();
            byte[] data=new byte[size];
            inputStream.read(data);
            String readData=new String(data,"UTF-8");
            JSONArray jsonarray= new JSONArray(readData);

            for(int i=0; i<jsonarray.length(); i++)
            {
                JSONObject jsonObject= jsonarray.getJSONObject(i);

                if(jsonObject.getString("City").equals(place)) {
                    String addresslist = (jsonObject.getString("Address"));
                    String namelist = (jsonObject.getString("Name"));
                    String phonelist = (jsonObject.getString("Ph no"));
                    String pincodelist = (jsonObject.getString("Pincode"));
                    String emaillist = (jsonObject.getString("Email"));
                    childout.append(addresslist+" - "+namelist+" - "+phonelist+" - "+pincodelist+" - "+emaillist+"\n");
                }
            }



        }
        catch (Exception e){
                e.printStackTrace();
        }
    }


}
