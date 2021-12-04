package Casino.Juegos.Ruleta.Sockets;

import Casino.Juegos.Ruleta.InterfazGrafica.ServidorInterfaz;

import Casino.Juegos.Ruleta.entidades.CasinoInforme;
import Casino.Juegos.Ruleta.entidades.Ruleta;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SocketServidor extends Thread implements Serializable {

    public Ruleta ruleta;
    public CasinoInforme informe;
    private ServidorInterfaz sisf;

    public SocketServidor(Ruleta r, ServidorInterfaz sisf) {
         this.ruleta = r;
            this.sisf = sisf;
    }
    public void run(){
        try {
           
            Socket s = null;
            ServerSocket ss = new ServerSocket(5000);
            System.out.println("Servidor Iniciado");
            while (true) {
                s = ss.accept();
                (new Cliente(s, SocketServidor.this, sisf)).start();
            }
        } catch (IOException ex) {
            Logger.getLogger(SocketServidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public Ruleta getRuleta() {
        return ruleta;
    }

    public void setRuleta(Ruleta ruleta) {
        this.ruleta = ruleta;
    }

    public CasinoInforme getInforme() {
        return informe;
    }

    public void setInforme(CasinoInforme informe) {
        this.informe = informe;
    }

    static class Cliente extends Thread {

        private Socket s = null;
        private ObjectInputStream ois = null;
        private ObjectOutputStream oos = null;
        private SocketServidor ser;
        private ServidorInterfaz sisf;
        private DataInputStream in=null;
        

        public Cliente(Socket s, SocketServidor ser, ServidorInterfaz sisf) {
            this.s = s;
            this.ser = ser;
            this.sisf = sisf;
        }

        public void run() {
            try {
   
                System.out.println("Se registro una conexion al server hola");
                
                in=new DataInputStream(s.getInputStream());
                String envio=in.readUTF();
                if(envio.equals("0")){
                     System.out.println("Intento enviar ruleta al Cliente?");
                
                if (ser.getRuleta() != null) {
                    oos = new ObjectOutputStream(s.getOutputStream());
                    oos.writeObject(ser.getRuleta());
                    System.out.println("Ruleta enviada al cliente");
                    oos.close();
                }
                }else{
                    if(s.isConnected()){
                    ois = new ObjectInputStream(s.getInputStream());
                    System.out.println("Intento recibir un informe?");
                CasinoInforme informe = (CasinoInforme) ois.readObject();
                
                System.out.println("Envie Informe");

                if (informe != null) {
                    
                    System.out.println("Recibo informe del cliente");
                    sisf.agregarRegistroTabla(informe);
                    ois.close();
                }
                }
                }
                System.out.println("El cliente se desconecto del server");
                s.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
