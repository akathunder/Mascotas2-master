package com.eisusquiza.mascotas.restApi.adapter;

import com.eisusquiza.mascotas.restApi.ConstantesRestApi;
import com.eisusquiza.mascotas.restApi.EndpointsApi;
import com.eisusquiza.mascotas.restApi.deserializador.ContactoDeserializador;
import com.eisusquiza.mascotas.restApi.model.ContactoResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by eisusquiza on 05/01/2017.
 */

public class RestApiAdapter {

    public EndpointsApi establecerConexionRestApiInstagram (Gson gson){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ConstantesRestApi.ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        return retrofit.create(EndpointsApi.class);

    }

    public Gson construyeGsonDeserializadorMediaRecent(){
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(ContactoResponse.class, new ContactoDeserializador());
        return gsonBuilder.create();
    }

}
