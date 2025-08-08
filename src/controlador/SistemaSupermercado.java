package controlador;


import java.util.ArrayList;

import modelo.Producto;
import modelo.Usuario;

/**
 * Clase que actúa como repositorio en memoria para productos y empleados.
 * Todo se maneja con listas estáticas.
 */
public class SistemaSupermercado {

    private static ArrayList<Producto> productos = new ArrayList<>();
    private static ArrayList<Usuario> empleados = new ArrayList<>();

    /**
     * Agrega un nuevo producto al sistema.
     * @param producto Producto a agregar.
     */
    public static void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    /**
     * Devuelve la lista de productos registrados.
     * @return ArrayList de productos.
     */
    public static ArrayList<Producto> getProductos() {
        return productos;
    }

    /**
     * Agrega un nuevo empleado al sistema.
     * @param usuario Empleado a agregar.
     */
    public static void agregarEmpleado(Usuario usuario) {
        empleados.add(usuario);
    }

    /**
     * Devuelve la lista de empleados registrados.
     * @return ArrayList de usuarios.
     */
    public static ArrayList<Usuario> getEmpleados() {
        return empleados;
    }

    /**
     * Limpia todos los datos del sistema (opcional, para pruebas o reinicios).
     */
    public static void reset() {
        productos.clear();
        empleados.clear();
    }
}