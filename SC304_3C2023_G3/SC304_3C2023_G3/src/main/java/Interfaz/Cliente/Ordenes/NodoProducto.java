/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaz.Cliente.Ordenes;

/**
 *
 * @author manri
 */
public class NodoProducto {
    private Producto producto;
    private NodoProducto siguiente;

    public NodoProducto(Producto producto) {
        this.producto = producto;
        this.siguiente = null;
    }
    public NodoProducto(){
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
    

    public NodoProducto getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoProducto siguiente) {
        this.siguiente = siguiente;
    } 
}
