package Personas;

/**
 *
 */
public class Cliente {
    private String nombre;
    private String apellidos;
    private String nombreUsuario;
    private String contrasena;
    private String confirmarContrasena; 
    private boolean estado;
    //CONSTRUCTOR

    public Cliente(String nombre, String apellidos, String nombreUsuario, String contrasena, String confirmarContrasena, boolean estado) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
        this.confirmarContrasena = confirmarContrasena;
        this.estado = estado;
    }
    

    //GETTER Y SETTERS

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getConfirmarContrasena() {
        return confirmarContrasena;
    }

    public void setConfirmarContrasena(String confirmarContrasena) {
        this.confirmarContrasena = confirmarContrasena;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

}