package com.eisusquiza.mascotas;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.eisusquiza.mascotas.restApi.JsonKeys;
import com.eisusquiza.mascotas.restApi.deserializador.MiMascotaDeserializador;
import com.eisusquiza.mascotas.restApi.model.MiMascotaResponse;
import com.eisusquiza.mascotas.restApiServer.EndPointsServer;
import com.eisusquiza.mascotas.restApiServer.adapterServer.RestApiAdapterServer;
import com.eisusquiza.mascotas.restApiServer.modelServer.UsuarioResponseServer;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializer;

import javax.mail.StoreClosedException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.eisusquiza.mascotas.ActivityConfigCuenta.usuario;

public class ActivityNotificaciones extends AppCompatActivity {

    private static final String TAG = "FIRABASE TOKEN";
    private static final String TAG2 = "ID_INSTAGRAM";
    public static String id_foto_instagram = "";


    //JsonArray data=json.getAsJsonObject().getAsJsonArray(JsonKeys.MEDIA_RESPONSE_ARRAY);
    MiMascotaDeserializador miMascotaDeserializador;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notificaciones);
        lanzasNotificacionID();
    }

    private void enviarTokenRegistro(String token, String id_instagram_emisor) {
        Log.d(TAG, token);
        Log.d(TAG2, id_instagram_emisor);
        Toast.makeText(this, "Cuenta Activa para Notificaciones", Toast.LENGTH_LONG).show();
        RestApiAdapterServer restApiAdapterServer = new RestApiAdapterServer();
        EndPointsServer endPointsServer = restApiAdapterServer.establecerconexionRestApiServer();
        Call<UsuarioResponseServer> usuarioResponseServerCall = endPointsServer.registrarTokenID(token, id_instagram_emisor);

        usuarioResponseServerCall.enqueue(new Callback<UsuarioResponseServer>() {
            @Override
            public void onResponse(Call<UsuarioResponseServer> call, Response<UsuarioResponseServer> response) {
                UsuarioResponseServer usuarioResponseServer = response.body();
                Log.d("ID_FIREBASE", usuarioResponseServer.getId());
                Log.d("TOKEN_FIREBASE", usuarioResponseServer.getToken());
                Log.d("ID_INSTAGRAM", usuarioResponseServer.getId_instagram_emisor());

            }

            @Override
            public void onFailure(Call<UsuarioResponseServer> call, Throwable t) {
            }
        });
    }

    public void lanzasNotificacionID() {

        String id_instagram_emisor;

        SharedPreferences prefs = getSharedPreferences("Cuenta", Context.MODE_PRIVATE);
        id_instagram_emisor = prefs.getString("Usuario", "Usuario No encontrado");



        String token = FirebaseInstanceId.getInstance().getToken();
        enviarTokenRegistro(token, id_instagram_emisor);
        Toast.makeText(this, "Su id_de teléfono es: " + token, Toast.LENGTH_SHORT).show();
        Toast.makeText(this, "Su id_de instagram es: " + id_instagram_emisor, Toast.LENGTH_SHORT).show();
        SharedPreferences prefToken = getSharedPreferences("Token", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefToken.edit();
        editor.putString("Token", token);
        editor.putString("id_instagram_emisor", id_instagram_emisor);
        editor.commit();
    }



}