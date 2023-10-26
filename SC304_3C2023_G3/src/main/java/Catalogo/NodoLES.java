package Catalogo;
import Catalogo.Bebidas.Bebidas;

public class NodoLES {
    private Catalogo dato;
    private NodoLES siguiente;
    
    public NodoLES() {
        this.siguiente = null;
    }

    public Catalogo getDato() {
        return dato;
    }

    public void setDato(Catalogo dato) {
        this.dato = dato;
    }

    public NodoLES getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoLES siguiente) {
        this.siguiente = siguiente;
    }
}
