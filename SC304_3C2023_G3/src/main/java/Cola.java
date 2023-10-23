
import javax.swing.JOptionPane;

/**
 *  Clase encolarCliente y Empleado Listo
 *  Clase activar y desactivar Usuario Revisar 
 */

public class Cola {

    private Nodo inicio;
    private Nodo fin;
    
    public Cola() {
        this.inicio = null;
        this.fin = null;
    }

    Empleado e = new Empleado();
    Cliente c = new Cliente();
    
    
    public boolean esVacia() { // Cambie este porque decia que era redundante, entonces para que sea mas corto
        return inicio == null;
    }

    public void encolarCliente() {
        

        c.setNombre(JOptionPane.showInputDialog("Ingrese el nombre del usuario: ")); 
        c.setApellido(JOptionPane.showInputDialog("Ingrese el apellido del usuario: "));
        c.setNickname(JOptionPane.showInputDialog("Ingrese un nombre de usuario: "));
        c.setPasssword(JOptionPane.showInputDialog("Ingrese la contraseña: "));
        c.setConfirmarPassword(JOptionPane.showInputDialog("Ingrese la confirme su contraseña: "));
        
        if(!c.getPasssword().equals(c.getConfirmarPassword())){encolarCliente();} //Si la contrasena es diferente
        
        c.setEstado(true);
        
        Nodo nuevo = new Nodo();
        nuevo.setElementoC(c);

        if (esVacia()) {
            inicio = nuevo;
            fin = nuevo;
        } else {
            fin.setSiguiente(nuevo);
            fin = nuevo;
        }
    }
    
    public void encolarEmpleado() {
        

        e.setNombre(JOptionPane.showInputDialog("Ingrese su Nombre: ")); 
        e.setApellido(JOptionPane.showInputDialog("Ingrese sus Apellidos: "));
        e.setNickname(JOptionPane.showInputDialog("Ingrese un Nombre de Usuario: "));
        e.setPasssword(JOptionPane.showInputDialog("Ingrese una contraseña: "));
        e.setConfirmarPassword(JOptionPane.showInputDialog("Confirme su contraseña: "));
        
        if(!e.getPasssword().equals(e.getConfirmarPassword())){encolarCliente();} //Si la contrasena es diferente
        e.setEstado(true);
        
        Nodo nuevo = new Nodo();
        nuevo.setElementoE(e);

        if (esVacia()) {
            inicio = nuevo;
            fin = nuevo;
        } else {
            fin.setSiguiente(nuevo);
            fin = nuevo;
        }
        
    }
    
    public void activarUsuario() {
        Nodo indice = inicio;
        String nombreUsuario = JOptionPane.showInputDialog("Digite su Nombre de Usuario: ");
        String contrasena = JOptionPane.showInputDialog("Digite su Contrasena: ");
        while (indice != null) {
            if (indice.getElementoC() != null && indice.getElementoC().getNombre().equals(nombreUsuario) && indice.getElementoC().getPasssword().equals(contrasena)) {
                indice.getElementoC().setEstado(true);
                return;
            }
            if (indice.getElementoE() != null && indice.getElementoE().getNombre().equals(nombreUsuario) && indice.getElementoC().getPasssword().equals(contrasena)) {
                indice.getElementoE().setEstado(true);
                return;
            }
            indice = indice.getSiguiente();
        }
    }
    
    public void desactivarUsuario() {
        Nodo indice = inicio;
        String nombreUsuario = JOptionPane.showInputDialog("Digite su Nombre de Usuario: ");
        String contrasena = JOptionPane.showInputDialog("Digite su Contrasena: ");
        while (indice != null) {
            if (indice.getElementoC() != null && indice.getElementoC().getNombre().equals(nombreUsuario) && indice.getElementoC().getPasssword().equals(contrasena)) {
                indice.getElementoC().setEstado(false);
                return;
            }
            if (indice.getElementoE() != null && indice.getElementoE().getNombre().equals(nombreUsuario) && indice.getElementoC().getPasssword().equals(contrasena)) {
                indice.getElementoE().setEstado(false);
                return;
            }
            indice = indice.getSiguiente();
        }
    }

}
