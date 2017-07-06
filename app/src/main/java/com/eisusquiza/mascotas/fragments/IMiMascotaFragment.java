package com.eisusquiza.mascotas.fragments;

import com.eisusquiza.mascotas.Mascota;
import com.eisusquiza.mascotas.adapter.ContactoAdaptador;
import com.eisusquiza.mascotas.adapter.ContactoAdaptadorMiMascota;
import com.eisusquiza.mascotas.pojo.Foto;

import java.util.ArrayList;

/**
 * Created by eisusquiza on 29/01/2017.
 */

public interface IMiMascotaFragment {
    public void generateGridLayout();

    ContactoAdaptadorMiMascota crearAdaptador(ArrayList<Foto> fotos, Mascota m);

    void inicializarAdaptadorRV(ContactoAdaptadorMiMascota adaptador);

}


