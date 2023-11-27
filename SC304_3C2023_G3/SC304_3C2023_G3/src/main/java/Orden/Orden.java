package Orden;

/*
 
 */

import Catalogo.Bebidas.Bebida;
import Catalogo.Platillo.Platillo;
import Catalogo.Postres.Postre;
import Personas.Cliente;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Orden {

    //ATRIBUTOS
    private static int contadorOrdenes = 100;
    private int numOrden;
    private LocalDateTime fechaHora;
    private Cliente cliente;
    private double total;
    private List<Platillo> platillos;
    private List<Bebida> bebidas;
    private List<Postre> postres;

    //CONSTRUCTOR
    public Orden(){
        this.cliente = null;
        this.fechaHora = LocalDateTime.now();
        this.numOrden = ++contadorOrdenes;
        this.total = 0.0;
        this.platillos = new ArrayList<>();
        this.bebidas = new ArrayList<>();
        this.postres = new ArrayList<>();
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

    public List<Platillo> getPlatillos() {
        return platillos;
    }

    public List<Bebida> getBebidas() {
        return bebidas;
    }

    public List<Postre> getPostres() {
        return postres;
    }

    public void agregarPlatillo(Platillo platillo, Orden orden) {
        orden.platillos.add(platillo);
    }

    public void agregarBebida(Bebida bebida, Orden orden) {
        orden.bebidas.add(bebida);
    }

    public void agregarPostre(Postre postre, Orden orden) {
        orden.postres.add(postre);
    }

    public double totalOrden(Orden orden) {
        double totalTransaccion = 0;
        if (!orden.platillos.isEmpty()) {
            for (Platillo platillo : orden.platillos) {
                totalTransaccion += Double.parseDouble(platillo.getPrecio());
            }
        }
        if (!orden.bebidas.isEmpty()) {
            for (Bebida bebida : orden.bebidas) {
                totalTransaccion += Double.parseDouble(bebida.getPrecio());
            }
        }
        if (!orden.postres.isEmpty()) {
            for (Postre postre : orden.postres) {
                totalTransaccion += Double.parseDouble(postre.getPrecio());
            }
        }
        return totalTransaccion;
    }
}
