package com.eisusquiza.mascotas;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.eisusquiza.mascotas.fragments.PerfilFragment;
import com.eisusquiza.mascotas.mail.EnviarMail;

import static com.eisusquiza.mascotas.R.id.btnBotonSig;
import static com.eisusquiza.mascotas.R.id.usuario;

public class ActivityConfigCuenta extends AppCompatActivity {


    public static String usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config_cuenta);
    }


    public void guardarCuenta(View v) {
        TextInputEditText cuenta = (TextInputEditText) findViewById(R.id.usuario);
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                usuario = cuenta.getText().toString();
                SharedPreferences cuentaGuardada = getSharedPreferences("Cuenta", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = cuentaGuardada.edit();
                editor.putString("Usuario", usuario);
                editor.commit();
                Toast.makeText(ActivityConfigCuenta.this, "Cuenta guardada con exito", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(ActivityConfigCuenta.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        });


    }

    public static String getIdUsuario(){
        return usuario;
    }
}



       // String respuesta_usuario = ((EditText) findViewById(R.id.edtDifUsuarios)).getText().toString();
       // String usuario1 = "turtus111";




