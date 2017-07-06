package com.eisusquiza.mascotas.notificaciones;

import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

/**
 * Created by eisusquiza on 05/02/2017.
 */

public class NotificacionIDTokenService extends FirebaseInstanceIdService {

    private static final String TAG="FIRABASE TOKEN";

    @Override
    public void onTokenRefresh() {
        String token = FirebaseInstanceId.getInstance().getToken();
    }

    private void enviarTokenRegistro(String token){
        Log.d(TAG, token);
        Toast.makeText(this, "Cuenta Activa para Notificaciones", Toast.LENGTH_LONG).show();
    }

    public void lanzasNotificacionID (View v){
        String token = FirebaseInstanceId.getInstance().getToken();
        enviarTokenRegistro(token);
    }
}
