package vista;


import controlador.GestorProducto;
import controlador.SistemaSupermercado;
import modelo.Producto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * Interfaz gráfica para registrar productos.
 */
public class VentanaProducto extends JFrame {

    private final GestorProducto gestorProducto;
    private final JTextField txtCodigo;
    private final JTextField txtNombre;
    private final JTextField txtPrecio;
    private final JTextArea areaListado;

    public VentanaProducto() {
        setTitle("Registro de Productos");
        setSize(400, 400);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        gestorProducto = new GestorProducto();

        // Panel de formulario
        JPanel panelFormulario = new JPanel(new GridLayout(4, 2, 10, 10));
        panelFormulario.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        txtCodigo = new JTextField();
        txtNombre = new JTextField();
        txtPrecio = new JTextField();

        panelFormulario.add(new JLabel("Código:"));
        panelFormulario.add(txtCodigo);
        panelFormulario.add(new JLabel("Nombre:"));
        panelFormulario.add(txtNombre);
        panelFormulario.add(new JLabel("Precio:"));
        panelFormulario.add(txtPrecio);

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
            registrarProducto();
        });

        // Acción botón limpiar
        btnLimpiar.addActionListener(e -> limpiarCampos());
    }

    private void registrarProducto() {
        String codigo = txtCodigo.getText().trim();
        String nombre = txtNombre.getText().trim();
        String precioStr = txtPrecio.getText().trim();

        try {
            double precio = Double.parseDouble(precioStr);
            boolean exito = gestorProducto.agregarProducto(codigo, nombre, precio);

            if (exito) {
                // Agrega el producto también al sistema global
                Producto nuevoProducto = gestorProducto.buscarPorCodigo(codigo);
                SistemaSupermercado.agregarProducto(nuevoProducto);  // Esta línea es clave 

                JOptionPane.showMessageDialog(this, "Producto registrado correctamente.");
                mostrarProductos();
                limpiarCampos();
            } else {
                JOptionPane.showMessageDialog(this, "Error: Código repetido o datos inválidos.", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Precio inválido. Ingrese un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    private void mostrarProductos() {
        StringBuilder sb = new StringBuilder("Listado de productos:\n");
        for (Producto p : gestorProducto.listarProductos()) {
            sb.append(p.getCodigo()).append(" - ").append(p.getNombre())
              .append(" ($").append(p.getPrecio()).append(")\n");
        }
        areaListado.setText(sb.toString());
    }

    private void limpiarCampos() {
        txtCodigo.setText("");
        txtNombre.setText("");
        txtPrecio.setText("");
    }
}