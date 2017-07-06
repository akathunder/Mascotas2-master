package com.eisusquiza.mascotas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.eisusquiza.mascotas.mail.EnviarMail;

public class ActivityContacto extends AppCompatActivity {

    private EditText edtNombre;
    private EditText edtEmail;
    private EditText edtMensaje;
    private Button btnBotonSig;

    public void init() {
        btnBotonSig = (Button) findViewById(R.id.btnBotonSig);
        btnBotonSig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EnviarMail();

             Toast.makeText(getBaseContext(), "Mensaje enviado ", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);
        init();

        edtNombre = (EditText)  findViewById(R.id.edtNombre);
        edtEmail = (EditText) findViewById(R.id.edtEmail);
        edtMensaje = (EditText) findViewById(R.id.edtMensaje);
    }

    private void EnviarMail() {
        String email= edtEmail.getText().toString().trim();
        String subject = edtNombre.getText().toString().trim();
        String message = edtMensaje.getText().toString().trim();

        EnviarMail sm = new EnviarMail(this, email, subject, message);
        sm.execute();
    }



}
