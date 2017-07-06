package com.eisusquiza.mascotas.fragments;

import com.eisusquiza.mascotas.Mascota;
import com.eisusquiza.mascotas.adapter.ContactoAdaptador;

import java.util.ArrayList;

/**
 * Created by eisusquiza on 09/01/2017.
 */

public interface IRecyclerViewFragmentViewUsuarios {

    public void generarLinearLayoutVertical ();

    public void generarGridLayout();

    public ContactoAdaptador crearAdaptador (ArrayList<Mascota> mascotas);

    public void inicializarAdaptadorRV (ContactoAdaptador adaptador);
}
