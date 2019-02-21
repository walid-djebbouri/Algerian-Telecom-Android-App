package com.zimaheka.merwan_walid.algerietelecome;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void envoyer (View view){

        final EditText em = (EditText)findViewById(R.id.editText);
        final EditText ps = (EditText)findViewById(R.id.editText2);

        final String email = em.getText().toString().trim();
        final String passWord = ps.getText().toString().trim();

        Response.Listener<String>  stringListener = new Response.Listener<String>(){


            @Override
            public void onResponse(String response) {

                try {
                    JSONObject jsonObject = new JSONObject(response);
                    boolean success = jsonObject.getBoolean("success");
                    if (success){

                        Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                        int i  = 0 ;
                        while ( i  < jsonObject.getInt("nb")){

                            intent.putExtra("nom"+String.valueOf(i) , jsonObject.getString(String.valueOf(i)));
                            intent.putExtra("prenom"+String.valueOf(i+1) , jsonObject.getString(String.valueOf(i+1)));
                            intent.putExtra("wilaya"+String.valueOf(i+2) , jsonObject.getString(String.valueOf(i+2)));
                            intent.putExtra("daira"+String.valueOf(i+3) , jsonObject.getString(String.valueOf(i+3)));
                            intent.putExtra("commune"+String.valueOf(i+4) , jsonObject.getString(String.valueOf(i+4)));
                            intent.putExtra("cité"+String.valueOf(i+5) , jsonObject.getString(String.valueOf(i+5)));
                            intent.putExtra("bloc"+String.valueOf(i+6) , jsonObject.getString(String.valueOf(i+6)));
                            intent.putExtra("porte"+String.valueOf(i+7) , jsonObject.getString(String.valueOf(i+7)));
                            intent.putExtra("telephone"+String.valueOf(i+8) , jsonObject.getString(String.valueOf(i+8)));
                            intent.putExtra("iddemande"+String.valueOf(i+9) , jsonObject.getString(String.valueOf(i+9)));

                            i = i+10 ;
                        }

                        intent.putExtra("nb", i) ;





                        startActivity(intent);
                        finish();





                    }
                    else {

                        Toast.makeText(getApplicationContext() ,"Le Mot De Passe Ou L E-Mail Est Incorrecte" , Toast.LENGTH_LONG).show();

                    }
                }
                catch (JSONException e) {
                    e.printStackTrace();


                }
            }
        } ;


        connexion cnx = new connexion(email , passWord , stringListener ) ;
        RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);
        requestQueue.add(cnx);



    }


}
