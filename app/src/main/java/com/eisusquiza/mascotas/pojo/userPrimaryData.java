package com.eisusquiza.mascotas.pojo;

/**
 * Created by eisusquiza on 14/01/2017.
 */

public class userPrimaryData {

    private String nombreCompleto;
    private String urlfoto;

    public userPrimaryData(){}

    public userPrimaryData(String nombreCompleto, String urlfoto){
        this.nombreCompleto=nombreCompleto;
        this.urlfoto=urlfoto;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getUrlfoto() {
        return urlfoto;
    }

    public void setUrlfoto(String urlfoto) {
        this.urlfoto = urlfoto;
    }
}
