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

        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jComboBox3 = new javax.swing.JComboBox<>();
        volver = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaFacturas = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        totalText = new javax.swing.JTextField();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jComboBox1.setBackground(new java.awt.Color(7, 0, 63));
        jComboBox1.setFont(jComboBox1.getFont().deriveFont(jComboBox1.getFont().getSize()+2f));
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre" }));
        getContentPane().add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 190, 210, 30));

        jComboBox2.setBackground(new java.awt.Color(7, 0, 63));
        jComboBox2.setFont(jComboBox2.getFont().deriveFont(jComboBox2.getFont().getSize()+2f));
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        getContentPane().add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 140, 210, 30));

        jComboBox3.setBackground(new java.awt.Color(7, 0, 63));
        jComboBox3.setFont(jComboBox3.getFont().deriveFont(jComboBox3.getFont().getSize()+2f));
        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2020", "2021", "2022", "2023", "2024", "2025" }));
        getContentPane().add(jComboBox3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 240, 210, 30));

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
                "Fecha", "Clientes", "Title 3"
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

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 51));
        jLabel1.setText("Mes");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 190, -1, -1));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 51));
        jLabel2.setText("Año");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 240, -1, -1));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 51));
        jLabel3.setText("Total diario");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 530, -1, -1));

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

        jLabel4.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 51));
        jLabel4.setText("Día");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 140, -1, -1));

        totalText.setEditable(false);
        getContentPane().add(totalText, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 520, 190, 40));

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Facturacion1.jpg"))); // NOI18N
        fondo.setText("07003F");
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
    private javax.swing.JLabel fondo;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaFacturas;
    private javax.swing.JTextField totalText;
    private javax.swing.JButton volver;
    // End of variables declaration//GEN-END:variables
}
