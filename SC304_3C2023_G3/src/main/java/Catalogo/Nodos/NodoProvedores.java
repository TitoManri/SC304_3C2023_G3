/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Catalogo.Nodos;

import Catalogo.Provedores.Provedores;

/**
 *
 * @author manri
 */
public class NodoProvedores {
    
    Provedores provedores;
    NodoProvedores siguiente;

    public NodoProvedores() {
        this.siguiente = null;
    }

    public Provedores getProvedores() {
        return provedores;
    }

    public void setProvedores(Provedores provedores) {
        this.provedores = provedores;
    }

    public NodoProvedores getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoProvedores siguiente) {
        this.siguiente = siguiente;
    }
    
    
}
