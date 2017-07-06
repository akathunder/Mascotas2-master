package com.eisusquiza.mascotas.restApiServer;

import com.eisusquiza.mascotas.restApiServer.modelServer.UsuarioResponseServer;
import com.eisusquiza.mascotas.restApiServer.modelServer.UsuarioResponseServerFireBase;

import retrofit2.http.Field;
import retrofit2.Call;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by eisusquiza on 06/02/2017.
 */

public interface EndPointsServer {

    @FormUrlEncoded
    @POST(ConstantesRestApiServer.KEY_POST_ID_TOKEN)
    Call<UsuarioResponseServer> registrarTokenID(@Field("token") String token, @Field("id_instagram_emisor") String id_instagram_emisor);

    @FormUrlEncoded
    @POST(ConstantesRestApiServer.KEY_POST_TOQUE_LIKES)
    Call<UsuarioResponseServerFireBase> registrarLikes(@Field("token") String token, @Field("id_instagram") String id_instagram, @Field("id_foto_instagram") String id_foto_instagram, @Field("likes_instagram") String likes_instagram);

    @GET(ConstantesRestApiServer.KEY_TOQUE_ANIMAL)
    Call<UsuarioResponseServerFireBase> toqueanimal(@Path("id") String id, @Path("id_instagram") String id_instagram );



}
