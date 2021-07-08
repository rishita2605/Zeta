package com.example.zeta;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

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
    TextView mentout,locfield;
    Button changelocbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mental_health);
        mentout=(TextView)findViewById(R.id.mentout);
        changelocbtn=(Button)findViewById(R.id.oxychangeloc);
        locfield=(TextView)findViewById(R.id.oxylocfield);

        changelocbtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                //Toast.makeText(getBaseContext(), "Success", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(MentalHealth.this, Location.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        parseJSON();
    }

    public void parseJSON(){
        //String place=bundle.getString("loc");
        Bundle b=getIntent().getExtras();
        String loc=b.getString("Location").toLowerCase();
        locfield.setText("Location: "+b.getString("Location"));
        String place="Bangalore";
        String json;
        try{
            InputStream is=getAssets().open("mentalhealth.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();

            json = new String(buffer,"UTF-8");
            JSONArray jsonArray=new JSONArray(json);
            int flag=0;
            for(int i=0; i<jsonArray.length(); i++){

                JSONObject obj=jsonArray.getJSONObject(i);
                //Toast.makeText(getBaseContext(),"Namaste", Toast.LENGTH_SHORT).show();
                //String str=obj.getString("Name of the District");
                //Toast.makeText(getBaseContext(),str+"", Toast.LENGTH_SHORT).show();

                if(loc.equals(obj.getString("Name of the District").toLowerCase())){
                    flag=1;
                    String numberlist=(obj.getString("Contact Number"));
                    String psychiatristlist=(obj.getString("Name of the Psychiatrist"));
                    String emaillist=(obj.getString("E-Mail Address"));
                    String city=(obj.getString("Name of the District"));
                    mentout.append("Phone Number: "+numberlist+"\nName: "+psychiatristlist+"\nEmail: "+emaillist+"\nAddress: "+city+"\n\n");
                }

            }

            if(flag==0){
                Bundle bundle = new Bundle();
                Intent intent=new Intent(MentalHealth.this, Error.class);
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