package com.eisusquiza.mascotas.restApi.model;

import com.eisusquiza.mascotas.Mascota;
import com.eisusquiza.mascotas.Usuarios;

import java.util.ArrayList;

/**
 * Created by eisusquiza on 05/01/2017.
 */

public class ContactoResponse {

    ArrayList<Usuarios> usuarios;

    public ArrayList<Usuarios> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(ArrayList<Usuarios> usuarios) {
        this.usuarios = usuarios;
    }

}



