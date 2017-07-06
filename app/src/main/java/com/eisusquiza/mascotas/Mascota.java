package com.eisusquiza.mascotas;

import com.eisusquiza.mascotas.pojo.Foto;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by eisusquiza on 27/11/2016.
 */

public class Mascota implements Comparable{
    private int votos;
    private String nombre;
    private String id;
    private String picture;
    private String fecha;
    private String id_fotos;
    private ArrayList<Foto> fotos;



    public Mascota(String picture, int likes, String nombre, String id_fotos, ArrayList<Foto> fotos) {
        this.picture=picture;
        this.nombre=nombre;
        this.fotos=fotos;
        this.votos = likes;
        this.id_fotos=id_fotos;
    }

    public Mascota() {

    }

    public String getId_fotos() {
        return id_fotos;
    }

    public void setId_fotos(String id_fotos) {
        this.id_fotos = id_fotos;
    }

    public int getVotos() {
        return votos;
    }

    public void setVotos(int votos) {
        this.votos = votos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public ArrayList<Foto> getFotos() {
        return fotos;
    }

    public void setFotos(ArrayList<Foto> fotos) {
        this.fotos = fotos;
    }

    @Override
    public int compareTo(Object otra) {

        Date d=new Date(Long.parseLong(this.getFecha())*1000);
        Date d2=new Date(Long.parseLong(((Mascota)otra).getFecha())*1000);

        return -d.compareTo(d2);
    }
}
