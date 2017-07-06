package com.eisusquiza.mascotas.restApiServer.adapterServer;

import com.eisusquiza.mascotas.restApiServer.ConstantesRestApiServer;
import com.eisusquiza.mascotas.restApiServer.EndPointsServer;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by eisusquiza on 06/02/2017.
 */

public class RestApiAdapterServer {

    public EndPointsServer establecerconexionRestApiServer(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ConstantesRestApiServer.ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                ;
        return retrofit.create(EndPointsServer.class);
    }
}
