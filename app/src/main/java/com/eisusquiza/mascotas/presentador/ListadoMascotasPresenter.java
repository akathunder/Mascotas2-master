package com.eisusquiza.mascotas.presentador;

import android.content.Context;

import com.eisusquiza.mascotas.IListadoMascotasView;
import com.eisusquiza.mascotas.Mascota;
import com.eisusquiza.mascotas.db.ConstructorMascotas;
import com.eisusquiza.mascotas.fragments.IListaMascotaFragment;
import com.eisusquiza.mascotas.pojo.MascotaAux;
import com.eisusquiza.mascotas.restApi.ConstantesRestApi;
import com.eisusquiza.mascotas.restApi.EndpointsApi;
import com.eisusquiza.mascotas.restApi.adapter.RestAdapter;
import com.eisusquiza.mascotas.restApi.adapter.RestApiAdapter;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Collections;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by eisusquiza on 21/12/2016.
 */

public class ListadoMascotasPresenter implements IListadoMascotasPresenter{

    private IListaMascotaFragment vista;
    private Context context;
    private ConstructorMascotas constructorMascotas;
    private ArrayList<Mascota> mascotas;

    public ListadoMascotasPresenter(IListaMascotaFragment  vista, Context context) {
        this.vista = vista;
        this.context = context;
        this.constructorMascotas=new ConstructorMascotas(context);
        //obtenerMascotasFavoritasDB();
        mascotas = new ArrayList<>();
    }


    @Override
    public void getMascotas() {
        this.mascotas=constructorMascotas.getMascotas();
        showMascotas(mascotas);
    }

    @Override
    public void showMascotas(ArrayList<Mascota> mascotas) {
        vista.initAdapter(vista.createAdapter(mascotas));
        vista.generateVerticalLayout();
    }

    @Override
    public void getFavoritos() {

        RestAdapter restAdapter=new RestAdapter();
        Gson gson=restAdapter.constructirDeserializador();
        EndpointsApi endpoints=restAdapter.establecerConexionInstagram(gson);
        for (int i = 0; i < ConstantesRestApi.USUARIOS_SANDBOX.length ; i++) {
            int finalI = i;
            endpoints.getUsuario(ConstantesRestApi.USUARIOS_SANDBOX[i])
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe((mascota)->{
                        mascotas.addAll(mascota.getMascotas());

                        showMascotas(ordenarPorVotos());
                    },e->e.printStackTrace());
        }
    }

    private ArrayList<Mascota> ordenarPorVotos() {
        ArrayList<MascotaAux> aux=new ArrayList<>();
        for (int i = 0; i < mascotas.size(); i++) {
            MascotaAux m=new MascotaAux(mascotas.get(i));
            aux.add(m);
        }
        Collections.sort(aux);
        ArrayList<Mascota> aux2=new ArrayList<>();
        for (int i = 0; i <5 ; i++) {
            aux2.add(aux.get(i));
        }
        return aux2;
    }




    @Override
    public void getMascotasRest() {
        
        RestAdapter restAdapter=new RestAdapter();
        Gson gson=restAdapter.constructirDeserializador();
        EndpointsApi endpoints=restAdapter.establecerConexionInstagram(gson);
        for (int i = 0; i <ConstantesRestApi.USUARIOS_SANDBOX.length ; i++) {
            int finalI = i;
            endpoints.getUsuario(ConstantesRestApi.USUARIOS_SANDBOX[i])
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe((mascota)->{
                        mascotas.addAll(mascota.getMascotas());
                        Collections.sort(mascotas);
                        showMascotas(mascotas);
                    },e->e.printStackTrace());
        }


    }
}







