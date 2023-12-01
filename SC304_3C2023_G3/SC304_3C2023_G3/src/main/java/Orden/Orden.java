package Orden;

/*
 
 */
import Personas.Cliente;
import java.time.LocalDateTime;


public class Orden {

    //ATRIBUTOS
    private static int contadorOrdenes = 100;
    private int numOrden;
    private LocalDateTime fechaHora;
    private Cliente cliente;
    private double total;
    private platillosLes platillos;
    private bebidasLes bebidas;
    private postresLes postres;

    //CONSTRUCTOR
    public Orden(){
        this.cliente = null;
        this.fechaHora = LocalDateTime.now();
        this.numOrden = ++contadorOrdenes;
        this.total = 0.0;
        this.platillos = null;
        this.bebidas = null;
        this.postres = null;
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

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public platillosLes getPlatillos() {
        return platillos;
    }

    public void setPlatillos(platillosLes platillos) {
        this.platillos = platillos;
    }

    public bebidasLes getBebidas() {
        return bebidas;
    }

    public void setBebidas(bebidasLes bebidas) {
        this.bebidas = bebidas;
    }

    public postresLes getPostres() {
        return postres;
    }

    public void setPostres(postresLes postres) {
        this.postres = postres;
    }
    
}