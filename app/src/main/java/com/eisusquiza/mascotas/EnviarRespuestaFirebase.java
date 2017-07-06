package com.eisusquiza.mascotas;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.eisusquiza.mascotas.adapter.ContactoAdaptador;
import com.eisusquiza.mascotas.restApiServer.EndPointsServer;
import com.eisusquiza.mascotas.restApiServer.adapterServer.RestApiAdapterServer;
import com.eisusquiza.mascotas.restApiServer.modelServer.UsuarioResponseServer;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.eisusquiza.mascotas.ActivityNotificaciones.id_foto_instagram;

/**
 * Created by eisusquiza on 03/03/2017.
 */

public class EnviarRespuestaFirebase extends AppCompatActivity {

    private static final String TAG = "FIREBASE TOKEN";
    private static final String TAG2 = "ID_INSTAGRAM";
    private static final String TAG3= "ID_FOTO_INSTAGRAM";
    public static String token;
    public static String id_instagram;
    public static String id_foto_instagram;

    public void enviardatosInstagramAFirebase() {

        SharedPreferences pre = getSharedPreferences("Token", Context.MODE_PRIVATE);
        token = pre.getString("Token", "Token no encontrado");
        id_instagram = pre.getString("id_instagram", "Instragram no registrado");


        Intent intent = getIntent();
        id_foto_instagram=intent.getStringExtra("id_foto_instagram");
        //Bundle bundle=getIntent().getExtras();

        Log.d(TAG, token);
        Log.d(TAG2, id_instagram);
        Log.d(TAG3, id_foto_instagram);
        Toast.makeText(this, "Se enviaron datos a Firebase" + id_foto_instagram, Toast.LENGTH_LONG).show();
        //RestApiAdapterServer restApiAdapterServer = new RestApiAdapterServer();
        //EndPointsServer endPointsServer = restApiAdapterServer.establecerconexionRestApiServer();
        //Call<UsuarioResponseServer> usuarioResponseServerCall = endPointsServer.registrarTokenID(token, id_instagram, id_foto_instagram);

        //usuarioResponseServerCall.enqueue(new Callback<UsuarioResponseServer>() {
          //  @Override
          //  public void onResponse(Call<UsuarioResponseServer> call, Response<UsuarioResponseServer> response) {
          //      UsuarioResponseServer usuarioResponseServer = response.body();
          //      Log.d("ID_FIREBASE", usuarioResponseServer.getId());
          //      Log.d("TOKEN_FIREBASE", usuarioResponseServer.getToken());
          //      Log.d("ID_INSTAGRAM", usuarioResponseServer.getId_instagram());
          //  }

        //    @Override
        //    public void onFailure(Call<UsuarioResponseServer> call, Throwable t) {
        //    }
       // });
    }


}

