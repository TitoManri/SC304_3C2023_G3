package Ordenes;

import javax.swing.JOptionPane;
import java.time.LocalDateTime;

/**
 *
 * @author marip
 */
public class OrdenLes {

    private NodoLes inicio;
    //private Cliente cli = new Cliente();

    public OrdenLes() {
        this.inicio = null;
    }

    public boolean esVaciaLes() {
        if (inicio == null) {
            return true;
        } else {
            return false;
        }
    }

    public void agregar() {
        Orden nuevaOrden = new Orden();
        nuevaOrden.setNumOrden(0);

        NodoLes nuevo = new NodoLes();
        nuevo.setOrden(nuevaOrden);

        if (esVaciaLes()) {
            inicio = nuevo;
        } else {
            inicio.setSiguiente(nuevo);
        }

    }

//        public void buscarPorFecha(int año, int mes, int dia) { //esta iría en orden
//        // Buscar órdenes por fecha (ejemplo: 9 de noviembre de 2023)
//        LocalDateTime fechaBusqueda = LocalDateTime.of(año, mes, dia, 0, 0);
//        for (Orden orden : ordenes) {
//            if (orden.getFechaHora.toLocalDate().equals(fechaBusqueda.toLocalDate())) {
//                JOptionPane.showMessageDialog(null,"Orden #" + orden.numOrden + " realizada el " + orden.fechaHora);
//            } else {
//                JOptionPane.showMessageDialog(null, "No se registraron ventas en esa fecha.");
//            }
//        }
//    } 
}
