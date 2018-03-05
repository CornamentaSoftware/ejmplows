/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatbien;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.websocket.EncodeException;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import objeto.decodermensaje;
import objeto.encodermensaje;
import objeto.mensajeg;

@ServerEndpoint(value="/chatbien", encoders={encodermensaje.class}, decoders={decodermensaje.class})


public class elchat {
    private static final List<Session> conectados= new ArrayList<>();
    
    @OnOpen 
    public void inicio(Session sesion){
        conectados.add(sesion);
        
    }
    @OnClose
    public void cerrar(Session sesion){
        conectados.remove(sesion);
        
    }
    @OnMessage
    public void mensaje(mensajeg mensaje) throws IOException, EncodeException, ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
         for(Session sesion: conectados){
            sesion.getBasicRemote().sendObject(mensaje);
        }
        

        
        String nombre=  mensaje.getNombre();
      String mensa= mensaje.getMensaje();
      int idChat=1000;
      String recep="grupo";
        Connection con = null;
            Statement sta = null;

            try {
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                con = DriverManager.getConnection("jdbc:mysql://localhost/smartdatabase", "root", "n0m3l0");
                sta = con.createStatement();

            } catch (SQLException error) {

                System.out.println(error.toString());
            }

            sta.executeUpdate("Insert into mensajes (idChat, Emisor, Receptor, Contenido, HoraFecha)values(1000,'" + nombre + "','" + recep + "','" + mensa + "',default);");

            con.close();

      
      
    
}
    }  