package com.eisusquiza.mascotas.fragments;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.eisusquiza.mascotas.Mascota;
import com.eisusquiza.mascotas.R;
import com.eisusquiza.mascotas.RockyAdaptador;
import com.eisusquiza.mascotas.Rockys;
import com.eisusquiza.mascotas.adapter.ContactoAdaptador;
import com.eisusquiza.mascotas.adapter.ContactoAdaptadorMiMascota;
import com.eisusquiza.mascotas.pojo.Foto;
import com.eisusquiza.mascotas.presentador.IMiMascotaPresenter;
import com.eisusquiza.mascotas.presentador.MiMascotaPresenter;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class PerfilFragment extends Fragment implements IMiMascotaFragment {


    private Mascota miMascota;
    private RecyclerView fotos;
    private IMiMascotaPresenter presenter;
    private ImageView thumnail;
    private TextView nombre;


    //ArrayList<Rockys> rockys;
    //RecyclerView listaRockys;

    public PerfilFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_perfil, container, false);

        View q = inflater.inflate(R.layout.fragment_perfil, container, false);
        SharedPreferences cuenta = getActivity().getSharedPreferences("Cuenta", Context.MODE_PRIVATE);
        String usuario = cuenta.getString("Usuario", "Usuario sin configurar");

        fotos = (RecyclerView) q.findViewById(R.id.rvRocky);
        thumnail = (ImageView) q.findViewById(R.id.imgPFDog);
        nombre = (TextView) q.findViewById(R.id.tvnombreMascota);
        presenter = new MiMascotaPresenter(this, getContext());

        if (usuario == "Usuario sin configurar") {
            nombre.setText("Usuario aun no configurado");
        }
        return q;
    }


    @Override
    public void generateGridLayout() {
        GridLayoutManager layoutManager=new GridLayoutManager(getContext(),3);
        fotos.setLayoutManager(layoutManager);
    }

    @Override
    public ContactoAdaptadorMiMascota crearAdaptador(ArrayList<Foto> fotos, Mascota m) {

        Log.i("Fotos fragment", fotos.size() + "");
        ContactoAdaptadorMiMascota adapter = new ContactoAdaptadorMiMascota(fotos, getActivity());
        Picasso.with(getContext()).load(m.getPicture()).placeholder(R.drawable.monkeyhead).into(thumnail);
        nombre.setText(m.getNombre());
        return adapter;
    }

    @Override
    public void inicializarAdaptadorRV(ContactoAdaptadorMiMascota adaptador) {

        fotos.setAdapter(adaptador);
    }
}
