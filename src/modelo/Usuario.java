package modelo;

public class Usuario {

    private String codigoEmpleado;
    private String nombre;

    /**
     * Constructor vacío.
     */
    public Usuario() {
    }

    /**
     * Constructor con parámetros.
     *
     * @param codigoEmpleado Código del empleado.
     * @param nombre Nombre del empleado.
     */
    public Usuario(String codigoEmpleado, String nombre) {
        this.codigoEmpleado = codigoEmpleado;
        this.nombre = nombre;
    }



    public String getCodigoEmpleado() {
        return codigoEmpleado;
    }

    public void setCodigoEmpleado(String codigoEmpleado) {
        this.codigoEmpleado = codigoEmpleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return nombre + " (" + codigoEmpleado + ")";
    }
}
