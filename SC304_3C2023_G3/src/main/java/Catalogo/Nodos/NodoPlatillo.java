/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Catalogo.Nodos;

import Catalogo.Platillo.Platillo;

/**
 *
 * @author manri
 */
public class NodoPlatillo {
    Platillo platillo;
    NodoPlatillo siguiente;

    public NodoPlatillo() {
        this.siguiente = null;
    }

    public Platillo getPlatillo() {
        return platillo;
    }

    public void setPlatillo(Platillo platillo) {
        this.platillo = platillo;
    }

    public NodoPlatillo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoPlatillo siguiente) {
        this.siguiente = siguiente;
    }
    
    
}
