package Orden;

//CAMBIAR LA FUNCIÓN DE CALCULAR TOTAL
//- Al final hay una función comentada que busqué y que tal vez pueda funcionar para hacer la estructura de buscar las facturas por fecha 
import javax.swing.JOptionPane;
//PLATILLOS
import Interfaz.Administrador.Platillos.CatalogoPlatillos;
import Catalogo.Nodos.NodoPlatillo;
import Catalogo.Platillo.Platillo;
//BEBIDAS
import Interfaz.Administrador.Bebidas.CatalogoBebidas;
import Catalogo.Nodos.NodoBebida;
import Catalogo.Bebidas.Bebida;
//POSTRES
import Interfaz.Administrador.Postres.CatalogoPostres;
import Catalogo.Nodos.NodoPostre;
import Catalogo.Postres.Postre;
//CLIENTE
import Personas.Cliente;
import Personas.Cola;

public class LesOrden {

    private NodoOrden inicio;

    public LesOrden() {
        this.inicio = null;
    }

    public boolean esVaciaLes() {
        if (inicio == null) {
            return true;
        } else {
            return false;
        }
    }

    public void agregarOrden(Orden nuevaOrden, Cliente cliente) {
        double total = 0.0;
        total += calcularTotal();
        nuevaOrden.setCliente(cliente);
        nuevaOrden.setTotal(total);

        NodoOrden nuevo = new NodoOrden();
        nuevo.setOrden(nuevaOrden);

        if (esVaciaLes()) {
            inicio = nuevo;
        } else {
            inicio.setSiguiente(nuevo);
        }
    }

    public void agregarPlatillo(Orden nuevaOrden, String Platillo) {
        String nomPlatillo = Platillo;
        calcularTotal();
        CatalogoPlatillos c = new CatalogoPlatillos();
        NodoPlatillo platilloNod = c.buscarPlatillo(nomPlatillo);
        Platillo platillo = platilloNod.getPlatillo();
        if (platillo == null) {
            JOptionPane.showMessageDialog(null, "No se encontró coincidencia con ningún platillo. Por favor ingrese un platillo del menú.");
            agregarPlatillo(nuevaOrden, Platillo);
        } else {
            nuevaOrden.agregarPlatillo(platillo);
        }
    }

    public void agregarCliente(Orden nuevaOrden, String usuario) {
        String userCliente = usuario;
        calcularTotal();
        Cola c = new Cola();
        Cliente cliente = c.buscarCliente(userCliente);
        if (cliente == null) {
            JOptionPane.showMessageDialog(null, "No se encontró coincidencia con ningún usuario. Por favor ingrese un usuerio en el sistema.");
            agregarCliente(nuevaOrden, usuario);
        } else {
            nuevaOrden.setCliente(cliente);
        }
    }

    public void agregarBebida(Orden nuevaOrden, String Bebida) {
        String nomBebida = Bebida;
        calcularTotal();
        CatalogoBebidas c = new CatalogoBebidas();
        NodoBebida bebidaNod = c.buscarBebida(nomBebida);
        Bebida bebida = bebidaNod.getBebida();
        if (bebida == null) {
            JOptionPane.showMessageDialog(null, "No se encontró coincidencia con ninguna bebida. Por favor ingrese una bebida del menú.");
            agregarBebida(nuevaOrden, Bebida);
        } else {
            nuevaOrden.agregarBebida(bebida);
        }
    }

    public void agregarPostre(Orden nuevaOrden, String Postre) {
        String nomPostre = Postre;
        calcularTotal();
        CatalogoPostres c = new CatalogoPostres();
        NodoPostre postreNod = c.buscarPostre(nomPostre);
        Postre postre = postreNod.getPostre();
        if (postre == null) {
            JOptionPane.showMessageDialog(null, "No se encontró coincidencia con ningún postre. Por favor ingrese un postre del menú.");
            agregarPostre(nuevaOrden, Postre);
        } else {
            nuevaOrden.agregarPostre(postre);
        }
    }

    public double calcularTotal() {
        int cantidad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de este producto que desea: "));
        double precio = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el precio del producto: "));

        // Validar el precio
        while (precio < 10.0) {
            JOptionPane.showMessageDialog(null, "Precio del producto no válido. Ingrese uno de nuevo.");
            precio = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el precio del producto: "));
        }

        return cantidad * precio;
    }
    
    public void mostrarOrdenes(){
        if (!esVaciaLes()) {
            String s = "";
            NodoOrden aux = inicio;
            while (aux != null) {
                s = s + "Cliente: " + aux.getOrden().getCliente().getNombre() + aux.getOrden().getCliente().getApellido() + "\n" + 
                        "Fecha y hora: " + aux.getOrden().getFechaHora() + "\n" + 
                        "Número de orden:" + aux.getOrden().getNumOrden() + "\n" + 
                        "Platillos: " +aux.getOrden().getPlatillos().toString() + "\n"  + 
                        "Bebidas: "+ aux.getOrden().getBebidas().toString() + "\n" + 
                        "Postres: "+ aux.getOrden().getPostres().toString() + "\n" + 
                        "Total: " + aux.getOrden().getTotal() + "-->";
                aux = aux.getSiguiente();
            }
            JOptionPane.showMessageDialog(null, "La lista contiene: \n" + s);
        } else {
            JOptionPane.showMessageDialog(null, "No se puede mostrar la lista, está vacía");
        }
    }
    
//        public void buscarPorFecha(int año, int mes, int dia) { //esta iría en orden
//        // Buscar órdenes por fecha (ejemplo: 9 de noviembre de 2023)
//        LocalDateTime fechaBusqueda = LocalDateTime.of(año, mes, dia, 0, 0);
//        for (Orden orden : ordenes) {
//            if (orden.getFechaHora.toLocalDate().equals(fechaBusqueda.toLocalDate())) {
//                JOptionPane.showMessageDialog(null,"Orden #" + orden.numOrden + " realizada el " + orden.fechaHora);
//            } else {
//                JOptionPane.showMessageDialog(null, "No se registraron ventas en esa fecha.");
//            }
//        }
//    } 
}
