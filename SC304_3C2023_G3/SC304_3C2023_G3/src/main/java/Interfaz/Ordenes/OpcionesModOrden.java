package Interfaz.Ordenes;

public class OpcionesModOrden extends javax.swing.JFrame {

    public OpcionesModOrden() {
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
        getContentPane().add(AgregarPostre);
        AgregarPostre.setBounds(705, 183, 270, 110);

        EliminarPlatillo.setBorderPainted(false);
        EliminarPlatillo.setContentAreaFilled(false);
        getContentPane().add(EliminarPlatillo);
        EliminarPlatillo.setBounds(45, 353, 270, 110);

        EliminarBebida.setBorderPainted(false);
        EliminarBebida.setContentAreaFilled(false);
        getContentPane().add(EliminarBebida);
        EliminarBebida.setBounds(375, 353, 270, 110);

        EliminarPostre.setBorderPainted(false);
        EliminarPostre.setContentAreaFilled(false);
        getContentPane().add(EliminarPostre);
        EliminarPostre.setBounds(705, 353, 270, 110);

        volver.setBorderPainted(false);
        volver.setContentAreaFilled(false);
        getContentPane().add(volver);
        volver.setBounds(805, 513, 200, 70);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/OpcionesModOrden.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 1000, 600);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AgregarBebidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgregarBebidaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AgregarBebidaActionPerformed

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
                new OpcionesModOrden().setVisible(true);
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
