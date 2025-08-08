package vista;


import controlador.GestorUsuario;
import modelo.Usuario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * Interfaz gráfica para registrar usuarios (empleados).
 */
public class VentanaUsuario extends JFrame {

    private final GestorUsuario gestorUsuario;
    private final JTextField txtCodigo;
    private final JTextField txtNombre;
    private final JTextArea areaListado;

    public VentanaUsuario() {
        setTitle("Registro de Usuarios");
        setSize(400, 350);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        gestorUsuario = new GestorUsuario();

        // Panel del formulario
        JPanel panelFormulario = new JPanel(new GridLayout(3, 2, 10, 10));
        panelFormulario.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        txtCodigo = new JTextField();
        txtNombre = new JTextField();

        panelFormulario.add(new JLabel("Código de empleado:"));
        panelFormulario.add(txtCodigo);
        panelFormulario.add(new JLabel("Nombre del empleado:"));
        panelFormulario.add(txtNombre);

        JButton btnRegistrar = new JButton("Registrar");
        JButton btnLimpiar = new JButton("Limpiar");

        panelFormulario.add(btnRegistrar);
        panelFormulario.add(btnLimpiar);

        // Área de listado
        areaListado = new JTextArea(10, 30);
        areaListado.setEditable(false);
        JScrollPane scroll = new JScrollPane(areaListado);

        add(panelFormulario, BorderLayout.NORTH);
        add(scroll, BorderLayout.CENTER);

        // Acción botón registrar
        btnRegistrar.addActionListener((ActionEvent e) -> {
            registrarUsuario();
        });

        // Acción botón limpiar
        btnLimpiar.addActionListener(e -> limpiarCampos());
    }

    private void registrarUsuario() {
        String codigo = txtCodigo.getText().trim();
        String nombre = txtNombre.getText().trim();

        boolean exito = gestorUsuario.registrarUsuario(codigo, nombre);

        if (exito) {
            JOptionPane.showMessageDialog(this, "Usuario registrado correctamente.");
            mostrarUsuarios();
            limpiarCampos();
        } else {
            JOptionPane.showMessageDialog(this, "Error: Código repetido o datos inválidos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void mostrarUsuarios() {
        StringBuilder sb = new StringBuilder("Listado de usuarios:\n");
        for (Usuario u : gestorUsuario.listarUsuarios()) {
            sb.append(u.getCodigoEmpleado()).append(" - ").append(u.getNombre()).append("\n");
        }
        areaListado.setText(sb.toString());
    }

    private void limpiarCampos() {
        txtCodigo.setText("");
        txtNombre.setText("");
    }
}