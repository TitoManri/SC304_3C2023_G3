package Bebidas;

import Catalogo.Catalogo;

public class Bebidas extends Catalogo {
        protected String gaseosas;
        protected String jugosNaturales;
        protected String licores;
        protected String otrasBebidas;
    
    public Bebidas() {
        super();
        this.gaseosas="";
        this.jugosNaturales="";
        this.licores="";
        this.otrasBebidas="";
    }

    public String getGaseosas() {
        return gaseosas;
    }

    public void setGaseosas(String gaseosas) {
        this.gaseosas = gaseosas;
    }

    public String getJugosNaturales() {
        return jugosNaturales;
    }

    public void setJugosNaturales(String jugosNaturales) {
        this.jugosNaturales = jugosNaturales;
    }

    public String getLicores() {
        return licores;
    }

    public void setLicores(String licores) {
        this.licores = licores;
    }

    public String getOtrasBebidas() {
        return otrasBebidas;
    }

    public void setOtrasBebidas(String otrasBebidas) {
        this.otrasBebidas = otrasBebidas;
    }
    
    
}
