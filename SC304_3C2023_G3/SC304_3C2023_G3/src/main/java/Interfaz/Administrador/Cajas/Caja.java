package Interfaz.Administrador.Cajas;

import Interfaz.Administrador.PaginaInicio;
import Transacciones.Arbol;
import Transacciones.NodoArb;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author marip
 */
public class Caja extends javax.swing.JFrame {

    DefaultTableModel model;
    private Arbol arbol = new Arbol();
    private double gananciaTotal = 0.0;
    private String fechaBusquedaActual = null;


    private static final String rutaTr = "SC304_3C2023_G3/src/main/java/BaseDeDatos/Transaccion.txt";
    String rutaArchivoTr = System.getProperty("user.dir") + "/" + rutaTr;

    NodoArb raiz;

    public Caja() {
        initComponents();   
        model = new DefaultTableModel(new Object[]{ "Cliente","Fecha", "Ganancia"}, 0);
        tablaFacturas.setModel(model);
        cargarDesdeArchivo();
        actualizarGananciaTotal();
    }

   private void cargarDesdeArchivo() {
        try (BufferedReader archivo = new BufferedReader(new FileReader(rutaArchivoTr))) {
            String linea;
            while ((linea = archivo.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length == 3) {
                    String cliente = partes[0];
                    String gananciaStr = partes[1];
                    String fechaStr = partes[2];

                    try {
                        LocalDate fecha = LocalDate.parse(fechaStr, DateTimeFormatter.ofPattern("MM-dd-yyyy"));
                        double ganancia = Double.parseDouble(gananciaStr);

                        // Agregar a la tabla
                        model.addRow(new Object[]{cliente, fechaStr, ganancia});
                        gananciaTotal += ganancia; // Actualizar la ganancia total
                    } catch (DateTimeParseException | NumberFormatException e) {
                        // Manejar errores de formato de fecha o ganancia
                        System.err.println("Error al procesar la línea: " + linea);
                    }
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al cargar el archivo de transacciones: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
   
   private void actualizarGananciaTotal() {
        totalText.setText(String.valueOf(gananciaTotal));
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        volver = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaFacturas = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        buscarBoton = new javax.swing.JButton();
        verTodo = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        totalText = new javax.swing.JTextField();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setForeground(new java.awt.Color(171, 171, 171));
        jLabel1.setText("DD/MM/YY");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(65, 200, -1, -1));
        jLabel1.getAccessibleContext().setAccessibleDescription("");

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 220, 270, -1));

        volver.setBorderPainted(false);
        volver.setContentAreaFilled(false);
        volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverActionPerformed(evt);
            }
        });
        getContentPane().add(volver, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 500, 190, 60));

        tablaFacturas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Clientes", "Fecha", "Ganancias"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaFacturas);
        if (tablaFacturas.getColumnModel().getColumnCount() > 0) {
            tablaFacturas.getColumnModel().getColumn(0).setResizable(false);
            tablaFacturas.getColumnModel().getColumn(1).setResizable(false);
            tablaFacturas.getColumnModel().getColumn(2).setResizable(false);
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 70, -1, -1));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 51));
        jLabel3.setText("Total diario");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 530, -1, -1));

        buscarBoton.setBorderPainted(false);
        buscarBoton.setContentAreaFilled(false);
        buscarBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarBotonActionPerformed(evt);
            }
        });
        getContentPane().add(buscarBoton, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 420, 180, 60));

        verTodo.setBorderPainted(false);
        verTodo.setContentAreaFilled(false);
        verTodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verTodoActionPerformed(evt);
            }
        });
        getContentPane().add(verTodo, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 420, 180, 60));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 51));
        jLabel4.setText("Agregar Fecha ");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 160, -1, -1));

        totalText.setEditable(false);
        getContentPane().add(totalText, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 520, 190, 40));

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Facturacion1.jpg"))); // NOI18N
        getContentPane().add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void volverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverActionPerformed
        PaginaInicio x = new PaginaInicio();
        x.setVisible(true);
        x.pack();
        x.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_volverActionPerformed

    private void verTodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verTodoActionPerformed
    }//GEN-LAST:event_verTodoActionPerformed

    private void buscarBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarBotonActionPerformed
     String fechaBusquedaStr = jTextField1.getText().trim();
        model.setRowCount(0);

        try {
            LocalDate fechaBusqueda = LocalDate.parse(fechaBusquedaStr, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
            System.out.println("Fecha buscada: " + fechaBusqueda);

            // Reiniciar la ganancia total para la nueva búsqueda
            gananciaTotal = 0.0;
            fechaBusquedaActual = fechaBusquedaStr;

            try (BufferedReader archivo = new BufferedReader(new FileReader(rutaArchivoTr))) {
                String linea;
                while ((linea = archivo.readLine()) != null) {
                    String[] partes = linea.split(",");
                    if (partes.length == 3) {
                        String cliente = partes[0];
                        String gananciaStr = partes[1];
                        String fechaStr = partes[2];

                        LocalDate fecha = LocalDate.parse(fechaStr, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
                        System.out.println("Fecha en archivo: " + fecha);

                        if (fecha.equals(fechaBusqueda)) {
                            double ganancia = Double.parseDouble(gananciaStr);
                            model.addRow(new Object[]{cliente, fechaStr, ganancia});
                            gananciaTotal += ganancia; // Actualizar la ganancia total de la fecha actual
                        }
                    }
                }
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Error al cargar el archivo de transacciones: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (DateTimeParseException e) {
            System.err.println("Error al parsear la fecha: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al parsear la fecha: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        actualizarGananciaTotal();
    }//GEN-LAST:event_buscarBotonActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    
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
            java.util.logging.Logger.getLogger(Caja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Caja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Caja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Caja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Caja().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buscarBoton;
    private javax.swing.JLabel fondo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTable tablaFacturas;
    private javax.swing.JTextField totalText;
    private javax.swing.JButton verTodo;
    private javax.swing.JButton volver;
    // End of variables declaration//GEN-END:variables
}
