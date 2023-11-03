/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Catalogo.Nodos;

import Catalogo.Bebidas.Bebida;

/**
 *
 * Lista Circular SImple
 */
public class NodoBebida {
    Bebida bebida;
    NodoBebida siguiente;

    public NodoBebida() {
        this.siguiente = null;
    }

    public Bebida getBebida() {
        return bebida;
    }

    public void setBebida(Bebida bebida) {
        this.bebida = bebida;
    }

    public NodoBebida getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoBebida siguiente) {
        this.siguiente = siguiente;
    }
    
    
}
