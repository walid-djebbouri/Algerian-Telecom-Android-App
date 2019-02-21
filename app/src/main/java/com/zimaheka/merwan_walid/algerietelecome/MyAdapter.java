package com.zimaheka.merwan_walid.algerietelecome;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.util.Pair;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Walid Djebbouri on 21/05/2018.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    Context context ;
    List<Client> list_cleint ;


    public MyAdapter(Context context, List<Client> list_client){

        this.context  = context ;
        this.list_cleint = list_client ;

    }



    @Override
    public int getItemCount() {
        return list_cleint.size();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.list_cell, parent , false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

       Client client = list_cleint.get(position) ;
        holder.name.setText(client.nom);
        holder.prenom.setText(client.prenom);
        holder.wilaya.setText(client.wilaya);
        holder.daira.setText(client.daira);
        holder.commune.setText(client.commune);
        holder.cite.setText(client.cite);
        holder.bloc.setText(client.bloc);
        holder.porte.setText(client.porte);
        holder.tel.setText(client.tel);
        holder.iddemande.setText(client.iddemande);




            }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private final TextView name;
        private final TextView prenom;
        private final TextView wilaya;
        private final TextView daira;
        private final TextView commune;
        private final TextView cite;
        private final TextView bloc;
        private final TextView porte;
        private final TextView tel;
        private final Button button ;
        private final TextView iddemande ;



        public MyViewHolder(final View itemView) {
            super(itemView);

            name = ((TextView) itemView.findViewById(R.id.nom));
            prenom = ((TextView) itemView.findViewById(R.id.prenom));
            wilaya = ((TextView) itemView.findViewById(R.id.wilaya));
            daira = ((TextView) itemView.findViewById(R.id.daira));
            commune = ((TextView) itemView.findViewById(R.id.commune));
            cite = ((TextView) itemView.findViewById(R.id.cite));
            bloc= ((TextView) itemView.findViewById(R.id.bloc));
            porte = ((TextView) itemView.findViewById(R.id.porte));
            tel = ((TextView) itemView.findViewById(R.id.tel));
            button = (Button)itemView.findViewById(R.id.Triater);
            iddemande = (TextView)itemView.findViewById(R.id.iddemande);



            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(itemView.getContext() , Main3Activity.class);
                    intent.putExtra("iddemande" , iddemande.getText().toString()) ;
                    itemView.getContext().startActivity(intent);



                }
            });
        }



    }





}

