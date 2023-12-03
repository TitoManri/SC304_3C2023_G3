package Transacciones;

import Orden.Orden;
import Personas.Cliente;
import java.io.*;
import java.time.LocalDateTime;
import javax.swing.JOptionPane;


/**
 *
 * @author marip
 */
public class Arbol {

    private NodoArb raiz;

    public Arbol(){
        this.raiz = null;
    }

    private boolean esVacia() {
        if (raiz == null) {
            return true;
        } else {
            return false;
        }
    }
    
    public void agregarAArbol(Orden orden){
        Transaccion t = new Transaccion();   
        t.setFechaHora(orden.getFechaHora());
        t.setNombreCliente(orden.getCliente().getNombre() + orden.getCliente().getApellidos());
        t.setMontoPagar(orden.getTotal());
        
        NodoArb nuevo = new NodoArb();
        nuevo.setTransaccion(t);
        
        if (esVacia()) {
            raiz = nuevo;
        } else {
            agregarNuevo(raiz, nuevo);
        }
    }
    
    public void agregarNuevo(NodoArb raiz, NodoArb nuevo){
        if (nuevo.getTransaccion().getMontoPagar() <= raiz.getTransaccion().getMontoPagar()) {
            if (raiz.getEnlaceIzq() == null) {
                raiz.setEnlaceIzq(nuevo);
            } else {
                agregarNuevo(raiz.getEnlaceIzq(), nuevo);
            }
        } else {
            if (raiz.getEnlaceDer() == null) {
                raiz.setEnlaceDer(nuevo);
            } else {
                agregarNuevo(raiz.getEnlaceDer(), nuevo);
            }
        }
    }
    
    public void guardarTransaccionArchivo(LocalDateTime fechaHora, Cliente cliente, double total) {
        try {
            DataOutputStream archivo = new DataOutputStream(new FileOutputStream("Ordenes.txt", true));

            String fechaHoraA = fechaHora.toString();
            String clientenomA = cliente.getNombre() + " " + cliente.getApellidos();
            double totalA = total;

            archivo.writeUTF(fechaHoraA);
            archivo.writeUTF(clientenomA);
            archivo.writeDouble(totalA);
            //JOptionPane.showMessageDialog(null, "Datos guardados correctamente!", "Agregar Datos", JOptionPane.INFORMATION_MESSAGE);
            archivo.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al agregar los datos: " + e.getMessage(), "Error!",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
