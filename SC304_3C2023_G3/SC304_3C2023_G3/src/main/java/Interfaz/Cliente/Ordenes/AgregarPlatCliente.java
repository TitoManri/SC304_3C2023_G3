package Interfaz.Cliente.Ordenes;

import Orden.LesOrden;
import Catalogo.Nodos.NodoPlatillo;
import Catalogo.Platillo.Platillo;
import javax.swing.table.DefaultTableModel;
import Interfaz.Administrador.Platillos.CatalogoPlatillos;
import Orden.Orden;
import java.awt.HeadlessException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author marip
 */
public class AgregarPlatCliente extends javax.swing.JFrame {

    DefaultTableModel tab = new DefaultTableModel();
    private NodoPlatillo inicioPlatillo;
    private static final String ruta = "SC304_3C2023_G3/src/main/java/BaseDeDatos/CatalogoPlatillos.txt";
    String RUTA_ARCHIVO = System.getProperty("user.dir") + "/" + ruta;

    public AgregarPlatCliente() {
        initComponents();
        setResizable(false);
        this.setLocationRelativeTo(null); //solo para que este centrada en la pantalla
        String[] titulo = new String[]{"Nombre", "Descripción", "Categoría", "Precio"};
        tab.setColumnIdentifiers(titulo);
        tabla.setModel(tab);
        cargarDesdeArchivo();
        llenarTabla();
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

        nombrePlatText = new javax.swing.JTextField();
        agregarPlat = new javax.swing.JButton();
        volver = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        nombrePlatText.setBackground(new java.awt.Color(0, 0, 51));
        nombrePlatText.setForeground(new java.awt.Color(255, 255, 255));
        nombrePlatText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombrePlatTextActionPerformed(evt);
            }
        });
        getContentPane().add(nombrePlatText, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 270, 390, 50));

        agregarPlat.setBorderPainted(false);
        agregarPlat.setContentAreaFilled(false);
        agregarPlat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarPlatActionPerformed(evt);
            }
        });
        getContentPane().add(agregarPlat, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 480, 180, 50));

        volver.setBorderPainted(false);
        volver.setContentAreaFilled(false);
        volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverActionPerformed(evt);
            }
        });
        getContentPane().add(volver, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 470, 170, 60));

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
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
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
        tabla.setSelectionBackground(new java.awt.Color(204, 204, 204));
        jScrollPane1.setViewportView(tabla);
        if (tabla.getColumnModel().getColumnCount() > 0) {
            tabla.getColumnModel().getColumn(0).setResizable(false);
            tabla.getColumnModel().getColumn(1).setResizable(false);
            tabla.getColumnModel().getColumn(2).setResizable(false);
            tabla.getColumnModel().getColumn(3).setResizable(false);
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 100, -1, -1));

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AgregarPlatCliente.jpg"))); // NOI18N
        getContentPane().add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void agregarPlatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarPlatActionPerformed
        Orden orden = Ordenes.getOrden();
        orden.getPlatillos().agregarPlatillo(nombrePlatText.getText());
    }//GEN-LAST:event_agregarPlatActionPerformed

    private void volverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverActionPerformed
        Ordenes apc=new Ordenes();
        apc.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_volverActionPerformed

    private void nombrePlatTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombrePlatTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombrePlatTextActionPerformed
    
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
            java.util.logging.Logger.getLogger(AgregarPlatCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AgregarPlatCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AgregarPlatCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AgregarPlatCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AgregarPlatCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agregarPlat;
    private javax.swing.JLabel fondo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nombrePlatText;
    private javax.swing.JTable tabla;
    private javax.swing.JButton volver;
    // End of variables declaration//GEN-END:variables
}
