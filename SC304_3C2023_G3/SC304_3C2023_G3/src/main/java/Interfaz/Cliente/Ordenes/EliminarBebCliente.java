package Interfaz.Cliente.Ordenes;

import Catalogo.Bebidas.Bebida;
import Catalogo.Nodos.NodoBebida;
import Orden.LesOrden;
import Orden.Orden;
import Orden.bebidasLes;
import Orden.nodoBebidas;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class EliminarBebCliente extends javax.swing.JFrame {
    private static final String ruta = "SC304_3C2023_G3/src/main/java/BaseDeDatos/CatalogoBebidas.txt";
    String RUTA_ARCHIVO = System.getProperty("user.dir") + "/" + ruta; 
    NodoBebida inicioBebida;
    NodoBebida finBebida;
    private Orden orden;
    DefaultTableModel tab = new DefaultTableModel();

    public EliminarBebCliente(Orden orden) {
        initComponents();
        this.orden = orden;
        this.setLocationRelativeTo(null);
        setResizable(false);
        String[] titulo = new String[]{"Nombre", "Categoría", "Precio"};
        tab.setColumnIdentifiers(titulo);
        tabla.setModel(tab);
        llenarTabla();
        cargarDesdeArchivo();
    }

        private void cargarDesdeArchivo() {
        try (BufferedReader archivo = new BufferedReader(new FileReader(RUTA_ARCHIVO))) {
            String linea;
            while ((linea = archivo.readLine()) != null) {
                Bebida bebida = partesBebida(linea);
                if (bebida != null) {
                    finBebida = agregarNodo(finBebida, bebida);
                    if (inicioBebida == null) {
                        inicioBebida = finBebida;
                    }
                }
            }

            if (finBebida != null) {
                llenarTabla();
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al cargar el archivo: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    private void llenarTabla() {
            DefaultTableModel model = (DefaultTableModel) tabla.getModel();
            model.setRowCount(0);

            NodoBebida aux = inicioBebida;
            do {
                if (aux != null) {
                    Bebida bebida = aux.getBebida();
                    if (bebida != null) {
                        model.addRow(new Object[]{bebida.getNombre(), bebida.getCategoria(), bebida.getPrecio()});
                    } else {
                    }
                } else {
                    break;
                }
                aux = aux.getSiguiente();
            } while (aux != inicioBebida);
        }

    private NodoBebida agregarNodo(NodoBebida fin, Bebida bebida) {
        NodoBebida nuevoNodo = new NodoBebida();
        nuevoNodo.setBebida(bebida);

        if (fin == null) {
            fin = nuevoNodo;
            nuevoNodo.setSiguiente(nuevoNodo);
        } else {
            nuevoNodo.setSiguiente(fin.getSiguiente());
            fin.setSiguiente(nuevoNodo);
            fin = nuevoNodo;
        }

        return fin;
    }  
    
     private Bebida partesBebida(String linea) {
        String[] partes = linea.split(",");
        try {
            if (partes.length == 3) {
                String nombre = partes[0];
                String categoria = partes[1];
                String precio = partes[2];
                return new Bebida(nombre, categoria, precio);
            } else {
                return null;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error al convertir el precio a un número.", "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        txtNomBebida = new javax.swing.JTextField();
        Volver = new javax.swing.JButton();
        Eliminar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
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
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabla);
        if (tabla.getColumnModel().getColumnCount() > 0) {
            tabla.getColumnModel().getColumn(0).setResizable(false);
            tabla.getColumnModel().getColumn(1).setResizable(false);
            tabla.getColumnModel().getColumn(2).setResizable(false);
        }

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(582, 92, 400, 410);

        txtNomBebida.setBackground(new java.awt.Color(0, 0, 51));
        txtNomBebida.setSelectedTextColor(new java.awt.Color(255, 255, 255));
        txtNomBebida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomBebidaActionPerformed(evt);
            }
        });
        getContentPane().add(txtNomBebida);
        txtNomBebida.setBounds(100, 270, 410, 50);

        Volver.setBorderPainted(false);
        Volver.setContentAreaFilled(false);
        Volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VolverActionPerformed(evt);
            }
        });
        getContentPane().add(Volver);
        Volver.setBounds(330, 490, 190, 70);

        Eliminar.setBorderPainted(false);
        Eliminar.setContentAreaFilled(false);
        Eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarActionPerformed(evt);
            }
        });
        getContentPane().add(Eliminar);
        Eliminar.setBounds(115, 483, 200, 70);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/EliminarBebidas.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 1000, 600);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNomBebidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomBebidaActionPerformed

    }//GEN-LAST:event_txtNomBebidaActionPerformed

    private void VolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VolverActionPerformed
        // volver al menú
    }//GEN-LAST:event_VolverActionPerformed

    private void EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarActionPerformed
        String nomBebida = txtNomBebida.getText();
        if (!nomBebida.isEmpty()) {
            orden.getBebidas().eliminarBebida(nomBebida);
        } else {
            JOptionPane.showMessageDialog(null, "Por favor, ingrese el nombre de la bebida a eliminar.");
        }
    }//GEN-LAST:event_EliminarActionPerformed

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
            java.util.logging.Logger.getLogger(EliminarBebCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EliminarBebCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EliminarBebCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EliminarBebCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
//                new EliminarBebCliente().setVisible(true);  -----Preguntar al profe
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Eliminar;
    private javax.swing.JButton Volver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla;
    private javax.swing.JTextField txtNomBebida;
    // End of variables declaration//GEN-END:variables
}
