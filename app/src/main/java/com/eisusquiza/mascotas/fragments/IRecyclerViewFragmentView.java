package com.eisusquiza.mascotas.fragments;

import com.eisusquiza.mascotas.Mascota;
import com.eisusquiza.mascotas.adapter.ContactoAdaptador;

import java.util.ArrayList;

/**
 * Created by eisusquiza on 13/12/2016.
 */

public interface IRecyclerViewFragmentView {

    public void generarLinearLayoutVertical ();

    public ContactoAdaptador crearAdaptador (ArrayList<Mascota> mascotas);

    public void inicializarAdaptadorRV (ContactoAdaptador adaptador);
}
