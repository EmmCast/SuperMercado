package modelo;

public class ProductoCarrito {


    private Producto producto;
    private int cantidad;

    /**
     * Constructor vacío.
     */
    public ProductoCarrito() {
    }

    /**
     * Constructor con parámetros.
     *
     * @param producto Producto que se añade al carrito.
     * @param cantidad Cantidad del producto.
     */
    public ProductoCarrito(Producto producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * Calcula el subtotal de este producto en el carrito.
     *
     * @return Precio unitario multiplicado por la cantidad.
     */
    public double getSubtotal() {
        return producto.getPrecio() * cantidad;
    }

    @Override
    public String toString() {
        return producto.getNombre() + " x" + cantidad + " = $" + String.format("%.2f", getSubtotal());
    }
    
}
