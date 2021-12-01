package Casino;

import java.util.Date;

public class Casino {
  protected long dinero;
  
    public Casino(long dinero) {//Por si quiero inicializar el dinero del casino por defecto se pondra dinero fijo
        this.dinero = dinero;
    }

    public Casino() {
        dinero=(long)Math.pow(2,30);
    }

    protected long getDineroCasino() {
        return dinero;
    }

   protected void setDineroCasino(long dinero) {
        this.dinero = dinero;
    }

   

    @Override
    public String toString() {
        return "El dinero actual del Casino es de " +dinero ;
    }
  
  
}
