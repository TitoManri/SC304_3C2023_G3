package Orden;

//revisar agregarbebidas, platillos etc
//falta calcular los totales despues de modificar una orden
//CLIENTE
import Personas.Cliente;
//OTROS
import javax.swing.JOptionPane;
import java.io.*;

public class LesOrden {

    private NodoOrden inicio;

    public LesOrden() {
        this.inicio = null;
    }

    public boolean esVaciaLes() {
        return inicio == null;
    }

    public Orden agregarOrden(Cliente cliente) {
        Orden nuevaOrden = new Orden();
        double total = 0;
        nuevaOrden.setCliente(cliente);
        platillosLes nuevoPlatillo = new platillosLes();
        nuevaOrden.setPlatillos(nuevoPlatillo);
        bebidasLes nuevaBebida = new bebidasLes();
        nuevaOrden.setBebidas(nuevaBebida);
        postresLes postres = new postresLes();
        nuevaOrden.setPostres(postres);
        nuevaOrden.setTotal(total);
        
        NodoOrden nuevo = new NodoOrden();
        nuevo.setOrden(nuevaOrden);

        if (esVaciaLes()) {
            inicio = nuevo;
        } else {
            inicio.setSiguiente(nuevo);
        }
        return nuevaOrden;
    }

    public void mostrarOrdenes() {
        if (!esVaciaLes()) {
            String s = "";
            NodoOrden aux = inicio;
            while (aux != null) {
                s = s + "Cliente: " + aux.getOrden().getCliente().getNombre() + aux.getOrden().getCliente().getApellidos() + "\n"
                        + "Fecha y hora: " + aux.getOrden().getFechaHora() + "\n"
                        + "Número de orden:" + aux.getOrden().getNumOrden() + "\n"
                        + "Platillos: " + aux.getOrden().getPlatillos().mostrarPlatillos() + "\n"
                        + "Bebidas: " + aux.getOrden().getBebidas().mostrarBebidas() + "\n"
                        + "Postres: " + aux.getOrden().getPostres().mostrarPostres() + "\n"
                        + "Total: " + aux.getOrden().getTotal() + "-->";
                aux = aux.getSiguiente();
            }
            JOptionPane.showMessageDialog(null, "La lista contiene: \n" + s);
        } else {
            JOptionPane.showMessageDialog(null, "No se puede mostrar la lista, está vacía");
        }
    }

    public double calcularTotal(Orden orden) {
        double total = orden.getPlatillos().getTotalPlatillos() + orden.getBebidas().getTotalBebidas() + orden.getPostres().getTotalPostres();
        return total;
    }

    public Orden encontrarOrden(int numeroOrden) {
        NodoOrden aux = inicio;

        while (aux != null) {
            if (aux.getOrden().getNumOrden() == numeroOrden) {
                return aux.getOrden();
            }
            aux = aux.getSiguiente();
        }
        return null;
    }

    //Le falta la interfaz
    public void cancelarOrden(int numeroOrden) {
        NodoOrden anterior = null;
        NodoOrden actual = inicio;

        while (actual != null && actual.getOrden().getNumOrden() != numeroOrden) {
            anterior = actual;
            actual = actual.getSiguiente();
        }

        //CAMBIAR EL ARCHIVO Y REVISAR
        if (actual != null) {
            try (DataOutputStream outputStream = new DataOutputStream(new FileOutputStream("aaaa.txt", true))) {
                outputStream.writeUTF("Fecha y hora: " + actual.getOrden().getFechaHora() + "\n");
                outputStream.writeUTF("Cliente: " + actual.getOrden().getCliente().getNombre() + " " + actual.getOrden().getCliente().getApellidos() + "\n");
                outputStream.writeDouble(actual.getOrden().getTotal());

                JOptionPane.showMessageDialog(null, "Orden cancelada correctamente.");
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Error al guardar la información de la orden.");
            }

            if (anterior != null) {
                anterior.setSiguiente(actual.getSiguiente());
            } else {
                inicio = actual.getSiguiente();
            }
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró una orden con el número especificado.");
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
