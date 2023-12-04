package Catalogo.Bebidas;
/**
 * Todo lo necesario para una bebida
 */
public class Bebida {
    private String nombre;
    private String categoria;
    private String precio;

    public Bebida(String nombre, String categoria, String precio) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getPrecio() {
        return precio;
    }
}

