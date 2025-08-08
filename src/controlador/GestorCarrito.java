package controlador;

import java.util.ArrayList;

import modelo.Producto;
import modelo.ProductoCarrito;

/**
 * Controlador para manejar la lógica del carrito de compras.
 */
public class GestorCarrito {

    private final ArrayList<ProductoCarrito> carrito;

    public GestorCarrito() {
        this.carrito = new ArrayList<>();
    }

    /**
     * Agrega un producto al carrito. Si ya existe, incrementa la cantidad.
     * @param producto Producto a agregar.
     * @param cantidad Cantidad a agregar.
     * @return true si se agregó correctamente, false si la cantidad es inválida.
     */
    public boolean agregarProducto(Producto producto, int cantidad) {
        if (producto == null || cantidad <= 0) {
            return false;
        }

        for (ProductoCarrito item : carrito) {
            if (item.getProducto().getCodigo().equalsIgnoreCase(producto.getCodigo())) {
                item.setCantidad(item.getCantidad() + cantidad);
                return true;
            }
        }

        carrito.add(new ProductoCarrito(producto, cantidad));
        return true;
    }

    /**
     * Elimina un producto del carrito.
     * @param codigo Código del producto a eliminar.
     * @return true si se eliminó; false si no se encontró.
     */
    public boolean eliminarProducto(String codigo) {
        return carrito.removeIf(item -> item.getProducto().getCodigo().equalsIgnoreCase(codigo));
    }

    /**
     * Calcula el total de la compra.
     * @return Monto total.
     */
    public double calcularTotal() {
        double total = 0.0;
        for (ProductoCarrito item : carrito) {
            total += item.getProducto().getPrecio() * item.getCantidad();
        }
        return total;
    }

    /**
     * Devuelve los productos actualmente en el carrito.
     * @return Lista de productos con cantidades.
     */
    public ArrayList<ProductoCarrito> listarCarrito() {
        return carrito;
    }

    /**
     * Vacía el carrito.
     */
    public void limpiarCarrito() {
        carrito.clear();
    }
}