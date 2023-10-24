package Catalogo.ListaEnlazadaSimple;



public class NodoLES {
    private String dato;
    private NodoLES siguiente;
    
    public NodoLES(String d){
        this.dato=d;    
    }
    
    public NodoLES(String d, NodoLES n){
       dato=d;
       siguiente=n;
    }

}
