package Casino.Juegos.Ruleta.entidades;

import Casino.Casino;
import Casino.Juegos.Ruleta.Servicio.ServicioMesaRuleta;
import java.io.Serializable;

import java.util.ArrayList;
import java.util.Scanner;

public class Ruleta extends Casino implements Serializable{

    private ArrayList<ServicioMesaRuleta> mesas = new ArrayList();
   // private Scanner l = new Scanner(System.in).useDelimiter("\n");

    public Ruleta() {
        super();
    }

   public void crearMesa(int cap,int inicio) {
        for (int i = 0; i < cap; i++) {
            ServicioMesaRuleta smr = new ServicioMesaRuleta();
            smr.setNumMesa( i+inicio);
            mesas.add(smr);

        }
    }
    public ServicioMesaRuleta mesa() {
        return mesas.get(0);
    }
    public ArrayList<ServicioMesaRuleta> mesadisponibles(){
        ArrayList<ServicioMesaRuleta> disponible=new ArrayList<ServicioMesaRuleta>();
        for (ServicioMesaRuleta m : mesas) {
            if(m.getM().isDisponible()){
                disponible.add(m);
            }
        }
        
        return disponible;
    }
    

    public ArrayList<ServicioMesaRuleta> getMesas() {
        return mesas;
    }

    public void setMesas(ArrayList<ServicioMesaRuleta> mesas) {
        this.mesas = mesas;
    }
    

}
