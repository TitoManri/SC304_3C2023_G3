package Interfaz.Ordenes;

import Orden.Orden;
import Catalogo.Platillo.Platillo;
import Orden.LesOrden;
import Orden.bebidasLes;
import Orden.nodoBebidas;
import Orden.nodoPlatillos;
import Orden.platillosLes;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;

public class EliminarPlatCliente extends javax.swing.JFrame {

    private Orden orden;
    DefaultTableModel tab = new DefaultTableModel();
    
    public EliminarPlatCliente(Orden orden) {
        this.orden = orden;
        this.setLocationRelativeTo(null);
        setResizable(false);
        String[] titulo = new String[]{"Nombre", "Características", "Categoría", "Precio"};
        tab.setColumnIdentifiers(titulo);
        jTable1.setModel(tab);
        llenarTabla(orden);
        initComponents();
    }
    
    private void llenarTabla(Orden orden) {
    platillosLes platillosOrden = orden.getPlatillos();
        nodoPlatillos aux = platillosOrden.getInicio();
        if (!platillosOrden.esVaciaPlatillos()) {
            while (aux != null) {
                tab.addRow(new Object[]{
                    aux.getPlatillo().getNombre(), aux.getPlatillo().getDescripcion(),aux.getPlatillo(), aux.getPlatillo().getCategoria(), aux.getPlatillo().getPrecio()
                });
                aux = aux.getSiguiente();
            }
        } else {
            JOptionPane.showMessageDialog(null, "La orden no tiene bebidas.");
        }
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        Eliminar = new javax.swing.JButton();
        Volver = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jTextField1.setBackground(new java.awt.Color(0, 0, 51));
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField1);
        jTextField1.setBounds(90, 270, 420, 50);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(3).setResizable(false);
        }

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(562, 92, 420, 410);

        Eliminar.setBorderPainted(false);
        Eliminar.setContentAreaFilled(false);
        Eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarActionPerformed(evt);
            }
        });
        getContentPane().add(Eliminar);
        Eliminar.setBounds(115, 483, 200, 70);

        Volver.setBorderPainted(false);
        Volver.setContentAreaFilled(false);
        Volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VolverActionPerformed(evt);
            }
        });
        getContentPane().add(Volver);
        Volver.setBounds(325, 483, 200, 70);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/EliminarPlatillos.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 1000, 600);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void VolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VolverActionPerformed
        // volver al menú
    }//GEN-LAST:event_VolverActionPerformed

    private void EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarActionPerformed
        String nomPlatillo = jTextField1.getText();
        if (!nomPlatillo.isEmpty()) {
            orden.getPlatillos().eliminarPlatillo(nomPlatillo);
        } else {
            JOptionPane.showMessageDialog(null, "Por favor, ingrese el nombre del platillo a eliminar.");
        }
    }//GEN-LAST:event_EliminarActionPerformed

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
            java.util.logging.Logger.getLogger(EliminarPlatCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EliminarPlatCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EliminarPlatCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EliminarPlatCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
//                new EliminarPlatCliente().setVisible(true); ------- Preguntar al profe
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Eliminar;
    private javax.swing.JButton Volver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
