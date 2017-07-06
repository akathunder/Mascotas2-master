package com.eisusquiza.mascotas.fragments;

import com.eisusquiza.mascotas.Mascota;
import com.eisusquiza.mascotas.adapter.ContactoAdaptador;

import java.util.ArrayList;

/**
 * Created by eisusquiza on 30/01/2017.
 */

public interface IListaMascotaFragment {
    public void generateVerticalLayout();
    public ContactoAdaptador createAdapter(ArrayList<Mascota> mascotas);
    public void initAdapter(ContactoAdaptador adapter);
}
