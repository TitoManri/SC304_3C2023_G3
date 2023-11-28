package Orden;

import Catalogo.Platillo.Platillo;

/**
 *
 * @author marip
 */
public class nodoPlatillos {

    private Platillo platillo;
    private nodoPlatillos siguiente;

    public nodoPlatillos() {
        this.siguiente = null;
    }

    public Platillo getPlatillo() {
        return platillo;
    }

    public void setPlatillo(Platillo platillo) {
        this.platillo = platillo;
    }

    public nodoPlatillos getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(nodoPlatillos siguiente) {
        this.siguiente = siguiente;
    }
}
