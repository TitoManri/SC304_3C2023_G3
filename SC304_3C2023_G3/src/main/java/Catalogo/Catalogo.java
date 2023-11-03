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
    //Bebida Lista Enlazada Simple
    NodoBebida inicioBebida;
    //Platillo Lista Simple Circular 
    NodoPlatillo inicioPlatillo;
    NodoPlatillo finPlatillo;
    //Postres Doble Lista Enlazada
    NodoPostre inicioPostre;
    NodoPostre finPostre;
    //Provedores Doble Lista Circular
    NodoProvedores inicioProvedores;
    NodoProvedores finProvedores;
    
    
 
    //Metodos esVacia
    public boolean esVaciaPlatillos(){
      if(inicioPlatillo==null && finPlatillo==null){
         return true;
      }else{
         return false;
      }
   }
    
   public boolean esVaciaProvedores(){
      if(inicioProvedores==null&& finProvedores == null){
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
      if(inicioPostre==null&&finPostre==null){
         return true;
      }else{
         return false;
      }
   }
   
   //Metodos Platillo Lista Simple Circular
   
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
    
    public void editarPlatillos() {
        NodoPlatillo aux = inicioPlatillo;
        while (aux != null) {
            String platilloNom = JOptionPane.showInputDialog("Ingrese el nombre del platillo que desea modificar: ");
            if (aux.getPlatillo().getNombre().equals(platilloNom)) {
                String nuevoNom = JOptionPane.showInputDialog("Nuevo nombre del platillo:");
                aux.getPlatillo().setNombre(nuevoNom);
                String nuevaDescr = JOptionPane.showInputDialog("Nueva descripcion: ");
                aux.getPlatillo().setDescripcion(nuevaDescr);
                String nuevaCateg = JOptionPane.showInputDialog("Nueva categoría del platillo:");
                aux.getPlatillo().setCategoria(nuevaCateg);
                break;
            } else {
                JOptionPane.showMessageDialog(null, "No se puede modificar el platillo que desea: no coincide con ninguno existente.");   
            }
            aux = aux.getSiguiente();
        } 
    }
 
    //Metodos Bebida Lista Enlazada Simple
    
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
   
    public void editarBebidas() {
        NodoBebida aux = inicioBebida;
        while (aux != null) {
            String bebidaNom = JOptionPane.showInputDialog("Ingrese el nombre de la bebida que desea modificar: ");
            if (aux.getBebida().getNombre().equals(bebidaNom)) {
                String nuevoNom = JOptionPane.showInputDialog("Nuevo nombre de la bebida:");
                aux.getBebida().setNombre(nuevoNom);
                String nuevaCateg = JOptionPane.showInputDialog("Nueva categoría de la bebida:");
                aux.getBebida().setCategoria(nuevaCateg);
                break;
            } else {
                JOptionPane.showMessageDialog(null, "No se puede modificar la bebida que desea: no coincide con ninguno existente.");   
            }
            aux = aux.getSiguiente();
        }
    }

    //Metodos Postres Doble Lista Enlazada
   
   public void agregarPostresAlPricipio(){
    NodoPostre np = new NodoPostre(); 
    if (finPostre == null) { 
        finPostre = np; 
        inicioPostre = np; 
    }else { 
        np.setSiguiente(finPostre); 
        finPostre.setAnterior(np); 
        finPostre = np;
    }
    
   } 
   public void agregarPostresAlFinal(){
    NodoPostre np = new NodoPostre(); 
    if (inicioPostre == null) { 
        finPostre = np; 
        inicioPostre = np; 
    }else{
        np.setSiguiente(np);
        np.setAnterior(inicioPostre);
        inicioPostre = np;
    }
   }  
    
   public void editarPostres() {
        NodoPostre aux = inicioPostre;
        while (aux != null) {
            String postreNom = JOptionPane.showInputDialog("Ingrese el nombre del postre que desea modificar: ");
            if (aux.getPostre().getNombre().equals(postreNom)) {
                String nuevoNom = JOptionPane.showInputDialog("Nuevo nombre del postre:");
                aux.getPostre().setNombre(nuevoNom);
                String nuevaDescr = JOptionPane.showInputDialog("Nueva descripcion: ");
                aux.getPostre().setDescripcion(nuevaDescr);
                String nuevaCateg = JOptionPane.showInputDialog("Nueva categoría del postre:");
                aux.getPostre().setCategoria(nuevaCateg);
                break;
            } else {
                JOptionPane.showMessageDialog(null, "No se puede modificar el postre que desea: no coincide con ninguno existente.");   
            }
            aux = aux.getSiguiente();
        }
    }     
   
   //Metodos Provedores Doble Lista Circular    

   public void agregarProvedoresAlPrincipio(){
        String nombre = JOptionPane.showInputDialog("Nombre del provedores:");
        Provedores provedor = new Provedores(nombre);
        NodoProvedores np = new NodoProvedores(); 
        np.setProvedores(provedor);
        if (esVaciaProvedores()){            
            np.setSiguiente(np);
            np.setAnterior(np);
            inicioProvedores = np;
            finProvedores =  inicioProvedores;            
        }else{
            np.setAnterior(finProvedores);
            finProvedores.setSiguiente(np);
            inicioProvedores.setAnterior(np);
            np.setSiguiente(inicioProvedores);
            inicioProvedores = np;        
        }  
    }
   
   public void agregarProvedoresAlFinal(int val){
        NodoProvedores np = new NodoProvedores(val);      
        if (esVaciaProvedores()){
            np.setSiguiente(np);
            np.setSiguiente(np);
            inicioProvedores = np;
            finProvedores = inicioProvedores;
        }else{
            np.setSiguiente(finProvedores);
            finProvedores.setSiguiente(np);
            inicioProvedores.setAnterior(np);
            np.setSiguiente(inicioProvedores);
            finProvedores = np;    
        }
        val++;
        np.setTamano(val);
    }
       
    public void editarProvedores() {
        NodoProvedores aux = inicioProvedores;
        while (aux != null) {
            String provedorNom = JOptionPane.showInputDialog("Ingrese el nombre del proveedor que desea modificar: ");
            if (aux.getProvedores().getNombre().equals(provedorNom)) {
                String nuevoNom = JOptionPane.showInputDialog("Nuevo nombre del proveedor:");
                aux.getProvedores().setNombre(nuevoNom);
                break;
            } else {
                JOptionPane.showMessageDialog(null, "No se puede modificar el proveedor que desea: no coincide con ninguno existente.");   
            }
            aux = aux.getSiguiente();
        }
    }
}
    

