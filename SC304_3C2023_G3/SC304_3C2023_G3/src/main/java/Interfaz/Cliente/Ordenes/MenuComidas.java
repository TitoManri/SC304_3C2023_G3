package Interfaz.Cliente.Ordenes;

import Interfaz.Cliente.Transaccion;

public class MenuComidas extends javax.swing.JFrame {
    
    private Transaccion transaccionInstance;
    
    public MenuComidas(Transaccion transaccionInstance) {
        this.transaccionInstance = transaccionInstance;
        this.setLocationRelativeTo(null);
        setSize(1000,600);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        AgregarPlatillo = new javax.swing.JButton();
        AgregarBebida = new javax.swing.JButton();
        AgregarPostre = new javax.swing.JButton();
        EliminarProducto = new javax.swing.JButton();
        volver = new javax.swing.JButton();
        terminarOrden = new javax.swing.JButton();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        AgregarPlatillo.setBorderPainted(false);
        AgregarPlatillo.setContentAreaFilled(false);
        AgregarPlatillo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgregarPlatilloActionPerformed(evt);
            }
        });
        getContentPane().add(AgregarPlatillo);
        AgregarPlatillo.setBounds(40, 170, 250, 100);

        AgregarBebida.setBorderPainted(false);
        AgregarBebida.setContentAreaFilled(false);
        AgregarBebida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgregarBebidaActionPerformed(evt);
            }
        });
        getContentPane().add(AgregarBebida);
        AgregarBebida.setBounds(350, 170, 240, 100);

        AgregarPostre.setBorderPainted(false);
        AgregarPostre.setContentAreaFilled(false);
        AgregarPostre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgregarPostreActionPerformed(evt);
            }
        });
        getContentPane().add(AgregarPostre);
        AgregarPostre.setBounds(200, 320, 240, 100);

        EliminarProducto.setBorderPainted(false);
        EliminarProducto.setContentAreaFilled(false);
        EliminarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarProductoActionPerformed(evt);
            }
        });
        getContentPane().add(EliminarProducto);
        EliminarProducto.setBounds(520, 330, 250, 90);

        volver.setBorderPainted(false);
        volver.setContentAreaFilled(false);
        volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverActionPerformed(evt);
            }
        });
        getContentPane().add(volver);
        volver.setBounds(290, 500, 330, 60);

        terminarOrden.setBorderPainted(false);
        terminarOrden.setContentAreaFilled(false);
        terminarOrden.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                terminarOrdenActionPerformed(evt);
            }
        });
        getContentPane().add(terminarOrden);
        terminarOrden.setBounds(640, 500, 290, 70);

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MenuComidas.png"))); // NOI18N
        fondo.setText("jLabel1");
        getContentPane().add(fondo);
        fondo.setBounds(0, 0, 1000, 600);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AgregarBebidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgregarBebidaActionPerformed
        AgregarBebCliente x = new AgregarBebCliente(transaccionInstance);
            x.setVisible(true);
            x.pack();
            x.setLocationRelativeTo(null); 
            this.dispose();
    }//GEN-LAST:event_AgregarBebidaActionPerformed

    private void AgregarPlatilloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgregarPlatilloActionPerformed
         AgregarPlatCliente x = new AgregarPlatCliente(transaccionInstance);
            x.setVisible(true);
            x.pack();
            x.setLocationRelativeTo(null); 
            this.dispose();
    }//GEN-LAST:event_AgregarPlatilloActionPerformed

    private void AgregarPostreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgregarPostreActionPerformed
        AgregarPostCliente x = new AgregarPostCliente(transaccionInstance);
            x.setVisible(true);
            x.pack();
            x.setLocationRelativeTo(null); 
            this.dispose();
    }//GEN-LAST:event_AgregarPostreActionPerformed

    private void EliminarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarProductoActionPerformed
        EliminarProducto x = new EliminarProducto(transaccionInstance);
            x.setVisible(true);
            x.pack();
            x.setLocationRelativeTo(null); 
            this.dispose();
    }//GEN-LAST:event_EliminarProductoActionPerformed

    private void volverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverActionPerformed
        //volver al menú 
    }//GEN-LAST:event_volverActionPerformed

    private void terminarOrdenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_terminarOrdenActionPerformed
    Transaccion x = new Transaccion();
        x.setVisible(true);
        x.pack();
        x.setLocationRelativeTo(null); 
        this.dispose();
        transaccionInstance.setVisible(true);
        transaccionInstance.pack();
        transaccionInstance.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_terminarOrdenActionPerformed

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
            java.util.logging.Logger.getLogger(MenuComidas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuComidas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuComidas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuComidas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
//                new MenuComidas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AgregarBebida;
    private javax.swing.JButton AgregarPlatillo;
    private javax.swing.JButton AgregarPostre;
    private javax.swing.JButton EliminarProducto;
    private javax.swing.JLabel fondo;
    private javax.swing.JButton terminarOrden;
    private javax.swing.JButton volver;
    // End of variables declaration//GEN-END:variables
}
