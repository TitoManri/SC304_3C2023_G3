
/**
 *
 */
public class Nodo {

    private Cliente elementoC;
    private Empleado elementoE;
    private Nodo siguiente;

    public Nodo() {
        this.siguiente = null; 
    }

    public Cliente getElementoC() {
        return elementoC;
    }

    public void setElementoC(Cliente elementoC) {
        this.elementoC = elementoC;
    }

    public Empleado getElementoE() {
        return elementoE;
    }

    public void setElementoE(Empleado elementoE) {
        this.elementoE = elementoE;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }
}
