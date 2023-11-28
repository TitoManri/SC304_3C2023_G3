package Interfaz;

import Transacciones.Arbol;
import Interfaz.Ordenes.Ordenes;
import Orden.Orden;
import javax.swing.JOptionPane;

/**
 *
 * @author marip
 */
public class Transaccion extends javax.swing.JFrame {

    public Transaccion() {
        initComponents();
        mostrarDatos();
    }

    public void mostrarDatos() {
        Orden orden = Ordenes.getOrden();

        if (orden != null) {
            fechaText.setText(orden.getFechaHora().toString());
            fechaText.setEditable(false);

            String nombre = orden.getCliente().getNombre() + " " + orden.getCliente().getApellido();
            clienteText.setText(nombre);
            clienteText.setEditable(false);

            totalText.setText(String.valueOf(orden.getTotal()));
            totalText.setEditable(false);
        } else {
            JOptionPane.showMessageDialog(null, "Error al localizar la orden");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pagar = new javax.swing.JButton();
        cancelar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        fechaText = new javax.swing.JTextField();
        clienteText = new javax.swing.JTextField();
        totalText = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pagar.setBorderPainted(false);
        pagar.setContentAreaFilled(false);
        pagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pagarActionPerformed(evt);
            }
        });
        getContentPane().add(pagar, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 230, 200, 90));

        cancelar.setBorderPainted(false);
        cancelar.setContentAreaFilled(false);
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarActionPerformed(evt);
            }
        });
        getContentPane().add(cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 340, 200, 80));

        jLabel1.setBackground(new java.awt.Color(0, 0, 51));
        jLabel1.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 51));
        jLabel1.setText("Cliente: ");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 250, 80, 20));

        fechaText.setBackground(new java.awt.Color(204, 204, 204));
        getContentPane().add(fechaText, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 190, 220, -1));

        clienteText.setBackground(new java.awt.Color(204, 204, 204));
        getContentPane().add(clienteText, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 280, 220, -1));

        totalText.setBackground(new java.awt.Color(204, 204, 204));
        getContentPane().add(totalText, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 380, 220, -1));

        jLabel2.setBackground(new java.awt.Color(0, 0, 51));
        jLabel2.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 51));
        jLabel2.setText("Detalles de la transacción");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 110, 340, 20));

        jLabel3.setBackground(new java.awt.Color(0, 0, 51));
        jLabel3.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 51));
        jLabel3.setText("Total:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 340, 250, 20));

        jLabel4.setBackground(new java.awt.Color(0, 0, 51));
        jLabel4.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 51));
        jLabel4.setText("Fecha: ");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 160, 70, 20));

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Facturacion.jpg"))); // NOI18N
        getContentPane().add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pagarActionPerformed
        Arbol a = new Arbol();
        Orden orden = Ordenes.getOrden();
        if (orden != null) {
            a.agregarAArbol(orden);
            a.guardarTransaccionArchivo(orden.getFechaHora(), orden.getCliente(), orden.getTotal());
        } else {
            JOptionPane.showMessageDialog(null, "Error al localizar la orden");
        }
    }//GEN-LAST:event_pagarActionPerformed

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
        Ordenes o = new Ordenes();
        o.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_cancelarActionPerformed

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
            java.util.logging.Logger.getLogger(Transaccion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Transaccion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Transaccion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Transaccion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Transaccion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelar;
    private javax.swing.JTextField clienteText;
    private javax.swing.JTextField fechaText;
    private javax.swing.JLabel fondo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JButton pagar;
    private javax.swing.JTextField totalText;
    // End of variables declaration//GEN-END:variables
}
