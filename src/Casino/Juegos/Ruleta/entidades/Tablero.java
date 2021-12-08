package Casino.Juegos.Ruleta.entidades;

import java.io.Serializable;
import java.util.Arrays;
//Clase que simula tablero de ruleta

public class Tablero implements Serializable {

    private int[] pleno = new int[37];//Guarda las apuestas de numeros plenos 
    private int[] Atriple = new int[6];//Guarda las apuestas triple de Docena y Columna
    private int[] Adoble = new int[6];//Guarda las apuestas dobles de Falta/Pasa([1,18],[19,36]) , Par/Impar y Colores

    public void inicializarTablero() {//Inicializo en 0 el tablero
        for (int i = 0; i < pleno.length; i++) {
            if (i < Adoble.length) {
                Atriple[i] = 0;
                Adoble[i] = 0;
            }
            pleno[i] = 0;
        }
    }

    public int[] getPleno() {
        return pleno;
    }

    public void setPleno(int[] pleno) {
        this.pleno = pleno;
    }

    public int[] getAtriple() {
        return Atriple;
    }

    public void setAtriple(int[] Atriple) {
        this.Atriple = Atriple;
    }

    public int[] getAdoble() {
        return Adoble;
    }

    public void setAdoble(int[] Adoble) {
        this.Adoble = Adoble;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + Arrays.hashCode(this.pleno);
        hash = 13 * hash + Arrays.hashCode(this.Atriple);
        hash = 13 * hash + Arrays.hashCode(this.Adoble);
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
        final Tablero other = (Tablero) obj;
        if (!Arrays.equals(this.pleno, other.pleno)) {
            return false;
        }
        if (!Arrays.equals(this.Atriple, other.Atriple)) {
            return false;
        }
        if (!Arrays.equals(this.Adoble, other.Adoble)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Tablero{" + "pleno=" + pleno + ", Atriple=" + Atriple + ", Adoble=" + Adoble + '}';
    }

}
