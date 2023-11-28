package Orden;

import Catalogo.Bebidas.Bebida;

/**
 *
 * @author marip
 */
public class nodoBebidas {

    private Bebida bebida;
    private nodoBebidas siguiente;

    public nodoBebidas() {
        this.siguiente = null;
    }

    public Bebida getBebida() {
        return bebida;
    }

    public void setBebida(Bebida bebida) {
        this.bebida = bebida;
    }

    public nodoBebidas getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(nodoBebidas siguiente) {
        this.siguiente = siguiente;
    }
}
