package vista;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * Ventana principal del sistema de supermercado (menú de navegación).
 */
public class VentanaPrincipal extends JFrame {

    public VentanaPrincipal() {
        setTitle("Sistema de Supermercado");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Panel principal
        JPanel panel = new JPanel(new GridLayout(4, 1, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));

        // Botones
        JButton btnProductos = new JButton("Registrar Productos");
        JButton btnUsuarios = new JButton("Registrar Empleados");
        JButton btnVentas = new JButton("Realizar Venta");
        JButton btnSalir = new JButton("Salir");

        // Acciones
        btnProductos.addActionListener((ActionEvent e) -> {
            new VentanaProducto().setVisible(true);
        });

        btnUsuarios.addActionListener((ActionEvent e) -> {
            new VentanaUsuario().setVisible(true);
        });

        btnVentas.addActionListener((ActionEvent e) -> {
            new VentanaVenta().setVisible(true);
        });

        btnSalir.addActionListener(e -> System.exit(0));

        // Añadir botones al panel
        panel.add(btnProductos);
        panel.add(btnUsuarios);
        panel.add(btnVentas);
        panel.add(btnSalir);

        add(panel);
    }


}