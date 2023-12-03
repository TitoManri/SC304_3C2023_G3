package Interfaz.Cliente.Ordenes;

import Catalogo.Nodos.NodoPlatillo;
import Orden.Orden;
import Catalogo.Platillo.Platillo;
import java.awt.HeadlessException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;

public class EliminarPlatCliente extends javax.swing.JFrame {
    private NodoPlatillo inicioPlatillo;
    private static final String ruta = "SC304_3C2023_G3/src/main/java/BaseDeDatos/CatalogoPlatillos.txt";
    String RUTA_ARCHIVO = System.getProperty("user.dir") + "/" + ruta;
    private Orden orden;
    DefaultTableModel tab = new DefaultTableModel();
    
    public EliminarPlatCliente(Orden orden) {
        this.orden = orden;
        this.setLocationRelativeTo(null);
        setResizable(false);
        String[] titulo = new String[]{"Nombre", "Características", "Categoría", "Precio"};
        tab.setColumnIdentifiers(titulo);
        tabla.setModel(tab);
        llenarTabla();
        initComponents();
        cargarDesdeArchivo();
    }
    
         //Metodos Iniciales
    private void cargarDesdeArchivo() {
        inicioPlatillo = null;

        try (BufferedReader archivo = new BufferedReader(new FileReader(RUTA_ARCHIVO))) {
            String linea;
            while ((linea = archivo.readLine()) != null) {
                Platillo platillo = partesPlatillo(linea);
                if (platillo != null) {
                    agregarPlatillo(platillo);
                }
            }

            if (inicioPlatillo != null) {
                llenarTabla();
            } 

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error loading the file: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void llenarTabla() {
            DefaultTableModel model = (DefaultTableModel) tabla.getModel();
            model.setRowCount(0);

            NodoPlatillo aux = inicioPlatillo;
            do {
                if (aux != null) {
                    Platillo platillo = aux.getPlatillo();
                    if (platillo != null) {
                        model.addRow(new Object[]{platillo.getNombre(), platillo.getDescripcion(),platillo.getCategoria(), platillo.getPrecio()});
                    } 
                } else {
                    break;
                }
                aux = aux.getSiguiente();
            } while (aux != inicioPlatillo);
        }

    private Platillo partesPlatillo(String linea) {
        String[] partes = linea.split(",");
        try {
            if (partes.length == 4) {
                String nombre = partes[0];
                String descripcion = partes[1];
                String categoria = partes[2];
                String precio = partes[3];

                return new Platillo(nombre, categoria, descripcion, precio);
            } else {
                return null;
            }
        } catch (NumberFormatException e) {
            mostrarError("Error al convertir el precio a un número.");
            return null;
        }
    }
    
    private void agregarPlatillo(Platillo platillo) {
        try {
            if (!platilloYaExiste(platillo.getNombre())) {
                NodoPlatillo nuevoNodo = new NodoPlatillo();
                nuevoNodo.setPlatillo(platillo);

                if (inicioPlatillo == null) {
                    inicioPlatillo = nuevoNodo;
                } else {
                    NodoPlatillo aux = inicioPlatillo;
                    while (aux.getSiguiente() != null) {
                        aux = aux.getSiguiente();
                    }
                    aux.setSiguiente(nuevoNodo);
                }
            } else {
                mostrarError("El platillo ya existe en el catálogo.");
            }

        } catch (NumberFormatException e) {
            mostrarError("Error al convertir el precio a un número.");
        } catch (HeadlessException e) {
            mostrarError("Error al agregar los datos: " + e.getMessage());
        }
    }
    
    private boolean platilloYaExiste(String nombre) {
        NodoPlatillo aux = inicioPlatillo;
        while (aux != null) {
            if (aux.getPlatillo().getNombre().equalsIgnoreCase(nombre)) {
                return true;
            }
            aux = aux.getSiguiente();
        }
        return false;
    }
    
    private void mostrarError(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        Eliminar = new javax.swing.JButton();
        Volver = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jTextField1.setBackground(new java.awt.Color(0, 0, 51));
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField1);
        jTextField1.setBounds(90, 270, 420, 50);

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
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
        jScrollPane1.setViewportView(tabla);
        if (tabla.getColumnModel().getColumnCount() > 0) {
            tabla.getColumnModel().getColumn(0).setResizable(false);
            tabla.getColumnModel().getColumn(1).setResizable(false);
            tabla.getColumnModel().getColumn(2).setResizable(false);
            tabla.getColumnModel().getColumn(3).setResizable(false);
        }

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(562, 92, 420, 410);

        Eliminar.setBorderPainted(false);
        Eliminar.setContentAreaFilled(false);
        Eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarActionPerformed(evt);
            }
        });
        getContentPane().add(Eliminar);
        Eliminar.setBounds(115, 483, 200, 70);

        Volver.setBorderPainted(false);
        Volver.setContentAreaFilled(false);
        Volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VolverActionPerformed(evt);
            }
        });
        getContentPane().add(Volver);
        Volver.setBounds(325, 483, 200, 70);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/EliminarPlatillos.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 1000, 600);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void VolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VolverActionPerformed
        // volver al menú
    }//GEN-LAST:event_VolverActionPerformed

    private void EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarActionPerformed
        String nomPlatillo = jTextField1.getText();
        if (!nomPlatillo.isEmpty()) {
            orden.getPlatillos().eliminarPlatillo(nomPlatillo);
        } else {
            JOptionPane.showMessageDialog(null, "Por favor, ingrese el nombre del platillo a eliminar.");
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
            java.util.logging.Logger.getLogger(EliminarPlatCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EliminarPlatCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EliminarPlatCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EliminarPlatCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
//                new EliminarPlatCliente().setVisible(true); ------- Preguntar al profe
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Eliminar;
    private javax.swing.JButton Volver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
}
