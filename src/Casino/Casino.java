package Casino;

import java.io.Serializable;

public class Casino implements Serializable {

    protected long dinero;

    public Casino(long dinero) {//Por si quiero inicializar el dinero del casino por defecto se pondra dinero fijo
        this.dinero = dinero;
    }

    public Casino() {
        dinero = (long) Math.pow(2, 27);//dinero =134.217.728
    }

    public long getDineroCasino() {
        return dinero;
    }

    public void setDineroCasino(long dinero) {
        this.dinero = dinero;
    }

    @Override
    public String toString() {
        return "El dinero actual del Casino es de " + dinero;
    }

}
