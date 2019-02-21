package com.zimaheka.merwan_walid.algerietelecome;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class projet extends AppCompatActivity {

    String iddemande = null ;
    TextView textView = null ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_projet);

        Intent intent = getIntent() ;
        iddemande = intent.getStringExtra("iddemande" ) ;
        textView = (TextView)findViewById(R.id.date_projet) ;

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

                        Toast.makeText(getApplicationContext() ,"Le Mot De Passe Ou L E-Mail Est Incorrecte" , Toast.LENGTH_LONG).show();

                    }
                } catch (JSONException e) {
                    e.printStackTrace();


                }
            }
        } ;


        projet_cnx cnx= new projet_cnx( iddemande ,textView.getText().toString().trim() , stringListener ) ;
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        requestQueue.add(cnx);


    }

}
