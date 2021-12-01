
package Casino.Juegos.Ruleta.InterfazGrafica;

import Casino.Juegos.Ruleta.Servicio.ServicioMesaRuleta;
import Casino.Juegos.Ruleta.entidades.Ruleta;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.*;


public class ClienteInterfaz extends JFrame {

   private Ruleta r=new Ruleta();
    public ClienteInterfaz() {
       
        initComponents();
        setVisible(true);
        ocultar();
        setTitle("Cliente");
        setResizable(false);
        setIconImage(new ImageIcon("src/Casino/Juegos/Ruleta/InterfazGrafica/imagen/cliente.png").getImage());
       
        r.crearMesa(8,0);
        r.getMesas().get(1).getM().setDisponible(false);
        
      
        
       
    }
    public JButton getSalir(){
        return Salir;
    }
    public JLabel getAdios(){
        return adios;
    }
  public void ocultar(){
        bienvenido.setVisible(false);
        vermesas.setVisible(false);
        Mesa.setVisible(false);
        mesas.setVisible(false);
        unirmesa.setVisible(false);
        ingresedin.setVisible(false);
        dinero.setVisible(false);
        jugar.setVisible(false);
        Salir.setVisible(false);
        adios.setVisible(false);
    }
   /* private void crearMesas(){
        Ruleta r=new Ruleta();
        r.crearMesa(4, 0);
        for(int i=0;i<r.getMesas().size();i++){
            JButton buton =new JButton();
           buton.setText("Mesa"+r.getMesas().get(i).getNumMesa());
            buton.setBounds(100, 200+50*i, 100, 50);
            panel.add(buton);
        }
    }*/
    
      private void fondo(JLabel lb, String ruta) {//Agrega imagen en los JLabel
        ImageIcon imagen;
        Icon icono;
        imagen = new ImageIcon(ruta);
        icono = new ImageIcon(imagen.getImage().getScaledInstance(lb.getWidth(), lb.getHeight(), Image.SCALE_DEFAULT));
        lb.setIcon(icono);
    }

       private void agregarModel(String[] p) {
        mesas.setModel(new javax.swing.DefaultComboBoxModel<>(p));
        mesas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mesasActionPerformed(evt);
            }
        });
    }
        private void ventanaErrorDineroLetras(KeyEvent evt) {//Valida que no se ingrese letras
        char val = evt.getKeyChar();
        if (Character.isLetter(val)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(rootPane, "Ingresar Solo Numeros");
        }
    }
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        cliente = new javax.swing.JLabel();
        conexion = new javax.swing.JButton();
        bienvenido = new javax.swing.JLabel();
        vermesas = new javax.swing.JButton();
        Mesa = new javax.swing.JLabel();
        mesas = new javax.swing.JComboBox<>();
        unirmesa = new javax.swing.JButton();
        ingresedin = new javax.swing.JLabel();
        jugar = new javax.swing.JButton();
        dinero = new javax.swing.JTextField();
        Salir = new javax.swing.JButton();
        adios = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(36, 195, 70));
        setMinimumSize(new java.awt.Dimension(100, 100));

        panel.setBackground(new java.awt.Color(0, 255, 255));
        panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cliente.setBackground(new java.awt.Color(0, 0, 255));
        cliente.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 1, 36)); // NOI18N
        cliente.setForeground(new java.awt.Color(0, 0, 0));
        cliente.setText("Cliente");
        panel.add(cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 130, 40));

        conexion.setBackground(new java.awt.Color(0, 0, 255));
        conexion.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        conexion.setForeground(new java.awt.Color(255, 255, 0));
        conexion.setText("Iniciar Conexion Servidor");
        conexion.setBorder(null);
        conexion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                conexionActionPerformed(evt);
            }
        });
        panel.add(conexion, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, 190, 40));

        bienvenido.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        bienvenido.setForeground(new java.awt.Color(153, 102, 0));
        bienvenido.setText("Bienvenido a las mesas de Ruleta, eliga una mesa donde jugar");
        panel.add(bienvenido, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 580, 50));

        vermesas.setText("Ver Mesas Disponibles");
        vermesas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vermesasActionPerformed(evt);
            }
        });
        panel.add(vermesas, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 170, -1));

        Mesa.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        Mesa.setForeground(new java.awt.Color(255, 0, 0));
        Mesa.setText("Mesas:");
        panel.add(Mesa, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 120, 50, 40));

        mesas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        mesas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mesasActionPerformed(evt);
            }
        });
        panel.add(mesas, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 130, -1, -1));

        unirmesa.setText("Usar mesa");
        unirmesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                unirmesaActionPerformed(evt);
            }
        });
        panel.add(unirmesa, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 120, 100, 50));

        ingresedin.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        ingresedin.setForeground(new java.awt.Color(51, 153, 0));
        ingresedin.setText("Ingrese dinero que desea jugar");
        panel.add(ingresedin, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 230, 30));

        jugar.setText("Jugar");
        jugar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jugarActionPerformed(evt);
            }
        });
        panel.add(jugar, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 230, 80, 30));

        dinero.setText("0");
        dinero.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                dineroKeyTyped(evt);
            }
        });
        panel.add(dinero, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 110, -1));

        Salir.setBackground(new java.awt.Color(255, 0, 255));
        Salir.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        Salir.setText("Salir");
        panel.add(Salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 40, 160, 40));

        adios.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        adios.setForeground(new java.awt.Color(51, 51, 255));
        adios.setText("Gracias por Jugar,Adios.");
        panel.add(adios, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 10, 200, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, 580, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void vermesasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vermesasActionPerformed
        ArrayList<ServicioMesaRuleta> mes=r.mesadisponibles();
        ArrayList<String> mesasdisponible =new ArrayList();
        for (ServicioMesaRuleta me : mes) {
            mesasdisponible.add(""+me.getNumMesa());
  
        }
        agregarModel(mesasdisponible.toArray(new String[mesasdisponible.size()]));
        mesas.setVisible(true);
        Mesa.setVisible(true);
        
    }//GEN-LAST:event_vermesasActionPerformed

    private void unirmesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_unirmesaActionPerformed
        ingresedin.setVisible(true);
        jugar.setVisible(true);
        dinero.setVisible(true);
    }//GEN-LAST:event_unirmesaActionPerformed

    private void jugarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jugarActionPerformed
        if(dinero.getText().isEmpty()||dinero.getText().equals("0")){
             JOptionPane.showMessageDialog(rootPane, "Ingresar Dinero");
            
        }else{
            int cash=Integer.parseInt(dinero.getText());
            if(cash<0){
                cash=-cash;
            }
            ServicioMesaRuleta tablero =r.getMesas().get(Integer.parseInt((String)mesas.getSelectedItem()));
            tablero.getM().setDinero(cash);
            setVisible(false);
             java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               
                new TableroInterfaz(tablero,ClienteInterfaz.this);
            }
        });
             ocultar();
        
        }
    }//GEN-LAST:event_jugarActionPerformed

    private void conexionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_conexionActionPerformed
       //Conectar con servidor socket ver mas tarde
       
       bienvenido.setVisible(true);
       vermesas.setVisible(true);
       conexion.setVisible(false);
    }//GEN-LAST:event_conexionActionPerformed

    private void mesasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mesasActionPerformed
        unirmesa.setVisible(true);
    }//GEN-LAST:event_mesasActionPerformed

    private void dineroKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dineroKeyTyped
        ventanaErrorDineroLetras(evt);
    }//GEN-LAST:event_dineroKeyTyped

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
       /* try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ClienteInterfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClienteInterfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClienteInterfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClienteInterfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>*/

        /* Create and display the form */
        
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ClienteInterfaz();
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Mesa;
    private javax.swing.JButton Salir;
    private javax.swing.JLabel adios;
    private javax.swing.JLabel bienvenido;
    private javax.swing.JLabel cliente;
    private javax.swing.JButton conexion;
    private javax.swing.JTextField dinero;
    private javax.swing.JLabel ingresedin;
    private javax.swing.JButton jugar;
    private javax.swing.JComboBox<String> mesas;
    private javax.swing.JPanel panel;
    private javax.swing.JButton unirmesa;
    private javax.swing.JButton vermesas;
    // End of variables declaration//GEN-END:variables



}
