package Personas;

import Personas.Cliente;

/**
 *
 */
public class NodoCliente {

    private Cliente elementoC;
    private NodoCliente siguiente;

    public NodoCliente() {
        this.siguiente = null; 
    }

    public Cliente getElementoC() {
        return elementoC;
    }

    public void setElementoC(Cliente elementoC) {
        this.elementoC = elementoC;
    }


    public NodoCliente getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoCliente siguiente) {
        this.siguiente = siguiente;
    }
}
