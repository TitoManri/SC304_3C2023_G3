package Interfaz.Cliente.Ordenes;

import Orden.LesOrden;
import Catalogo.Nodos.NodoPlatillo;
import javax.swing.table.DefaultTableModel;
import Interfaz.Administrador.Platillos.CatalogoPlatillos;
import Orden.Orden;

/**
 *
 * @author marip
 */
public class AgregarPlatCliente extends javax.swing.JFrame {

    DefaultTableModel tab = new DefaultTableModel();

    public AgregarPlatCliente() {
        initComponents();
        setResizable(false);
        this.setLocationRelativeTo(null); //solo para que este centrada en la pantalla
        String[] titulo = new String[]{"Nombre", "Descripción", "Categoría", "Precio"};
        tab.setColumnIdentifiers(titulo);
        TablaPlatillos.setModel(tab);
        llenarTabla();
    }

    public void llenarTabla() {
        CatalogoPlatillos c = new CatalogoPlatillos();
        if (!c.esVaciaPlatillos()) {
            NodoPlatillo aux = c.getInicioPlatillo();
            while (aux != null) {
                tab.addRow(new Object[]{
                aux.getPlatillo().getNombre(), aux.getPlatillo().getDescripcion(),  aux.getPlatillo().getCategoria(), aux.getPlatillo().getPrecio()
                });
                aux = aux.getSiguiente();
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nombrePlatText = new javax.swing.JTextField();
        agregarPlat = new javax.swing.JButton();
        volver = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaPlatillos = new javax.swing.JTable();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        nombrePlatText.setBackground(new java.awt.Color(0, 0, 51));
        nombrePlatText.setForeground(new java.awt.Color(255, 255, 255));
        nombrePlatText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombrePlatTextActionPerformed(evt);
            }
        });
        getContentPane().add(nombrePlatText, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 270, 390, 50));

        agregarPlat.setBorderPainted(false);
        agregarPlat.setContentAreaFilled(false);
        agregarPlat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarPlatActionPerformed(evt);
            }
        });
        getContentPane().add(agregarPlat, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 480, 180, 50));

        volver.setBorderPainted(false);
        volver.setContentAreaFilled(false);
        volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverActionPerformed(evt);
            }
        });
        getContentPane().add(volver, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 470, 170, 60));

        TablaPlatillos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nombre", "Descripción", "Categoría", "Precio"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TablaPlatillos.setSelectionBackground(new java.awt.Color(204, 204, 204));
        jScrollPane1.setViewportView(TablaPlatillos);
        if (TablaPlatillos.getColumnModel().getColumnCount() > 0) {
            TablaPlatillos.getColumnModel().getColumn(0).setResizable(false);
            TablaPlatillos.getColumnModel().getColumn(1).setResizable(false);
            TablaPlatillos.getColumnModel().getColumn(2).setResizable(false);
            TablaPlatillos.getColumnModel().getColumn(3).setResizable(false);
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 100, -1, -1));

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AgregarPlatCliente.jpg"))); // NOI18N
        getContentPane().add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void agregarPlatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarPlatActionPerformed
        Orden orden = Ordenes.getOrden();
        orden.getPlatillos().agregarPlatillo(nombrePlatText.getText());
    }//GEN-LAST:event_agregarPlatActionPerformed

    private void volverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverActionPerformed
        Ordenes apc=new Ordenes();
        apc.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_volverActionPerformed

    private void nombrePlatTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombrePlatTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombrePlatTextActionPerformed
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AgregarPlatCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AgregarPlatCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AgregarPlatCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AgregarPlatCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AgregarPlatCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablaPlatillos;
    private javax.swing.JButton agregarPlat;
    private javax.swing.JLabel fondo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nombrePlatText;
    private javax.swing.JButton volver;
    // End of variables declaration//GEN-END:variables
}
