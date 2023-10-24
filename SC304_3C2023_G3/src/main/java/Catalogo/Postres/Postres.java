package Catalogo.Postres;

import Catalogo.Catalogo;

public class Postres extends Catalogo {
    protected String Dulces;
    protected String Salados;
    
    public Postres() {
        super();
        this.Dulces="";
        this.Salados="";
    }

    public String getDulces() {
        return Dulces;
    }

    public void setDulces(String Dulces) {
        this.Dulces = Dulces;
    }

    public String getSalados() {
        return Salados;
    }

    public void setSalados(String Salados) {
        this.Salados = Salados;
    }
}
