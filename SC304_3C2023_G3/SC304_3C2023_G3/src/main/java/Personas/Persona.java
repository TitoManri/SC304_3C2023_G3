package Personas;



/**
 * Agregue una confirmacion de contrasena
 */
public class Persona {

    //ATRIBUTOS 
    protected String nombre;
    protected String apellido;
    protected String nickname;
    protected String passsword;
    protected String confirmarPassword; 
    protected boolean estado;

    //CONSTRUCTOR
    public Persona() {
        this.nombre = "";
        this.apellido = "";
        this.nickname = "";
        this.passsword = "";
        this.estado = false;
    }

}