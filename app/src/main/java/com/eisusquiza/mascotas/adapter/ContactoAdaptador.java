package com.eisusquiza.mascotas.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.eisusquiza.mascotas.ActivityNotificaciones;
import com.eisusquiza.mascotas.EnviarRespuestaAFirebase2;
import com.eisusquiza.mascotas.EnviarRespuestaFirebase;
import com.eisusquiza.mascotas.Mascota;
import com.eisusquiza.mascotas.R;
import com.eisusquiza.mascotas.restApiServer.EndPointsServer;
import com.eisusquiza.mascotas.restApiServer.adapterServer.RestApiAdapterServer;
import com.eisusquiza.mascotas.restApiServer.modelServer.UsuarioResponseServer;
import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.eisusquiza.mascotas.ActivityNotificaciones.id_foto_instagram;
import static com.eisusquiza.mascotas.EnviarRespuestaAFirebase2.id_instagram;

/**
 * Created by eisusquiza on 27/11/2016.
 */

public class ContactoAdaptador extends RecyclerView.Adapter<ContactoAdaptador.ContactoViewHolder>{




    public ContactoAdaptador(ArrayList<Mascota> mascotas, Activity activity){
        this.mascotas = mascotas;
        this.activity= activity;
    }

    ArrayList<Mascota> mascotas;
    Activity activity;

    @Override
    public ContactoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) { //INFLAR EL LAYOUT y LO PASARÁ A UN VIEWHOLDER PARA QUE OBTENGA LOS VIEWS
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascotas, parent, false);
        return new ContactoViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ContactoViewHolder holder, int position) { //ASOCIA CADA ELEMENTO DE LA LISTA CON CADA VIEW

        final Mascota m = mascotas.get(position);
        Picasso.with(activity)
                .load(m.getPicture())
                .placeholder(R.drawable.monkeyhead)
                .into(holder.foto);
        //mascotaViewHolder.imgFotoContacto.setImageResource(mascota.getFoto());
        //mascotaViewHolder.tvNombreCV.setText(mascota.getNombre());
        //mascotaViewHolder.tvLikesCV.setText(String.valueOf(mascota.getLikes()));

        if(position%2==0)
            holder.foto.setBackgroundResource(R.color.fondo1);
        else
            holder.foto.setBackgroundResource(R.color.fondo2);
        Calendar c=Calendar.getInstance();
        c.setTimeInMillis(Long.parseLong(m.getFecha())*1000);
        SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yy hh:mm:ss");
        holder.fecha.setText(sdf.format(c.getTime()));
        holder.nombre.setText(m.getNombre());
        holder.votos.setText(m.getVotos()+"");

        holder.foto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(activity, "Diste Like a: " + m.getNombre(), Toast.LENGTH_SHORT).show();
                Toast.makeText(activity, "El id de la fotos es: " + m.getId_fotos(), Toast.LENGTH_SHORT).show();
                id_foto_instagram=m.getId_fotos();
                id_instagram=m.getNombre();
                enviardatos();

                //EnviarRespuestaFirebase.enviardatosinstagram();
            }
        });

    }

    private void enviardatos() {
        Intent i = new Intent(activity, EnviarRespuestaAFirebase2.class);
        i.putExtra("id_foto_instagram", id_foto_instagram);
        i.putExtra("id_instagram", id_instagram);
        activity.startActivity(i);

    }





       /* mascotaViewHolder.btnHueso.setOnClickListener(new View.OnClickListener() {
           // int contador = 0;
           //TextView tvNumeroEstrellasCV = (TextView) View.OnClickListener.findViewById(R.id.tvNumeroEstrellasCV);
         //   TextView tvNumeroEstrellasCV = (TextView) findViewById(R.id.tvNumeroEstrellasCV);

           @Override
            public void onClick(View v) {
                Toast.makeText(activity, "Diste Like a :" + mascota.getNombre(), Toast.LENGTH_SHORT).show();
               // contador++;

               ConstructorContactos constructorContactos = new ConstructorContactos(activity);
               constructorContactos.darLikeContacto(mascota);
               mascotaViewHolder.tvLikesCV.setText(constructorContactos.obtenerLikesContacto(mascota)+ " "+ "Likes");

            }
        });*/



    @Override
    public int getItemCount () { //CANTIDAD DE ELEMENTOS QUE CONTIENE MI LISTA de CONTACTOS
        return mascotas.size();
    }

public static class ContactoViewHolder extends RecyclerView.ViewHolder{
    private ImageView foto;
    private TextView nombre,votos,fecha, id_foto;


    public ContactoViewHolder(View itemView) {
        super(itemView);
        foto=(ImageView) itemView.findViewById(R.id.imgFotoContacto);
        nombre=(TextView)itemView.findViewById(R.id.tvNombreCV);
        votos=(TextView)itemView.findViewById(R.id.votos);
        fecha=(TextView)itemView.findViewById(R.id.fecha);
        id_foto=(TextView)itemView.findViewById(R.id.id_fotos);
    }
}
}


