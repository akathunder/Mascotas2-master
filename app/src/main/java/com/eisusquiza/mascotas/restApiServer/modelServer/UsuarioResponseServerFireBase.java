package com.eisusquiza.mascotas.restApiServer.modelServer;

/**
 * Created by eisusquiza on 04/03/2017.
 */

public class UsuarioResponseServerFireBase {

    private String id;
    private String token;
    private String id_instagram;
    private String id_foto_instagram;
    private String likes_instagram;

    public UsuarioResponseServerFireBase(String id, String token, String id_instagram, String id_foto_instagram, String likes_instagram) {
        this.id = id;
        this.token = token;
        this.id_instagram = id_instagram;
        this.id_foto_instagram = id_foto_instagram;
        this.likes_instagram = likes_instagram;
    }

    public UsuarioResponseServerFireBase() {
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

    public String getId_instagram() {
        return id_instagram;
    }

    public void setId_instagram(String id_instagram) {
        this.id_instagram = id_instagram;
    }

    public String getId_foto_instagram() {
        return id_foto_instagram;
    }

    public void setId_foto_instagram(String id_foto_instagram) {
        this.id_foto_instagram = id_foto_instagram;
    }

    public String getLikes_instagram() {
        return likes_instagram;
    }

    public void setLikes_instagram(String likes_instagram) {
        this.likes_instagram = likes_instagram;
    }
}
