
package Casino.Juegos.Ruleta.InterfazGrafica;

import Casino.Juegos.Ruleta.Servicio.ServicioMesaRuleta;
import Casino.Juegos.Ruleta.Sockets.SocketCliente;
import Casino.Juegos.Ruleta.entidades.CasinoInforme;
import Casino.Juegos.Ruleta.entidades.Ruleta;
import java.awt.event.ActionEvent;


import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.*;




public class ClienteInterfaz extends JFrame {

   private Ruleta r;

 

 public ClienteInterfaz(){
      initComponents();
        setVisible(true);
        ocultar();
        setTitle("Cliente");
        setResizable(false);
        setIconImage(new ImageIcon("src/Casino/Juegos/Ruleta/InterfazGrafica/imagen/cliente.png").getImage());
      
 }
 
    public ClienteInterfaz getCliente(){
        return ClienteInterfaz.this;
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
  public void EnviarInfoServer(CasinoInforme c){
      new SocketCliente(c,"a");
  }
   //java.awt.event.
       private void agregarModel(String[] p) {
        mesas.setModel(new DefaultComboBoxModel<>(p));
        mesas.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
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
  
        //Metodo creado por Design
   // @SuppressWarnings("unchecked")
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

        cliente.setBackground(new java.awt.Color(0, 0, 255));
        cliente.setFont(new java.awt.Font("Franklin Gothic Demi Cond", 1, 36)); // NOI18N
        cliente.setForeground(new java.awt.Color(0, 0, 0));
        cliente.setText("Cliente");

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

        bienvenido.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        bienvenido.setForeground(new java.awt.Color(153, 102, 0));
        bienvenido.setText("Bienvenido a las mesas de Ruleta, eliga una mesa donde jugar");

        vermesas.setText("Ver Mesas Disponibles");
        vermesas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vermesasActionPerformed(evt);
            }
        });

        Mesa.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        Mesa.setForeground(new java.awt.Color(255, 0, 0));
        Mesa.setText("Mesas:");

        mesas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        mesas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mesasActionPerformed(evt);
            }
        });

        unirmesa.setText("Usar mesa");
        unirmesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                unirmesaActionPerformed(evt);
            }
        });

        ingresedin.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        ingresedin.setForeground(new java.awt.Color(51, 153, 0));
        ingresedin.setText("Ingrese dinero que desea jugar");

        jugar.setText("Jugar");
        jugar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jugarActionPerformed(evt);
            }
        });

        dinero.setText("0");
        dinero.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                dineroKeyTyped(evt);
            }
        });

        Salir.setBackground(new java.awt.Color(255, 0, 255));
        Salir.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        Salir.setText("Salir");
        Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalirActionPerformed(evt);
            }
        });

        adios.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        adios.setForeground(new java.awt.Color(51, 51, 255));
        adios.setText("Gracias por Jugar,Adios.");

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(130, 130, 130)
                        .addComponent(conexion, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bienvenido, javax.swing.GroupLayout.PREFERRED_SIZE, 580, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(350, 350, 350)
                        .addComponent(adios, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(350, 350, 350)
                        .addComponent(Salir, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addGroup(panelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(vermesas, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(Mesa)
                .addGap(0, 0, 0)
                .addComponent(mesas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(unirmesa, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(panelLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(ingresedin, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(panelLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(dinero, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jugar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(conexion, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(bienvenido, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(adios)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(Salir, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Mesa, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(unirmesa, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(vermesas)
                            .addComponent(mesas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(30, 30, 30)
                .addComponent(ingresedin, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dinero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jugar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(69, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, 580, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void vermesasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vermesasActionPerformed
        

        ArrayList<ServicioMesaRuleta> mes=r.mesadisponibles();
        ArrayList<String> mesasdisponible =new ArrayList();
        for (ServicioMesaRuleta me : mes) {
            mesasdisponible.add(""+(me.getNumMesa()+1)); 
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
            ServicioMesaRuleta tablero =r.getMesas().get(Integer.parseInt((String)mesas.getSelectedItem())-1);
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
     
        SocketCliente sc;
        (sc=new SocketCliente(null,"0")).start();
      
        if(sc.getRuleta()!=null){
            System.out.println("Recibi la ruleta del servidor en ver mesas disponibles");
            r=sc.getRuleta();
        }
       
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

    private void SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalirActionPerformed
     System.exit(0);
    }//GEN-LAST:event_SalirActionPerformed

 

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
