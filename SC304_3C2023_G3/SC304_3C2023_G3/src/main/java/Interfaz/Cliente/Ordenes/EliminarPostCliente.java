package Interfaz.Cliente.Ordenes;

import Catalogo.Nodos.NodoPostre;
import Catalogo.Postres.Postre;
import Orden.Orden;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class EliminarPostCliente extends javax.swing.JFrame {

    private Orden orden;
    NodoPostre inicioPostre;
    NodoPostre finPostre;
    
    private static final String ruta = "SC304_3C2023_G3/src/main/java/BaseDeDatos/CatalogoPostres.txt";
    String RUTA_ARCHIVO_POSTRES = System.getProperty("user.dir") + "/" + ruta;
    DefaultTableModel tab = new DefaultTableModel();

    public EliminarPostCliente(Orden orden) {
        initComponents();
        this.orden = orden;
        this.setLocationRelativeTo(null);
        setResizable(false);
        String[] titulo = new String[]{"Nombre", "Descripción", "Categoría", "Precio"};
        tab.setColumnIdentifiers(titulo);
        tabla.setModel(tab);
        llenarTabla();
        cargarDesdeArchivo();
    }

    private void cargarDesdeArchivo() {
        try (BufferedReader archivo = new BufferedReader(new FileReader(RUTA_ARCHIVO_POSTRES))) {
        String linea;
        while ((linea = archivo.readLine()) != null) {
            Postre bebida = partesPostre(linea);
            if (bebida != null) {
                finPostre = agregarNodo(finPostre, bebida);
                if (inicioPostre == null) {
                    inicioPostre= finPostre;
                }
            }
        }

        if (finPostre != null) {
           llenarTabla();
        }

    } catch (IOException e) {
        JOptionPane.showMessageDialog(null, "Error al cargar el archivo: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
}
    private void llenarTabla() {
            DefaultTableModel model = (DefaultTableModel) tabla.getModel();
            model.setRowCount(0);

            NodoPostre aux = inicioPostre;
            do {
                if (aux != null) {
                    Postre postre = aux.getPostre();
                    if (postre != null) {
                        model.addRow(new Object[]{postre.getNombre(), postre.getCategoria(), postre.getDescripcion(),postre.getPrecio()});
                    } else {
                    }
                } else {
                    break;
                }
                aux = aux.getSiguiente();
            } while (aux != inicioPostre);
        }
    
    
    private NodoPostre agregarNodo(NodoPostre fin, Postre postre) {
        NodoPostre nuevoNodo = new NodoPostre();
        nuevoNodo.setPostre(postre);

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

    private Postre partesPostre(String linea) {
        String[] partes = linea.split(",");
        try {
            if (partes.length == 4) {
                String nombre = partes[0];
                String descripcion = partes[1];
                String tipo = partes[2];
                String precio = partes[3];

                return new Postre(nombre, tipo, descripcion, precio); // Orden de parámetros corregido
            } else {
                System.out.println("Error en el formato de línea: " + linea);
                return null;
            }
        } catch (NumberFormatException e) {
            System.out.println("Error al convertir el precio a un número.");
            return null;
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jTextField1 = new javax.swing.JTextField();
        Eliminar = new javax.swing.JButton();
        volver = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

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
        jScrollPane1.setBounds(572, 92, 410, 410);

        jTextField1.setBackground(new java.awt.Color(0, 0, 51));
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField1);
        jTextField1.setBounds(100, 270, 410, 50);

        Eliminar.setBorderPainted(false);
        Eliminar.setContentAreaFilled(false);
        Eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarActionPerformed(evt);
            }
        });
        getContentPane().add(Eliminar);
        Eliminar.setBounds(115, 490, 200, 60);

        volver.setBorderPainted(false);
        volver.setContentAreaFilled(false);
        volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverActionPerformed(evt);
            }
        });
        getContentPane().add(volver);
        volver.setBounds(325, 490, 200, 60);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/EliminarPostres.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 1000, 600);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarActionPerformed
        String nomPostre = jTextField1.getText();
        if (!nomPostre.isEmpty()) {
            orden.getPostres().eliminarPostre(nomPostre);
        } else {
            JOptionPane.showMessageDialog(null, "Por favor, ingrese el nombre del postre a eliminar.");
        }
    }//GEN-LAST:event_EliminarActionPerformed

    private void volverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverActionPerformed
        // volver al menú
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
            java.util.logging.Logger.getLogger(EliminarPostCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EliminarPostCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EliminarPostCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EliminarPostCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
//                new EliminarPostCliente().setVisible(true); -----Preguntar al profe
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Eliminar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTable tabla;
    private javax.swing.JButton volver;
    // End of variables declaration//GEN-END:variables
}
