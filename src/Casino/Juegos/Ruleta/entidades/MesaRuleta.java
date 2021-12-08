package Casino.Juegos.Ruleta.entidades;

import java.io.Serializable;
import java.util.Objects;

//Clase que simula maquina virtual de ruleta
public class MesaRuleta implements Serializable {

    private Tablero mesa;
    private boolean disponible;
    private long dinero;//dinero del jugador
    private int numeroRuleta;

    public MesaRuleta() {
        mesa = new Tablero();
        mesa.inicializarTablero();
        disponible = true;

        dinero = 0;
    }

    public Tablero getMesa() {
        return mesa;
    }

    public void setMesa(Tablero mesa) {
        this.mesa = mesa;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public long getDinero() {
        return dinero;
    }

    public void setDinero(long dinero) {
        this.dinero = dinero;
    }

    public int getNumeroRuleta() {
        return numeroRuleta;
    }

    public void setNumeroRuleta(int numeroRuleta) {
        this.numeroRuleta = numeroRuleta;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final MesaRuleta other = (MesaRuleta) obj;
        if (this.disponible != other.disponible) {
            return false;
        }
        if (this.dinero != other.dinero) {
            return false;
        }
        if (this.numeroRuleta != other.numeroRuleta) {
            return false;
        }
        if (!Objects.equals(this.mesa, other.mesa)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MesaRuleta{" + "mesa=" + mesa + ", disponible=" + disponible + ", dinero=" + dinero + ", numeroRuleta=" + numeroRuleta + '}';
    }

    //Inicializo mesa
    public void inicializar(char o) //A=inicializa tablero,B=Inicializa dinero,C=Disponibilidad
    {
        if (o == 'A') {
            mesa.inicializarTablero();
        } else if (o == 'B') {
            dinero = 0;
        } else {
            disponible = true;
        }
    }

}
