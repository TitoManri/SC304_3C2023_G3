/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Catalogo.Nodos;

import Catalogo.Postres.Postre;

/**
 *
 * @author manri
 */
public class NodoPostre {
    Postre postre;
    NodoPostre anterior;
    NodoPostre siguiente;

    public NodoPostre() {
        this.siguiente = null;
        this.anterior = null;
    }

    public Postre getPostre() {
        return postre;
    }

    public void setPostre(Postre postre) {
        this.postre = postre;
    }

    public NodoPostre getAnterior() {
        return anterior;
    }

    public void setAnterior(NodoPostre anterior) {
        this.anterior = anterior;
    }

    public NodoPostre getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoPostre siguiente) {
        this.siguiente = siguiente;
    }
    
    
}
