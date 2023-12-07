package Interfaz.Administrador.Cajas;

import Interfaz.Administrador.PaginaInicio;
import Transacciones.Arbol;
import Transacciones.NodoArb;
import Transacciones.Transaccion;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author marip
 */
public class Caja extends javax.swing.JFrame {

    DefaultTableModel model;
    private Arbol arbol = new Arbol();

    private static final String rutaTr = "SC304_3C2023_G3/src/main/java/BaseDeDatos/Transaccion.txt";
    String rutaArchivoTr = System.getProperty("user.dir") + "/" + rutaTr;

    NodoArb raiz;

    public Caja() {
        initComponents();
        model = new DefaultTableModel(new Object[]{"Fecha", "Clientes atendidos", "Ganancias diarias"}, 0);
        tablaFacturas.setModel(model);
        cargarDesdeArchivo();
        llenarTablaDesdeArbol();
    }

    private void cargarDesdeArchivo() {
        try (BufferedReader archivo = new BufferedReader(new FileReader(rutaArchivoTr))) {
            String linea;
            while ((linea = archivo.readLine()) != null) {
                procesarLineaTransaccion(linea);
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al cargar el archivo de orden: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    //Cargar Tabla y Actualizar Tabla
    private void procesarLineaTransaccion(String linea) {
        String[] partes = linea.split(",");
        if (partes.length == 2) {
            String nombreCliente = partes[0];
            String totalOrden = partes[1];
            String fechaTransaccion = partes[2];

            LocalDateTime fecha = StringAFecha(fechaTransaccion);
            double total = Double.parseDouble(totalOrden);

            Transaccion transaccion = new Transaccion(fecha, nombreCliente, total);
            agregarTransaccion(transaccion);

        } else {
            System.out.println("Error en el formato de línea de orden: " + linea);
        }
    }

    private LocalDateTime StringAFecha(String fechaHoraString) {
        LocalDateTime fechaFinal = null;
        DateTimeFormatter fecha = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        try {
            fechaFinal = LocalDateTime.parse(fechaHoraString, fecha);
        } catch (Exception e) {
            System.out.println("Error al convertir el String a LocalDateTime: " + e.getMessage());
        }
        return fechaFinal;
    }

    private void agregarTransaccion(Transaccion transaccion) {
        arbol.agregar(transaccion);
    }
    
    public void llenarTablaDesdeArbol() {
        DefaultTableModel model = (DefaultTableModel) tablaFacturas.getModel();
        model.setRowCount(0); 

        llenarTablaDesdeArbolRecursivo(arbol.getRaiz(), model);
    }

    

    private void llenarTablaDesdeArbolRecursivo(NodoArb aux, DefaultTableModel model) {
        if (aux != null) {
            llenarTablaDesdeArbolRecursivo(aux.getEnlaceIzq(), model);

            Transaccion transaccion = aux.getTransaccion();

            Object[] fila = {transaccion.getFechaHora(), transaccion.getNombreCliente(), transaccion.getMontoPagar()};
            model.addRow(fila);

            llenarTablaDesdeArbolRecursivo(aux.getEnlaceDer(), model);
        }
    }
    
    private void limpiarCampos(){
        diaText.setText("");
        mesText.setText("");
        añoText.setText("");
    }
    
    private void limpiarTabla(){
         int filas = model.getRowCount();
        for (int i = 0; i < filas; i++) {
            model.removeRow(0);
        }
    }
    
    private void buscarPorFecha(int año, Month mes){
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        volver = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaFacturas = new javax.swing.JTable();
        añoText = new javax.swing.JTextField();
        mesText = new javax.swing.JTextField();
        diaText = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tablaFacturas);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 70, -1, -1));
        getContentPane().add(añoText, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 210, 190, -1));
        getContentPane().add(mesText, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 180, 190, -1));
        getContentPane().add(diaText, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 150, 190, -1));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 51));
        jLabel1.setText("Mes");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 180, -1, -1));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 51));
        jLabel2.setText("Año");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 210, -1, -1));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 51));
        jLabel3.setText("Día");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 150, -1, -1));

        jButton1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 0, 51));
        jButton1.setText("Limpiar campos");
        jButton1.setContentAreaFilled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 380, -1, -1));

        jButton2.setBorderPainted(false);
        jButton2.setContentAreaFilled(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 420, 180, 60));

        jButton3.setBorderPainted(false);
        jButton3.setContentAreaFilled(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 420, 180, 60));

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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        limpiarCampos();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       limpiarTabla();
       llenarTablaDesdeArbol();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        limpiarTabla();
    }//GEN-LAST:event_jButton2ActionPerformed

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
    private javax.swing.JTextField añoText;
    private javax.swing.JTextField diaText;
    private javax.swing.JLabel fondo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField mesText;
    private javax.swing.JTable tablaFacturas;
    private javax.swing.JButton volver;
    // End of variables declaration//GEN-END:variables
}
