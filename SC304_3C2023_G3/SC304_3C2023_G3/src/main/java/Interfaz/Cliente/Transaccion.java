package Interfaz.Cliente;

import Interfaz.Cliente.Ordenes.MenuComidas;
import Interfaz.Cliente.Ordenes.NodoProducto;
import Interfaz.Cliente.Ordenes.Producto;
import java.io.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 * Clase Transaccion: Clase para confirmar todas las ordenes
 */
public class Transaccion extends javax.swing.JFrame {

    DefaultTableModel model;

    private static final String ruta = "SC304_3C2023_G3/src/main/java/BaseDeDatos/Orden.txt";
    String rutaArchivo = System.getProperty("user.dir") + "/" + ruta;
    private NodoProducto inicioProductos;

    //archivo transacciones
    private static final String rutaTr = "SC304_3C2023_G3/src/main/java/BaseDeDatos/Transaccion.txt";
    String rutaArchivoTr = System.getProperty("user.dir") + "/" + rutaTr;

    public Transaccion() {
        initComponents();
        model = new DefaultTableModel(new Object[]{"Nombre", "Precio"}, 0);
        tabla.setModel(model);
        cargarOrdenDesdeArchivo(rutaArchivo);
        setResizable(false);
        this.setLocationRelativeTo(null);
    }

    //Metodos Iniciales
    private void cargarOrdenDesdeArchivo(String rutaArchivo) {
        try (BufferedReader archivo = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = archivo.readLine()) != null) {
                procesarLineaOrden(linea);
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al cargar el archivo de orden: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    //Cargar Tabla y Actualizar Tabla
    private void procesarLineaOrden(String linea) {
        String[] partes = linea.split(",");
        if (partes.length == 2) {
            String nombreProducto = partes[0];
            String precioProducto = partes[1];
            Producto producto = new Producto(nombreProducto, precioProducto);
            agregarProductoATransaccion(producto);
        } else {
            System.out.println("Error en el formato de línea de orden: " + linea);
        }
    }

    public void agregarProductoATransaccion(Producto producto) {
        agregarProducto(producto);
    }

    private void agregarProducto(Producto producto) {
        NodoProducto nuevoNodo = new NodoProducto(producto);

        if (inicioProductos == null) {
            inicioProductos = nuevoNodo;
        } else {
            NodoProducto aux = inicioProductos;
            while (aux.getSiguiente() != null) {
                aux = aux.getSiguiente();
            }
            aux.setSiguiente(nuevoNodo);
        }

        actualizarTabla();
    }

    private void actualizarTabla() {
        model.setRowCount(0);
        NodoProducto aux = inicioProductos;
        while (aux != null) {
            Producto producto = aux.getProducto();
            model.addRow(new Object[]{producto.getNombre(), producto.getPrecio()});
            aux = aux.getSiguiente();
        }
    }

    private String obtenerFecha() {
        LocalDateTime fechaHoraActual = LocalDateTime.now();
        DateTimeFormatter formatoFechaHora = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String fechaFormateada = fechaHoraActual.format(formatoFechaHora);
        return fechaFormateada;
    }

    private void transaccionAArchivo(String clienteNom, double total) {
        String fecha = obtenerFecha();
        try {
            try (FileWriter fileWriter = new FileWriter(rutaArchivoTr, true); PrintWriter printWriter = new PrintWriter(fileWriter)) {
                printWriter.println(clienteNom + "," + total + "," + fecha);
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al guardar en el archivo Transaccion.txt: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private double calcularTotal() {
        double total = 0.0;

        try (BufferedReader archivo = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = archivo.readLine()) != null) {
                total += obtenerPrecioDeLineaOrden(linea);
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al calcular el total: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        return total;
    }

    private double obtenerPrecioDeLineaOrden(String linea) {
        String[] partes = linea.split(",");
        if (partes.length == 2) {
            try {
                return Double.parseDouble(partes[1].trim());
            } catch (NumberFormatException e) {
                System.out.println("Error al convertir el precio a double: " + e.getMessage());
            }
        }
        return 0.0;
    }

    private String clienteNom() {
        SignIn si = new SignIn();
        String nombreCliente = si.buscarUsuarioEnArchivo(LogIn.getUsuarioActual());
        return nombreCliente;
    }
    
    private void registrarTransaccion(){
        String cliente = clienteNom();
        double total = calcularTotal();
        if (!cliente.equals("") && total != 0.0) {
            fechaText.setText(obtenerFecha());
            clienteText.setText(cliente);
            totalText.setText(Double.toString(total));
            transaccionAArchivo(cliente, total);
            JOptionPane.showMessageDialog(null, "Transacción registrada correctamente", "Éxito!", JOptionPane.INFORMATION_MESSAGE);
        } else {
          JOptionPane.showMessageDialog(null, "Error al registrar cliente o total en la transacción.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void limpiarArchivoOrden() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaArchivo))) {
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al limpiar el archivo de orden: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        fechaText = new javax.swing.JTextField();
        clienteText = new javax.swing.JTextField();
        totalText = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        volver = new javax.swing.JButton();
        pagarOrden = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(0, 0, 51));
        jLabel1.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 51));
        jLabel1.setText("Cliente");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 280, 80, 20));

        fechaText.setEditable(false);
        fechaText.setBackground(new java.awt.Color(204, 204, 204));
        fechaText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fechaTextActionPerformed(evt);
            }
        });
        getContentPane().add(fechaText, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 240, 220, -1));

        clienteText.setEditable(false);
        clienteText.setBackground(new java.awt.Color(204, 204, 204));
        clienteText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clienteTextActionPerformed(evt);
            }
        });
        getContentPane().add(clienteText, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 320, 220, -1));

        totalText.setEditable(false);
        totalText.setBackground(new java.awt.Color(204, 204, 204));
        totalText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totalTextActionPerformed(evt);
            }
        });
        getContentPane().add(totalText, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 400, 220, -1));

        jLabel2.setBackground(new java.awt.Color(0, 0, 51));
        jLabel2.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 51));
        jLabel2.setText("Confirmación");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 230, 180, -1));

        jLabel3.setBackground(new java.awt.Color(0, 0, 51));
        jLabel3.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 51));
        jLabel3.setText("Total");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 360, 90, 20));

        jLabel4.setBackground(new java.awt.Color(0, 0, 51));
        jLabel4.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 51));
        jLabel4.setText("Fecha ");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 210, 70, 20));

        jLabel5.setBackground(new java.awt.Color(0, 0, 51));
        jLabel5.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 51));
        jLabel5.setText("Detalles de la transacción");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 160, 340, 20));

        jLabel6.setBackground(new java.awt.Color(0, 0, 51));
        jLabel6.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 51));
        jLabel6.setText("Lista de la Orden");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 150, 210, 20));

        volver.setBackground(new java.awt.Color(0, 0, 102));
        volver.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        volver.setForeground(new java.awt.Color(255, 255, 255));
        volver.setText("Volver a Menu Orden");
        volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverActionPerformed(evt);
            }
        });
        getContentPane().add(volver, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 520, 300, 50));

        pagarOrden.setBackground(new java.awt.Color(0, 0, 102));
        pagarOrden.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        pagarOrden.setForeground(new java.awt.Color(255, 255, 255));
        pagarOrden.setText("Pagar Orden");
        pagarOrden.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pagarOrdenActionPerformed(evt);
            }
        });
        getContentPane().add(pagarOrden, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 280, 200, 50));

        tabla.setBackground(new java.awt.Color(102, 102, 102));
        tabla.setFont(tabla.getFont().deriveFont(tabla.getFont().getSize()+3f));
        tabla.setForeground(new java.awt.Color(255, 255, 255));
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
        tabla.setGridColor(new java.awt.Color(204, 204, 204));
        tabla.setSelectionBackground(new java.awt.Color(153, 153, 153));
        tabla.setSelectionForeground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(tabla);
        if (tabla.getColumnModel().getColumnCount() > 0) {
            tabla.getColumnModel().getColumn(0).setResizable(false);
            tabla.getColumnModel().getColumn(1).setResizable(false);
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 190, 260, 270));

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Facturacion.jpg"))); // NOI18N
        getContentPane().add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fechaTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fechaTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fechaTextActionPerformed

    private void clienteTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clienteTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_clienteTextActionPerformed

    private void totalTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totalTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_totalTextActionPerformed

    //Boton para pagar orden
    private void pagarOrdenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pagarOrdenActionPerformed
        registrarTransaccion();
        limpiarArchivoOrden();
    }//GEN-LAST:event_pagarOrdenActionPerformed
    //Boton para volver a Menu Comidas
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
            java.util.logging.Logger.getLogger(Transaccion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Transaccion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Transaccion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Transaccion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Transaccion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField clienteText;
    private javax.swing.JTextField fechaText;
    private javax.swing.JLabel fondo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton pagarOrden;
    private javax.swing.JTable tabla;
    private javax.swing.JTextField totalText;
    private javax.swing.JButton volver;
    // End of variables declaration//GEN-END:variables
}
