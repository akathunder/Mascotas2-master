package com.eisusquiza.mascotas.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.eisusquiza.mascotas.Favoritas;
import com.eisusquiza.mascotas.Mascota;
import com.eisusquiza.mascotas.R;
import com.eisusquiza.mascotas.pojo.Foto;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by eisusquiza on 28/11/2016.
 */

public class ContactoAdaptadorMiMascota extends RecyclerView.Adapter<ContactoAdaptadorMiMascota.MiMascotaViewHolder>{



    public ContactoAdaptadorMiMascota(ArrayList<Foto> fotos, Activity a){
        this.fotos= fotos;
        this.context=a;

    }

    ArrayList<Foto> fotos;
    private Activity context;


    @Override
    public ContactoAdaptadorMiMascota.MiMascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_grid_mascota,parent,false);
        return new MiMascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ContactoAdaptadorMiMascota.MiMascotaViewHolder holder, int position) {

        Foto x=fotos.get(position);
        Picasso.with(context)
                .load(x.getUrl())
                .placeholder(R.drawable.huella_de_gato_48)
                .into(holder.foto);
        holder.votos.setText(x.getVotos()+"");
    }

    @Override
    public int getItemCount() {
        return fotos.size();
    }

    public class MiMascotaViewHolder extends RecyclerView.ViewHolder {
        public  ImageView foto;
        public TextView votos;
        public MiMascotaViewHolder(View itemView) {
            super(itemView);
            foto=(ImageView)itemView.findViewById(R.id.imgFotoMiMascota);
            votos=(TextView)itemView.findViewById(R.id.tvLikes2);
        }
    }
}