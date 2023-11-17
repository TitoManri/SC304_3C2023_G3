package Orden;

/*

 */
public class NodoOrden {
    private Orden orden;
    private NodoOrden siguiente;
    
    public NodoOrden(){
        this.siguiente = null;
    }

    public Orden getOrden() {
        return orden;
    }

    public void setOrden(Orden orden) {
        this.orden = orden;
    }

    public NodoOrden getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoOrden siguiente) {
        this.siguiente = siguiente;
    }
}
