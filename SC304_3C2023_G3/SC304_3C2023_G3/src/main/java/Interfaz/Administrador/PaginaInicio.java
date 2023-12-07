/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interfaz.Administrador;

import Interfaz.Administrador.Bebidas.CatalogoBebidas;
import Interfaz.Administrador.Cajas.Caja;
import Interfaz.Administrador.Platillos.CatalogoPlatillos;
import Interfaz.Administrador.Postres.CatalogoPostres;
import Interfaz.Administrador.Proovedores.CatalogoProvedores;
import Interfaz.Cliente.LogIn;


/**
 *
 * @author manri
 */
public class PaginaInicio extends javax.swing.JFrame {

    /**
     * Creates new form PaginaInicio
     */
    public PaginaInicio() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        botonVolver = new javax.swing.JButton();
        botonCatalogoPlatillos = new javax.swing.JButton();
        botonCajas = new javax.swing.JButton();
        botonCatalogoPostres = new javax.swing.JButton();
        botonCatalogoProveedores = new javax.swing.JButton();
        botonCatalogoBebidas1 = new javax.swing.JButton();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        botonVolver.setBackground(new java.awt.Color(255, 255, 255));
        botonVolver.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        botonVolver.setForeground(new java.awt.Color(0, 0, 0));
        botonVolver.setText("Volver a Inicio de Sesion");
        botonVolver.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(77, 130, 188), 3));
        botonVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonVolverActionPerformed(evt);
            }
        });
        getContentPane().add(botonVolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 530, 360, 40));

        botonCatalogoPlatillos.setBackground(new java.awt.Color(255, 255, 255));
        botonCatalogoPlatillos.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        botonCatalogoPlatillos.setForeground(new java.awt.Color(0, 0, 0));
        botonCatalogoPlatillos.setText("Catalogo Platillos");
        botonCatalogoPlatillos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(77, 130, 188), 3));
        botonCatalogoPlatillos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCatalogoPlatillosActionPerformed(evt);
            }
        });
        getContentPane().add(botonCatalogoPlatillos, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 170, 200, 80));

        botonCajas.setBackground(new java.awt.Color(255, 255, 255));
        botonCajas.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        botonCajas.setForeground(new java.awt.Color(0, 0, 0));
        botonCajas.setText("Cajas");
        botonCajas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(77, 130, 188), 3));
        botonCajas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCajasActionPerformed(evt);
            }
        });
        getContentPane().add(botonCajas, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 280, 200, 80));

        botonCatalogoPostres.setBackground(new java.awt.Color(255, 255, 255));
        botonCatalogoPostres.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        botonCatalogoPostres.setForeground(new java.awt.Color(0, 0, 0));
        botonCatalogoPostres.setText("Catalogo Postres");
        botonCatalogoPostres.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(77, 130, 188), 3));
        botonCatalogoPostres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCatalogoPostresActionPerformed(evt);
            }
        });
        getContentPane().add(botonCatalogoPostres, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 380, 200, 80));

        botonCatalogoProveedores.setBackground(new java.awt.Color(255, 255, 255));
        botonCatalogoProveedores.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        botonCatalogoProveedores.setForeground(new java.awt.Color(0, 0, 0));
        botonCatalogoProveedores.setText("Catalogo proveedores");
        botonCatalogoProveedores.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(77, 130, 188), 3));
        botonCatalogoProveedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCatalogoProveedoresActionPerformed(evt);
            }
        });
        getContentPane().add(botonCatalogoProveedores, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 380, 200, 80));

        botonCatalogoBebidas1.setBackground(new java.awt.Color(255, 255, 255));
        botonCatalogoBebidas1.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        botonCatalogoBebidas1.setForeground(new java.awt.Color(0, 0, 0));
        botonCatalogoBebidas1.setText("Catalogo Bebidas");
        botonCatalogoBebidas1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(77, 130, 188), 3));
        botonCatalogoBebidas1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCatalogoBebidas1ActionPerformed(evt);
            }
        });
        getContentPane().add(botonCatalogoBebidas1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 160, 200, 80));

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/catalogoimagen.png"))); // NOI18N
        fondo.setToolTipText("");
        getContentPane().add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    //Boton Catalogo Platillos
    private void botonCatalogoPlatillosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCatalogoPlatillosActionPerformed
        CatalogoPlatillos x = new CatalogoPlatillos();
        x.setVisible(true);
        x.pack();
        x.setLocationRelativeTo(null); 
        this.dispose();
    }//GEN-LAST:event_botonCatalogoPlatillosActionPerformed
    //Volver a LogIn
    private void botonVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonVolverActionPerformed
        LogIn x = new LogIn();
        x.setVisible(true);
        x.pack();
        x.setLocationRelativeTo(null); 
        this.dispose();
    }//GEN-LAST:event_botonVolverActionPerformed
    //Boton Catalogo Bebidas
    private void botonCajasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCajasActionPerformed
        CatalogoBebidas x = new CatalogoBebidas();
        x.setVisible(true);
        x.pack();
        x.setLocationRelativeTo(null); 
        this.dispose();
    }//GEN-LAST:event_botonCajasActionPerformed
    //Boton Catalogo Postres
    private void botonCatalogoPostresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCatalogoPostresActionPerformed
        CatalogoPostres x = new CatalogoPostres();
        x.setVisible(true);
        x.pack();
        x.setLocationRelativeTo(null); 
        this.dispose();
    }//GEN-LAST:event_botonCatalogoPostresActionPerformed
    //Boton Catalogo Provedorees
    private void botonCatalogoProveedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCatalogoProveedoresActionPerformed
        CatalogoProvedores x = new CatalogoProvedores();
        x.setVisible(true);
        x.pack();
        x.setLocationRelativeTo(null); 
        this.dispose();
    }//GEN-LAST:event_botonCatalogoProveedoresActionPerformed

    private void botonCatalogoBebidas1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCatalogoBebidas1ActionPerformed
        Caja x = new Caja();
        x.setVisible(true);
        x.pack();
        x.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_botonCatalogoBebidas1ActionPerformed

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
            java.util.logging.Logger.getLogger(PaginaInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PaginaInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PaginaInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PaginaInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PaginaInicio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonCajas;
    private javax.swing.JButton botonCatalogoBebidas1;
    private javax.swing.JButton botonCatalogoPlatillos;
    private javax.swing.JButton botonCatalogoPostres;
    private javax.swing.JButton botonCatalogoProveedores;
    private javax.swing.JButton botonVolver;
    private javax.swing.JLabel fondo;
    // End of variables declaration//GEN-END:variables
}
