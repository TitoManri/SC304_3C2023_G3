package Transacciones;

/**
 *
 * @author marip
 */
public class NodoArb {

    private Transaccion transaccion;
    private NodoArb enlaceIzq;
    private NodoArb enlaceDer;

    public NodoArb() {
        this.transaccion = null;
        this.enlaceIzq = null;
        this.enlaceDer = null;
    }

    public Transaccion getTransaccion() {
        return transaccion;
    }

    public void setTransaccion(Transaccion transaccion) {
        this.transaccion = transaccion;
    }

    public NodoArb getEnlaceIzq() {
        return enlaceIzq;
    }

    public void setEnlaceIzq(NodoArb enlaceIzq) {
        this.enlaceIzq = enlaceIzq;
    }

    public NodoArb getEnlaceDer() {
        return enlaceDer;
    }

    public void setEnlaceDer(NodoArb enlaceDer) {
        this.enlaceDer = enlaceDer;
    }
}
