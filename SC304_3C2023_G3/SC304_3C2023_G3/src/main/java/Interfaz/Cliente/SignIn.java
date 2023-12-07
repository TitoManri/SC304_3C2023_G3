/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interfaz.Cliente;

import Personas.Cliente;
import Personas.NodoCliente;
import java.awt.HeadlessException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;

/**
 *
 * @author manri
 */
public class SignIn extends javax.swing.JFrame {

    private static final String ruta = "SC304_3C2023_G3/src/main/java/BaseDeDatos/Usuarios.txt";
    String rutaArchivo = System.getProperty("user.dir") + "/" + ruta;
    private NodoCliente inicio;
    private NodoCliente fin;

    public SignIn() {
        initComponents();
        cargarDesdeArchivo();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nombreTexto = new javax.swing.JTextField();
        apellidosTexto = new javax.swing.JTextField();
        nombreUsuarioTexto = new javax.swing.JTextField();
        contrasenaTexto = new javax.swing.JTextField();
        confirmarContrasenaTexto = new javax.swing.JTextField();
        registroBoton = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        nombreTexto.setBackground(new java.awt.Color(245, 222, 180));
        nombreTexto.setFont(new java.awt.Font("Helvetica Neue", 0, 16)); // NOI18N
        nombreTexto.setForeground(new java.awt.Color(0, 0, 0));
        nombreTexto.setBorder(null);
        nombreTexto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreTextoActionPerformed(evt);
            }
        });
        getContentPane().add(nombreTexto, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 180, 120, 30));

        apellidosTexto.setBackground(new java.awt.Color(245, 222, 180));
        apellidosTexto.setFont(new java.awt.Font("Helvetica Neue", 0, 16)); // NOI18N
        apellidosTexto.setForeground(new java.awt.Color(0, 0, 0));
        apellidosTexto.setBorder(null);
        apellidosTexto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                apellidosTextoActionPerformed(evt);
            }
        });
        getContentPane().add(apellidosTexto, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 180, 200, 30));

        nombreUsuarioTexto.setBackground(new java.awt.Color(245, 222, 180));
        nombreUsuarioTexto.setFont(new java.awt.Font("Helvetica Neue", 0, 16)); // NOI18N
        nombreUsuarioTexto.setForeground(new java.awt.Color(0, 0, 0));
        nombreUsuarioTexto.setBorder(null);
        nombreUsuarioTexto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreUsuarioTextoActionPerformed(evt);
            }
        });
        getContentPane().add(nombreUsuarioTexto, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 270, 370, 30));

        contrasenaTexto.setBackground(new java.awt.Color(245, 222, 180));
        contrasenaTexto.setFont(new java.awt.Font("Helvetica Neue", 0, 16)); // NOI18N
        contrasenaTexto.setForeground(new java.awt.Color(0, 0, 0));
        contrasenaTexto.setBorder(null);
        contrasenaTexto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contrasenaTextoActionPerformed(evt);
            }
        });
        getContentPane().add(contrasenaTexto, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 360, 370, 30));

        confirmarContrasenaTexto.setBackground(new java.awt.Color(245, 222, 180));
        confirmarContrasenaTexto.setFont(new java.awt.Font("Helvetica Neue", 0, 16)); // NOI18N
        confirmarContrasenaTexto.setForeground(new java.awt.Color(0, 0, 0));
        confirmarContrasenaTexto.setBorder(null);
        getContentPane().add(confirmarContrasenaTexto, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 450, 370, 30));

        registroBoton.setBackground(new java.awt.Color(245, 222, 180));
        registroBoton.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        registroBoton.setForeground(new java.awt.Color(0, 0, 0));
        registroBoton.setText("Registrarme");
        registroBoton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        registroBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registroBotonActionPerformed(evt);
            }
        });
        getContentPane().add(registroBoton, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 500, 240, 40));

        jButton2.setBackground(new java.awt.Color(245, 222, 180));
        jButton2.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(0, 0, 0));
        jButton2.setText("Volver a Inicio Sesion");
        jButton2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 550, 190, -1));

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Registro.png"))); // NOI18N
        getContentPane().add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void nombreTextoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreTextoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombreTextoActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        LogIn x = new LogIn();
        x.setVisible(true);
        x.pack();
        x.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void cargarDesdeArchivo() {
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                Cliente clientes = partesCliente(linea);
                if (clientes != null) {
                    encolarCliente(clientes);

                }
            }
        } catch (IOException e) {
            mostrarError("Error al cargar desde el archivo: " + e.getMessage());
        }
    }

    public boolean esVaciaCliente() {
        return inicio == null || fin == null;
    }
    private void registroBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registroBotonActionPerformed
        String nombre = nombreTexto.getText();
        String apellidos = apellidosTexto.getText();
        String nombreUsuario = nombreUsuarioTexto.getText();
        String contrasena = contrasenaTexto.getText();
        String confirmarContrasena = confirmarContrasenaTexto.getText();

        if (nombre.isEmpty() || apellidos.isEmpty() || nombreUsuario.isEmpty() || contrasena.isEmpty() || confirmarContrasena.isEmpty()) {
            mostrarError("Todos los campos son obligatorios.");
            return;
        }

        if (!contrasena.equals(confirmarContrasena)) {
            mostrarError("Las contraseñas no coinciden.");
            return;
        }

        if (contrasena.length() < 8) {
            mostrarError("La contraseña debe tener al menos 8 caracteres.");
            return;
        }

        SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() throws Exception {
                agregarClienteInBackground(nombre, apellidos, nombreUsuario, contrasena, confirmarContrasena);
                return null;
            }

            @Override
            protected void done() {
            }
        };

        worker.execute();
    }//GEN-LAST:event_registroBotonActionPerformed
    private void agregarClienteInBackground(String nombre, String apellidos, String nombreUsuario, String contrasena, String confirmarContrasena) {
        try {
            Cliente cliente = new Cliente(nombre, apellidos, nombreUsuario, contrasena, confirmarContrasena, true);

            if (!clienteYaExiste(cliente.getNombreUsuario())) {
                encolarCliente(cliente);

                guardarEnArchivo();
                JOptionPane.showMessageDialog(null, "Cliente registrado correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            } else {
                mostrarError("El cliente ya existe en la base de datos.");
            }

        } catch (HeadlessException e) {
            mostrarError("Error al agregar los datos del cliente: " + e.getMessage());
        }
    }

    public boolean clienteYaExiste(String nombreUsuario) {
        NodoCliente aux = inicio;
        while (aux != null) {
            if (aux.getElementoC() != null && aux.getElementoC().getNombreUsuario().equalsIgnoreCase(nombreUsuario)) {
                return true;
            }
            aux = aux.getSiguiente();
        }
        return false;
    }

    public void encolarCliente(Cliente cliente) {
        NodoCliente nuevo = new NodoCliente();
        nuevo.setElementoC(cliente);

        if (esVaciaCliente()) {
            inicio = nuevo;
            fin = nuevo;
        } else {
            fin.setSiguiente(nuevo);
            fin = nuevo;
        }
    }

    private Cliente partesCliente(String linea) {
        String[] partes = linea.split(",");

        if (partes.length == 5) {
            String nombre = partes[0].trim();
            String apellidos = partes[1].trim();
            String nombreUsuario = partes[2].trim();
            String contrasena = partes[3].trim();
            String confirmarContrasena = partes[4].trim();

            return new Cliente(nombre, apellidos, nombreUsuario, contrasena, confirmarContrasena, true);
        } else {
            mostrarError("Formato de línea inválido en el archivo de usuarios.");
            return null;
        }
    }

    private void guardarEnArchivo() {
        try (PrintWriter archivo = new PrintWriter(new FileWriter(rutaArchivo))) {
            NodoCliente aux = inicio;
            while (aux != null) {
                Cliente cliente = aux.getElementoC();
                if (cliente != null) {
                    archivo.println(formatoCliente(cliente));
                }
                aux = aux.getSiguiente();
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al guardar en el archivo: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public String buscarUsuarioEnArchivo(String nombreUsuario) {
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                Cliente cliente = partesCliente(linea);
                if (cliente != null && cliente.getNombreUsuario().equals(nombreUsuario)) {
                    return cliente.getNombre() + " " + cliente.getApellidos();
                }
            }
        } catch (IOException e) {
            mostrarError("Error al buscar en el archivo de usuarios: " + e.getMessage());
        }
        return "";
    }

    private String formatoCliente(Cliente cliente) {
        return cliente.getNombre() + "," + cliente.getApellidos() + "," + cliente.getNombreUsuario() + "," + cliente.getContrasena() + "," + cliente.getConfirmarContrasena();
    }

    //Metodos Mensaje y Error
    private void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, "Mensaje", JOptionPane.INFORMATION_MESSAGE);
    }

    private void mostrarError(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }

    private void apellidosTextoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_apellidosTextoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_apellidosTextoActionPerformed

    private void nombreUsuarioTextoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreUsuarioTextoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombreUsuarioTextoActionPerformed

    private void contrasenaTextoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contrasenaTextoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_contrasenaTextoActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(SignIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SignIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SignIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SignIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SignIn().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField apellidosTexto;
    private javax.swing.JTextField confirmarContrasenaTexto;
    private javax.swing.JTextField contrasenaTexto;
    private javax.swing.JLabel fondo;
    private javax.swing.JButton jButton2;
    private javax.swing.JTextField nombreTexto;
    private javax.swing.JTextField nombreUsuarioTexto;
    private javax.swing.JButton registroBoton;
    // End of variables declaration//GEN-END:variables
}
