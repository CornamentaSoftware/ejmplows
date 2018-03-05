/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objeto;

import java.io.IOException;
import java.io.Reader;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;

/**
 *
 * @author Javier
 */
public class decodermensaje implements Decoder.TextStream<mensajeg> {

    @Override
    public mensajeg decode(Reader reader) throws DecodeException, IOException {
        mensajeg mensaje = new mensajeg();
        try(JsonReader jsonReader= Json.createReader(reader)){
           JsonObject json = jsonReader.readObject();
           mensaje.setNombre(json.getString("nombre"));
           mensaje.setMensaje(json.getString("mensaje"));

        }
        
        
        return mensaje;
    }

    @Override
    public void init(EndpointConfig ec) {
    }

    @Override
    public void destroy() {
    }
    
}
