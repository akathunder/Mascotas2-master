package com.eisusquiza.mascotas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.eisusquiza.mascotas.adapter.ContactoAdaptador;
import com.eisusquiza.mascotas.fragments.IListaMascotaFragment;
import com.eisusquiza.mascotas.presentador.IListadoMascotasPresenter;
import com.eisusquiza.mascotas.presentador.ListadoMascotasPresenter;

import java.util.ArrayList;

public class Favoritas extends AppCompatActivity  implements IListaMascotaFragment{

    RecyclerView listaFavoritos;
    IListadoMascotasPresenter presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favoritas);

        listaFavoritos = (RecyclerView) findViewById(R.id.rvListaFavoritas);
        presenter = new ListadoMascotasPresenter(this,this);
        presenter.getFavoritos();

        Toolbar miActionBar2 = (Toolbar) findViewById(R.id.miActionBar2);
        setSupportActionBar(miActionBar2);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }


    @Override
    public void generateVerticalLayout() {

        LinearLayoutManager llm=new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaFavoritos.setLayoutManager(llm);
    }

    @Override
    public ContactoAdaptador createAdapter(ArrayList<Mascota> mascotas) {
        ContactoAdaptador adaptador=new ContactoAdaptador(mascotas,this);
        return adaptador;
    }

    @Override
    public void initAdapter(ContactoAdaptador adapter) {
        listaFavoritos.setAdapter(adapter);
    }
}
