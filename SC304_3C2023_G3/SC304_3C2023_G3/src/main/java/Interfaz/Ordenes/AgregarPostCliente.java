package Interfaz.Ordenes;

import Orden.LesOrden;

/**
 *
 * @author marip
 */
public class AgregarPostCliente extends javax.swing.JFrame {

    public AgregarPostCliente() {
        initComponents();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        postNomText = new javax.swing.JTextField();
        AgregarPost = new javax.swing.JButton();
        volver = new javax.swing.JButton();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        postNomText.setBackground(new java.awt.Color(0, 0, 51));
        postNomText.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(postNomText, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 270, 390, 50));

        AgregarPost.setBorderPainted(false);
        AgregarPost.setContentAreaFilled(false);
        AgregarPost.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgregarPostActionPerformed(evt);
            }
        });
        getContentPane().add(AgregarPost, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 480, 180, 50));

        volver.setBorderPainted(false);
        volver.setContentAreaFilled(false);
        getContentPane().add(volver, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 470, 170, 60));

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AgregPostrCliente.jpg"))); // NOI18N
        getContentPane().add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 600));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AgregarPostActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgregarPostActionPerformed
        LesOrden lo = new LesOrden();
        lo.agregarPlatillo(Ordenes.getOrden(), postNomText.getText());
    }//GEN-LAST:event_AgregarPostActionPerformed

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
            java.util.logging.Logger.getLogger(AgregarPostCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AgregarPostCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AgregarPostCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AgregarPostCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AgregarPostCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AgregarPost;
    private javax.swing.JLabel fondo;
    private javax.swing.JTextField postNomText;
    private javax.swing.JButton volver;
    // End of variables declaration//GEN-END:variables
}
