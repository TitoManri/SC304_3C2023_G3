package com.mycompany.sc304_3c2023_g3;

/**
 *
 */
public class Persona {

    //ATRIBUTOS 
    protected String nombre;
    protected String apellido;
    protected String nickname;
    protected String passsword;
    protected boolean estado;

    //CONSTRUCTOR
    public Persona() {
        this.nombre = "";
        this.apellido = "";
        this.nickname = "";
        this.passsword = "";
        this.estado = false;
    }

    //FUNCIONES
    public void agregar() {
        //Hacer un botón para dar la opción de mostrar si es cliente o empleado el que se va a agregar
        //hacer una clase aparte para la cola y llamar las funciones aquí dependiendo de lo que el usuario quiera agregar. cliente o empleado 
       
    }

    public String estado() {
        if (estado) {
            return "Activo";
        } else {
            return "Inactivo";
        }
    }

    public void inactivar() {

    }

}