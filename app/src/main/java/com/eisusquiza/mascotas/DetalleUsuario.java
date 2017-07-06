package com.eisusquiza.mascotas;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * Created by eisusquiza on 16/01/2017.
 */

public class DetalleUsuario  extends AppCompatActivity{

    private static final String KEY_EXTRA_URL= "url";
    private static final String KEY_EXTRA_LIKES = "like";
    private ImageView imgFotoDetalle;
    private TextView tvLikesDetalle;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_contacto_foto);

        Bundle extras = getIntent().getExtras();

        String url = extras.getString(KEY_EXTRA_URL);
        int likes  = extras.getInt(KEY_EXTRA_LIKES);

        tvLikesDetalle = (TextView) findViewById(R.id.tvLikesDetalle);
        tvLikesDetalle.setText(String.valueOf(likes));

        imgFotoDetalle = (ImageView) findViewById(R.id.imgFotoContactoDetalle);

        Picasso.with(this)
                .load(url)
                .placeholder(R.drawable.monkeyhead)
                .into(imgFotoDetalle);


    }
}
