package com.eisusquiza.mascotas;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.eisusquiza.mascotas.notificaciones.NotificacionService;
import com.eisusquiza.mascotas.restApi.adapter.RestApiAdapter;
import com.eisusquiza.mascotas.restApiServer.EndPointsServer;
import com.eisusquiza.mascotas.restApiServer.adapterServer.RestApiAdapterServer;
import com.eisusquiza.mascotas.restApiServer.modelServer.UsuarioResponseServer;
import com.eisusquiza.mascotas.restApiServer.modelServer.UsuarioResponseServerFireBase;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.R.attr.id;

public class EnviarRespuestaAFirebase2 extends AppCompatActivity {

    private static final String TAG = "FIREBASE TOKEN";
    private static final String TAG2 = "ID_INSTAGRAM";
    private static final String TAG3= "ID_FOTO_INSTAGRAM";
    private static String USUARIO_EMISOR;
    private static String USUARIO_RECEPTOR;
    public static String id;
    public static String token;
    public static String id_instagram;
    public static String id_foto_instagram;
    public static String likes_instagram;
    Activity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enviar_respuesta_afirebase2);

        Intent intent = getIntent();
        id_foto_instagram=intent.getStringExtra("id_foto_instagram");
        id_instagram=intent.getStringExtra("id_instagram");
        enviardatosaFirebase();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    private void enviardatosaFirebase() {
        SharedPreferences pre = getSharedPreferences("Token", Context.MODE_PRIVATE);
        token = pre.getString("Token", "Token no encontrado");
        //id_instagram = pre.getString("id_instagram", "Instragram no registrado");
        id_foto_instagram= getIntent().getStringExtra("id_foto_instagram");


        Log.d(TAG, token);
        Log.d(TAG2, id_instagram);
        Log.d(TAG3, id_foto_instagram);
        likes_instagram="1";
        Toast.makeText(this, "Se enviaron datos a Firebase", Toast.LENGTH_LONG).show();
       EtiquetarDatosFirebase(token, id_instagram, id_foto_instagram, likes_instagram);


        //usuarioResponseServerCall.enqueue(new Callback<UsuarioResponseServer>() {
        //    @Override
        //    public void onResponse(Call<UsuarioResponseServer> call, Response<UsuarioResponseServer> response) {
        //        UsuarioResponseServer usuarioResponseServer = response.body();
        //        Log.d("ID_FIREBASE", usuarioResponseServer.getId());
        //        Log.d("TOKEN_FIREBASE", usuarioResponseServer.getToken());
        //        Log.d("ID_INSTAGRAM", usuarioResponseServer.getId_instagram());
        //        Log.d("ID_FOTO_INSTAGRAM", usuarioResponseServer.getId_foto_instagram());
        //        Log.d("LIKES", usuarioResponseServer.getLikes_instagram());
        //    }

      //      @Override
      //      public void onFailure(Call<UsuarioResponseServer> call, Throwable t) {
//
  //          }
    //    });


    }

    private void EtiquetarDatosFirebase(String token, String id_instagram, String id_foto_instagram, String likes_instagram ) {
        RestApiAdapterServer restApiAdapterServer = new RestApiAdapterServer();
        EndPointsServer endPointsServer = restApiAdapterServer.establecerconexionRestApiServer();
        Call<UsuarioResponseServerFireBase> usuarioResponseServerCall = endPointsServer.registrarLikes(token, id_instagram, id_foto_instagram, likes_instagram);
        usuarioResponseServerCall.enqueue(new Callback<UsuarioResponseServerFireBase>() {
            @Override
            public void onResponse(Call<UsuarioResponseServerFireBase> call, Response<UsuarioResponseServerFireBase> response) {
                UsuarioResponseServerFireBase usuarioresponse2 = response.body();
                id = usuarioresponse2.getId();
                toqueanimal();
                //Intent i = new Intent(activity, NotificacionService.class);
                //Log.d("ID_FIREBASE2", usuarioresponse2.getId());
                //Log.d("TOKEN_FIREBASE2", usuarioresponse2.getToken());
                //Log.d("ID_INSTAGRAM2", usuarioresponse2.getId_instagram());
                //Log.d("ID_FOTO_INSTAGRAM2", usuarioresponse2.getId_foto_instagram());
                //Log.d("LIKES_INSTAGRAM2", usuarioresponse2.getLikes_instagram());

            }

            @Override
            public void onFailure(Call<UsuarioResponseServerFireBase> call, Throwable t) {

            }
        });


    }

    private void toqueanimal() {
        Log.d("TOQUE_ANIMAL", "true");
        USUARIO_RECEPTOR=id_instagram;
        SharedPreferences pre = getSharedPreferences("Token", Context.MODE_PRIVATE);
        USUARIO_EMISOR= pre.getString("id_instagram_emisor", "Instragram no registrado");

        UsuarioResponseServer usuario23 = new UsuarioResponseServer(id, token, USUARIO_RECEPTOR);
        RestApiAdapterServer restApiAdapter23 = new RestApiAdapterServer();
        EndPointsServer endpoint23= restApiAdapter23.establecerconexionRestApiServer();

        Call<UsuarioResponseServerFireBase> usuarioResponseCall23= endpoint23.toqueanimal(usuario23.getId(),USUARIO_EMISOR);
        usuarioResponseCall23.enqueue(new Callback<UsuarioResponseServerFireBase>() {
            @Override
            public void onResponse(Call<UsuarioResponseServerFireBase> call, Response<UsuarioResponseServerFireBase> response) {
                UsuarioResponseServerFireBase usuarioResponse1 = response.body();
                Log.d("ID_FIREBASE", usuarioResponse1.getId());
                Log.d("TOKEN_FIREBASE", usuarioResponse1.getToken());
                Log.d("ID_INSTAGRAM", usuarioResponse1.getId_instagram());
            }

            @Override
            public void onFailure(Call<UsuarioResponseServerFireBase> call, Throwable t) {

            }
        });



    }

}
