package Transacciones;

import Orden.Orden;


/**
 *
 * @author marip
 */
public class Arbol {

    private NodoArb raiz;

    public Arbol(){
        this.raiz = null;
    }

    private boolean esVacia() {
        if (raiz == null) {
            return true;
        } else {
            return false;
        }
    }
    
    public void agregarAArbol(Orden orden){
        Transaccion t = new Transaccion();   
        t.setFechaHora(orden.getFechaHora());
        t.setNombreCliente(orden.getCliente().getNombre() + orden.getCliente().getApellido());
        t.setMontoPagar(orden.getTotal());
        
        NodoArb nuevo = new NodoArb();
        nuevo.setTransaccion(t);
        
        if (esVacia()) {
            raiz = nuevo;
        } else {
            agregarNuevo(raiz, nuevo);
        }
    }
    
    public void agregarNuevo(NodoArb raiz, NodoArb nuevo){
        if (nuevo.getTransaccion().getMontoPagar() <= raiz.getTransaccion().getMontoPagar()) {
            if (raiz.getEnlaceIzq() == null) {
                raiz.setEnlaceIzq(nuevo);
            } else {
                agregarNuevo(raiz.getEnlaceIzq(), nuevo);
            }
        } else {
            if (raiz.getEnlaceDer() == null) {
                raiz.setEnlaceDer(nuevo);
            } else {
                agregarNuevo(raiz.getEnlaceDer(), nuevo);
            }
        }
    }
}
