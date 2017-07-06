package com.eisusquiza.mascotas.restApi.adapter;

import com.eisusquiza.mascotas.restApi.ConstantesRestApi;
import com.eisusquiza.mascotas.restApi.EndpointApiFoto;
import com.eisusquiza.mascotas.restApi.deserializador.FotoDeserializador;
import com.eisusquiza.mascotas.restApi.model.DatosUsuarios;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by eisusquiza on 10/01/2017.
 */

public class RestApiAdapterFoto {

    public EndpointApiFoto establecerConexionRestApiFotoInstagram (Gson gson){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ConstantesRestApi.ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        return retrofit.create(EndpointApiFoto.class);

    }

    public Gson construyeGsonDeserializadorFoto(){
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(DatosUsuarios.class, new FotoDeserializador());
        return gsonBuilder.create();
    }
}
