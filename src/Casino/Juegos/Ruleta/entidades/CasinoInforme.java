package Casino.Juegos.Ruleta.entidades;

import java.io.Serializable;
import java.util.Date;

//Esta clase se encarga de enviar al servidor el informe de la jugada de un cliente
public class CasinoInforme implements Serializable {

    private long dineroCasino;
    private long ganper;
    private Date fecha;
    private int nroMesa;

    public CasinoInforme() {
    }

    public CasinoInforme(long dineroCasino, long ganper, int nroMesa, Date fecha) {
        this.dineroCasino = dineroCasino;
        this.ganper = ganper;
        this.fecha = fecha;
        this.nroMesa = nroMesa;
    }

    public long getDineroCasino() {
        return dineroCasino;
    }

    public void setDineroCasino(long dineroCasino) {
        this.dineroCasino = dineroCasino;
    }

    public long getGanper() {
        return ganper;
    }

    public void setGanper(long ganper) {
        this.ganper = ganper;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getNroMesa() {
        return nroMesa;
    }

    public void setNroMesa(int nroMesa) {
        this.nroMesa = nroMesa;
    }

    @Override
    public String toString() {
        return "CasinoInforme{" + "dineroCasino=" + dineroCasino + ", ganper=" + ganper + ", fecha=" + fecha + ", nroMesa=" + nroMesa + '}';
    }

}
