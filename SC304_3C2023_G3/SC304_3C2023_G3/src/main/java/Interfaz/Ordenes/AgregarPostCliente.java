package Interfaz.Ordenes;

import Catalogo.Nodos.NodoPostre;
import Interfaz.Administrador.Postres.CatalogoPostres;
import Orden.LesOrden;
import Orden.Orden;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author marip
 */
public class AgregarPostCliente extends javax.swing.JFrame {

    DefaultTableModel tab = new DefaultTableModel();
    
    public AgregarPostCliente() {
        initComponents();
        String[] titulo = new String[]{"Nombre", "Descripción", "Categoría", "Precio"};
        tab.setColumnIdentifiers(titulo);
        tablaPostres.setModel(tab);
        llenarTabla();
    }
    
    public void llenarTabla(){
        CatalogoPostres c = new CatalogoPostres();
        if (!c.esVaciaPostres()) {
           NodoPostre aux = c.getInicioPostre();
           tab.addRow(new Object[]{
           aux.getPostre().getNombre(), aux.getPostre().getDescripcion(), aux.getPostre().getCategoria(), aux.getPostre().getPrecio()});
            while (aux != c.getInicioPostre()) {
                tab.addRow(new Object[]{
                aux.getPostre().getNombre(), aux.getPostre().getDescripcion(), aux.getPostre().getCategoria(), aux.getPostre().getPrecio()
                });
                aux = aux.getSiguiente();
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        postNomText = new javax.swing.JTextField();
        AgregarPost = new javax.swing.JButton();
        volver = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaPostres = new javax.swing.JTable();
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

        tablaPostres.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
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
        jScrollPane1.setViewportView(tablaPostres);
        if (tablaPostres.getColumnModel().getColumnCount() > 0) {
            tablaPostres.getColumnModel().getColumn(0).setResizable(false);
            tablaPostres.getColumnModel().getColumn(1).setResizable(false);
            tablaPostres.getColumnModel().getColumn(2).setResizable(false);
            tablaPostres.getColumnModel().getColumn(3).setResizable(false);
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 110, -1, -1));

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AgregPostrCliente.jpg"))); // NOI18N
        getContentPane().add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 600));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AgregarPostActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgregarPostActionPerformed
        Orden orden = Ordenes.getOrden();
        orden.getPostres().agregarPostre(postNomText.getText());
    }//GEN-LAST:event_AgregarPostActionPerformed

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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField postNomText;
    private javax.swing.JTable tablaPostres;
    private javax.swing.JButton volver;
    // End of variables declaration//GEN-END:variables
}
