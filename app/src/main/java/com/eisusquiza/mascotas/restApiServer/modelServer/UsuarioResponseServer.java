package com.eisusquiza.mascotas.restApiServer.modelServer;

/**
 * Created by eisusquiza on 06/02/2017.
 */

public class UsuarioResponseServer {

    private String id;
    private String token;
    private String id_instagram_emisor;

    public UsuarioResponseServer(String id, String token, String id_instagram_emisor) {
        this.id = id;
        this.token = token;
        this.id_instagram_emisor = id_instagram_emisor;

    }

    public UsuarioResponseServer(){};


    public String getId_instagram_emisor() {
        return id_instagram_emisor;
    }

    public void setId_instagram_emisor(String id_instagram_emisor) {
        this.id_instagram_emisor = id_instagram_emisor;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
