package Orden;

import Catalogo.Postres.Postre;

/**
 *
 * @author marip
 */
public class nodoPostres {

    private Postre postre;
    private nodoPostres siguiente;

    public nodoPostres() {
        this.siguiente = null;
    }

    public Postre getPostre() {
        return postre;
    }

    public void setPostre(Postre postre) {
        this.postre = postre;
    }

    public nodoPostres getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(nodoPostres siguiente) {
        this.siguiente = siguiente;
    }
}
