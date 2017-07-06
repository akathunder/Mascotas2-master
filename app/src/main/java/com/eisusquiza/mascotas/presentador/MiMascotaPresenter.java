package com.eisusquiza.mascotas.presentador;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.eisusquiza.mascotas.Mascota;
import com.eisusquiza.mascotas.db.ConstructorMascotas;
import com.eisusquiza.mascotas.fragments.IMiMascotaFragment;
import com.eisusquiza.mascotas.pojo.Foto;
import com.eisusquiza.mascotas.restApi.ConstantesRestApi;
import com.eisusquiza.mascotas.restApi.EndpointsApi;
import com.eisusquiza.mascotas.restApi.adapter.RestAdapter;
import com.google.gson.Gson;

import java.util.ArrayList;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by eisusquiza on 29/01/2017.
 */

public class MiMascotaPresenter  implements IMiMascotaPresenter{

    private IMiMascotaFragment vista;
    private ConstructorMascotas constructorMascota;
    private Context context;
    private ArrayList<Foto> fotos;
    private Mascota mascota;


    public MiMascotaPresenter(IMiMascotaFragment vista, Context context) {
        this.vista = vista;
        this.context = context;
        constructorMascota=new ConstructorMascotas(context);
        getMiMascotaRest();
    }

    private void getMiMascotaRest() {

        RestAdapter restAdapter=new RestAdapter();
        Gson gson=restAdapter.constructorMiMascotaDeserializador();
        EndpointsApi endpoints=restAdapter.establecerConexionInstagram(gson);
        SharedPreferences sp=context.getSharedPreferences("Cuenta",Context.MODE_PRIVATE);
        String miUsuario= sp.getString("Usuario","No existe");
        if(miUsuario=="No existe"){
            mascota=new Mascota();}
        else{
            int aux=-1;
            for (int i = 0; i < ConstantesRestApi.USUARIOS_SANDBOX_NOMBRE.length ; i++) {
                if(ConstantesRestApi.USUARIOS_SANDBOX_NOMBRE[i].equalsIgnoreCase(miUsuario.trim()))
                    aux=i;
            }
            String miUsuarioClave="";
            if(aux>=0)
                miUsuarioClave=ConstantesRestApi.USUARIOS_SANDBOX[aux];

            endpoints.getMiUsuario(miUsuarioClave)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe((mascota)->{
                        this.mascota=mascota.getMiMascota();
                        getFotos();
                    },e-> e.printStackTrace());
        }

    }


    @Override
    public void getFotos() {
        this.fotos=mascota.getFotos();
        showFotos();
    }

    @Override
    public void showFotos() {
        Log.i("Fotos",fotos.size()+"");
        vista.inicializarAdaptadorRV(vista.crearAdaptador(fotos,mascota));
        vista.generateGridLayout();

    }

    @Override
    public Mascota getMiMascota() {
        return null;
    }

    @Override
    public Mascota getPet() {
        return mascota;
    }
}
