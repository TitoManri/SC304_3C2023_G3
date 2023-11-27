package Interfaz.Ordenes;

import javax.swing.table.DefaultTableModel;

public class ModificarOrden extends javax.swing.JFrame {

    DefaultTableModel tab = new DefaultTableModel();

    public ModificarOrden() {
        initComponents();
        String[] titulo = new String[]{"Orden #", "Cliente", "Hora"};
        tab.setColumnIdentifiers(titulo);
        TablaOrdenes.setModel(tab);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        numeroOrden = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaOrdenes = new javax.swing.JTable();
        modificar = new javax.swing.JButton();
        volver = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1000, 600));
        setResizable(false);
        getContentPane().setLayout(null);

        numeroOrden.setBackground(new java.awt.Color(0, 0, 51));
        numeroOrden.setToolTipText("");
        numeroOrden.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numeroOrdenActionPerformed(evt);
            }
        });
        getContentPane().add(numeroOrden);
        numeroOrden.setBounds(80, 260, 420, 60);

        TablaOrdenes.setModel(new javax.swing.table.DefaultTableModel(
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
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
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
                "Orden #", "Cliente", "Hora"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(TablaOrdenes);
        if (TablaOrdenes.getColumnModel().getColumnCount() > 0) {
            TablaOrdenes.getColumnModel().getColumn(0).setResizable(false);
            TablaOrdenes.getColumnModel().getColumn(1).setResizable(false);
            TablaOrdenes.getColumnModel().getColumn(2).setResizable(false);
        }

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(540, 70, 452, 460);

        modificar.setBorderPainted(false);
        modificar.setContentAreaFilled(false);
        modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarActionPerformed(evt);
            }
        });
        getContentPane().add(modificar);
        modificar.setBounds(110, 480, 190, 60);

        volver.setBorderPainted(false);
        volver.setContentAreaFilled(false);
        getContentPane().add(volver);
        volver.setBounds(320, 480, 180, 60);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ModificarOrden.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 1000, 600);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_modificarActionPerformed

    private void numeroOrdenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numeroOrdenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_numeroOrdenActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(ModificarOrden.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ModificarOrden.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ModificarOrden.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ModificarOrden.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ModificarOrden().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablaOrdenes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton modificar;
    private javax.swing.JTextField numeroOrden;
    private javax.swing.JButton volver;
    // End of variables declaration//GEN-END:variables
}
