package com.eisusquiza.mascotas.restApi.model;

import android.support.annotation.NonNull;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by eisusquiza on 10/01/2017.
 */

public class DatosUsuarios {

    public List<DatosUsuarios> datosUsuariosList;


    public DatosUsuarios(List<DatosUsuarios> datosUsuariosList){
        this.datosUsuariosList=datosUsuariosList;

    }

    public DatosUsuarios() {

    }

    public List<DatosUsuarios> getDatosUsuariosList() {
        return datosUsuariosList;
    }

    public void setDatosUsuariosList(List<DatosUsuarios> datosUsuariosList) {
        this.datosUsuariosList = datosUsuariosList;
    }

}
