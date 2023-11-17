package Catalogo.Nodos;

import Catalogo.Bebidas.Bebida;

public class NodoBebida {
    private Bebida bebida;
    private NodoBebida siguiente;

    public NodoBebida() {
        this.siguiente = null;
    }

    public void setBebida(Bebida bebida) {
        this.bebida = bebida;
    }

    public Bebida getBebida() {
        return bebida;
    }

    public NodoBebida getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoBebida siguiente) {
        this.siguiente = siguiente;
    }
}
