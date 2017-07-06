package com.eisusquiza.mascotas.restApi;

/**
 * Created by eisusquiza on 05/01/2017.
 */

public class ConstantesRestApi {

    public static final String VERSION = "/v1/";
    public static final String ROOT_URL = "https://api.instagram.com" + VERSION;
    public static final String ACCESS_TOKEN = "4302183848.d57a7b3.8c8289536ba449b6b6dd3d83a90911b8";
    public static final String KEY_ACCESS_TOKEN = "?access_token=";
    public static final String KEY_GET_RECENT_MEDIA_USER = "users/self/media/recent/";
    public static final String URL_GET_RECENT_MEDIA_USER = KEY_GET_RECENT_MEDIA_USER+KEY_ACCESS_TOKEN+ACCESS_TOKEN;

    //DATOS DE ID DE DIFERENTES USUARIOS
    public static final String KEY_GET_RECENT_MEDIA_DIFERENT_USER1 = "users/4275789769/media/recent/"; //ID DE TURTUS111
    public static final String URL_GET_RECENT_MEDIA_DIFERENT_USER1 = KEY_GET_RECENT_MEDIA_DIFERENT_USER1+KEY_ACCESS_TOKEN+ACCESS_TOKEN;

    //https://api.instagram.com/v1/users/4275789769/media/recent/?access_token=4302183848.d57a7b3.8c8289536ba449b6b6dd3d83a90911b8


    //https://api.instagram.com/v1/users/4275789769/?access_token=4302183848.d57a7b3.8c8289536ba449b6b6dd3d83a90911b8

    public static final String KEY_GET_USERS="users/4275789769/";
    public static final String KEY_GET_USERS_ALL_INFO=KEY_GET_USERS+KEY_ACCESS_TOKEN+ACCESS_TOKEN;


    //usuarios sandbox

    public static final String[] USUARIOS_SANDBOX={"4253551275","4275789769","4377271040","4302183848","4666694013"};
    public static final String[] USUARIOS_SANDBOX_NOMBRE={"gbrcode","turtus111","alephcoursera","rockymartinez77","perritopochito"};
    public static final String GET_MEDIA_USUARIO="users/{user-id}/media/recent/"+KEY_ACCESS_TOKEN+ACCESS_TOKEN;
}
