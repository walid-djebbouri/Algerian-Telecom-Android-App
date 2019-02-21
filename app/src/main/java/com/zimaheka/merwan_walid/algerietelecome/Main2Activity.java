package com.zimaheka.merwan_walid.algerietelecome;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {

    ArrayList<Client> list_client  = null ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        list_client = new ArrayList<>();
        int i = 0 ;
        Intent intent = getIntent();
        while( i < intent.getIntExtra("nb" , 0) ){

            Client client = new Client(intent.getStringExtra("nom"+String.valueOf(i)),
                                       intent.getStringExtra("prenom"+String.valueOf(i+1)),
                    intent.getStringExtra("wilaya"+String.valueOf(i+2)),
                    intent.getStringExtra("daira"+String.valueOf(i+3)),
                    intent.getStringExtra("commune"+String.valueOf(i+4)),
                    intent.getStringExtra("cité"+String.valueOf(i+5)),
                    intent.getStringExtra("bloc"+String.valueOf(i+6)),
                    intent.getStringExtra("porte"+String.valueOf(i+7)),
                    intent.getStringExtra("telephone"+String.valueOf(i+8)),
                    intent.getStringExtra("iddemande"+String.valueOf(i+9))

            );

            i = i+10 ;

            list_client.add(client);

        }

        final RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recycle);

        recyclerView.setLayoutManager( new LinearLayoutManager(this) );

        recyclerView.setAdapter(new MyAdapter(getApplicationContext() , list_client ));


    }


}
