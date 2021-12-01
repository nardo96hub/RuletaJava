

package Casino.Juegos;

import Casino.Casino;
import Casino.Juegos.Ruleta.InterfazGrafica.Tablero;
import Casino.Juegos.Ruleta.entidades.Ruleta;


public class Inicio {

 
    public static void main(String[] args) {
        Ruleta r=new Ruleta();
        r.crearMesa(1, 0);
       
        
       //r.JuegoRuleta();
         java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                new Tablero(r.mesa()).setVisible(true);
            }
        });
    }

}
