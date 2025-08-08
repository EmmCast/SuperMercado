package controlador;


import modelo.Producto;

import java.util.ArrayList;

/**
 * Controlador que maneja la lógica de los productos.
 */
public class GestorProducto {

    private final ArrayList<Producto> productos;

    public GestorProducto() {
        this.productos = new ArrayList<>();
    }

    /**
     * Agrega un nuevo producto si no está repetido.
     * @param codigo Código único del producto.
     * @param nombre Nombre del producto.
     * @param precio Precio del producto.
     * @return true si se agregó correctamente; false si es inválido o duplicado.
     */
    public boolean agregarProducto(String codigo, String nombre, double precio) {
        if (codigo == null || nombre == null || codigo.trim().isEmpty() || nombre.trim().isEmpty() || precio < 0) {
            return false;
        }

        if (buscarPorCodigo(codigo) != null) {
            return false; // Ya existe
        }

        productos.add(new Producto(codigo, nombre, precio));
        return true;
    }

    /**
     * Busca un producto por su código.
     * @param codigo Código a buscar.
     * @return El producto si existe; null en caso contrario.
     */
    public Producto buscarPorCodigo(String codigo) {
        for (Producto p : productos) {
            if (p.getCodigo().equalsIgnoreCase(codigo)) {
                return p;
            }
        }
        return null;
    }

    /**
     * Devuelve la lista de todos los productos registrados.
     * @return Lista de productos.
     */
    public ArrayList<Producto> listarProductos() {
        return productos;
    }
}