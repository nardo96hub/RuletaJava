package Casino.Juegos.Ruleta.entidades;

import Casino.Casino;
import Casino.Juegos.Ruleta.Servicio.ServicioMesaRuleta;

import java.util.ArrayList;
import java.util.Scanner;

public class Ruleta extends Casino {

    private ArrayList<ServicioMesaRuleta> mesas = new ArrayList();
    private Scanner l = new Scanner(System.in).useDelimiter("\n");

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
    
    //  Metodos para consola
    
    
    /*private void mostrarMesa(ArrayList<Integer> mesa){
     
        for (Integer i : mesa) {
            System.out.print(i+" ");
        }
     
    }*/
    /*
    private int buscarmesadisponible() { //Verifica mesas disponibles para jugar
        int m;
        ArrayList<Integer> md = new ArrayList();
        
        for (ServicioMesaRuleta mesa : mesas) {
            if (mesa.getM().isDisponible()) {
                md.add(mesa.getNumMesa());
                
            }
        }
        if (md.size() == 0) {
            System.out.println("No hay mesas disponibles ");
            return 0;
        } else {
           System.out.print("Las mesas disponibles son:");
            mostrarMesa(md);
            System.out.println("\nIngrese num de mesa");
            m =l.nextInt();
            while (!md.contains(m)) {
                System.out.print("\nIngrese una mesa disponible:");
                mostrarMesa(md);System.out.println("");
                m = l.nextInt();
            }
            return m;
        }

    }*/
    /*
    private ServicioMesaRuleta Mesa(int mesa){
        ServicioMesaRuleta smr=null;
        for (ServicioMesaRuleta m : mesas) {
            if(m.getNumMesa()==mesa){
                smr=m;
            }
            
        }
        
        return smr;
    }
*/
  /*  public void JuegoRuleta() {
        //System.out.println("Ingrese cuantas mesas desea crear");
        int mesa=l.nextInt();
        while(mesa<=0){
          System.out.println("Ingrese cuantas mesas desea crear");
          mesa=l.nextInt();  
        }
       
        crearMesa(mesa,1);
       Mesa(buscarmesadisponible()).Juego();
    }*/

    public ArrayList<ServicioMesaRuleta> getMesas() {
        return mesas;
    }

    public void setMesas(ArrayList<ServicioMesaRuleta> mesas) {
        this.mesas = mesas;
    }
    

}
