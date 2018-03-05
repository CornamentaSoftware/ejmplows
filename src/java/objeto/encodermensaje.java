/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objeto;

import java.io.IOException;
import java.io.Writer;
import java.math.BigDecimal;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonWriter;
import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

/**
 *
 * @author Javier
 */
public class encodermensaje implements Encoder.TextStream<mensajeg>{

    @Override
    public void encode(mensajeg object, Writer writer) throws EncodeException, IOException {
            JsonObject json = Json.createObjectBuilder().add("nombre",object.getNombre()).add("mensaje",object.getMensaje()).build();
            try(JsonWriter jsonWriter = Json.createWriter(writer)){
                jsonWriter.writeObject(json);
                
            }
    }

    @Override
    public void init(EndpointConfig ec) {
    }

    @Override
    public void destroy() {
    }
    
}
