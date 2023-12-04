package Interfaz.Cliente;

import Interfaz.Cliente.Ordenes.NodoProducto;
import Interfaz.Cliente.Ordenes.Producto;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author marip
 */
public class Transaccion extends javax.swing.JFrame {
    DefaultTableModel model = new DefaultTableModel();
    private NodoProducto inicioProductos;
    public Transaccion() {
        initComponents();
        
        setResizable(false);
        this.setLocationRelativeTo(null);
        String[] titulo = new String[]{"Nombre", "Categoría", "Precio"};
        model.setColumnIdentifiers(titulo);
        tabla.setModel(model);
        mostrarOrdenYTotal();
    }

    

    private void mostrarOrdenYTotal(){
    
    int rowCount = model.getRowCount();

    if (rowCount > 0) {
        double total = 0;

        StringBuilder ordenStringBuilder = new StringBuilder("Orden:\n");

        for (int i = 0; i < rowCount; i++) {
            String nombre = (String) model.getValueAt(i, 0);
            String categoria = (String) model.getValueAt(i, 1);
            double precio = (double) model.getValueAt(i, 2);

            total += precio;

            ordenStringBuilder.append(String.format("%s - %s - $%.2f\n", nombre, categoria, precio));
        }

        totalText.setText(String.format("Total: $%.2f", total));

        JOptionPane.showMessageDialog(this, ordenStringBuilder.toString(), "Orden Completa", JOptionPane.INFORMATION_MESSAGE);
    } else {
        JOptionPane.showMessageDialog(this, "La orden está vacía.", "Orden Vacía", JOptionPane.INFORMATION_MESSAGE);
    }
}
    
    public void agregarProductoATransaccion(Producto producto) {
        agregarProducto(producto);
    }
    
    private void agregarProducto(Producto producto) {
        NodoProducto nuevoNodo = new NodoProducto(producto);

        if (inicioProductos == null) {
            inicioProductos = nuevoNodo;
        } else {
            NodoProducto aux = inicioProductos;
            while (aux.getSiguiente() != null) {
                aux = aux.getSiguiente();
            }
            aux.setSiguiente(nuevoNodo);
        }

        actualizarTabla();
    }
    
    private void actualizarTabla() {
        model.setRowCount(0);

        NodoProducto aux = inicioProductos;
        while (aux != null) {
            Producto producto = aux.getProducto();
            model.addRow(new Object[]{producto.getNombre(), producto.getPrecio()});
            aux = aux.getSiguiente();
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
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
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
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 260, 80, 20));

        fechaText.setEditable(false);
        fechaText.setBackground(new java.awt.Color(204, 204, 204));
        fechaText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fechaTextActionPerformed(evt);
            }
        });
        getContentPane().add(fechaText, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 200, 220, -1));

        clienteText.setEditable(false);
        clienteText.setBackground(new java.awt.Color(204, 204, 204));
        getContentPane().add(clienteText, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 290, 220, -1));

        totalText.setEditable(false);
        totalText.setBackground(new java.awt.Color(204, 204, 204));
        getContentPane().add(totalText, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 390, 220, -1));

        jLabel2.setBackground(new java.awt.Color(0, 0, 51));
        jLabel2.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 51));
        jLabel2.setText("Lista de la Orden");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 110, 340, 20));

        jLabel3.setBackground(new java.awt.Color(0, 0, 51));
        jLabel3.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 51));
        jLabel3.setText("Total:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 350, 250, 20));

        jLabel4.setBackground(new java.awt.Color(0, 0, 51));
        jLabel4.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 51));
        jLabel4.setText("Fecha: ");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 160, 70, 20));

        jLabel5.setBackground(new java.awt.Color(0, 0, 51));
        jLabel5.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 51));
        jLabel5.setText("Detalles de la transacción");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 110, 340, 20));

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Nombre", "Precio"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabla);
        if (tabla.getColumnModel().getColumnCount() > 0) {
            tabla.getColumnModel().getColumn(0).setResizable(false);
            tabla.getColumnModel().getColumn(1).setResizable(false);
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 150, 260, 290));

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Facturacion.jpg"))); // NOI18N
        getContentPane().add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pagarActionPerformed
        
    }//GEN-LAST:event_pagarActionPerformed

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
        
    }//GEN-LAST:event_cancelarActionPerformed

    private void fechaTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fechaTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fechaTextActionPerformed

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
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton pagar;
    private javax.swing.JTable tabla;
    private javax.swing.JTextField totalText;
    // End of variables declaration//GEN-END:variables
}
