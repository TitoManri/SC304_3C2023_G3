package Interfaz.Ordenes;

import Orden.LesOrden;
import Orden.Orden;
import Orden.bebidasLes;
import Orden.nodoBebidas;
import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class EliminarBebCliente extends javax.swing.JFrame {

    private Orden orden;
    DefaultTableModel tab = new DefaultTableModel();

    public EliminarBebCliente(Orden orden) {
        this.orden = orden;
        this.setLocationRelativeTo(null);
        setResizable(false);
        String[] titulo = new String[]{"Nombre", "Categoría", "Precio"};
        tab.setColumnIdentifiers(titulo);
        jTable1.setModel(tab);
        llenarTabla(orden);
        initComponents();
    }

    public void llenarTabla(Orden orden) {
        bebidasLes bebidasOrden = orden.getBebidas();
        nodoBebidas aux = bebidasOrden.getInicio();
        if (!bebidasOrden.esVaciaBebidas()) {
            while (aux != null) {
                tab.addRow(new Object[]{
                    aux.getBebida().getNombre(), aux.getBebida(), aux.getBebida().getCategoria(), aux.getBebida().getPrecio()
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        txtNomBebida = new javax.swing.JTextField();
        Volver = new javax.swing.JButton();
        Eliminar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Nombre", "Categoría", "Precio"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
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
        }

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(582, 92, 400, 410);

        txtNomBebida.setBackground(new java.awt.Color(0, 0, 51));
        txtNomBebida.setSelectedTextColor(new java.awt.Color(255, 255, 255));
        txtNomBebida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomBebidaActionPerformed(evt);
            }
        });
        getContentPane().add(txtNomBebida);
        txtNomBebida.setBounds(100, 270, 410, 50);

        Volver.setBorderPainted(false);
        Volver.setContentAreaFilled(false);
        Volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VolverActionPerformed(evt);
            }
        });
        getContentPane().add(Volver);
        Volver.setBounds(330, 490, 190, 70);

        Eliminar.setBorderPainted(false);
        Eliminar.setContentAreaFilled(false);
        Eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarActionPerformed(evt);
            }
        });
        getContentPane().add(Eliminar);
        Eliminar.setBounds(115, 483, 200, 70);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/EliminarBebidas.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 1000, 600);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNomBebidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomBebidaActionPerformed

    }//GEN-LAST:event_txtNomBebidaActionPerformed

    private void VolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VolverActionPerformed
        // volver al menú
    }//GEN-LAST:event_VolverActionPerformed

    private void EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarActionPerformed
        String nomBebida = txtNomBebida.getText();
        if (!nomBebida.isEmpty()) {
            orden.getBebidas().eliminarBebida(nomBebida);
        } else {
            JOptionPane.showMessageDialog(null, "Por favor, ingrese el nombre de la bebida a eliminar.");
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
            java.util.logging.Logger.getLogger(EliminarBebCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EliminarBebCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EliminarBebCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EliminarBebCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
//                new EliminarBebCliente().setVisible(true);  -----Preguntar al profe
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Eliminar;
    private javax.swing.JButton Volver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtNomBebida;
    // End of variables declaration//GEN-END:variables
}
