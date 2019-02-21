package com.zimaheka.merwan_walid.algerietelecome;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Main3Activity extends AppCompatActivity {

    String iddemande = null ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        Intent intent0 = getIntent();
        iddemande = intent0.getStringExtra("iddemande") ;
    }

    public void zone(View view){

        Intent intent = new Intent(this , Zone.class);
        intent.putExtra("iddemande" , iddemande) ;
        startActivity(intent);
        finish();
    }


    public void projet(View view){

        Intent intent = new Intent(this , projet.class);
        intent.putExtra("iddemande" , iddemande) ;
        startActivity(intent);
        finish();
    }


    public void traiter(View view){

        Intent intent = new Intent(this , traiter.class);
        intent.putExtra("iddemande" , iddemande) ;
        startActivity(intent);
        finish();
    }
}
