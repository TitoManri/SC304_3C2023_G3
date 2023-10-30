package Catalogo;

import Catalogo.Bebidas.Bebida;
import Catalogo.Nodos.NodoProvedores;
import Catalogo.Nodos.NodoPlatillo;
import Catalogo.Nodos.NodoBebida;
import Catalogo.Nodos.NodoPostre;
import Catalogo.Platillo.Platillo;
import Catalogo.Postres.Postre;
import Catalogo.Provedores.Provedores;
import javax.swing.JOptionPane;

public class Catalogo {
    NodoPlatillo platillos;
    NodoProvedores provedores;
    NodoBebida bebidas;
    NodoPostre postres;
    NodoPlatillo inicioPlatillo;
    NodoProvedores inicioProvedores;
    NodoBebida inicioBebida;
    NodoPostre inicioPostres;
 
    //Metodos
    public boolean esVaciaPlatillos(){
      if(inicioPlatillo==null){
         return true;
      }else{
         return false;
      }
   }
    
   public boolean esVaciaProvedores(){
      if(inicioProvedores==null){
         return true;
      }else{
         return false;
      }
   }
   
   public boolean esVaciaBebidas(){
      if(inicioBebida==null){
         return true;
      }else{
         return false;
      }
   }
   public boolean esVaciaPostres(){
      if(inicioPostres==null){
         return true;
      }else{
         return false;
      }
   }
    public void agregarPlatillos(){
        String nombre = JOptionPane.showInputDialog("Nombre del platillo:");
        String descripcion = JOptionPane.showInputDialog("Descripcion: ");
        String categoria = JOptionPane.showInputDialog("Categoría del platillo:");
        Platillo platillo = new Platillo(nombre,descripcion, categoria);
        NodoPlatillo nuevo=new NodoPlatillo();
        nuevo.setPlatillo(platillo);
        if(esVaciaPlatillos()){
            inicioPlatillo=nuevo;
        }else if(inicioPlatillo.getSiguiente()==null){
            inicioPlatillo.setSiguiente(nuevo);
        }else{
            NodoPlatillo aux=inicioPlatillo;
            while(aux.getSiguiente()!=null){
                aux=aux.getSiguiente();
            }
            nuevo.setSiguiente(aux.getSiguiente());
            aux.setSiguiente(nuevo);
        }
   }
    
   public void agregarBebidas(){
        String nombre = JOptionPane.showInputDialog("Nombre del bebida:");
        String categoria = JOptionPane.showInputDialog("Categoría del bebida:");
        Bebida bebida = new Bebida(nombre, categoria);
        NodoBebida nuevo=new NodoBebida();
        nuevo.setBebida(bebida);
        if(esVaciaBebidas()){
            inicioBebida=nuevo;
        }else if(inicioBebida.getSiguiente()==null){
            inicioBebida.setSiguiente(nuevo);
        }else{
            NodoBebida aux=inicioBebida;
            while(aux.getSiguiente()!=null){
                aux=aux.getSiguiente();
            }
            nuevo.setSiguiente(aux.getSiguiente());
            aux.setSiguiente(nuevo);
        }
   }
       public void agregarPostres(){
        String nombre = JOptionPane.showInputDialog("Nombre del postre:");
        String descripcion = JOptionPane.showInputDialog("Descripcion: ");
        String categoria = JOptionPane.showInputDialog("Categoría del postre:");
        Postre postre = new Postre(nombre,descripcion, categoria);
        NodoPostre nuevo=new NodoPostre();
        nuevo.setPostre(postre);
        if(esVaciaPostres()){
            inicioPostres=nuevo;
        }else if(inicioPostres.getSiguiente()==null){
            inicioPostres.setSiguiente(nuevo);
        }else{
            NodoPostre aux=inicioPostres;
            while(aux.getSiguiente()!=null){
                aux=aux.getSiguiente();
            }
            nuevo.setSiguiente(aux.getSiguiente());
            aux.setSiguiente(nuevo);
        }
   }  

   public void agregarProvedores(){
        String nombre = JOptionPane.showInputDialog("Nombre del bebida:");
        Provedores provedor = new Provedores(nombre);
        NodoProvedores nuevo=new NodoProvedores();
        nuevo.setProvedores(provedor);
        if(esVaciaProvedores()){
            inicioProvedores=nuevo;
        }else if(inicioProvedores.getSiguiente()==null){
            inicioProvedores.setSiguiente(nuevo);
        }else{
            NodoProvedores aux=inicioProvedores;
            while(aux.getSiguiente()!=null){
                aux=aux.getSiguiente();
            }
            nuevo.setSiguiente(aux.getSiguiente());
            aux.setSiguiente(nuevo);
        }
   }
}
    

