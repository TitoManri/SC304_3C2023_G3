package Catalogo.Bebidas;
import Catalogo.NodoLES;
import Catalogo.Catalogo;
import javax.swing.JOptionPane;

public class Gaseosas extends Bebidas{
    private NodoLES inicio;
   
    public Gaseosas() {
        super();
        this.inicio=null;
    }

   public boolean esVacia(){
      if(inicio==null){
         return true;
      }else{
         return false;
      }
   }
    
    public void agregarGaseosa(){
        Bebidas b=new Bebidas();
        b.setGaseosas(JOptionPane.showInputDialog(null,"Digite el nombre de la Bebida:"));
        b.setDescripcion(JOptionPane.showInputDialog(null,"Digite la descripción del producto:"));
        b.setPrecio(Double.parseDouble(JOptionPane.showInputDialog(null,"Digite el precio del producto:")));
        NodoLES nuevo=new NodoLES();
        nuevo.setDato(b);
    if(esVacia()){
        inicio=nuevo;
    }else if(inicio.getDato().getPrecio()>0) {
        nuevo.setSiguiente(inicio);
        inicio=nuevo;
        }else if(inicio.getSiguiente()==null){
            inicio.setSiguiente(nuevo);
        }else{
            NodoLES aux=inicio;
            while(aux.getSiguiente()!=null){
                aux=aux.getSiguiente();
            }
            nuevo.setSiguiente(aux.getSiguiente());
            aux.setSiguiente(nuevo);
        }
   }
}
