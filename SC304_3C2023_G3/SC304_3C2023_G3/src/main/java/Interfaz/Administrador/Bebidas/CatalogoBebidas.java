/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interfaz.Administrador.Bebidas;
import Catalogo.Bebidas.Bebida;
import Catalogo.Nodos.NodoBebida;
import Interfaz.Administrador.PaginaInicio;
import java.awt.HeadlessException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.ButtonModel;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;
import javax.swing.table.DefaultTableModel;

/**
 * Clase CatalogoBebidas: sirve para guardar toda la informacion nueva sobre una bebida que quiera implementar el administrador 
 */
public class CatalogoBebidas extends javax.swing.JFrame {
    NodoBebida inicioBebida;
    NodoBebida finBebida;
    //Ruta archivo Catalogo Bebidas
    private static final String ruta = "SC304_3C2023_G3/src/main/java/BaseDeDatos/CatalogoBebidas.txt";
    String RUTA_ARCHIVO = System.getProperty("user.dir") + "/" + ruta;  
    
    public CatalogoBebidas() {
        initComponents();
        inicioBebida = null; 
        finBebida = null; 
        cargarDesdeArchivo();
        otrasBebidasRadioButton.setActionCommand("Otras Bebidas");
        jugosNaturalesRadioButton.setActionCommand("Jugos Naturales");
        gaseosasRadioButton.setActionCommand("Gaseosas");
        licoresRadioButton.setActionCommand("Licores");
        llenarTabla();
    }

    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        nombreBebidaTexto = new javax.swing.JTextField();
        precioBebida = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        otrasBebidasRadioButton = new javax.swing.JRadioButton();
        jugosNaturalesRadioButton = new javax.swing.JRadioButton();
        gaseosasRadioButton = new javax.swing.JRadioButton();
        licoresRadioButton = new javax.swing.JRadioButton();
        limpiar = new javax.swing.JButton();
        agregarBebida = new javax.swing.JButton();
        editarBebida = new javax.swing.JButton();
        volverPantallaPrincipal = new javax.swing.JButton();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        nombreBebidaTexto.setBackground(new java.awt.Color(7, 0, 63));
        nombreBebidaTexto.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        nombreBebidaTexto.setForeground(new java.awt.Color(255, 255, 255));
        nombreBebidaTexto.setBorder(null);
        nombreBebidaTexto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreBebidaTextoActionPerformed(evt);
            }
        });
        getContentPane().add(nombreBebidaTexto, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 230, 340, 30));

        precioBebida.setBackground(new java.awt.Color(7, 0, 63));
        precioBebida.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        precioBebida.setForeground(new java.awt.Color(255, 255, 255));
        precioBebida.setBorder(null);
        precioBebida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                precioBebidaActionPerformed(evt);
            }
        });
        getContentPane().add(precioBebida, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 400, 130, 20));

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Nombre ", "Categoria", "Precio"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabla);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 100, 430, -1));

        buttonGroup1.add(otrasBebidasRadioButton);
        otrasBebidasRadioButton.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        otrasBebidasRadioButton.setForeground(new java.awt.Color(0, 0, 0));
        otrasBebidasRadioButton.setText("Otras Bebidas");
        otrasBebidasRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                otrasBebidasRadioButtonActionPerformed(evt);
            }
        });
        getContentPane().add(otrasBebidasRadioButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 350, -1, -1));

        buttonGroup1.add(jugosNaturalesRadioButton);
        jugosNaturalesRadioButton.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        jugosNaturalesRadioButton.setForeground(new java.awt.Color(0, 0, 0));
        jugosNaturalesRadioButton.setText("Jugos Naturales");
        jugosNaturalesRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jugosNaturalesRadioButtonActionPerformed(evt);
            }
        });
        getContentPane().add(jugosNaturalesRadioButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 320, -1, -1));

        buttonGroup1.add(gaseosasRadioButton);
        gaseosasRadioButton.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        gaseosasRadioButton.setForeground(new java.awt.Color(0, 0, 0));
        gaseosasRadioButton.setText("Gaseosas");
        gaseosasRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gaseosasRadioButtonActionPerformed(evt);
            }
        });
        getContentPane().add(gaseosasRadioButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, -1, -1));

        buttonGroup1.add(licoresRadioButton);
        licoresRadioButton.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        licoresRadioButton.setForeground(new java.awt.Color(0, 0, 0));
        licoresRadioButton.setText("Licores");
        licoresRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                licoresRadioButtonActionPerformed(evt);
            }
        });
        getContentPane().add(licoresRadioButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, -1, -1));

        limpiar.setBackground(new java.awt.Color(7, 0, 63));
        limpiar.setFont(new java.awt.Font("Helvetica Neue", 1, 16)); // NOI18N
        limpiar.setForeground(new java.awt.Color(255, 255, 255));
        limpiar.setText("Limpiar");
        limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limpiarActionPerformed(evt);
            }
        });
        getContentPane().add(limpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 460, 160, 40));

        agregarBebida.setBackground(new java.awt.Color(7, 0, 63));
        agregarBebida.setFont(new java.awt.Font("Helvetica Neue", 1, 16)); // NOI18N
        agregarBebida.setForeground(new java.awt.Color(255, 255, 255));
        agregarBebida.setText("Agregar Bebida");
        agregarBebida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarBebidaActionPerformed(evt);
            }
        });
        getContentPane().add(agregarBebida, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 460, 160, 40));

        editarBebida.setBackground(new java.awt.Color(7, 0, 63));
        editarBebida.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        editarBebida.setForeground(new java.awt.Color(255, 255, 255));
        editarBebida.setText("Editar Bebida");
        editarBebida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarBebidaActionPerformed(evt);
            }
        });
        getContentPane().add(editarBebida, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 530, 150, 50));

        volverPantallaPrincipal.setBackground(new java.awt.Color(7, 0, 63));
        volverPantallaPrincipal.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        volverPantallaPrincipal.setForeground(new java.awt.Color(255, 255, 255));
        volverPantallaPrincipal.setText("Volver a la pantalla principal");
        volverPantallaPrincipal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverPantallaPrincipalActionPerformed(evt);
            }
        });
        getContentPane().add(volverPantallaPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 540, 300, 40));

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AgregarYEditarBebidas.png"))); // NOI18N
        getContentPane().add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jugosNaturalesRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jugosNaturalesRadioButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jugosNaturalesRadioButtonActionPerformed

    private void otrasBebidasRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_otrasBebidasRadioButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_otrasBebidasRadioButtonActionPerformed

    private void licoresRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_licoresRadioButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_licoresRadioButtonActionPerformed

    private void limpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limpiarActionPerformed
        nombreBebidaTexto.setText("");
        precioBebida.setText("");
    }//GEN-LAST:event_limpiarActionPerformed

    private void nombreBebidaTextoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreBebidaTextoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombreBebidaTextoActionPerformed

    private void gaseosasRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gaseosasRadioButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_gaseosasRadioButtonActionPerformed

    private void precioBebidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_precioBebidaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_precioBebidaActionPerformed
  
  //Metodos Iniciales  
    public NodoBebida getInicioBebida() {
        return inicioBebida;
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

        public boolean esVaciaBebidas(){
            return inicioBebida==null&&finBebida==null;
    }
        
    //Metodos para Agregar Bebida    

    private void agregarBebidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarBebidaActionPerformed
    ButtonModel botonesRadioButton = buttonGroup1.getSelection();
    if (botonesRadioButton == null) {
        JOptionPane.showMessageDialog(null, "Debe seleccionar una categoría de bebida.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    String nombreBebida = nombreBebidaTexto.getText();
    String categoria = botonesRadioButton.getActionCommand();
    String precio = precioBebida.getText();

    if (nombreBebida.isEmpty() || precio.isEmpty() || categoria.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Alguno de los campos requeridos no fue completado.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
        @Override
        protected Void doInBackground() throws Exception {
            agregarBebidaInBackground(nombreBebida, categoria, precio);
            return null;
        }

        @Override
        protected void done() {
            
        }
    };

    worker.execute();
    }//GEN-LAST:event_agregarBebidaActionPerformed
    

    private void agregarBebidaInBackground(String nombreBebida, String categoria, String precio) {
        try {
            if (nombreBebida.isEmpty() || categoria.isEmpty() || precio.isEmpty()) {
                mostrarError("Alguno de los campos requeridos no fue completado.");
                return;
            }

            if (bebidaYaExiste(nombreBebida)) {
                mostrarError("Ya existe una bebida con el mismo nombre.");
                return;
            }

            Bebida bebida = new Bebida(nombreBebida, categoria, precio);
            NodoBebida nuevoNodo = new NodoBebida();
            nuevoNodo.setBebida(bebida);

            if (finBebida == null) {
                finBebida = nuevoNodo;
                inicioBebida = nuevoNodo;
                nuevoNodo.setSiguiente(nuevoNodo);
            } else {
                nuevoNodo.setSiguiente(finBebida.getSiguiente());
                finBebida.setSiguiente(nuevoNodo);
                finBebida = nuevoNodo;
            }

            guardarListaEnArchivo(inicioBebida);
            llenarTabla();
            nombreBebidaTexto.setText("");
            precioBebida.setText("");
            JOptionPane.showMessageDialog(null, "Bebida agregada correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);

        } catch (NumberFormatException e) {
            mostrarError("Error al convertir el precio a un número.");
        } catch (HeadlessException e) {
            mostrarError("Error al agregar los datos: " + e.getMessage());
        }
    }

    private boolean bebidaYaExiste(String nombre) {
        if (finBebida != null) {
            NodoBebida aux = finBebida.getSiguiente();

            do {
                Bebida bebida = aux.getBebida();
                if (bebida != null && bebida.getNombre().equals(nombre)) {
                    return true; // La bebida ya existe en el catálogo
                }
                aux = aux.getSiguiente();
            } while (aux != finBebida.getSiguiente());
        }

        return false; // La bebida no existe en el catálogo
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
    
    //Metodos Editar Bebidas
    
    private void editarBebidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarBebidaActionPerformed
    try {
        String bebidaNom = JOptionPane.showInputDialog("Ingrese el nombre de la bebida que desea modificar:");

        if (bebidaNom != null) {
            NodoBebida aux = buscarBebida(bebidaNom);

            if (aux != null) {
                Bebida bebidaActual = aux.getBebida();

                String nuevoNom = JOptionPane.showInputDialog("Nuevo nombre de la bebida:", bebidaActual.getNombre());
                String nuevaCateg = JOptionPane.showInputDialog("Nueva categoría de la bebida:", bebidaActual.getCategoria());
                String nuevoPrecio = JOptionPane.showInputDialog("Nuevo precio de la bebida:", bebidaActual.getPrecio());

                if (nuevoNom != null && nuevaCateg != null && nuevoPrecio != null) {
                    Bebida nuevaBebida = new Bebida(nuevoNom, nuevaCateg, nuevoPrecio);

                    aux.setBebida(nuevaBebida);

                    guardarListaEnArchivo(inicioBebida); 
                    llenarTabla();

                    mostrarMensaje("Bebida editada correctamente.");
                } else {
                    mostrarMensaje("No se realizaron cambios en la bebida.");
                }
            } else {
                mostrarError("No se encontró la bebida con el nombre proporcionado.");
            }
        }
    } catch (NumberFormatException | HeadlessException e) {
        mostrarError("Error al editar la bebida: " + e.getMessage());
    }
    }//GEN-LAST:event_editarBebidaActionPerformed
      
    public NodoBebida buscarBebida(String nombreBebida) {
        NodoBebida aux = inicioBebida;
        while (aux != null) {
            if (aux.getBebida().getNombre().equalsIgnoreCase(nombreBebida)) {
                return aux;
            }
            aux = aux.getSiguiente();
        }
        return null;
    }
        
    //Metodos para guardar en el archivo
    
    private void guardarListaEnArchivo(NodoBebida inicio) {
        PrintWriter archivo = null;
        try {
            archivo = new PrintWriter(new FileWriter(RUTA_ARCHIVO));

            NodoBebida aux = inicio;
            do {
                Bebida bebida = aux.getBebida();
                if (bebida != null) {
                    archivo.println(formatoBebida(bebida));
                } 
                aux = aux.getSiguiente();
            } while (aux != inicio);
        } catch (IOException e) {
            mostrarError("Error al guardar en el archivo: " + e.getMessage());
        } finally {
            if (archivo != null) {
                archivo.close();
            }
        }
    }


    
    //Volver al Catalogo Principal
   
    private void volverPantallaPrincipalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverPantallaPrincipalActionPerformed
        PaginaInicio x = new PaginaInicio();
        x.setVisible(true);
        x.pack();
        x.setLocationRelativeTo(null); 
        this.dispose();
    }//GEN-LAST:event_volverPantallaPrincipalActionPerformed
    
    //Metodos para el Archivo    

    private String formatoBebida(Bebida bebida) {
        return bebida.getNombre() + "," + bebida.getCategoria() + "," + bebida.getPrecio();
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
    
    //Metodos para Errores y Mensajes
     
    private void mostrarError(String mensaje) {
        JOptionPane.showMessageDialog(null, "Error: " + mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }

    private void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, "Mensaje", JOptionPane.INFORMATION_MESSAGE);
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
            java.util.logging.Logger.getLogger(CatalogoBebidas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CatalogoBebidas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CatalogoBebidas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CatalogoBebidas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new CatalogoBebidas().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agregarBebida;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton editarBebida;
    private javax.swing.JLabel fondo;
    private javax.swing.JRadioButton gaseosasRadioButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton jugosNaturalesRadioButton;
    private javax.swing.JRadioButton licoresRadioButton;
    private javax.swing.JButton limpiar;
    private javax.swing.JTextField nombreBebidaTexto;
    private javax.swing.JRadioButton otrasBebidasRadioButton;
    private javax.swing.JTextField precioBebida;
    private javax.swing.JTable tabla;
    private javax.swing.JButton volverPantallaPrincipal;
    // End of variables declaration//GEN-END:variables
}
