

package Casino.Juegos;

import Casino.Juegos.Ruleta.Sockets.ClienteHilo;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;


public class InicioCliente {

 
    public static void main(String[] args) {
        try {
            Socket sc=new Socket("localhost",5000);
            ClienteHilo hilo=new ClienteHilo();
            hilo.start();
            
            hilo.join();
            
            
        } catch (IOException ex) {
            Logger.getLogger(InicioCliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(InicioCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
