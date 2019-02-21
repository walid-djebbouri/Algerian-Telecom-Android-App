package com.zimaheka.merwan_walid.algerietelecome;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class Zone extends AppCompatActivity {

    String iddemande = null ;
    TextView textView = null ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zone);

        Intent intent = getIntent() ;
        iddemande = intent.getStringExtra("iddemande"  ) ;

        textView = (TextView)findViewById(R.id.nom_zone) ;
    }

    public void enregistrer (View view){


        Response.Listener<String>  stringListener = new Response.Listener<String>(){


            @Override
            public void onResponse(String response) {

                try {
                    JSONObject jsonObject = new JSONObject(response);
                    boolean success = jsonObject.getBoolean("success");
                    if (success){


                        finish();





                    }
                    else {

                        Toast.makeText(getApplicationContext() ,"il y a un problème " , Toast.LENGTH_LONG).show();

                    }
                } catch (JSONException e) {
                    e.printStackTrace();


                }
            }
        } ;


        Zone_cnx zone_cnx = new Zone_cnx(iddemande , textView.getText().toString().trim() ,  stringListener ) ;
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        requestQueue.add(zone_cnx);


    }
}
