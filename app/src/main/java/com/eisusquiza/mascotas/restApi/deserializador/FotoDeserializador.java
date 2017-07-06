package com.eisusquiza.mascotas.restApi.deserializador;

import com.eisusquiza.mascotas.Usuarios;
import com.eisusquiza.mascotas.pojo.userPrimaryData;
import com.eisusquiza.mascotas.restApi.JsonKeys;
import com.eisusquiza.mascotas.restApi.model.ContactoResponse;
import com.eisusquiza.mascotas.restApi.model.DatosUsuarios;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by eisusquiza on 10/01/2017.
 */

public class FotoDeserializador implements JsonDeserializer<ContactoResponse> {
    @Override
    public ContactoResponse deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        //String json = CADENA_JSON;
        Gson gson = new Gson();
        ContactoResponse contactoResponse = gson.fromJson(json, ContactoResponse.class);

        //List<DatosUsuarios> datosUsuariosList = (List<DatosUsuarios>) gson.fromJson(json, DatosUsuarios.class);

        JsonArray usuariosResponseData = json.getAsJsonObject().getAsJsonArray(JsonKeys.MEDIA_RESPONSE_ARRAY);

        contactoResponse.setUsuarios(deserializarUsuariosDeJson(usuariosResponseData));


        return contactoResponse;


    }

    //List<DatosUsuarios> fotoPerfilUsuario = gson.fromJson(CADENA_JSON, DatosUsuarios.class);
    //ContactoResponse contactoResponse = gson.fromJson(json, ContactoResponse.class);

    private ArrayList<Usuarios> deserializarUsuariosDeJson(JsonArray usuariosResponseData) {
        ArrayList<Usuarios> usuarios = new ArrayList<>();
        //JsonArray contactoResponseData = json.getAsJsonObject().getAsJsonArray(JsonKeys.MEDIA_RESPONSE_ARRAY);

        JsonObject contactoResponseDataObject = usuariosResponseData.getAsJsonObject();

        //TRAER LA FOTO
        String URLfotoJson = contactoResponseDataObject.get(JsonKeys.PROFILE_PICTURE).getAsString();
        //TRAER EL NOMBRE
        String User_Name = contactoResponseDataObject.get(JsonKeys.USER_NAME).getAsString();

        //TRAER LOS DATOS JSON A UN LISTADO
        Usuarios usuariosactuales = new Usuarios();
        usuariosactuales.setUrlfoto(URLfotoJson);
        usuariosactuales.setNombreCompleto(User_Name);

        usuarios.add(usuariosactuales);
        return usuarios;
    }
}






        //PONER LA FOTO EN EL ARREGLO
        //DatosUsuarios fotoPerfilUsuario = new DatosUsuarios();
        //fotoPerfilUsuario.setUrlfotoUsuario(URLfotoJson);

        //contactoResponse.toString();

         //  }

//}