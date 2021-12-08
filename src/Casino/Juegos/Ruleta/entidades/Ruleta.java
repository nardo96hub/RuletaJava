package Casino.Juegos.Ruleta.entidades;

import Casino.Casino;
import Casino.Juegos.Ruleta.Servicio.ServicioMesaRuleta;
import java.io.Serializable;
import java.util.ArrayList;

//Clase encargada de contener todas las mesas de Ruleta virtual
public class Ruleta extends Casino implements Serializable {

    private ArrayList<ServicioMesaRuleta> mesas = new ArrayList();//Contenedor de Ruletas Virtuales

    public Ruleta() {
        super();
    }
//Creo la cantidad de mesas de ruleta, inicio es por si quiero empezar desde un numero en vez de 0 en adelante 

    public void crearMesa(int cap, int inicio) {
        for (int i = 0; i < cap; i++) {
            ServicioMesaRuleta smr = new ServicioMesaRuleta();
            smr.setNumMesa(i + inicio);
            mesas.add(smr);

        }
    }

    //Retorna lista de mesas que puede ocupar el cliente por estar disponibles
    public ArrayList<ServicioMesaRuleta> mesadisponibles() {
        ArrayList<ServicioMesaRuleta> disponible = new ArrayList<ServicioMesaRuleta>();
        for (ServicioMesaRuleta m : mesas) {
            if (m.getM().isDisponible()) {
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
