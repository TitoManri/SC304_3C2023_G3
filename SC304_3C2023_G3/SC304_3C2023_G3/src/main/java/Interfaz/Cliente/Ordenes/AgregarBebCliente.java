package Interfaz.Cliente.Ordenes;

import Catalogo.Bebidas.Bebida;
import Catalogo.Nodos.NodoBebida;
import java.io.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *Clase AgregarBebCliente: Esta clase funciona para agregar bebidas dentro del Catalogo Bebidas en una orden como cliente
 * 
 */
public class AgregarBebCliente extends javax.swing.JFrame {
    
    //Ruta Catalogo Bebidas
    private static final String ruta = "SC304_3C2023_G3/src/main/java/BaseDeDatos/CatalogoBebidas.txt";
    String RUTA_ARCHIVO = System.getProperty("user.dir") + "/" + ruta;
    //Ruta Orden
    private static final String rutao = "SC304_3C2023_G3/src/main/java/BaseDeDatos/Orden.txt";
    String rutaArchivoOrden = System.getProperty("user.dir") + "/" + rutao; 
    
    NodoBebida inicioBebida;
    NodoBebida finBebida;
    
    DefaultTableModel tab = new DefaultTableModel();
    
    public AgregarBebCliente() {
        initComponents();
        setResizable(false);
        setLocationRelativeTo(null);
        String[] titulo = new String[]{"Nombre", "Categoría", "Precio"};
        tab.setColumnIdentifiers(titulo);
        tabla.setModel(tab);
        cargarDesdeArchivo();
        llenarTabla();
    }
    

    //Metodos Iniciales
    
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

    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nombreBebText = new javax.swing.JTextField();
        agregarBeb = new javax.swing.JButton();
        volver = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
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

        tabla.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tabla);
        if (tabla.getColumnModel().getColumnCount() > 0) {
            tabla.getColumnModel().getColumn(0).setResizable(false);
            tabla.getColumnModel().getColumn(1).setResizable(false);
            tabla.getColumnModel().getColumn(2).setResizable(false);
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 100, -1, 430));

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AgregarBebCliente.jpg"))); // NOI18N
        getContentPane().add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 600));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    //Boton para agregar la bebida a la orden
    private void agregarBebActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarBebActionPerformed

    String nombreBebida = nombreBebText.getText();

    if (bebidaExisteEnCatalogo(nombreBebida)) {
        Bebida bebida = obtenerBebidaPorNombre(nombreBebida);
        guardarOrden(bebida.getNombre(), bebida.getPrecio());

        nombreBebText.setText("");
        JOptionPane.showMessageDialog(this, "Bebida agregada a la orden.");
    } else {
        JOptionPane.showMessageDialog(this, "La bebida no existe en el catálogo.", "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_agregarBebActionPerformed
    
    //Metodos para agregar la bebida a la orden
    
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
    private Bebida obtenerBebidaPorNombre(String nombreBebida) {
        NodoBebida aux = inicioBebida;

        do {
            if (aux != null) {
                Bebida bebida = aux.getBebida();
                if (bebida != null && bebida.getNombre().equalsIgnoreCase(nombreBebida)) {
                    return bebida;
                }
            } else {
                break;
            }
            aux = aux.getSiguiente();
        } while (aux != inicioBebida);

        return null;
    }
    
    private boolean bebidaExisteEnCatalogo(String nombreBebida){
        NodoBebida aux = inicioBebida;
        do {
            if (aux != null) {
                Bebida bebida = aux.getBebida();
                if (bebida != null && bebida.getNombre().equalsIgnoreCase(nombreBebida)) {
                    return true;
                }
            } else {
                break;
            }
            aux = aux.getSiguiente();
        } while (aux != inicioBebida);

        return false;
    }

    private void guardarOrden(String nombre, String precio) {
    try {
        try (FileWriter fileWriter = new FileWriter(rutaArchivoOrden, true);
             PrintWriter printWriter = new PrintWriter(fileWriter)) {
            printWriter.println(nombre + "," + precio);
        }
    } catch (IOException e) {
        JOptionPane.showMessageDialog(null, "Error al guardar en el archivo Orden.txt: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
}

    //Boton para volver al Menu Comidas
    private void volverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverActionPerformed
        MenuComidas x = new MenuComidas();
            x.setVisible(true);
            x.pack();
            x.setLocationRelativeTo(null); 
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
            AgregarBebCliente agregarBebCliente = new AgregarBebCliente();
                agregarBebCliente.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agregarBeb;
    private javax.swing.JLabel fondo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nombreBebText;
    private javax.swing.JTable tabla;
    private javax.swing.JButton volver;
    // End of variables declaration//GEN-END:variables
}
