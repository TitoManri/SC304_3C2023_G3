package Orden;

//revisar agregarbebidas, platillos etc
//falta calcular los totales despues de modificar una orden
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
import java.util.List;
//OTROS
import javax.swing.JOptionPane;
import Orden.Orden;
import java.io.*;

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
        CatalogoPlatillos c = new CatalogoPlatillos();
        NodoPlatillo platilloNod = c.buscarPlatillo(nomPlatillo);
        Platillo platillo = platilloNod.getPlatillo();
        if (platillo == null) {
            JOptionPane.showMessageDialog(null, "No se encontró coincidencia con ningún platillo. Por favor ingrese un platillo del menú.");
            agregarPlatillo(nuevaOrden, Platillo);
        } else {
            nuevaOrden.agregarPlatillo(platillo, nuevaOrden);
        }
    }

    public void agregarBebida(Orden nuevaOrden, String Bebida) {
        String nomBebida = Bebida;
        CatalogoBebidas c = new CatalogoBebidas();
        NodoBebida bebidaNod = c.buscarBebida(nomBebida);
        Bebida bebida = bebidaNod.getBebida();
        if (bebida == null) {
            JOptionPane.showMessageDialog(null, "No se encontró coincidencia con ninguna bebida. Por favor ingrese una bebida del menú.");
            agregarBebida(nuevaOrden, Bebida);
        } else {
            nuevaOrden.agregarBebida(bebida, nuevaOrden);
        }
    }

    public void agregarPostre(Orden nuevaOrden, String Postre) {
        String nomPostre = Postre;
        CatalogoPostres c = new CatalogoPostres();
        NodoPostre postreNod = c.buscarPostre(nomPostre);
        Postre postre = postreNod.getPostre();
        if (postre == null) {
            JOptionPane.showMessageDialog(null, "No se encontró coincidencia con ningún postre. Por favor ingrese un postre del menú.");
            agregarPostre(nuevaOrden, Postre);
        } else {
            nuevaOrden.agregarPostre(postre, nuevaOrden);
        }
    }

//    BORRAR
//    public double calcularTotal() {
//        int cantidad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de este producto que desea: "));
//        double precio = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el precio del producto: "));
//
//        // Validar el precio
//        while (precio < 10.0) {
//            JOptionPane.showMessageDialog(null, "Precio del producto no válido. Ingrese uno de nuevo.");
//            precio = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el precio del producto: "));
//        }
//
//        return cantidad * precio;
//    }
    
    public void mostrarOrdenes() {
        if (!esVaciaLes()) {
            String s = "";
            NodoOrden aux = inicio;
            while (aux != null) {
                s = s + "Cliente: " + aux.getOrden().getCliente().getNombre() + aux.getOrden().getCliente().getApellido() + "\n"
                        + "Fecha y hora: " + aux.getOrden().getFechaHora() + "\n"
                        + "Número de orden:" + aux.getOrden().getNumOrden() + "\n"
                        + "Platillos: " + aux.getOrden().getPlatillos().toString() + "\n"
                        + "Bebidas: " + aux.getOrden().getBebidas().toString() + "\n"
                        + "Postres: " + aux.getOrden().getPostres().toString() + "\n"
                        + "Total: " + aux.getOrden().getTotal() + "-->";
                aux = aux.getSiguiente();
            }
            JOptionPane.showMessageDialog(null, "La lista contiene: \n" + s);
        } else {
            JOptionPane.showMessageDialog(null, "No se puede mostrar la lista, está vacía");
        }
    }

    //BORRAR
//    public void modificarOrdenes(int numeroOrden) {
//        NodoOrden aux = inicio;
//        boolean encontrado = false;
//        while (aux != null && !encontrado) {
//            if (aux.getOrden().getNumOrden() == numeroOrden) {
//                encontrado = true;
//            }
//            aux = aux.getSiguiente();
//        }
//
//        if (!encontrado) {
//            JOptionPane.showMessageDialog(null, "No se encontró una orden con el número especificado.");
//        }
//    }
    
    public void eliminarPlatillo(Orden orden, String nombrePlatillo) {
        List<Platillo> platillos = orden.getPlatillos();
        for (int i = 0; i < platillos.size(); i++) {
            if (platillos.get(i).getNombre().equals(nombrePlatillo)) {
                platillos.remove(i);
                break;
            }
        }
    }

    public void eliminarBebida(Orden orden, String nombreBebida) {
        List<Bebida> bebidas = orden.getBebidas();
        for (int i = 0; i < bebidas.size(); i++) {
            if (bebidas.get(i).getNombre().equals(nombreBebida)) {
                bebidas.remove(i);
                break;
            }
        }
    }

    public void eliminarPostre(Orden orden, String nombrePostre) {
        List<Postre> postres = orden.getPostres();
        for (int i = 0; i < postres.size(); i++) {
            if (postres.get(i).getNombre().equals(nombrePostre)) {
                postres.remove(i);
                break;
            }
        }
    }

    public double calcularTotal(Orden orden) {
        double totalTransaccion = 0;
        if (!orden.getPlatillos().isEmpty()) {
            for (Platillo platillo : orden.getPlatillos()) {
                totalTransaccion += Double.parseDouble(platillo.getPrecio());
            }
        }
        if (!orden.getBebidas().isEmpty()) {
            for (Bebida bebida : orden.getBebidas()) {
                totalTransaccion += Double.parseDouble(bebida.getPrecio());
            }
        }
        if (!orden.getPostres().isEmpty()) {
            for (Postre postre : orden.getPostres()) {
                totalTransaccion += Double.parseDouble(postre.getPrecio());
            }
        }
        orden.setTotal(totalTransaccion);
        return totalTransaccion;
    }

    public Orden encontrarOrden(int numeroOrden) {
        NodoOrden aux = inicio;

        while (aux != null) {
            if (aux.getOrden().getNumOrden() == numeroOrden) {
                return aux.getOrden();
            }
            aux = aux.getSiguiente();
        }
        return null; 
    }
      
    //Le falta la interfaz
    public void cancelarOrden(int numeroOrden) {
    NodoOrden anterior = null;
    NodoOrden actual = inicio;
    
    while (actual != null && actual.getOrden().getNumOrden() != numeroOrden) {
        anterior = actual;
        actual = actual.getSiguiente();
    }

    //CAMBIAR EL ARCHIVO Y REVISAR
    if (actual != null) {
        try (DataOutputStream outputStream = new DataOutputStream(new FileOutputStream("aaaa.txt", true))) {
            outputStream.writeUTF("Fecha y hora: " + actual.getOrden().getFechaHora() + "\n");
            outputStream.writeUTF("Cliente: " + actual.getOrden().getCliente().getNombre() + " " + actual.getOrden().getCliente().getApellido() + "\n");
            outputStream.writeDouble(actual.getOrden().getTotal());
            
            JOptionPane.showMessageDialog(null, "Orden cancelada correctamente.");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al guardar la información de la orden.");
        }
        
        if (anterior != null) {
            anterior.setSiguiente(actual.getSiguiente());
        } else {
            inicio = actual.getSiguiente();
        }
    } else {
        JOptionPane.showMessageDialog(null, "No se encontró una orden con el número especificado.");
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
