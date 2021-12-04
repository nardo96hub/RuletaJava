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

    public SocketCliente(CasinoInforme cin,String mensaje) {
        this.ci = cin;
        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;
        Socket s = null;
        try {

            s = new Socket("localhost", 5000);
            System.out.println("Un nuevo cliente quiere ingresar al servidor");
           DataOutputStream out=new DataOutputStream(s.getOutputStream());
            out.writeUTF(mensaje);
            if (ci != null) {
                oos = new ObjectOutputStream(s.getOutputStream());
                System.out.println("Envio informe desde el cliente");
                System.out.println(ci);
                oos.writeObject(ci);
                System.out.println("Se envio el informe");
                oos.close();
            } else {
                ois = new ObjectInputStream(s.getInputStream());
                Ruleta rul = (Ruleta) ois.readObject();
                if (rul != null) {
                    System.out.println("Recibi la ruleta bien?");
                    setRuleta(rul);
                    System.out.println("La ruleta llego bien");
                    ois.close();
                }
                if (ois != null) {
                    ois.close();
                }
            }

            s.close();

        } catch (IOException ex) {
            Logger.getLogger(SocketCliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SocketCliente.class.getName()).log(Level.SEVERE, null, ex);
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
