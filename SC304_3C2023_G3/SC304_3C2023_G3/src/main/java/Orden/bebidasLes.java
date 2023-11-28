package Orden;

import Catalogo.Bebidas.Bebida;
import javax.swing.JOptionPane;

/**
 *
 * @author marip
 */
public class bebidasLes {

    private nodoBebidas inicio;
    private double totalBebidas;

    public bebidasLes() {
        this.inicio = null;
    }

    public boolean esVaciaBebidas() {
        if (inicio == null) {
            return true;
        } else {
            return false;
        }
    }

    public void agregarBebida(String nomBebida) {
        Bebida bebida = buscarBebida(nomBebida);
        if (bebida == null) {
            JOptionPane.showMessageDialog(null, "La bebida ingresada no es válida. Intente de nuevo");
        } else {
            nodoBebidas nuevo = new nodoBebidas();
            nuevo.setBebida(bebida);

            if (esVaciaBebidas()) {
                inicio = nuevo;
            } else {
                inicio.setSiguiente(nuevo);
            }
        }
    }

    public void eliminarBebida(String nomBebida) {
        if (!esVaciaBebidas()) {
            if (inicio.getBebida().getNombre().equals(nomBebida)) {
                inicio = inicio.getSiguiente();
                JOptionPane.showMessageDialog(null, "La bebida se eliminó.");
            } else {
                nodoBebidas anterior = inicio;
                nodoBebidas auxiliar = inicio.getSiguiente();
                while ((auxiliar != null) && (!auxiliar.getBebida().getNombre().equals(anterior))) {
                    anterior = anterior.getSiguiente();
                    auxiliar = auxiliar.getSiguiente();
                }
                if (auxiliar != null) {
                    anterior.setSiguiente(auxiliar.getSiguiente());
                }
            }
        }
    }

    public String mostrarBebidas() {
        if (!esVaciaBebidas()) {
            String s = "";
            nodoBebidas aux = inicio;
            while (aux != null) {
                s = s + aux.getBebida().getNombre() + " -- " + aux.getBebida().getCategoria() + "--" + aux.getBebida().getPrecio() + ", ";
                aux = aux.getSiguiente();
            }
            return "Bebida(s): \n" + s;
        } else {
            return "No hay bebidas para mostrar";
        }
    }

    public double totalPostres() {
        if (!esVaciaBebidas()) {
            nodoBebidas aux = inicio;
            while (aux != null) {
                totalBebidas += Double.parseDouble(aux.getBebida().getPrecio());
                aux = aux.getSiguiente();
            }
        }
        return totalBebidas;
    }

    public Bebida buscarBebida(String nom) {
        Bebida bebida = null;
        nodoBebidas aux = inicio;
        while (aux != null) {
            if (aux.getBebida().getNombre().equals(nom)) {
                bebida = aux.getBebida();
            }
        }
        return bebida;
    }

    public double getTotalBebidas() {
        return totalBebidas;
    }

    public void setTotalBebidas(double totalBebidas) {
        this.totalBebidas = totalBebidas;
    }

    public nodoBebidas getInicio() {
        return inicio;
    }

    public void setInicio(nodoBebidas inicio) {
        this.inicio = inicio;
    }

}
