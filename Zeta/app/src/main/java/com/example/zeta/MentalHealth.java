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

public class MentalHealth extends AppCompatActivity {

    //TextView agencyName, personName, contactNumber, city;

    ArrayList<String> emaillist = new ArrayList<>();
    ArrayList<String> psychiatristlist = new ArrayList<>();
    ArrayList<String> numberlist = new ArrayList<>();
    TextView mentout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mental_health);
        mentout=(TextView)findViewById(R.id.mentout);
        parseJSON();
    }

    public void parseJSON(){
        Bundle bundle=getIntent().getExtras();
        String place=bundle.getString("loc");
        //String place="Bangalore";
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
                //Toast.makeText(getBaseContext(),"Namaste", Toast.LENGTH_SHORT).show();
                //String str=obj.getString("City");
                //String str=obj.getString("Name of the District");
                //Toast.makeText(getBaseContext(),str+"", Toast.LENGTH_SHORT).show();

                if(place.equals(obj.getString("Name of the District"))){
                    String numberlist=(obj.getString("Contact Number"));
                    String psychiatristlist=(obj.getString("Name of the Psychiatrist"));
                    String emaillist=(obj.getString("E-Mail Address"));
                    String city=(obj.getString("Name of the District"));
                    mentout.append(numberlist+" - "+psychiatristlist+" - "+emaillist+" - "+city+"\n\n");
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