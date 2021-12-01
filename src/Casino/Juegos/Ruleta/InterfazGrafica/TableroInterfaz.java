/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Casino.Juegos.Ruleta.InterfazGrafica;

import Casino.Juegos.Ruleta.Servicio.ServicioMesaRuleta;

import java.awt.Color;
import java.awt.Image;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.*;

/**
 *
 * @author Jorge
 */
public class TableroInterfaz extends javax.swing.JFrame {

    private ServicioMesaRuleta tablero;
    private StringBuilder n = new StringBuilder();
    ClienteInterfaz c;

    public TableroInterfaz(ServicioMesaRuleta m,ClienteInterfaz cliente) {
        c=cliente;
        tablero = m;
        initComponents();
        VentanaParametros();
        fondos();
        checkbox();

    }

    private void fondo(JLabel lb, String ruta) {//Agrega imagen en los JLabel
        ImageIcon imagen;
        Icon icono;
        imagen = new ImageIcon(ruta);
        icono = new ImageIcon(imagen.getImage().getScaledInstance(lb.getWidth(), lb.getHeight(), Image.SCALE_DEFAULT));
        lb.setIcon(icono);
    }

    private void fondos() {// Coloco las imagenes en los label
        this.fondo(this.tab, "src/Casino/Juegos/Ruleta/InterfazGrafica/imagen/tablero.jpg");
        this.fondo(this.rul, "src/Casino/Juegos/Ruleta/InterfazGrafica/imagen/BCB.gif");
        this.fondo(this.f1, "src/Casino/Juegos/Ruleta/InterfazGrafica/imagen/1.jpg");
        this.fondo(this.f2, "src/Casino/Juegos/Ruleta/InterfazGrafica/imagen/2.jpg");
        this.fondo(this.f3, "src/Casino/Juegos/Ruleta/InterfazGrafica/imagen/5.jpg");
        this.fondo(this.f4, "src/Casino/Juegos/Ruleta/InterfazGrafica/imagen/10.jpg");
        this.fondo(this.f5, "src/Casino/Juegos/Ruleta/InterfazGrafica/imagen/25.jpg");
        this.fondo(this.f6, "src/Casino/Juegos/Ruleta/InterfazGrafica/imagen/50.jpg");
        this.fondo(this.f7, "src/Casino/Juegos/Ruleta/InterfazGrafica/imagen/100.jpg");
        this.fondo(this.f8, "src/Casino/Juegos/Ruleta/InterfazGrafica/imagen/500.jpg");
      
    }

    private void VentanaParametros() {//Establece medidas
        n.append("");
        String text = "";
        //tablero.getM().setDinero(100000);
        
        din.setText(text + tablero.getM().getDinero());
        mesa.setText(text + tablero.getNumMesa());
        mesa.setEnabled(false);
        din.setEnabled(false);
        numeros.setEnabled(false);
        setBounds(0, 0, 1000, 570);
        setTitle("Ruleta");
        setResizable(false);
        setVisible(true);
        setIconImage(new ImageIcon("src/Casino/Juegos/Ruleta/InterfazGrafica/imagen/logo.jpg").getImage());
    }

    private void checkbox() {
        opcion.setVisible(false);
        salio.setVisible(false);
        num.setVisible(false);
        volverAportar.setVisible(false);
        apostar.setVisible(false);
        girar.setVisible(false);

    }

    private int fichas() {
        int[] f = new int[8];
        f[0] = Integer.parseInt(c1.getText());
        f[1] = Integer.parseInt(c2.getText()) * 2;
        f[2] = Integer.parseInt(c5.getText()) * 5;
        f[3] = Integer.parseInt(c10.getText()) * 10;
        f[4] = Integer.parseInt(c25.getText()) * 25;
        f[5] = Integer.parseInt(c50.getText()) * 50;
        f[6] = Integer.parseInt(c100.getText()) * 100;
        f[7] = Integer.parseInt(c500.getText()) * 500;

        for (int i = 0; i < f.length; i++) {
            if (f[i] < 0) {
                f[i] = -f[i];
            }

        }

        int ficha = 0;
        for (int i : f) {
            ficha += i;

        }
        if (ficha > tablero.getM().getDinero()) {
            return (int) tablero.getM().getDinero();
        } else {
            return ficha;
        }

    }

    private void verificacionApuesta() {

        if (c1.getText().equals("0") && c2.getText().equals("0") && c5.getText().equals("0") && c10.getText().equals("0") && c25.getText().equals("0") && c50.getText().equals("0") && c100.getText().equals("0") && c500.getText().equals("0")) {
            JOptionPane.showMessageDialog(rootPane, "No ingreso fichas de Apuesta");
        } else {
            volverAportar.setVisible(true);
            girar.setVisible(true);

            int a, o, ficha;
            a = 0;
            o = 0;
            String apues, op;
            ficha = fichas();
            apues = (String) apuesta.getSelectedItem();
            op = (String) opcion.getSelectedItem();

            switch (apues) {
                case "Numeros":
                    a = 1;
                    o = Integer.parseInt(op);
                    break;
                case "Docena":
                    a = 2;
                    switch (op) {
                        case "Doc1":
                            o = 1;
                            break;
                        case "Doc2":
                            o = 2;
                            break;
                        case "Doc3":
                            o = 3;
                            break;
                    }
                    break;
                case "Columna":
                    a = 3;
                    switch (op) {
                        case "Col1":
                            o = 1;
                            break;
                        case "Col2":
                            o = 2;
                            break;
                        case "Col3":
                            o = 3;
                            break;
                    }
                    break;
                case "[1,18]  [19,36]":
                    a = 4;
                    switch (op) {
                        case "[1,18]":
                            o = 1;
                            break;
                        case "[19,36]":
                            o = 2;
                            break;

                    }
                    break;
                case "Par e Impar":
                    a = 5;
                    switch (op) {
                        case "Par":
                            o = 1;
                            break;
                        case "Impar":
                            o = 2;
                            break;

                    }
                    break;
                case "Color":
                    a = 6;
                    switch (op) {
                        case "Rojo":
                            o = 1;
                            break;
                        case "Negro":
                            o = 2;
                            break;

                    }
                    break;

            }
            tablero.seteoapuesta(a, o, ficha);
            din.setText(""+tablero.getM().getDinero());

        }

    }
    private void seteoApuesta(){
        c1.setText("0");
        c2.setText("0");
        c5.setText("0");
        c10.setText("0");
        c25.setText("0");
        c50.setText("0");
        c100.setText("0");
        c500.setText("0");
    }
    private void seteoNumRuleta() {
        num.setText("" + tablero.getM().getNumeroRuleta());
        ArrayList<Integer> Rojo = new ArrayList<Integer>(Arrays.asList(1, 3, 5, 7, 9, 12, 14, 16, 18, 19, 21, 23, 25, 27, 30, 32, 34, 36));
        ArrayList<Integer> Negro = new ArrayList<Integer>(Arrays.asList(2, 4, 6, 8, 10, 11, 13, 15, 17, 20, 22, 24, 26, 28, 29, 31, 33, 35));
        if(Rojo.contains(tablero.getM().getNumeroRuleta())){
            num.setForeground(Color.RED);
        }else if(Negro.contains(tablero.getM().getNumeroRuleta())){
            num.setForeground(Color.BLACK);
        }else{
            num.setForeground(Color.GREEN);
        }
        
        
        
        
        num.setVisible(true);
        

    }

    private void ventanaErrorApuestaLetras(KeyEvent evt) {//Valida que no se ingrese letras
        char val = evt.getKeyChar();
        if (Character.isLetter(val)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(rootPane, "Ingresar Solo Numeros");
        }
    }

    private void agregarModel(String[] p) {
        opcion.setModel(new javax.swing.DefaultComboBoxModel<>(p));
        opcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcionActionPerformed(evt);
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel1 = new javax.swing.JPanel();
        numeros = new javax.swing.JTextField();
        rul = new javax.swing.JLabel();
        tab = new javax.swing.JLabel();
        nroS = new javax.swing.JLabel();
        Cash = new javax.swing.JLabel();
        din = new javax.swing.JTextField();
        retirar = new javax.swing.JButton();
        girar = new javax.swing.JButton();
        nromesa = new javax.swing.JLabel();
        mesa = new javax.swing.JTextField();
        f1 = new javax.swing.JLabel();
        f2 = new javax.swing.JLabel();
        f3 = new javax.swing.JLabel();
        f4 = new javax.swing.JLabel();
        f5 = new javax.swing.JLabel();
        f6 = new javax.swing.JLabel();
        f7 = new javax.swing.JLabel();
        f8 = new javax.swing.JLabel();
        c1 = new javax.swing.JTextField();
        c2 = new javax.swing.JTextField();
        c5 = new javax.swing.JTextField();
        c10 = new javax.swing.JTextField();
        c25 = new javax.swing.JTextField();
        c50 = new javax.swing.JTextField();
        c100 = new javax.swing.JTextField();
        c500 = new javax.swing.JTextField();
        volverAportar = new javax.swing.JButton();
        apuesta = new javax.swing.JComboBox<>();
        opcion = new javax.swing.JComboBox<>();
        apostar = new javax.swing.JButton();
        salio = new javax.swing.JLabel();
        num = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 204, 0));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel1.setBackground(new java.awt.Color(13, 124, 0));
        panel1.setMinimumSize(new java.awt.Dimension(760, 500));
        panel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        numeros.setBackground(new java.awt.Color(0, 0, 0));
        numeros.setFont(new java.awt.Font("Palatino Linotype", 1, 14)); // NOI18N
        numeros.setForeground(new java.awt.Color(255, 255, 255));
        numeros.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        panel1.add(numeros, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 410, 970, 40));

        rul.setBackground(new java.awt.Color(204, 153, 0));
        rul.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        rul.setForeground(new java.awt.Color(255, 255, 255));
        rul.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        panel1.add(rul, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 370, 140));

        tab.setBackground(new java.awt.Color(255, 255, 255));
        panel1.add(tab, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 370, 230));

        nroS.setFont(new java.awt.Font("Dutch801 Rm BT", 1, 18)); // NOI18N
        nroS.setForeground(new java.awt.Color(230, 255, 16));
        nroS.setText("Numeros que salieron:");
        panel1.add(nroS, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 380, 240, 30));

        Cash.setFont(new java.awt.Font("Dialog", 3, 24)); // NOI18N
        Cash.setForeground(new java.awt.Color(0, 0, 255));
        Cash.setText("Dinero:");
        panel1.add(Cash, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 470, 90, -1));

        din.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        din.setForeground(new java.awt.Color(255, 102, 0));
        din.setCaretColor(new java.awt.Color(255, 102, 0));
        din.setDisabledTextColor(new java.awt.Color(255, 102, 0));
        din.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dinActionPerformed(evt);
            }
        });
        panel1.add(din, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 470, 170, -1));

        retirar.setBackground(new java.awt.Color(255, 0, 0));
        retirar.setFont(new java.awt.Font("Franklin Gothic Medium", 1, 18)); // NOI18N
        retirar.setForeground(new java.awt.Color(253, 214, 6));
        retirar.setText("Retirarse");
        retirar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                retirarActionPerformed(evt);
            }
        });
        panel1.add(retirar, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 460, 150, 50));

        girar.setBackground(new java.awt.Color(51, 255, 51));
        girar.setFont(new java.awt.Font("Franklin Gothic Medium", 1, 18)); // NOI18N
        girar.setForeground(new java.awt.Color(0, 0, 255));
        girar.setText("Girar Ruleta");
        girar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                girarActionPerformed(evt);
            }
        });
        panel1.add(girar, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 470, 200, 50));

        nromesa.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        nromesa.setForeground(new java.awt.Color(67, 8, 10));
        nromesa.setText("Mesa Nº:");
        panel1.add(nromesa, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 10, 70, 30));

        mesa.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        mesa.setForeground(new java.awt.Color(255, 204, 0));
        mesa.setDisabledTextColor(new java.awt.Color(255, 0, 0));
        panel1.add(mesa, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 10, 30, 30));
        panel1.add(f1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 170, 50, 30));
        panel1.add(f2, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 170, 50, 30));
        panel1.add(f3, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 170, 50, 30));

        f4.setBackground(new java.awt.Color(204, 0, 0));
        panel1.add(f4, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 170, 50, 30));
        panel1.add(f5, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 250, 50, 30));
        panel1.add(f6, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 250, 50, 30));
        panel1.add(f7, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 250, 50, 30));

        f8.setPreferredSize(new java.awt.Dimension(30, 15));
        panel1.add(f8, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 250, 50, 30));

        c1.setText("0");
        c1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c1ActionPerformed(evt);
            }
        });
        c1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                c1KeyTyped(evt);
            }
        });
        panel1.add(c1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 210, 50, 30));

        c2.setText("0");
        c2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c2ActionPerformed(evt);
            }
        });
        c2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                c2KeyTyped(evt);
            }
        });
        panel1.add(c2, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 210, 50, 30));

        c5.setText("0");
        c5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c5ActionPerformed(evt);
            }
        });
        c5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                c5KeyTyped(evt);
            }
        });
        panel1.add(c5, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 210, 50, 30));

        c10.setText("0");
        c10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c10ActionPerformed(evt);
            }
        });
        c10.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                c10KeyTyped(evt);
            }
        });
        panel1.add(c10, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 210, 50, 30));

        c25.setText("0");
        c25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c25ActionPerformed(evt);
            }
        });
        c25.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                c25KeyTyped(evt);
            }
        });
        panel1.add(c25, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 290, 50, 30));

        c50.setText("0");
        c50.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c50ActionPerformed(evt);
            }
        });
        c50.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                c50KeyTyped(evt);
            }
        });
        panel1.add(c50, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 290, 50, 30));

        c100.setText("0");
        c100.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c100ActionPerformed(evt);
            }
        });
        c100.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                c100KeyTyped(evt);
            }
        });
        panel1.add(c100, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 290, 50, 30));

        c500.setText("0");
        c500.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                c500KeyTyped(evt);
            }
        });
        panel1.add(c500, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 290, 50, 30));

        volverAportar.setBackground(new java.awt.Color(97, 56, 31));
        volverAportar.setFont(new java.awt.Font("DialogInput", 1, 14)); // NOI18N
        volverAportar.setForeground(new java.awt.Color(153, 153, 153));
        volverAportar.setText("Volver a Apostar");
        volverAportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverAportarActionPerformed(evt);
            }
        });
        panel1.add(volverAportar, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 350, 190, -1));

        apuesta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Numeros", "Docena", "Columna", "[1,18]  [19,36]", "Par e Impar", "Color" }));
        apuesta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                apuestaActionPerformed(evt);
            }
        });
        panel1.add(apuesta, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 190, 90, -1));

        panel1.add(opcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 190, -1, -1));

        apostar.setBackground(new java.awt.Color(0, 255, 255));
        apostar.setFont(new java.awt.Font("DialogInput", 1, 14)); // NOI18N
        apostar.setForeground(new java.awt.Color(187, 29, 58));
        apostar.setText("Apostar");
        apostar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                apostarActionPerformed(evt);
            }
        });
        panel1.add(apostar, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 200, 90, -1));

        salio.setBackground(new java.awt.Color(153, 0, 153));
        salio.setFont(new java.awt.Font("MS UI Gothic", 1, 36)); // NOI18N
        salio.setForeground(new java.awt.Color(242, 245, 42));
        salio.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        salio.setText("Salio el numero:");
        panel1.add(salio, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 50, 290, 90));

        num.setBackground(new java.awt.Color(204, 0, 0));
        num.setFont(new java.awt.Font("MS UI Gothic", 1, 36)); // NOI18N
        panel1.add(num, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 70, 40, 60));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(13, 1, 207));
        jLabel1.setText("Ingrese donde Apostar");
        panel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 150, 200, 30));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(13, 1, 207));
        jLabel2.setText("Ingrese Su Apuesta");
        panel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 130, 180, 30));

        getContentPane().add(panel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1050, 540));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void retirarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_retirarActionPerformed
        tablero.inicializo();
        setVisible(false);
        
        c.ocultar();
        c.getSalir().setVisible(true);
        c.getAdios().setVisible(true);
        c.setVisible(true);
        
    }//GEN-LAST:event_retirarActionPerformed

    private void girarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_girarActionPerformed
        tablero.JuegoTablero();
        din.setText(""+tablero.getM().getDinero());
        salio.setVisible(true);

        n.append(tablero.getM().getNumeroRuleta() + " ");
        numeros.setText(n.toString());
        seteoNumRuleta();
        apostar.setVisible(false);
        volverAportar.setVisible(false);
        opcion.setVisible(false);
        seteoApuesta();
        
        if(din.getText().equals("0")){
            c1.setVisible(false); c2.setVisible(false); c5.setVisible(false); c10.setVisible(false); c25.setVisible(false); c50.setVisible(false); c100.setVisible(false); c500.setVisible(false);
            f1.setVisible(false);  f2.setVisible(false);  f3.setVisible(false);  f4.setVisible(false);  f5.setVisible(false);  f6.setVisible(false);  f7.setVisible(false);  f8.setVisible(false);
            jLabel1.setVisible(false);
            jLabel2.setVisible(false);
            girar.setVisible(false);
            apuesta.setVisible(false);
            
        }


    }//GEN-LAST:event_girarActionPerformed

    private void c10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_c10ActionPerformed

    private void c2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_c2ActionPerformed

    private void c1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_c1ActionPerformed

    private void dinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dinActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dinActionPerformed

    private void volverAportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverAportarActionPerformed
        seteoApuesta();
        opcion.setVisible(false);
        volverAportar.setVisible(false);
        girar.setVisible(false);
        apostar.setVisible(false);
    }//GEN-LAST:event_volverAportarActionPerformed

    private void c5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c5ActionPerformed

    }//GEN-LAST:event_c5ActionPerformed

    private void c25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c25ActionPerformed

    }//GEN-LAST:event_c25ActionPerformed

    private void opcionActionPerformed(java.awt.event.ActionEvent evt) {
        apostar.setVisible(true);
    }


    private void apuestaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_apuestaActionPerformed

        String valor = (String) apuesta.getSelectedItem();

        if (valor.equalsIgnoreCase("Numeros")) {
            String[] opciones = new String[37];
            String x = "";
            for (int i = 0; i < opciones.length; i++) {
                opciones[i] = x + i;
            }
            agregarModel(opciones);

        }
        if (valor.equalsIgnoreCase("Docena")) {
            String[] opciones = new String[3];
            String x = "Doc";
            for (int i = 0; i < opciones.length; i++) {
                opciones[i] = x + (i + 1);
            }
            agregarModel(opciones);
        }
        if (valor.equalsIgnoreCase("Columna")) {
            String[] opciones = new String[3];
            String x = "Col";
            for (int i = 0; i < opciones.length; i++) {
                opciones[i] = x + (i + 1);
            }
            agregarModel(opciones);
        }
        if (valor.equalsIgnoreCase("[1,18]  [19,36]")) {
            String[] opciones = {"[1,18]", "[19,36]"};
            agregarModel(opciones);
        }
        if (valor.equalsIgnoreCase("Par e Impar")) {
            String[] opciones = {"Par", "Impar"};
            agregarModel(opciones);

        }
        if (valor.equalsIgnoreCase("Color")) {
            String[] opciones = {"Rojo", "Negro"};
            agregarModel(opciones);

        }
        opcion.setVisible(true);


    }//GEN-LAST:event_apuestaActionPerformed

    private void apostarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_apostarActionPerformed
        verificacionApuesta();
        //volverAportar.setVisible(true);


    }//GEN-LAST:event_apostarActionPerformed

    private void c50ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c50ActionPerformed

    }//GEN-LAST:event_c50ActionPerformed

    private void c100ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c100ActionPerformed

    }//GEN-LAST:event_c100ActionPerformed

    //Metodos para validar que no se agregue letras 
    private void c1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_c1KeyTyped
        ventanaErrorApuestaLetras(evt);
    }//GEN-LAST:event_c1KeyTyped

    private void c2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_c2KeyTyped
        ventanaErrorApuestaLetras(evt);
    }//GEN-LAST:event_c2KeyTyped

    private void c5KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_c5KeyTyped
        ventanaErrorApuestaLetras(evt);
    }//GEN-LAST:event_c5KeyTyped

    private void c10KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_c10KeyTyped
        ventanaErrorApuestaLetras(evt);
    }//GEN-LAST:event_c10KeyTyped

    private void c25KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_c25KeyTyped
        ventanaErrorApuestaLetras(evt);
    }//GEN-LAST:event_c25KeyTyped

    private void c50KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_c50KeyTyped
        ventanaErrorApuestaLetras(evt);
    }//GEN-LAST:event_c50KeyTyped

    private void c100KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_c100KeyTyped
        ventanaErrorApuestaLetras(evt);
    }//GEN-LAST:event_c100KeyTyped

    private void c500KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_c500KeyTyped
        ventanaErrorApuestaLetras(evt);
    }//GEN-LAST:event_c500KeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Cash;
    private javax.swing.JButton apostar;
    private javax.swing.JComboBox<String> apuesta;
    private javax.swing.JTextField c1;
    private javax.swing.JTextField c10;
    private javax.swing.JTextField c100;
    private javax.swing.JTextField c2;
    private javax.swing.JTextField c25;
    private javax.swing.JTextField c5;
    private javax.swing.JTextField c50;
    private javax.swing.JTextField c500;
    private javax.swing.JTextField din;
    private javax.swing.JLabel f1;
    private javax.swing.JLabel f2;
    private javax.swing.JLabel f3;
    private javax.swing.JLabel f4;
    private javax.swing.JLabel f5;
    private javax.swing.JLabel f6;
    private javax.swing.JLabel f7;
    private javax.swing.JLabel f8;
    private javax.swing.JButton girar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField mesa;
    private javax.swing.JLabel nroS;
    private javax.swing.JLabel nromesa;
    private javax.swing.JLabel num;
    private javax.swing.JTextField numeros;
    private javax.swing.JComboBox<String> opcion;
    private javax.swing.JPanel panel1;
    private javax.swing.JButton retirar;
    private javax.swing.JLabel rul;
    private javax.swing.JLabel salio;
    private javax.swing.JLabel tab;
    private javax.swing.JButton volverAportar;
    // End of variables declaration//GEN-END:variables

}
