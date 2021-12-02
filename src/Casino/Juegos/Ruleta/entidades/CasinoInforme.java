package Casino.Juegos.Ruleta.entidades;

import java.util.Date;

public class CasinoInforme {
    private long dineroCasino;
    private long ganper;
    private Date fecha;
    private int nroMesa;

    public CasinoInforme() {
    }

    public CasinoInforme(long dineroCasino, long ganper, Date fecha, int nroMesa) {
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
    
    
    
}
