package com.eisusquiza.mascotas.restApi.model;

import com.eisusquiza.mascotas.Mascota;

import java.util.ArrayList;

/**
 * Created by eisusquiza on 18/01/2017.
 */

public class MascotaResponse {


        private ArrayList<Mascota> mascotas;

        public ArrayList<Mascota> getMascotas() {
            return mascotas;
        }

        public void setMascotas(ArrayList<Mascota> mascotas) {
            this.mascotas = mascotas;
        }
    }

