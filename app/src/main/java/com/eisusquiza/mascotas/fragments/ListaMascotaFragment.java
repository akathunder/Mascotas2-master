package com.eisusquiza.mascotas.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.eisusquiza.mascotas.IListadoMascotasView;
import com.eisusquiza.mascotas.Mascota;
import com.eisusquiza.mascotas.R;
import com.eisusquiza.mascotas.adapter.ContactoAdaptador;
import com.eisusquiza.mascotas.presentador.IListadoMascotasPresenter;
import com.eisusquiza.mascotas.presentador.ListadoMascotasPresenter;

import java.util.ArrayList;

/**
 * Created by eisusquiza on 30/01/2017.
 */

public class ListaMascotaFragment extends Fragment implements IListaMascotaFragment {

    private static ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;
    private IListadoMascotasPresenter presenter;



    public ListaMascotaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.detallemascotas, container, false);
        listaMascotas=(RecyclerView)v.findViewById(R.id.rvMascotas3);
        presenter=new ListadoMascotasPresenter(ListaMascotaFragment.this,getContext());
        presenter.getMascotasRest();
        return  v;
    }

    @Override
    public void generateVerticalLayout() {
        LinearLayoutManager llm=new LinearLayoutManager(getContext());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(llm);

    }

    @Override
    public ContactoAdaptador createAdapter(ArrayList<Mascota> mascotas) {
        ContactoAdaptador adaptador=new ContactoAdaptador(mascotas,getActivity());
        return adaptador;
    }

    @Override
    public void initAdapter(ContactoAdaptador adapter) {
        listaMascotas.setAdapter(adapter);

    }
}
