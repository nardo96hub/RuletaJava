
package Casino.Juegos.Ruleta.InterfazGrafica;

import Casino.Juegos.Ruleta.Sockets.SocketServidor;
import Casino.Juegos.Ruleta.entidades.CasinoInforme;
import Casino.Juegos.Ruleta.entidades.Ruleta;
import java.awt.event.KeyEvent;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


public class ServidorInterfaz extends JFrame {

    private Ruleta r = new Ruleta();

  
    public ServidorInterfaz() {

        initComponents();
        setLocation(800, 0);
        ocultar();
        setVisible(true);
        setTitle("Servidor Casino");
        setIconImage(new ImageIcon("src/Casino/Juegos/Ruleta/InterfazGrafica/imagen/servidor.jpg").getImage());

        dinero.setEnabled(false);

    }

    private void leerArchivo() {
        long din = 0;
        FileInputStream informe = null;
    

            try {
                informe = new FileInputStream("casinoinforme.txt");
                if (informe != null) {
                    ObjectInputStream casinoInforme = new ObjectInputStream(informe);

                    try{
                        Object p;
                    while ((p = casinoInforme.readObject()) instanceof CasinoInforme && p!=null) {
                        System.out.println("Se esta viendo un registro");

                        System.out.println("La persona existe en archivo:" + (CasinoInforme) p);
                        agregarRegistroTabla((CasinoInforme) p);
                        din = ((CasinoInforme) p).getDineroCasino();
                    }
                    }catch(EOFException ex){
                        
                    }
                    

                }
              
            } catch(EOFException ex){
              //Fin de archivo
            }catch (FileNotFoundException ex) {
                Logger.getLogger(ServidorInterfaz.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(ServidorInterfaz.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ServidorInterfaz.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                if (informe != null) {
                    try {
                        informe.close();
                    } catch (IOException ex) {
                        Logger.getLogger(ServidorInterfaz.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }

        if (din > 0) {
            r.setDineroCasino(din);
        }
    }

    private ArrayList<CasinoInforme> ObtenerDatosTabla() {
        ArrayList<CasinoInforme> Aci = new ArrayList();
        for (int i = 0; i < tabla.getRowCount(); i++) {
            try {
                CasinoInforme ci;
                String fecha = (String) tabla.getValueAt(i, 3);
                SimpleDateFormat formFecha = new SimpleDateFormat("dd/MM/yy  hh:mm:ss");
                Date fechas = formFecha.parse(fecha);
                ci = new CasinoInforme((long) tabla.getValueAt(i, 0), (long) tabla.getValueAt(i, 1), (int) tabla.getValueAt(i, 2), fechas);
                Aci.add(ci);
            } catch (ParseException ex) {
                Logger.getLogger(ServidorInterfaz.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        Aci.forEach(System.out::println);
        return Aci;
    }

    private void escribirArchivo() {
        FileOutputStream informe = null;
        ArrayList<CasinoInforme> ci = ObtenerDatosTabla();
        if (!ci.isEmpty()) {
            try {
                informe = new FileOutputStream("casinoinforme.txt");
                ObjectOutputStream casinoInforme = new ObjectOutputStream(informe);
                for (CasinoInforme i : ci) {
                    casinoInforme.writeObject(i);

                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(ServidorInterfaz.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(ServidorInterfaz.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    informe.close();
                } catch (IOException ex) {
                    Logger.getLogger(ServidorInterfaz.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public ServidorInterfaz getServidor() {
        return ServidorInterfaz.this;
    }

    public JTextField getJTextField() {
        return dinero;
    }

    public JTable getJTable() {
        return tabla;
    }

    public JPanel getPanelTable() {
        return contable;
    }

    public Ruleta getRuleta() {
        return r;
    }

    public void setRuleta(Ruleta ru) {
        r = ru;
    }

    public void agregarRegistroTabla(CasinoInforme ci) {

        String formFecha = "dd/MM/yy  hh:mm:ss";
        SimpleDateFormat fecha = new SimpleDateFormat(formFecha);
        Object fila[] = {ci.getDineroCasino(), ci.getGanper(), ci.getNroMesa(), fecha.format(ci.getFecha())};
        ((DefaultTableModel) tabla.getModel()).addRow(fila);
    }

    private void ocultar() {
        salir.setVisible(false);
        cantmesa.setVisible(false);
        cargarm.setVisible(false);
        mesa.setVisible(false);
        textcasino.setVisible(false);
        dinero.setVisible(false);
    }

    private void ventanaErrorMesaLetras(KeyEvent evt) {//Valida que no se ingrese letras
        char val = evt.getKeyChar();
        if (Character.isLetter(val)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(rootPane, "Ingresar Solo Numeros");
        }
    }

  //Metodo generado por Design
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        server = new javax.swing.JLabel();
        salir = new javax.swing.JButton();
        iniciarserver = new javax.swing.JButton();
        cantmesa = new javax.swing.JLabel();
        mesa = new javax.swing.JTextField();
        cargarm = new javax.swing.JButton();
        contable = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        textcasino = new javax.swing.JLabel();
        dinero = new javax.swing.JTextField();
        guardar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(100, 100));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        panel.setBackground(new java.awt.Color(102, 0, 102));
        panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        server.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        server.setForeground(new java.awt.Color(252, 170, 71));
        server.setText("Servidor");
        panel.add(server, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 160, 40));

        salir.setBackground(new java.awt.Color(255, 0, 0));
        salir.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        salir.setForeground(new java.awt.Color(255, 255, 255));
        salir.setText("Salir");
        salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirActionPerformed(evt);
            }
        });
        panel.add(salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 20, -1, -1));

        iniciarserver.setBackground(new java.awt.Color(255, 255, 255));
        iniciarserver.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        iniciarserver.setForeground(new java.awt.Color(0, 0, 0));
        iniciarserver.setText("Inicializar Servidor");
        iniciarserver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iniciarserverActionPerformed(evt);
            }
        });
        panel.add(iniciarserver, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 20, -1, -1));

        cantmesa.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        cantmesa.setForeground(new java.awt.Color(0, 204, 204));
        cantmesa.setText("Ingrese la cantidad de mesas de Ruleta");
        panel.add(cantmesa, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 280, 20));

        mesa.setText("0");
        mesa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                mesaKeyTyped(evt);
            }
        });
        panel.add(mesa, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 120, -1));

        cargarm.setBackground(new java.awt.Color(51, 204, 0));
        cargarm.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        cargarm.setForeground(new java.awt.Color(51, 51, 255));
        cargarm.setText("Cargar Mesas");
        cargarm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cargarmActionPerformed(evt);
            }
        });
        panel.add(cargarm, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 90, 140, -1));

        contable.setBackground(new java.awt.Color(102, 0, 102));
        contable.setBorder(javax.swing.BorderFactory.createTitledBorder("Registro de Movimiento de dinero Casino"));
        contable.setForeground(new java.awt.Color(255, 0, 0));

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tabla);

        javax.swing.GroupLayout contableLayout = new javax.swing.GroupLayout(contable);
        contable.setLayout(contableLayout);
        contableLayout.setHorizontalGroup(
            contableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contableLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 458, Short.MAX_VALUE)
                .addContainerGap())
        );
        contableLayout.setVerticalGroup(
            contableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contableLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38))
        );

        panel.add(contable, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 480, 280));

        textcasino.setBackground(new java.awt.Color(0, 255, 0));
        textcasino.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        textcasino.setForeground(new java.awt.Color(0, 51, 51));
        textcasino.setText("Dinero Casino");
        panel.add(textcasino, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 70, 130, 30));

        dinero.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        dinero.setForeground(new java.awt.Color(0, 0, 255));
        dinero.setText("0");
        panel.add(dinero, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 100, 150, -1));

        guardar.setBackground(new java.awt.Color(102, 102, 0));
        guardar.setForeground(new java.awt.Color(0, 0, 0));
        guardar.setText("Guardar Informacion");
        guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarActionPerformed(evt);
            }
        });
        panel.add(guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 430, 280, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, 482, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, 479, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cargarmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cargarmActionPerformed
        leerArchivo();
        int cantmesas = Integer.parseInt(mesa.getText());
        if (cantmesas > 10 || cantmesas < -10 || cantmesas == 0) {
            JOptionPane.showMessageDialog(rootPane, "Ingrese un numero 0< nro <=10");
        } else {

            if (cantmesas < 0) {
                cantmesas = -cantmesas;
            }
            dinero.setText("" + r.getDineroCasino());
            dinero.setVisible(true);
            textcasino.setVisible(true);
            r.crearMesa(cantmesas, 0);
            cantmesa.setVisible(false);
            mesa.setVisible(false);
            cargarm.setVisible(false);
            (new SocketServidor(r, ServidorInterfaz.this)).start();

        }
    }//GEN-LAST:event_cargarmActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        modelo.addColumn("Dinero Casino");
        modelo.addColumn("Ganancia/Perdida");
        modelo.addColumn("NroMesa");
        modelo.addColumn("Fecha");
        tabla.setEnabled(false);
    }//GEN-LAST:event_formWindowOpened

    private void iniciarserverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iniciarserverActionPerformed

        cantmesa.setVisible(true);
        cargarm.setVisible(true);
        mesa.setVisible(true);
        salir.setVisible(true);
        iniciarserver.setVisible(false);
    }//GEN-LAST:event_iniciarserverActionPerformed

    private void mesaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_mesaKeyTyped
        ventanaErrorMesaLetras(evt);
    }//GEN-LAST:event_mesaKeyTyped

    private void salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_salirActionPerformed

    private void guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarActionPerformed
        escribirArchivo();
    }//GEN-LAST:event_guardarActionPerformed

    /**
     * @param args the command line arguments
     */
    /* public static void main(String args[]) {
        /* Set the Nimbus look and feel */
    //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
    /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
     */
 /*  try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ServidorInterfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ServidorInterfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ServidorInterfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ServidorInterfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
     */
 /* Create and display the form */
 /*  java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ServidorInterfaz().setVisible(true);
            }
        });*/
 /* }*/

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel cantmesa;
    private javax.swing.JButton cargarm;
    private javax.swing.JPanel contable;
    private javax.swing.JTextField dinero;
    private javax.swing.JButton guardar;
    private javax.swing.JButton iniciarserver;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField mesa;
    private javax.swing.JPanel panel;
    private javax.swing.JButton salir;
    private javax.swing.JLabel server;
    private javax.swing.JTable tabla;
    private javax.swing.JLabel textcasino;
    // End of variables declaration//GEN-END:variables
}
