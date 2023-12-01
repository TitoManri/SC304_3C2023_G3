package Interfaz.Ordenes;

import Catalogo.Nodos.NodoBebida;
import Interfaz.Administrador.Bebidas.CatalogoBebidas;
import Orden.LesOrden;
import Orden.Orden;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author marip
 */
public class AgregarBebCliente extends javax.swing.JFrame {

    DefaultTableModel tab = new DefaultTableModel();
    
    public AgregarBebCliente() {
        initComponents();
        setResizable(false);
        this.setLocationRelativeTo(null);
        String[] titulo = new String[]{"Nombre", "Categoría", "Precio"};
        tab.setColumnIdentifiers(titulo);
        tablaBebidas.setModel(tab);
        llenarTabla();
    }
    
    public void llenarTabla(){
        CatalogoBebidas c = new CatalogoBebidas();
        if (!c.esVaciaBebidas()) {
           NodoBebida aux = c.getInicioBebida();
           tab.addRow(new Object[]{
           aux.getBebida().getNombre(), aux.getBebida().getCategoria(), aux.getBebida().getPrecio()});
            while (aux != c.getInicioBebida()) {
                tab.addRow(new Object[]{
                aux.getBebida().getNombre(), aux.getBebida().getCategoria(), aux.getBebida().getPrecio(), aux.getBebida()
                });
                aux = aux.getSiguiente();
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nombreBebText = new javax.swing.JTextField();
        agregarBeb = new javax.swing.JButton();
        volver = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaBebidas = new javax.swing.JTable();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        nombreBebText.setBackground(new java.awt.Color(0, 0, 51));
        nombreBebText.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(nombreBebText, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 270, 390, 50));

        agregarBeb.setBorderPainted(false);
        agregarBeb.setContentAreaFilled(false);
        agregarBeb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarBebActionPerformed(evt);
            }
        });
        getContentPane().add(agregarBeb, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 480, 180, 50));

        volver.setBorderPainted(false);
        volver.setContentAreaFilled(false);
        volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverActionPerformed(evt);
            }
        });
        getContentPane().add(volver, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 480, 170, 50));

        tablaBebidas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
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
                false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaBebidas);
        if (tablaBebidas.getColumnModel().getColumnCount() > 0) {
            tablaBebidas.getColumnModel().getColumn(0).setResizable(false);
            tablaBebidas.getColumnModel().getColumn(1).setResizable(false);
            tablaBebidas.getColumnModel().getColumn(2).setResizable(false);
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 100, -1, -1));

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AgregarBebCliente.jpg"))); // NOI18N
        getContentPane().add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 600));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void agregarBebActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarBebActionPerformed
        Orden orden = Ordenes.getOrden();
        orden.getBebidas().agregarBebida(nombreBebText.getText());
    }//GEN-LAST:event_agregarBebActionPerformed

    private void volverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverActionPerformed
        Ordenes apc=new Ordenes();
        apc.setVisible(true);
        this.dispose();
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
            java.util.logging.Logger.getLogger(AgregarBebCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AgregarBebCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AgregarBebCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AgregarBebCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AgregarBebCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agregarBeb;
    private javax.swing.JLabel fondo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nombreBebText;
    private javax.swing.JTable tablaBebidas;
    private javax.swing.JButton volver;
    // End of variables declaration//GEN-END:variables
}
