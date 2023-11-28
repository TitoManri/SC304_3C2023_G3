package Orden;

import Catalogo.Postres.Postre;
import javax.swing.JOptionPane;

/**
 *
 * @author marip
 */
public class postresLes {

    private nodoPostres inicio;
    private double totalPostres;

    public postresLes() {
        this.inicio = null;
    }

    public boolean esVaciaPostres() {
        if (inicio == null) {
            return true;
        } else {
            return false;
        }
    }

    public void agregarPostre(String nomPostre) {
        Postre postre = buscarPostre(nomPostre);
        if (postre == null) {
            JOptionPane.showMessageDialog(null, "El postre ingresado no es válido. Intente de nuevo");
        } else {
            nodoPostres nuevo = new nodoPostres();
            nuevo.setPostre(postre);

            if (esVaciaPostres()) {
                inicio = nuevo;
            } else {
                inicio.setSiguiente(nuevo);
            }
        }
    }

    public void eliminarPostre(String nomPostre) {
        if (!esVaciaPostres()) {
            if (inicio.getPostre().getNombre().equals(nomPostre)) {
                inicio = inicio.getSiguiente();
                JOptionPane.showMessageDialog(null, "El postre se eliminó.");
            } else {
                nodoPostres anterior = inicio;
                nodoPostres auxiliar = inicio.getSiguiente();
                while ((auxiliar != null) && (!auxiliar.getPostre().getNombre().equals(anterior))) {
                    anterior = anterior.getSiguiente();
                    auxiliar = auxiliar.getSiguiente();
                }
                if (auxiliar != null) {
                    anterior.setSiguiente(auxiliar.getSiguiente());
                }
            }
        }
    }

    public String mostrarPostres() {
        if (!esVaciaPostres()) {
            String s = "";
            nodoPostres aux = inicio;
            while (aux != null) {
                s = s + aux.getPostre().getNombre() + " -- " + aux.getPostre().getDescripcion() + " -- " + aux.getPostre().getCategoria() + "--" + aux.getPostre().getPrecio() + ", ";
                aux = aux.getSiguiente();
            }
            return "Postre(s): \n" + s;
        } else {
            return "No hay postres para mostrar";
        }
    }

    public double totalPostres() {
        if (!esVaciaPostres()) {
            nodoPostres aux = inicio;
            while (aux != null) {
                totalPostres += Double.parseDouble(aux.getPostre().getPrecio());
                aux = aux.getSiguiente();
            }
        }
        return totalPostres;
    }

    public Postre buscarPostre(String nom) {
        Postre postre = null;
        nodoPostres aux = inicio;
        while (aux != null) {
            if (aux.getPostre().getNombre().equals(nom)) {
                postre = aux.getPostre();
            }
        }
        return postre;
    }

    public double getTotalPostres() {
        return totalPostres;
    }

    public void setTotalPostres(double totalPostres) {
        this.totalPostres = totalPostres;
    }

    public nodoPostres getInicio() {
        return inicio;
    }

    public void setInicio(nodoPostres inicio) {
        this.inicio = inicio;
    }

}
