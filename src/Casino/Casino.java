package Casino;

import java.util.Date;

public class Casino {
  protected long dinero;
  protected long ganancia_perdida;
  protected Date fecha;
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

    public long getGanancia_perdida() {
        return ganancia_perdida;
    }

    public void setGanancia_perdida(long ganancia_perdida) {
        this.ganancia_perdida = ganancia_perdida;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "El dinero actual del Casino es de " +dinero ;
    }
  
  
}
