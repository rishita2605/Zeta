package com.example.zeta;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.util.ArrayList;

public class Bedvaccancy extends AppCompatActivity {
    ArrayList<String> addresslist= new ArrayList<>();
    ArrayList<String> namelist= new ArrayList<>();
    ArrayList<String> zipcodelist= new ArrayList<>();
    TextView childout3,locfield;
    Button changelocbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bedvaccancy);
        childout3=findViewById(R.id.childout2);
        locfield=findViewById(R.id.bvchildlocfield);
//        changelocbtn=findViewById(R.id.bvchildchangeloc);
//
//        changelocbtn.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                Bundle bundle = new Bundle();
//                //Toast.makeText(getBaseContext(), "Success", Toast.LENGTH_SHORT).show();
//                Intent intent=new Intent(Bedvaccancy.this, Location.class);
//                intent.putExtras(bundle);
//                startActivity(intent);
//            }
//        });
        parseJson();
    }
    public void parseJson()
    {

        Bundle b=getIntent().getExtras();
        String loc=b.getString("Location").toLowerCase();
        locfield.setText("Location: "+b.getString("Location"));

        try
        {
            InputStream inputStream=getAssets().open("bedvaccancy.json");
            int size= inputStream.available();
            byte[] data=new byte[size];
            inputStream.read(data);
            String readData=new String(data,"UTF-8");
            JSONArray jsonarray= new JSONArray(readData);
            int flag=0;
            for(int i=0; i<jsonarray.length(); i++)
            {
                JSONObject jsonObject= jsonarray.getJSONObject(i);

                if(jsonObject.getString("city").toLowerCase().equals(loc)) {
                    flag=1;
                    addresslist.add(jsonObject.getString("street_address"));
                    namelist.add(jsonObject.getString("name"));
                    zipcodelist.add(jsonObject.getString("zip_code"));
                    childout3.append("Hospital Name: "+namelist+"\nAddress: "+addresslist+"\nZIP Code: "+zipcodelist+"\n\n");
                }


            }


            if(flag==0){
                Bundle bundle = new Bundle();
                Intent intent=new Intent(Bedvaccancy.this, Error.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }


        }
        catch (Exception e)
        {e.printStackTrace();}
    }
}