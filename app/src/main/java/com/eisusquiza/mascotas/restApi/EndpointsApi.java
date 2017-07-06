package com.eisusquiza.mascotas.restApi;

import com.eisusquiza.mascotas.restApi.model.ContactoResponse;
import com.eisusquiza.mascotas.restApi.model.MascotaResponse;
import com.eisusquiza.mascotas.restApi.model.MiMascotaResponse;

import java.util.Observable;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by eisusquiza on 05/01/2017.
 */

public interface EndpointsApi {

    //se incluyen los métodos para retrofit

    @GET(ConstantesRestApi.URL_GET_RECENT_MEDIA_USER)
    rx.Observable<MascotaResponse> getRecentMedia();
    @GET(ConstantesRestApi.GET_MEDIA_USUARIO)
    rx.Observable<MascotaResponse> getUsuario(@Path("user-id") String id);
    @GET(ConstantesRestApi.GET_MEDIA_USUARIO)
    rx.Observable<MiMascotaResponse> getMiUsuario(@Path("user-id") String id);

}
