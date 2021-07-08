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

public class Childcare extends AppCompatActivity {

    ArrayList<String> addresslist= new ArrayList<>();
    ArrayList<String> namelist= new ArrayList<>();
    ArrayList<String> pincodelist= new ArrayList<>();
    ArrayList<String> phonelist= new ArrayList<>();
    ArrayList<String> emaillist= new ArrayList<>();
    TextView childout,locfield;
    Button changelocbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_childcare);
        childout=findViewById(R.id.childout);
        locfield=findViewById(R.id.childlocfield);
        changelocbtn=findViewById(R.id.childchangeloc);

        changelocbtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                //Toast.makeText(getBaseContext(), "Success", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(Childcare.this, Location.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        parseJson();
    }
    public void parseJson()
    {   Bundle b=getIntent().getExtras();
        String loc=b.getString("Location").toLowerCase();
        locfield.setText("Location: "+b.getString("Location"));

        try
        {
            InputStream inputStream=getAssets().open("childcare.json");
            int size= inputStream.available();
            byte[] data=new byte[size];
            inputStream.read(data);
            String readData=new String(data,"UTF-8");
            JSONArray jsonarray= new JSONArray(readData);
            int flag=0;
            for(int i=0; i<jsonarray.length(); i++)
            {
                JSONObject jsonObject= jsonarray.getJSONObject(i);

                if(jsonObject.getString("City").toLowerCase().equals(loc)) {
                    flag=1;
                    String addresslist = (jsonObject.getString("Address"));
                    String namelist = (jsonObject.getString("Name"));
                    String phonelist = (jsonObject.getString("Ph no"));
                    String pincodelist = (jsonObject.getString("Pincode"));
                    String emaillist = (jsonObject.getString("Email"));
                    //childout.append(addresslist+" - "+namelist+" - "+phonelist+" - "+pincodelist+" - "+emaillist+"\n");
                    childout.append("Name: "+namelist+"\nPhone Number: "+phonelist+"\nAddress: "+addresslist+"\nPincode: "+pincodelist+"\nEmail: "+emaillist+"\n\n");
                    //childout.append("Hello");
                }
            }


            if(flag==0){
                Bundle bundle = new Bundle();
                Intent intent=new Intent(Childcare.this, Error.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }


        }
        catch (Exception e){
                e.printStackTrace();
        }
    }


}
