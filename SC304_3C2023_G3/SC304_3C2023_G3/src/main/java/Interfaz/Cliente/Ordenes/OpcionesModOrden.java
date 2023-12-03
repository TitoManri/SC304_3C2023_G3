package Interfaz.Cliente.Ordenes;
import Orden.Orden;

public class OpcionesModOrden extends javax.swing.JFrame {

    private Orden orden;
    
    public OpcionesModOrden(Orden orden) {
        this.orden = orden;
        this.setLocationRelativeTo(null);
        setResizable(false);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        AgregarPlatillo = new javax.swing.JButton();
        AgregarBebida = new javax.swing.JButton();
        AgregarPostre = new javax.swing.JButton();
        EliminarPlatillo = new javax.swing.JButton();
        EliminarBebida = new javax.swing.JButton();
        EliminarPostre = new javax.swing.JButton();
        volver = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

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
        AgregarPlatillo.setBounds(50, 180, 260, 110);

        AgregarBebida.setBorderPainted(false);
        AgregarBebida.setContentAreaFilled(false);
        AgregarBebida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgregarBebidaActionPerformed(evt);
            }
        });
        getContentPane().add(AgregarBebida);
        AgregarBebida.setBounds(375, 183, 270, 110);

        AgregarPostre.setBorderPainted(false);
        AgregarPostre.setContentAreaFilled(false);
        AgregarPostre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgregarPostreActionPerformed(evt);
            }
        });
        getContentPane().add(AgregarPostre);
        AgregarPostre.setBounds(705, 183, 270, 110);

        EliminarPlatillo.setBorderPainted(false);
        EliminarPlatillo.setContentAreaFilled(false);
        EliminarPlatillo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarPlatilloActionPerformed(evt);
            }
        });
        getContentPane().add(EliminarPlatillo);
        EliminarPlatillo.setBounds(45, 353, 270, 110);

        EliminarBebida.setBorderPainted(false);
        EliminarBebida.setContentAreaFilled(false);
        EliminarBebida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarBebidaActionPerformed(evt);
            }
        });
        getContentPane().add(EliminarBebida);
        EliminarBebida.setBounds(375, 353, 270, 110);

        EliminarPostre.setBorderPainted(false);
        EliminarPostre.setContentAreaFilled(false);
        EliminarPostre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarPostreActionPerformed(evt);
            }
        });
        getContentPane().add(EliminarPostre);
        EliminarPostre.setBounds(705, 353, 270, 110);

        volver.setBorderPainted(false);
        volver.setContentAreaFilled(false);
        volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverActionPerformed(evt);
            }
        });
        getContentPane().add(volver);
        volver.setBounds(805, 513, 200, 70);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/OpcionesModOrden.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 1000, 600);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AgregarBebidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgregarBebidaActionPerformed
        //Falta agregar
    }//GEN-LAST:event_AgregarBebidaActionPerformed

    private void AgregarPlatilloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgregarPlatilloActionPerformed
        //Falta agregar
    }//GEN-LAST:event_AgregarPlatilloActionPerformed

    private void AgregarPostreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgregarPostreActionPerformed
        //Falta agregar
    }//GEN-LAST:event_AgregarPostreActionPerformed

    private void EliminarPlatilloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarPlatilloActionPerformed
        EliminarPlatCliente eliminarPla = new EliminarPlatCliente(orden);
        eliminarPla.setVisible(true);
    }//GEN-LAST:event_EliminarPlatilloActionPerformed

    private void EliminarBebidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarBebidaActionPerformed
        EliminarBebCliente eliminarBeb = new EliminarBebCliente(orden);
        eliminarBeb.setVisible(true);
    }//GEN-LAST:event_EliminarBebidaActionPerformed

    private void EliminarPostreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarPostreActionPerformed
        EliminarPostCliente eliminarPos = new EliminarPostCliente(orden);
        eliminarPos.setVisible(true);
    }//GEN-LAST:event_EliminarPostreActionPerformed

    private void volverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverActionPerformed
        //volver al menú 
    }//GEN-LAST:event_volverActionPerformed

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
            java.util.logging.Logger.getLogger(OpcionesModOrden.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OpcionesModOrden.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OpcionesModOrden.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OpcionesModOrden.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
//                new OpcionesModOrden().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AgregarBebida;
    private javax.swing.JButton AgregarPlatillo;
    private javax.swing.JButton AgregarPostre;
    private javax.swing.JButton EliminarBebida;
    private javax.swing.JButton EliminarPlatillo;
    private javax.swing.JButton EliminarPostre;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton volver;
    // End of variables declaration//GEN-END:variables
}
