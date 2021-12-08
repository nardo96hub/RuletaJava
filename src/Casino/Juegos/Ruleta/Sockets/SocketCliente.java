package Casino.Juegos.Ruleta.Sockets;

import Casino.Juegos.Ruleta.entidades.CasinoInforme;
import Casino.Juegos.Ruleta.entidades.Ruleta;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SocketCliente extends Thread {

    private Ruleta ruleta;
    private CasinoInforme ci;

    //El cliente recibe un informe y un mensaje si informe==null y mensaje="0" entonces recibe del servidor una ruleta sino envia el informe al servidor
    public SocketCliente(CasinoInforme cin, String mensaje) {
        this.ci = cin;
        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;
        Socket s = null;
        try {

            s = new Socket("localhost", 5000);//El cliente se conecta al servidor 
            System.out.println("Un nuevo cliente quiere ingresar al servidor");
            //Envio al servidor el mensaje y segun el mensaje el servidor envia o recibe informacion
            DataOutputStream out = new DataOutputStream(s.getOutputStream());
            out.writeUTF(mensaje);//Envio al servidor un string 
            if (ci != null) {
                oos = new ObjectOutputStream(s.getOutputStream());
                System.out.println("Envio informe desde el cliente");
                System.out.println(ci);
                oos.writeObject(ci);//Envio al servidor el objeto de informe 
                System.out.println("Se envio el informe");
                oos.close();
            } else {
                ois = new ObjectInputStream(s.getInputStream());
                Ruleta rul = (Ruleta) ois.readObject();//Recibo del servidor la ruleta creada 
                if (rul != null) {//Si no ocurrio algun error seteo la ruleta del cliente
                    System.out.println("Recibi la ruleta bien?");
                    setRuleta(rul);
                    System.out.println("La ruleta llego bien");
                    ois.close();
                }
                if (ois != null) {//Si por algun motivo no se cerro
                    ois.close();
                }
            }

            s.close();//Cierro el socket de cliente 

        } catch (IOException ex) {
            ex.printStackTrace();
           // Logger.getLogger(SocketCliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
           // Logger.getLogger(SocketCliente.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public Ruleta getRuleta() {
        return ruleta;
    }

    public void setRuleta(Ruleta ruleta) {
        this.ruleta = ruleta;
    }

    public CasinoInforme getCi() {
        return ci;
    }

    public void setCi(CasinoInforme ci) {
        this.ci = ci;
    }

}
