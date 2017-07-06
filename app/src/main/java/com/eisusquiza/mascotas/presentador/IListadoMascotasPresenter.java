package com.eisusquiza.mascotas.presentador;

import com.eisusquiza.mascotas.Mascota;

import java.util.ArrayList;

/**
 * Created by eisusquiza on 17/01/2017.
 */

public interface IListadoMascotasPresenter {
    public void getMascotas();
    public void showMascotas(ArrayList <Mascota> mascotas);
    public void getFavoritos();
    public void getMascotasRest();

}
