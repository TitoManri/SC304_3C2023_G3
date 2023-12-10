package Interfaz.Cliente.Ordenes;

import Catalogo.Nodos.NodoPostre;
import Catalogo.Postres.Postre;
import java.io.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *Clase AgregarPostCliente: Esta clase funciona para agregar postres dentro del Catalogo Postress en una orden como cliente
 */
public class AgregarPostCliente extends javax.swing.JFrame {
    NodoPostre inicioPostre;
    NodoPostre finPostre;
    
    //Ruta Catalogo Postres
    private static final String ruta = "SC304_3C2023_G3/src/main/java/BaseDeDatos/CatalogoPostres.txt";
    String RUTA_ARCHIVO_POSTRES = System.getProperty("user.dir") + "/" + ruta;
    //Ruta Orden
    private static final String rutao = "SC304_3C2023_G3/src/main/java/BaseDeDatos/Orden.txt";
    String rutaArchivoOrden = System.getProperty("user.dir") + "/" + rutao; 
    
    DefaultTableModel tab = new DefaultTableModel();
    
    public AgregarPostCliente() {
        initComponents();
        setResizable(false);
        this.setLocationRelativeTo(null);
        String[] titulo = new String[]{"Nombre", "Descripción", "Categoría", "Precio"};
        tab.setColumnIdentifiers(titulo);
        tabla.setModel(tab);
        llenarTabla();
        cargarDesdeArchivo();
    }
    
    //Metodos Iniciales
    
     private void cargarDesdeArchivo() {
        try (BufferedReader archivo = new BufferedReader(new FileReader(RUTA_ARCHIVO_POSTRES))) {
            String linea;
            while ((linea = archivo.readLine()) != null) {
                Postre postre = partesPostre(linea);
                if (postre != null) {
                    finPostre = agregarNodo(finPostre, postre);
                    if (inicioPostre == null) {
                        inicioPostre = finPostre;
                    }
                }
            }

            if (finPostre != null) {
                llenarTabla();
            }

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al cargar el archivo: " + e.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
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
                    model.addRow(new Object[] { postre.getNombre(), postre.getDescripcion(), postre.getCategoria(),
                            postre.getPrecio() });
                }
            } else {
                break;
            }
            aux = aux.getSiguiente();
        } while (aux != inicioPostre);
    }
    
   
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        postNomText = new javax.swing.JTextField();
        AgregarPost = new javax.swing.JButton();
        volver = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
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
        volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverActionPerformed(evt);
            }
        });
        getContentPane().add(volver, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 480, 170, 50));

        tabla.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tabla);
        if (tabla.getColumnModel().getColumnCount() > 0) {
            tabla.getColumnModel().getColumn(0).setResizable(false);
            tabla.getColumnModel().getColumn(1).setResizable(false);
            tabla.getColumnModel().getColumn(2).setResizable(false);
            tabla.getColumnModel().getColumn(3).setResizable(false);
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 110, -1, -1));

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AgregPostrCliente.jpg"))); // NOI18N
        getContentPane().add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 600));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Boton para Agregar Postre
    private void AgregarPostActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgregarPostActionPerformed
    String nombrePostre = postNomText.getText();

    if (!postreExisteEnCatalogo(nombrePostre)) {
        JOptionPane.showMessageDialog(this, "El postre ya existe en el catálogo.", "Error", JOptionPane.ERROR_MESSAGE);
    } else {
        Postre postre = obtenerPostrePorNombre(nombrePostre);

        if (postre != null) {
            guardarOrden(postre.getNombre(), postre.getPrecio());

            postNomText.setText("");
            JOptionPane.showMessageDialog(this, "Postre agregado a la orden.");
        } else {
            JOptionPane.showMessageDialog(this, "El postre no existe en el catálogo.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    }//GEN-LAST:event_AgregarPostActionPerformed
    
    //Metodos para agregar el postre
    private boolean postreExisteEnCatalogo(String nombrePostre) {
        NodoPostre aux = inicioPostre;
        while (aux != null) {
            if (aux.getPostre().getNombre().equalsIgnoreCase(nombrePostre)) {
                return true;
            }
            aux = aux.getSiguiente();
        }
        return false;
    }
    
    
    private Postre obtenerPostrePorNombre(String nombrePostre) {
           NodoPostre aux = inicioPostre;

           do {
               if (aux != null) {
                   Postre postre = aux.getPostre();
                   if (postre != null && postre.getNombre().equalsIgnoreCase(nombrePostre)) {
                       return postre;
                   }
               } else {
                   break;
               }
               aux = aux.getSiguiente();
           } while (aux != inicioPostre);

           return null;
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
    
    //Volver a Menu Comidas
    private void volverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverActionPerformed
        MenuComidas x = new MenuComidas();
            x.setVisible(true);
            x.pack();
            x.setLocationRelativeTo(null); 
            this.dispose();
    }//GEN-LAST:event_volverActionPerformed
   
    //Metodo para guardar la orden
    private void guardarOrden(String nombre, String precio) {
        try {
            try (FileWriter fileWriter = new FileWriter(rutaArchivoOrden, true);
                    PrintWriter printWriter = new PrintWriter(fileWriter)) {
                printWriter.println(nombre + "," + precio);
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al guardar en el archivo Orden.txt: " + e.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

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
    private javax.swing.JTable tabla;
    private javax.swing.JButton volver;
    // End of variables declaration//GEN-END:variables
}
