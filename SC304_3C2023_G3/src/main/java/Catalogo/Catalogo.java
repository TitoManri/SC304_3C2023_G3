package Catalogo;

public class Catalogo {
    protected String nombreC;
    protected String descripcion;
    protected double precio;
    protected String categoria;

    public Catalogo() {
        this.nombreC = "";
        this.descripcion = "";
        this.precio = 0.00;
        this.categoria = "";
    }

    public String getNombreC() {
        return nombreC;
    }

    public void setNombreC(String nombreC) {
        this.nombreC = nombreC;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}