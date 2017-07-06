package com.eisusquiza.mascotas.db;

import android.content.ContentValues;
import android.content.Context;

import com.eisusquiza.mascotas.Mascota;

import java.util.ArrayList;

/**
 * Created by eisusquiza on 17/01/2017.
 */

public class ConstructorMascotas {
    private Context context;
    private DataBase db;

    public ConstructorMascotas(Context context) {
        this.context = context;
        db = new DataBase(context);
    }

    public ArrayList<Mascota> getMascotas(){
        return db.getMascotas();
    }

    private void initData(){
        if(db.getMascotas().size()<1){
            Mascota[] mascotas={};
        }
    }

    public Mascota darLike(Mascota m){
        ContentValues values=new ContentValues();
        values.put(DBConfig.MASCOTA_VOTOS, m.getVotos()+1);
        return new Mascota();
    }


    public ArrayList<Mascota> getFavoritos(){
        return db.getFavoritos();
    }


    public Mascota getMiMascota(){
        return db.getMascota(1);
    }

}
