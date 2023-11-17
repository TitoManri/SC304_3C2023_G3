package Orden;

/*
 
 */

import Catalogo.Bebidas.Bebida;
import Catalogo.Platillo.Platillo;
import Catalogo.Postres.Postre;
import Personas.Cliente;
import java.time.LocalDateTime;

public class Orden {

    //ATRIBUTOS
    private int numOrden;
    private LocalDateTime fechaHora;
    private Cliente cliente;
    private double total;
    private Platillo platillo;
    private Bebida bebida;
    private Postre postre;

    //CONSTRUCTOR
    public Orden(){
        this.cliente = null;
        this.fechaHora = LocalDateTime.now();
        this.numOrden = 100;
        numOrden++;
        this.total = 0.0;
        this.platillo = null;
        this.bebida = null;
        this.postre = null;
    }

    
    //GETTERS Y SETTERS
    public int getNumOrden() {
        return numOrden;
    }

    public void setNumOrden(int numOrden) {
        this.numOrden = numOrden;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Platillo getPlatillo() {
        return platillo;
    }

    public void setPlatillo(Platillo platillo) {
        this.platillo = platillo;
    }

    public Bebida getBebida() {
        return bebida;
    }

    public void setBebida(Bebida bebida) {
        this.bebida = bebida;
    }

    public Postre getPostre() {
        return postre;
    }

    public void setPostre(Postre postre) {
        this.postre = postre;
    }


    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
}
