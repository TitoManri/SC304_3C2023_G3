package Orden;

import Catalogo.Platillo.Platillo;
import javax.swing.JOptionPane;

/**
 *
 * @author marip
 */
public class platillosLes {

    private nodoPlatillos inicio;
    private double totalPlatillos;

    public platillosLes() {
        this.inicio = null;
    }

    public boolean esVaciaPlatillos() {
        if (inicio == null) {
            return true;
        } else {
            return false;
        }
    }

    public void agregarPlatillo(String nomPlatillo) {
        Platillo platillo = buscarPlatillo(nomPlatillo);
        if (platillo == null) {
            JOptionPane.showMessageDialog(null, "El platillo ingresado no es válido. Intente de nuevo");
        } else {
            nodoPlatillos nuevo = new nodoPlatillos();
            nuevo.setPlatillo(platillo);

            if (esVaciaPlatillos()) {
                inicio = nuevo;
            } else {
                inicio.setSiguiente(nuevo);
            }
        }
    }

    public void eliminarPlatillo(String nomPlatillo) {
        if (!esVaciaPlatillos()) {
            if (inicio.getPlatillo().getNombre().equals(nomPlatillo)) {
                inicio = inicio.getSiguiente();
                JOptionPane.showMessageDialog(null, "El platillo se eliminó.");
            } else {
                nodoPlatillos anterior = inicio;
                nodoPlatillos auxiliar = inicio.getSiguiente();
                while ((auxiliar != null) && (!auxiliar.getPlatillo().getNombre().equals(anterior))) {
                    anterior = anterior.getSiguiente();
                    auxiliar = auxiliar.getSiguiente();
                }
                if (auxiliar != null) {
                    anterior.setSiguiente(auxiliar.getSiguiente());
                }
            }
        }
    }

    public String mostrarPlatillos() {
        if (!esVaciaPlatillos()) {
            String s = "";
            nodoPlatillos aux = inicio;
            while (aux != null) {
                s = s + aux.getPlatillo().getNombre() + " -- " + aux.getPlatillo().getDescripcion() + " -- " + aux.getPlatillo().getCategoria() + "--" + aux.getPlatillo().getPrecio() + ", ";
                aux = aux.getSiguiente();
            }
            return "Platillo(s): \n" + s;
        } else {
            return "No hay platillos para mostrar";
        }
    }

    public double totalPlatillos() {
        if (!esVaciaPlatillos()) {
            nodoPlatillos aux = inicio;
            while (aux != null) {
                totalPlatillos += Double.parseDouble(aux.getPlatillo().getPrecio());
                aux = aux.getSiguiente();
            }
        }
        return totalPlatillos;
    }

    public Platillo buscarPlatillo(String nom) {
        Platillo platillo = null;
        nodoPlatillos aux = inicio;
        while (aux != null) {
            if (aux.getPlatillo().getNombre().equals(nom)) {
                platillo = aux.getPlatillo();
            }
        }
        return platillo;
    }

    public double getTotalPlatillos() {
        return totalPlatillos;
    }

    public void setTotalPlatillos(double totalPlatillos) {
        this.totalPlatillos = totalPlatillos;
    }

    public nodoPlatillos getInicio() {
        return inicio;
    }

    public void setInicio(nodoPlatillos inicio) {
        this.inicio = inicio;
    }

}
