package com.eisusquiza.mascotas;

/**
 * Created by eisusquiza on 10/01/2017.
 */

public class Usuarios {

    private String id;
    private String nombreCompleto;
    private String urlfoto;
    private int likes = 0;


    public Usuarios(String urlfoto, String nombreCompleto, int likes){
        this.urlfoto = urlfoto;
        this.nombreCompleto = nombreCompleto;
        this.likes = likes;
    }


    public Usuarios(){}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }
}
