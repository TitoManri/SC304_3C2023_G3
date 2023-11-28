package Interfaz.Ordenes;

import Orden.Orden;
import Orden.LesOrden;
import Interfaz.Transaccion;
import Interfaz.LogIn;
import javax.swing.JOptionPane;

/**
 *
 * @author marip
 */
public class Ordenes extends javax.swing.JFrame {

    LesOrden lo = new LesOrden();
    private static Orden orden;

    public Ordenes() {
        initComponents();
        orden = lo.agregarOrden(LogIn.getCliente());
    }

    public static Orden getOrden() {
        return orden;
    }

    public static void setOrden(Orden orden) {
        Ordenes.orden = orden;
    }

    public void cancelarOrden() {
        int respuesta = JOptionPane.showConfirmDialog(null, "¿Seguro que sea cancelar su orden?", "Confirmación", JOptionPane.YES_NO_OPTION);

        if (respuesta == JOptionPane.YES_OPTION) {
            LesOrden lo = new LesOrden();
            lo.cancelarOrden(orden.getNumOrden());
            JOptionPane.showMessageDialog(null, "Se eliminó la orden correctamente");
        } else {
            JOptionPane.showMessageDialog(null, "No se ha eliminado puede seguir editando");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        agrPlatillo = new javax.swing.JButton();
        agrBebida = new javax.swing.JButton();
        agrPostre = new javax.swing.JButton();
        terminarOrd = new javax.swing.JButton();
        cancelarOrd = new javax.swing.JButton();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        agrPlatillo.setBorderPainted(false);
        agrPlatillo.setContentAreaFilled(false);
        agrPlatillo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agrPlatilloActionPerformed(evt);
            }
        });
        getContentPane().add(agrPlatillo, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 210, 250, 100));

        agrBebida.setBorderPainted(false);
        agrBebida.setContentAreaFilled(false);
        agrBebida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agrBebidaActionPerformed(evt);
            }
        });
        getContentPane().add(agrBebida, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 210, 240, 100));

        agrPostre.setBorderPainted(false);
        agrPostre.setContentAreaFilled(false);
        agrPostre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agrPostreActionPerformed(evt);
            }
        });
        getContentPane().add(agrPostre, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 210, 250, 100));

        terminarOrd.setBorderPainted(false);
        terminarOrd.setContentAreaFilled(false);
        terminarOrd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                terminarOrdActionPerformed(evt);
            }
        });
        getContentPane().add(terminarOrd, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 510, 240, 60));

        cancelarOrd.setBorderPainted(false);
        cancelarOrd.setContentAreaFilled(false);
        cancelarOrd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarOrdActionPerformed(evt);
            }
        });
        getContentPane().add(cancelarOrd, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 510, 200, 60));

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Orden.jpg"))); // NOI18N
        getContentPane().add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void agrPlatilloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agrPlatilloActionPerformed
        AgregarPlatCliente apc = new AgregarPlatCliente();
        apc.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_agrPlatilloActionPerformed

    private void agrBebidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agrBebidaActionPerformed
        AgregarBebCliente abc = new AgregarBebCliente();
        abc.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_agrBebidaActionPerformed

    private void agrPostreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agrPostreActionPerformed
        AgregarPostCliente apc = new AgregarPostCliente();
        apc.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_agrPostreActionPerformed

    private void terminarOrdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_terminarOrdActionPerformed
        LesOrden lo = new LesOrden();
        orden.setTotal(lo.calcularTotal(orden));
        Transaccion t = new Transaccion();
        t.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_terminarOrdActionPerformed

    private void cancelarOrdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarOrdActionPerformed
        cancelarOrden();
        //AQUÍ SE LLAMA AL MENU PRINCIPAL
    }//GEN-LAST:event_cancelarOrdActionPerformed

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
            java.util.logging.Logger.getLogger(Ordenes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ordenes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ordenes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ordenes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ordenes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agrBebida;
    private javax.swing.JButton agrPlatillo;
    private javax.swing.JButton agrPostre;
    private javax.swing.JButton cancelarOrd;
    private javax.swing.JLabel fondo;
    private javax.swing.JButton terminarOrd;
    // End of variables declaration//GEN-END:variables
}
