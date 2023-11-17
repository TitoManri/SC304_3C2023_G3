package Ordenes;

/**
 *
 * @author marip
 */
public class NodoLes {

    private Orden orden;
    private NodoLes siguiente;

    public NodoLes() {
        this.siguiente = null;
    }

    public Orden getOrden() {
        return orden;
    }

    public void setOrden(Orden orden) {
        this.orden = orden;
    }

    public NodoLes getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoLes siguiente) {
        this.siguiente = siguiente;
    }
}
