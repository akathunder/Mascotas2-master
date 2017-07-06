package com.eisusquiza.mascotas;

import com.eisusquiza.mascotas.adapter.ContactoAdaptador;

import java.util.ArrayList;

/**
 * Created by eisusquiza on 21/12/2016.
 */

public interface IListadoMascotasView {

    void generarLinearLayoutVertical();

    ContactoAdaptador crearAdaptador(ArrayList<Mascota> mascotas);

    void inicializarAdaptadorRV(ContactoAdaptador adaptador);
}
