/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interfaz.Cliente.Ordenes;

import Interfaz.Cliente.Transaccion;
import javax.swing.JOptionPane;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.table.DefaultTableModel;

public class EliminarProducto extends javax.swing.JFrame {
    
    private Transaccion transaccionInstance;
    private static final String ruta = "SC304_3C2023_G3/src/main/java/BaseDeDatos/Orden.txt";
    String RUTA_ARCHIVO = System.getProperty("user.dir") + "/" + ruta;
    private NodoProducto inicioProducto;
    public EliminarProducto(Transaccion transaccionInstance) {
        initComponents();
        cargarProductosDesdeArchivo();
         this.transaccionInstance = transaccionInstance;
         cargarProductosEnTabla();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        volver = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        nombreText = new javax.swing.JTextField();
        eliminar = new javax.swing.JButton();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        volver.setText("Volver");
        getContentPane().add(volver, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 470, 190, 70));

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

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 110, 380, -1));

        nombreText.setBackground(new java.awt.Color(60, 63, 65));
        nombreText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreTextActionPerformed(evt);
            }
        });
        getContentPane().add(nombreText, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 270, 380, 40));

        eliminar.setText("Eliminar");
        eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarActionPerformed(evt);
            }
        });
        getContentPane().add(eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 470, 190, 70));

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/EliminarProductos.png"))); // NOI18N
        getContentPane().add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nombreTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombreTextActionPerformed

    private void eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarActionPerformed
    String nombreProducto = nombreText.getText().trim();
    if (!nombreProducto.isEmpty()) {
        eliminarProducto(nombreProducto);
        // Recargar la tabla después de la eliminación
        cargarProductosEnTabla();
    } else {
        JOptionPane.showMessageDialog(this, "Ingrese un nombre de producto válido", "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_eliminarActionPerformed

    
    private void cargarProductosDesdeArchivo() {
        inicioProducto = null;

        try (BufferedReader archivo = new BufferedReader(new FileReader(RUTA_ARCHIVO))) {
            String linea;
            while ((linea = archivo.readLine()) != null) {
                Producto producto = partesProducto(linea);
                if (producto != null) {
                    inicioProducto = agregarNodo(inicioProducto, producto);
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al cargar el archivo: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private Producto partesProducto(String linea) {
        String[] partes = linea.split(",");
        try {
            if (partes.length == 2) {
                String nombre = partes[0];
                String precio = partes[1];
                return new Producto(nombre, precio);
            } else {
                return null;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error al convertir el precio a un número.", "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    private NodoProducto agregarNodo(NodoProducto inicio, Producto producto) {
        NodoProducto nuevoNodo = new NodoProducto();
        nuevoNodo.setProducto(producto);

        if (inicio == null) {
            inicio = nuevoNodo;
        } else {
            nuevoNodo.setSiguiente(inicio);
            inicio = nuevoNodo;
        }

        return inicio;
    }

    private void guardarProductosEnArchivo() {
        try (PrintWriter printWriter = new PrintWriter(new FileWriter(RUTA_ARCHIVO))) {
            NodoProducto aux = inicioProducto;
            while (aux != null) {
                Producto producto = aux.getProducto();
                printWriter.println(producto.getNombre() + "," + producto.getPrecio());
                aux = aux.getSiguiente();
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al guardar en el archivo Orden.txt: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void eliminarProducto(String nombreProducto) {
        NodoProducto aux = inicioProducto;
        NodoProducto anterior = null;

        while (aux != null) {
            Producto producto = aux.getProducto();

            if (producto.getNombre().equalsIgnoreCase(nombreProducto)) {
                if (anterior != null) {
                    anterior.setSiguiente(aux.getSiguiente());
                } else {
                    inicioProducto = aux.getSiguiente();
                }

                // Guardar la lista actualizada en el archivo
                guardarProductosEnArchivo();

                JOptionPane.showMessageDialog(this, "Producto eliminado de la lista.");
                return;
            }

            anterior = aux;
            aux = aux.getSiguiente();
        }

        JOptionPane.showMessageDialog(this, "El producto no existe en la lista.", "Error", JOptionPane.ERROR_MESSAGE);
    }
    
    private void cargarProductosEnTabla() {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Nombre");
        modelo.addColumn("Precio");

        NodoProducto aux = inicioProducto;
        while (aux != null) {
            Producto producto = aux.getProducto();
            modelo.addRow(new Object[]{producto.getNombre(), producto.getPrecio()});
            aux = aux.getSiguiente();
        }

        tabla.setModel(modelo);
    }
    
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
            java.util.logging.Logger.getLogger(EliminarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EliminarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EliminarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EliminarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        Transaccion transaccionInstance = new Transaccion();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EliminarProducto(transaccionInstance).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton eliminar;
    private javax.swing.JLabel fondo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nombreText;
    private javax.swing.JTable tabla;
    private javax.swing.JButton volver;
    // End of variables declaration//GEN-END:variables
}
