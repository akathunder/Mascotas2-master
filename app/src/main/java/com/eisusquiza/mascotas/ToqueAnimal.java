package com.eisusquiza.mascotas;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.widget.Toast;

import com.eisusquiza.mascotas.restApiServer.EndPointsServer;
import com.eisusquiza.mascotas.restApiServer.adapterServer.RestApiAdapterServer;
import com.eisusquiza.mascotas.restApiServer.modelServer.UsuarioResponseServer;
import com.eisusquiza.mascotas.restApiServer.modelServer.UsuarioResponseServerFireBase;
import com.google.firebase.iid.FirebaseInstanceId;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.eisusquiza.mascotas.EnviarRespuestaAFirebase2.id;
import static com.eisusquiza.mascotas.EnviarRespuestaAFirebase2.id_instagram;
import static com.eisusquiza.mascotas.EnviarRespuestaFirebase.token;




/**
 * Created by eisusquiza on 10/05/2017.
 */

public class ToqueAnimal extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {


        String ACTION_KEY ="TOQUE_ANIMAL";
        String action = intent.getAction();

        if (ACTION_KEY.equals(action)){
            toqueanimal();
            Toast.makeText(context, "Diste un toque a ", Toast.LENGTH_SHORT).show();
        }
    }


    private void toqueanimal() {
        Log.d("TOQUE_ANIMAL", "true");
        String USUARIO_RECEPTOR = id_instagram;
        //String token = FirebaseInstanceId.getInstance().getToken();

        //SharedPreferences pre = getSharedPreferences("Token", Context.MODE_PRIVATE);
        //String USUARIO_EMISOR = pre.getString("id_instagram_emisor", "Instragram no registrado");
        String USUARIO_EMISOR = "turtus 111";

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
