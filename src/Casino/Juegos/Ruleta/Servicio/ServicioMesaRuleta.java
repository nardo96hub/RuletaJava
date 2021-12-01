package Casino.Juegos.Ruleta.Servicio;

import Casino.Casino;
import Casino.Juegos.Ruleta.entidades.MesaRuleta;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ServicioMesaRuleta extends Casino {

    private MesaRuleta m = new MesaRuleta();
    private int numMesa;
    private Scanner l = new Scanner(System.in).useDelimiter("\n");

    public int getNumMesa() {
        return numMesa;
    }

    public void setNumMesa(int numMesa) {
        this.numMesa = numMesa;
    }

    public MesaRuleta getM() {
        return m;
    }

   
    private void inicializo() {
        for (int i = 0; i < 3; i++) {
            m.inicializar((char) ('A' + i));
        }
    }

    public void seteoapuesta(int apuesta, int opcion, int ficha) {
        int[] a, b, c;
        switch (apuesta) {
            case 1:
                a = m.getMesa().getPleno();
                a[opcion] += ficha;
                m.setDinero(m.getDinero() - ficha);
                m.getMesa().setPleno(a);
                break;
            case 2:
                b = m.getMesa().getAtriple();
                b[opcion - 1] += ficha;
                m.setDinero(m.getDinero() - ficha);
                m.getMesa().setAtriple(b);
                break;
            case 3:
                b = m.getMesa().getAtriple();
                b[opcion + 2] += ficha;
                m.setDinero(m.getDinero() - ficha);
                m.getMesa().setAtriple(b);
                break;
            case 4:
                c = m.getMesa().getAdoble();
                c[opcion - 1] += ficha;
                m.setDinero(m.getDinero() - ficha);
                m.getMesa().setAdoble(c);
                break;
            case 5:
                c = m.getMesa().getAdoble();
                c[opcion + 1] += ficha;
                m.setDinero(m.getDinero() - ficha);
                m.getMesa().setAdoble(c);
                break;
            case 6:
                c = m.getMesa().getAdoble();
                c[opcion + 3] += ficha;
                m.setDinero(m.getDinero() - ficha);
                m.getMesa().setAdoble(c);
                break;
        }
    }

    public void JuegoTablero() {//Metodo para tablero
        int num = (int) (Math.random() * 37);

        resultadoApuesta(num);
        m.setNumeroRuleta(num);
    }


    private void resultadoApuesta(int salio) {

        int[] a, b, c;
        a = m.getMesa().getPleno();
        b = m.getMesa().getAtriple();
        c = m.getMesa().getAdoble();
        ArrayList<Integer> Rojo = new ArrayList<Integer>(Arrays.asList(1, 3, 5, 7, 9, 12, 14, 16, 18, 19, 21, 23, 25, 27, 30, 32, 34, 36));
        ArrayList<Integer> Negro = new ArrayList<Integer>(Arrays.asList(2, 4, 6, 8, 10, 11, 13, 15, 17, 20, 22, 24, 26, 28, 29, 31, 33, 35));
        for (int i = 0; i < a.length; i++) {

            if (i < 6) {//Analizo los 3 array
                if (a[i] != 0) {//Anlizo pleno
                    if (i == salio) {
                        m.setDinero(m.getDinero() + a[i] * 36);
                        setDineroCasino(getDineroCasino() - a[i] * 36);
                    } else {
                        setDineroCasino(getDineroCasino() + a[i]);
                    }
                }
                if (b[i] != 0) {//Analizo triple
                    if (i < 3) {//Analizo Docena
                        if ((i == 0 && salio <= 12) || (i == 1 && salio > 12 && salio <= 24) || (i == 2 && salio > 24) && salio != 0) {
                            m.setDinero(m.getDinero() + b[i] * 3);
                            setDineroCasino(getDineroCasino() - b[i] * 3);
                        } else {
                            setDineroCasino(getDineroCasino() + b[i]);
                        }
                    } else {//Analizo Columna
                        if ((i == 0 && (salio % 3) == 1) || (i == 1 && (salio % 3) == 2) || (i == 2 && (salio % 3) == 0) && salio != 0) {
                            m.setDinero(m.getDinero() + b[i] * 3);
                            setDineroCasino(getDineroCasino() - b[i] * 3);
                        } else {
                            setDineroCasino(getDineroCasino() + b[i]);
                        }
                    }
                }
                if (c[i] != 0) {//Analizo dobles
                    if (i < 2) {//Analizo [1,18] / [19,36]
                        if ((i == 0 && salio < 19) || (i == 1 && salio > 18) && salio != 0) {
                            m.setDinero(m.getDinero() + b[i] * 2);
                            setDineroCasino(getDineroCasino() - c[i] * 2);
                        } else {
                            setDineroCasino(getDineroCasino() + c[i]);
                        }

                    } else if (i < 4) {//Analizo Par/Impar
                        if ((i == 2 && (salio % 2) == 0) || (i == 3 && (salio % 2) == 1) && salio != 0) {
                            m.setDinero(m.getDinero() + c[i] * 2);
                            setDineroCasino(getDineroCasino() - c[i] * 2);
                        } else {
                            setDineroCasino(getDineroCasino() + c[i]);
                        }
                    } else {//Analizo Color
                        if ((i == 4 && Rojo.contains(salio)) || (i == 5 && Negro.contains(salio)) && salio != 0) {
                            m.setDinero(m.getDinero() + c[i] * 2);
                            setDineroCasino(getDineroCasino() - c[i] * 2);
                        } else {
                            setDineroCasino(getDineroCasino() + c[i]);
                        }
                    }
                }
            } else {//Analizo resto pleno
                if (a[i] != 0) {
                    if (i == salio) {
                        m.setDinero(m.getDinero() + a[i] * 36);
                        setDineroCasino(getDineroCasino() - a[i] * 36);
                    } else {
                        setDineroCasino(getDineroCasino() + a[i]);
                    }

                }
            }
        }
    }
    
    
    // Metodos consoloa
    
    /* private void ponerDinero() {
        long d;

        System.out.println("Ingrese dinero que desee apostar");
        d = l.nextLong();
        while (d <= 0) {
            System.out.println("Ingrese dinero que desee poner en juego");
            d = l.nextLong();
        }
        m.setDinero(m.getDinero() + d);
    }

    private int validar(int op, char tipo) {

        if (tipo == 'A') {//Valido tipo de ficha
            while (op != 1 && op != 2 && op != 5 && op != 10 && op != 50 && op != 100 && op != 500) {
                System.out.println("Error ingrese [1, 2, 5, 10, 50, 100,500]: ");
                op = l.nextInt();
            }
            return op;
        }
        if (tipo == 'B') {//Valido rango positivo
            while (op <= 0) {
                System.out.println("Ingrese un numero>0");
                op = l.nextInt();

            }
            return op;
        }

        return 0;//Nunca llego aca
    }

    private int validoRango(int op, int min, int max) {
        while (op < min || op > max) {
            System.out.println("Ingrese una opcion entre [" + min + "," + max + "]");
            op = l.nextInt();
        }
        return op;
    }
*/
       /* public void Juego() {
        String r = "";
        long d;
        int opcion, ficha, cantFicha;
        inicializo();
        m.setDisponible(false);
        ponerDinero();

        do {

            System.out.println("Desea agregar Mas dinero? (s/n)");
            r = l.next();
            if (r.equalsIgnoreCase("s")) {
                ponerDinero();
            }
            m.getMesa().inicializarTablero();
            //Apuestas
            do {

                System.out.println("***Apuestas***");
                System.out.println("1)Numeros.\n2)Docenas.\n3)Columna.\n4)[1,18] y [19,36].\n5)Par e Impar.\n6)Color.\n");
                System.out.println("Ingrese opcion entre [1,6]");
                opcion = l.nextInt();
                validoRango(opcion, 1, 6);
                System.out.println("Ingrese el tipo de ficha [1,2,5,10,50,100,500]");
                ficha = l.nextInt();
                validar(ficha, 'A');
                System.out.println("Ingrese la cantidad de fichas de :" + ficha + " que desea apostar <=" + ((int) (m.getDinero() / ficha)));
                cantFicha = l.nextInt();
                validar(cantFicha, 'B');
                while (ficha * cantFicha > m.getDinero()) {
                    System.out.println("Ingrese la cantidad de fichas de :" + ficha + " que desea apostar <=" + ((int) (m.getDinero() / ficha)));
                    cantFicha = l.nextInt();
                    validar(cantFicha, 'B');
                }
                int[] a, b, c;
                m.getMesa().mostrarTablero();
                switch (opcion) {
                    case 1:
                        System.out.println("Ingrese el numero que desea apostar entre [0,36]");
                        opcion = l.nextInt();
                        validoRango(opcion, 0, 36);
                        a = m.getMesa().getPleno();
                        a[opcion] += ficha * cantFicha;
                        m.setDinero(m.getDinero() - ficha * cantFicha);
                        m.getMesa().setPleno(a); //Revisar si guarda

                        break;
                    case 2:
                        System.out.println("--Docenas--\n1)Doc1.\n2)Doc2.\n3)Doc3.\nIngrese opcion entre [1,3]");
                        opcion = l.nextInt();
                        validoRango(opcion, 1, 3);
                        b = m.getMesa().getAtriple();
                        b[opcion - 1] += ficha * cantFicha;
                        m.setDinero(m.getDinero() - ficha * cantFicha);
                        m.getMesa().setAtriple(b);

                        break;
                    case 3:
                        System.out.println("--Columna--\n1)Col1.\n2)Col2.\n3)Col3.\nIngrese opcion entre [1,3]");
                        opcion = l.nextInt();
                        validoRango(opcion, 1, 3);
                        b = m.getMesa().getAtriple();
                        b[opcion + 2] += ficha * cantFicha;
                        m.setDinero(m.getDinero() - ficha * cantFicha);
                        m.getMesa().setAtriple(b);

                        break;
                    case 4:
                        System.out.println("[1,18] o [19,36]\n1)[1,18].\n2)[19,36]\nIngrese una opcion entre [1,2]");

                        opcion = l.nextInt();
                        validoRango(opcion, 1, 2);
                        c = m.getMesa().getAdoble();
                        c[opcion - 1] += ficha * cantFicha;
                        m.setDinero(m.getDinero() - ficha * cantFicha);
                        m.getMesa().setAdoble(c);
                        break;
                    case 5:
                        System.out.println("Par e Impar\n1)Par.\n2)Impar\nIngrese una opcion entre [1,2]");

                        opcion = l.nextInt();
                        validoRango(opcion, 1, 2);
                        c = m.getMesa().getAdoble();
                        c[opcion + 1] += ficha * cantFicha;
                        m.setDinero(m.getDinero() - ficha * cantFicha);
                        m.getMesa().setAdoble(c);
                        break;
                    case 6:
                        System.out.println("Rojo o Negro\n1)Rojo.\n2)Negro.\nIngrese una opcion entre [1,2]");

                        opcion = l.nextInt();
                        validoRango(opcion, 1, 2);
                        c = m.getMesa().getAdoble();
                        //0 1   2 3     4 5
                        c[opcion + 3] += ficha * cantFicha;
                        m.setDinero(m.getDinero() - ficha * cantFicha);
                        m.getMesa().setAdoble(c);
                        break;
                }

                System.out.println("Desea apostar de nuevo (s/n)");
                r = l.next();
            } while (r.equalsIgnoreCase("s"));
            int numero = (int) (Math.random() * 37);
            mostrar_dinero();
            m.getMesa().mostrarTablero();
            resultadoApuesta(numero);

            System.out.println("Salio el numero :" + numero);

            m.getMesa().mostrarTablero();
            mostrar_dinero();

            System.out.println("Desea seguir jugando? (presione s/n para continuar)");
            r = l.next();
        } while (!r.equalsIgnoreCase("n"));

        inicializo();

    }

    private void mostrar_dinero() {
        System.out.println("Actualmente el jugador tiene: " + m.getDinero());
        System.out.println("Actualmente el casino tiene: " + getDineroCasino());
    }
*/
}
