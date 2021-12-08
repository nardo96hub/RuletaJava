package Casino.Juegos.Ruleta.Servicio;

import Casino.Casino;
import Casino.Juegos.Ruleta.entidades.MesaRuleta;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

public class ServicioMesaRuleta extends Casino implements Serializable {

    private MesaRuleta m = new MesaRuleta();
    private int numMesa;

    public int getNumMesa() {
        return numMesa;
    }

    public void setNumMesa(int numMesa) {
        this.numMesa = numMesa;
    }

    public MesaRuleta getM() {
        return m;
    }

    //Metodo que invoca la inicializacion de datos en la clase MesaRuleta
    public void inicializo() {
        for (int i = 0; i < 3; i++) {
            m.inicializar((char) ('A' + i));
        }
    }

    //Seteo los arreglos en la clase Tablero segun la apuesta del cliente 
    public void seteoapuesta(int apuesta, int opcion, int ficha) {
        //Recordatorio Triple [doc1,doc2,doc3,col1,col2,col3]
        //Recordatorio Doble[<19,>19,Par,Impar,Rojo,Negro]
        int[] a, b, c;//Declaro 3 array (pleno/triple/doble)
        switch (apuesta) {
            case 1://Apuesta pleno
                a = m.getMesa().getPleno();
                a[opcion] += ficha;
                m.setDinero(m.getDinero() - ficha);
                m.getMesa().setPleno(a);
                break;
            case 2://Apuesta Docenas
                //rango de Triple para doc [0,2] opcion es entre [1,3]
                b = m.getMesa().getAtriple();
                b[opcion - 1] += ficha;
                m.setDinero(m.getDinero() - ficha);
                m.getMesa().setAtriple(b);
                break;
            case 3://Apuesta Columnas
                //rango de Triple para col [3,5] opcion es entre [1,3]
                b = m.getMesa().getAtriple();
                b[opcion + 2] += ficha;
                m.setDinero(m.getDinero() - ficha);
                m.getMesa().setAtriple(b);
                break;
            case 4://Apuesta [1,18] [19,36]
                //rango de Doble para [1,18] [19,36] [0,1] opcion es entre [1,2]
                c = m.getMesa().getAdoble();
                c[opcion - 1] += ficha;
                m.setDinero(m.getDinero() - ficha);
                m.getMesa().setAdoble(c);
                break;
            case 5://Apuesta Par e impar
                //rango de Doble para Par e Impar [2,3] opcion es entre [1,2]
                c = m.getMesa().getAdoble();
                c[opcion + 1] += ficha;
                m.setDinero(m.getDinero() - ficha);
                m.getMesa().setAdoble(c);
                break;
            case 6://Apuesta Color
                //rango de Doble paracolor [4,5] opcion es entre [1,2]
                c = m.getMesa().getAdoble();
                c[opcion + 3] += ficha;
                m.setDinero(m.getDinero() - ficha);
                m.getMesa().setAdoble(c);
                break;
        }
    }

    public void JuegoTablero() {//Metodo para tablero
        int num = (int) (Math.random() * 37);//Sale numero entre [0,36]

        resultadoApuesta(num);//Metodo con resulta
        m.setNumeroRuleta(num);
    }

    private void resultadoApuesta(int salio) {

        int[] a, b, c;//Creo 3 array para no estar repitiendo m.getMesa().get____();
        a = m.getMesa().getPleno();
        b = m.getMesa().getAtriple();
        c = m.getMesa().getAdoble();
        //Defino 2 arreglos dinamicos que contiene todos los numeros de un respectivo color y poder usar contains();
        ArrayList<Integer> Rojo = new ArrayList<Integer>(Arrays.asList(1, 3, 5, 7, 9, 12, 14, 16, 18, 19, 21, 23, 25, 27, 30, 32, 34, 36));//Numeros Rojos
        ArrayList<Integer> Negro = new ArrayList<Integer>(Arrays.asList(2, 4, 6, 8, 10, 11, 13, 15, 17, 20, 22, 24, 26, 28, 29, 31, 33, 35));//Numeros Negros
        //Recorro los 3 array en simultaneo 
        for (int i = 0; i < a.length; i++) {

            if (i < 6) {//Analizo los 3 array
                if (a[i] != 0) {//Anlizo pleno
                    if (i == salio) {//Gana el jugador
                        m.setDinero(m.getDinero() + a[i] * 36);
                        setDineroCasino(getDineroCasino() - a[i] * 36);
                    } else {//Gana el casino
                        setDineroCasino(getDineroCasino() + a[i]);
                    }
                }
                if (b[i] != 0) {//Analizo triple
                    if (i < 3) {//Analizo Docena
                        //Analizo los 3 casos de de docena 
                        if ((i == 0 && salio <= 12) || (i == 1 && salio > 12 && salio <= 24) || (i == 2 && salio > 24) && salio != 0) {
                            //Ganancia jugador
                            m.setDinero(m.getDinero() + b[i] * 3);
                            setDineroCasino(getDineroCasino() - b[i] * 3);
                        } else {
                            //ganancia casino
                            setDineroCasino(getDineroCasino() + b[i]);
                        }
                    } else {//Analizo Columna
                        //Analizo los 3 casos de de columna
                        if ((i == 0 && (salio % 3) == 1) || (i == 1 && (salio % 3) == 2) || (i == 2 && (salio % 3) == 0) && salio != 0) {
                            //ganancia jugador
                            m.setDinero(m.getDinero() + b[i] * 3);
                            setDineroCasino(getDineroCasino() - b[i] * 3);
                        } else {
                            //ganancia casino
                            setDineroCasino(getDineroCasino() + b[i]);
                        }
                    }
                }
                if (c[i] != 0) {//Analizo dobles
                    if (i < 2) {//Analizo [1,18] / [19,36]
                        if ((i == 0 && salio < 19) || (i == 1 && salio > 18) && salio != 0) {
                            //ganancia jugador
                            m.setDinero(m.getDinero() + b[i] * 2);
                            setDineroCasino(getDineroCasino() - c[i] * 2);
                        } else {
                            //ganancia casino
                            setDineroCasino(getDineroCasino() + c[i]);
                        }

                    } else if (i < 4) {//Analizo Par/Impar
                        if ((i == 2 && (salio % 2) == 0) || (i == 3 && (salio % 2) == 1) && salio != 0) {
                            //ganancia jugador
                            m.setDinero(m.getDinero() + c[i] * 2);
                            setDineroCasino(getDineroCasino() - c[i] * 2);
                        } else {
                            //ganancia casino
                            setDineroCasino(getDineroCasino() + c[i]);
                        }
                    } else {//Analizo Color
                        if ((i == 4 && Rojo.contains(salio)) || (i == 5 && Negro.contains(salio)) && salio != 0) {
                            //ganancia jugador
                            m.setDinero(m.getDinero() + c[i] * 2);
                            setDineroCasino(getDineroCasino() - c[i] * 2);
                        } else {
                            //ganancia casino
                            setDineroCasino(getDineroCasino() + c[i]);
                        }
                    }
                }
            } else {//Analizo resto pleno
                if (a[i] != 0) {
                    if (i == salio) {
                        //ganancia jugador
                        m.setDinero(m.getDinero() + a[i] * 36);
                        setDineroCasino(getDineroCasino() - a[i] * 36);
                    } else {
                        //ganancia casino
                        setDineroCasino(getDineroCasino() + a[i]);
                    }

                }
            }
        }
    }

}
