package com.eisusquiza.mascotas.db;

/**
 * Created by eisusquiza on 11/12/2016.
 */

public final class ConstantesBaseDatos {

    public static final String DATABASE_NAME = "mascotas";
    public static final int DATABASE_VERSION = 1;

    public static final String TABLE_MASCOTAS           = "mascota";
    public static final String TABLE_MASCOTAS_ID        = "id";
    public static final String TABLE_MASCOTAS_NOMBRE    = "nombre";
    public static final String TABLE_MASCOTAS_FOTO      = "foto";



    public static final String TABLE_LIKES_CONTACTOS                = "contacto_likes";
    public static final String TABLE_LIKES_CONTACTOS_ID             = "id";
    public static final String TABLE_LIKES_CONTACTOS_ID_CONTACTO    = "id_contact";
    public static final String TABLE_LIKES_CONTACTOS_NUMERO_LIKES   = "numero_likes";
}
