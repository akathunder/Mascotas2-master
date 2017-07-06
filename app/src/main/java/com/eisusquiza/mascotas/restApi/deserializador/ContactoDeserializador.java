package com.eisusquiza.mascotas.restApi.deserializador;

import com.eisusquiza.mascotas.Mascota;
import com.eisusquiza.mascotas.Usuarios;
import com.eisusquiza.mascotas.restApi.JsonKeys;
import com.eisusquiza.mascotas.restApi.model.ContactoResponse;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * Created by eisusquiza on 06/01/2017.
 */

public class ContactoDeserializador implements JsonDeserializer<ContactoResponse> {
    @Override
    public ContactoResponse deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        Gson gson = new Gson();
        ContactoResponse contactoResponse = gson.fromJson(json, ContactoResponse.class);
        JsonArray contactoResponseData = json.getAsJsonObject().getAsJsonArray(JsonKeys.MEDIA_RESPONSE_ARRAY);

        contactoResponse.setUsuarios(deserializarContactoDeJson(contactoResponseData));

        return contactoResponse;
    }

    //TRAER LOS DATOS DEL JSON A TRAVÉS DE LA DESERIALIZACIÓN DEPENDE DEL MODELO DE DATOS DEL JSON
    private ArrayList<Usuarios> deserializarContactoDeJson(JsonArray contactoResponseData){
        ArrayList<Usuarios> usuarios = new ArrayList<>();
        for (int i= 0; i <contactoResponseData.size(); i++){
            JsonObject contactoResponseDataObject = contactoResponseData.get(i).getAsJsonObject();

            //Obtener datos del objeto user
            JsonObject userJson = contactoResponseDataObject.getAsJsonObject(JsonKeys.USER);
            String id = userJson.get(JsonKeys.USER_ID).getAsString(); //obtenemos el id del JSON dentro del arreglo data
            String nombreCompleto = userJson.get(JsonKeys.USER_FULLNAME).getAsString(); //obtenemos el nombre completo del JSON

            //Obtener datos del objeto images
            JsonObject imageJson = contactoResponseDataObject.getAsJsonObject(JsonKeys.MEDIA_IMAGES);
            JsonObject stdResolutionJson = imageJson.getAsJsonObject(JsonKeys.MEDIA_STANDARD_RESOLUTION);
            String urlFoto = stdResolutionJson.get(JsonKeys.MEDIA_URL).getAsString();

            //Obtener datos del objeto likes
            JsonObject likesJson= contactoResponseDataObject.getAsJsonObject(JsonKeys.MEDIA_LIKES);
            int likes= likesJson.get(JsonKeys.MEDIA_LIKES_COUNT).getAsInt();

            //Atraer los datos de JSON en un arreglo de datos
            Usuarios usuariosActual = new Usuarios();
            usuariosActual.setId(id);
            usuariosActual.setNombreCompleto(nombreCompleto);
            usuariosActual.setUrlfoto(urlFoto);
            usuariosActual.setLikes(likes);

            usuarios.add(usuariosActual); //Llenar los datos del arraylist con los datos deserializados

        }

        return usuarios;
    }

}
