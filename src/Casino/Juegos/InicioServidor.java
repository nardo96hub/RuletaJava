package Casino.Juegos;

import Casino.Juegos.Ruleta.Sockets.ServidorHilo;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class InicioServidor {

    public static void main(String[] args) {

        try {
            ServerSocket server = new ServerSocket(5000);
            Socket sc;
            System.out.println("Server iniciado");
            while (true) {
                sc=server.accept();
               // DataOutputStream out=new DataOutputStream(sc.getOutputStream());
               // DataInputStream in = new DataInputStream(sc.getInputStream());
                ServidorHilo hilo=new ServidorHilo();
                hilo.start();
            }

        } catch (IOException ex) {
            Logger.getLogger(InicioServidor.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
