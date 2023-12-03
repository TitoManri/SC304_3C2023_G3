package Interfaz.Cliente.Ordenes;

import Catalogo.Bebidas.Bebida;
import Catalogo.Nodos.NodoBebida;
import Orden.Orden;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author marip
 */
public class AgregarBebCliente extends javax.swing.JFrame {
    private static final String ruta = "SC304_3C2023_G3/src/main/java/BaseDeDatos/CatalogoBebidas.txt";
    String RUTA_ARCHIVO = System.getProperty("user.dir") + "/" + ruta; 
    NodoBebida inicioBebida;
    NodoBebida finBebida;
    DefaultTableModel tab = new DefaultTableModel();
    
    public AgregarBebCliente() {
        initComponents();
        setResizable(false);
        this.setLocationRelativeTo(null);
        String[] titulo = new String[]{"Nombre", "Categoría", "Precio"};
        tab.setColumnIdentifiers(titulo);
        tabla.setModel(tab);
        cargarDesdeArchivo();
        llenarTabla();
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
    private javax.swing.JTable tabla;
    private javax.swing.JButton volver;
    // End of variables declaration//GEN-END:variables
}
