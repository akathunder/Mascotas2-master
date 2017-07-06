package com.eisusquiza.mascotas.restApi.adapter;

import com.eisusquiza.mascotas.restApi.ConstantesRestApi;
import com.eisusquiza.mascotas.restApi.EndpointsApi;
import com.eisusquiza.mascotas.restApi.deserializador.MascotaDeserializador;
import com.eisusquiza.mascotas.restApi.deserializador.MiMascotaDeserializador;
import com.eisusquiza.mascotas.restApi.model.MascotaResponse;
import com.eisusquiza.mascotas.restApi.model.MiMascotaResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by eisusquiza on 29/01/2017.
 */

public class RestAdapter {
    public EndpointsApi establecerConexionInstagram(Gson gson){
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(ConstantesRestApi.ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        return retrofit.create(EndpointsApi.class);
    }

    public Gson constructirDeserializador(){
        GsonBuilder builder=new GsonBuilder();
        builder.registerTypeAdapter(MascotaResponse.class,new MascotaDeserializador());
        return builder.create();
    }

    public Gson constructorMiMascotaDeserializador(){
        GsonBuilder builder=new GsonBuilder();
        builder.registerTypeAdapter(MiMascotaResponse.class,new MiMascotaDeserializador());
        return  builder.create();
    }


}
