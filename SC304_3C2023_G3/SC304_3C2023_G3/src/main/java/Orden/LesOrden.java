package Orden;

/*
Lo de agregar platillo, bebida, postre etc lo hice pensando en llamar esas funciones los botones
- Al final hay una función comentada que busqué y que tal vez pueda funcionar para hacer la estructura de buscar las facturas por fecha 
 
import javax.swing.JOptionPane;
import java.time.LocalDateTime;
import Catalogo.Catalogo;
import Catalogo.Bebidas.Bebida;
import Catalogo.Platillo.Platillo;
import Catalogo.Postres.Postre;
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

    public void agregarOrden() {
        Orden nuevaOrden = new Orden();
        double total = 0.0;
        agregarCliente(nuevaOrden, total);
        agregarPlatillo(nuevaOrden);
        agregarBebida(nuevaOrden, total);
        agregarPostre(nuevaOrden, total);
        nuevaOrden.setTotal(total);

        NodoOrden nuevo = new NodoOrden();
        nuevo.setOrden(nuevaOrden);

        if (esVaciaLes()) {
            inicio = nuevo;
        } else {
            inicio.setSiguiente(nuevo);
        }

    }

    public void agregarPlatillo(Orden nuevaOrden) {
        String nomPlatillo = JOptionPane.showInputDialog("Ingrese el platillo que desea: ");
        Catalogo c = new Catalogo();
        Platillo platillo = c.buscarPlatillo(nomPlatillo);
        if (platillo == null) {
            JOptionPane.showMessageDialog(null, "No se encontró coincidencia con ningún platillo. Por favor ingrese un platillo del menú.");
            agregarPlatillo(nuevaOrden);
        } else {
            nuevaOrden.setPlatillo(platillo);
        }
    }

    public void agregarCliente(Orden nuevaOrden, double total) {
        String userCliente = JOptionPane.showInputDialog("Ingrese su usario: ");
        calcularTotal(total);
        Cola c = new Cola();
        Cliente cliente = c.buscarCliente(userCliente);
        if (cliente == null) {
            JOptionPane.showMessageDialog(null, "No se encontró coincidencia con ningún usuario. Por favor ingrese un usuerio en el sistema.");
            agregarCliente(nuevaOrden, total);
        } else {
            nuevaOrden.setCliente(cliente);
        }
    }

    public void agregarBebida(Orden nuevaOrden, double total) {
        String nomBebida = JOptionPane.showInputDialog("Ingrese la bebida que desea: ");
        calcularTotal(total);
        Catalogo c = new Catalogo();
        Bebida bebida = c.buscarBebida(nomBebida);
        if (bebida == null) {
            JOptionPane.showMessageDialog(null, "No se encontró coincidencia con ninguna bebida. Por favor ingrese una bebida del menú.");
            agregarBebida(nuevaOrden, total);
        } else {
            nuevaOrden.setBebida(bebida);
        }
    }

    public void agregarPostre(Orden nuevaOrden, double total) {
        String nomPostre = JOptionPane.showInputDialog("Ingrese del postre que desea: ");
        calcularTotal(total);
        Catalogo c = new Catalogo();
        Postre postre = c.buscarPostre(nomPostre);
        if (postre == null) {
            JOptionPane.showMessageDialog(null, "No se encontró coincidencia con ningún postre. Por favor ingrese un postre del menú.");
            agregarPostre(nuevaOrden, total);
        } else {
            nuevaOrden.setPostre(postre);
        }
    }

    public void calcularTotal(double total) {
        int cantidad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de este producto que desea: "));
        double precio = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el precio del producto: "));
        if (precio < 10.0) {
            JOptionPane.showMessageDialog(null, "Precio del producto no válido. Ingrese uno de nuevo.");
            precio = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el precio del producto: "));
        }
        total += cantidad * precio;
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
*/