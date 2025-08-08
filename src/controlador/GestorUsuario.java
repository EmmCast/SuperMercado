package controlador;

import java.util.ArrayList;

import modelo.Usuario;

/**
 * Controlador para manejar la lógica relacionada con usuarios.
 */
public class GestorUsuario {

    private final ArrayList<Usuario> usuarios;

    public GestorUsuario() {
        this.usuarios = new ArrayList<>();
    }

    /**
     * Registra un nuevo usuario si no está repetido.
     * @param codigo Código único del empleado.
     * @param nombre Nombre del empleado.
     * @return true si se registra con éxito; false si está duplicado o inválido.
     */
    public boolean registrarUsuario(String codigo, String nombre) {
        if (codigo == null || nombre == null || codigo.trim().isEmpty() || nombre.trim().isEmpty()) {
            return false;
        }

        if (buscarPorCodigo(codigo) != null) {
            return false;
        }

        usuarios.add(new Usuario(codigo, nombre));
        return true;
    }

    /**
     * Busca un usuario por código de empleado.
     * @param codigo Código a buscar.
     * @return Usuario si existe; null si no.
     */
    public Usuario buscarPorCodigo(String codigo) {
        for (Usuario u : usuarios) {
            if (u.getCodigoEmpleado().equalsIgnoreCase(codigo)) {
                return u;
            }
        }
        return null;
    }

    /**
     * Devuelve todos los usuarios registrados.
     * @return Lista de usuarios.
     */
    public ArrayList<Usuario> listarUsuarios() {
        return usuarios;
    }
}