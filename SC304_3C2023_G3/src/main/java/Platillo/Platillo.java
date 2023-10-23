package Platillo;

import Catalogo.Catalogo;

public class Platillo extends Catalogo {
    protected String platosFuertes;
    protected String ensaldas;
    protected String entradas;
    protected String sopas;
    
    public Platillo() {
        super();
        this.platosFuertes="";
        this.entradas="";
        this.entradas="";
        this.sopas="";
    }

    public String getPlatosFuertes() {
        return platosFuertes;
    }

    public void setPlatosFuertes(String platosFuertes) {
        this.platosFuertes = platosFuertes;
    }

    public String getEnsaldas() {
        return ensaldas;
    }

    public void setEnsaldas(String ensaldas) {
        this.ensaldas = ensaldas;
    }

    public String getEntradas() {
        return entradas;
    }

    public void setEntradas(String entradas) {
        this.entradas = entradas;
    }

    public String getSopas() {
        return sopas;
    }

    public void setSopas(String sopas) {
        this.sopas = sopas;
    }
}