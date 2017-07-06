package com.eisusquiza.mascotas.restApi;

import com.eisusquiza.mascotas.restApi.model.ContactoResponse;
import com.eisusquiza.mascotas.restApi.model.DatosUsuarios;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by eisusquiza on 10/01/2017.
 */

public interface EndpointApiFoto {

    @GET(ConstantesRestApi.KEY_GET_USERS_ALL_INFO)
    Call<ContactoResponse> getFotoUser();

}


