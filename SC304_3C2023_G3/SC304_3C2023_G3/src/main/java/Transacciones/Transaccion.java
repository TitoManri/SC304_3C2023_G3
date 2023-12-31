package Transacciones;

import java.time.LocalDateTime;

/**
 *
 * @author marip
 */
public class Transaccion {

    private LocalDateTime fechaHora;
    private String nombreCliente;
    private double montoPagar;

    public Transaccion(String nombreCliente1, double total, LocalDateTime fecha) {
        this.fechaHora = null;
        this.montoPagar = 0.0;
        this.nombreCliente = "";
    }

    public Transaccion(LocalDateTime fechaHora, String nombreCliente, double montoPagar) {
        this.fechaHora = fechaHora;
        this.nombreCliente = nombreCliente;
        this.montoPagar = montoPagar;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public double getMontoPagar() {
        return montoPagar;
    }

    public void setMontoPagar(double montoPagar) {
        this.montoPagar = montoPagar;
    }

}
