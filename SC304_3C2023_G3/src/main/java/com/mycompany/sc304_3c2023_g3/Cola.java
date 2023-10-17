package com.mycompany.sc304_3c2023_g3;

import javax.swing.JOptionPane;

/**
 *
 */

public class Cola {

    private Nodo inicio;
    private Nodo fin;

    public Cola() {
        this.inicio = null;
        this.fin = null;
    }

    public boolean esVacia() {
        if (inicio == null) {
            return true;
        } else {
            return false;
        }
    }

    public void encolarCliente() {
        Cliente c = new Cliente();

        c.setNombre(JOptionPane.showInputDialog("Ingrese el nombre del usuario: ")); 
        c.setApellido(JOptionPane.showInputDialog("Ingrese el apellido del usuario: "));
        c.setNickname(JOptionPane.showInputDialog("Ingrese un nombre de usuario: "));
        c.setPasssword(JOptionPane.showInputDialog("Ingrese la contraseña: "));
        c.setEstado(true);
        
        Nodo nuevo = new Nodo();
        nuevo.setElementoC(c);

        if (esVacia()) {
            inicio = nuevo;
            fin = nuevo;
        } else {
            fin.setSiguiente(nuevo);
            fin = nuevo;
        }
    }
    
    public void encolarEmpleado() {
        Empleado e = new Empleado();

        e.setNombre(JOptionPane.showInputDialog("Ingrese el nombre del usuario: ")); 
        e.setApellido(JOptionPane.showInputDialog("Ingrese el apellido del usuario: "));
        e.setNickname(JOptionPane.showInputDialog("Ingrese un nombre de usuario: "));
        e.setPasssword(JOptionPane.showInputDialog("Ingrese la contraseña: "));
        e.setEstado(true);
        
        Nodo nuevo = new Nodo();
        nuevo.setElementoE(e);

        if (esVacia()) {
            inicio = nuevo;
            fin = nuevo;
        } else {
            fin.setSiguiente(nuevo);
            fin = nuevo;
        }
    }
}
