package vista;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import controlador.SistemaSupermercado;
import modelo.Producto;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaVenta extends JFrame {

    private JComboBox<String> comboProductos;
    private JTextField txtCantidad;
    private JTable tablaCarrito;
    private DefaultTableModel modeloTabla;
    private JLabel lblTotal;
    private double total = 0;

    public VentanaVenta() {
        setTitle("Realizar Venta");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // solo cerrar esta ventana
        setLayout(new BorderLayout());

        // Panel superior para selección
        JPanel panelSuperior = new JPanel();
        panelSuperior.setLayout(new FlowLayout());

        comboProductos = new JComboBox<>();
        for (Producto p : SistemaSupermercado.getProductos()) {
            comboProductos.addItem(p.getCodigo() + " - " + p.getNombre());
        }

        txtCantidad = new JTextField(5);
        JButton btnAgregar = new JButton("Agregar al carrito");

        panelSuperior.add(new JLabel("Producto:"));
        panelSuperior.add(comboProductos);
        panelSuperior.add(new JLabel("Cantidad:"));
        panelSuperior.add(txtCantidad);
        panelSuperior.add(btnAgregar);

        add(panelSuperior, BorderLayout.NORTH);

        // Tabla carrito
        modeloTabla = new DefaultTableModel(new Object[]{"Producto", "Cantidad", "Precio Unitario", "Subtotal"}, 0);
        tablaCarrito = new JTable(modeloTabla);
        JScrollPane scrollPane = new JScrollPane(tablaCarrito);
        add(scrollPane, BorderLayout.CENTER);

        // Panel inferior
        JPanel panelInferior = new JPanel();
        panelInferior.setLayout(new FlowLayout());

        lblTotal = new JLabel("Total: $0.00");
        JButton btnCerrar = new JButton("Cerrar");
        JButton btnAtras = new JButton("Atrás");

        panelInferior.add(lblTotal);
        panelInferior.add(btnAtras);
        panelInferior.add(btnCerrar);

        add(panelInferior, BorderLayout.SOUTH);

        // Eventos
        btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = comboProductos.getSelectedIndex();
                if (index >= 0) {
                    Producto p = SistemaSupermercado.getProductos().get(index);
                    try {
                        int cantidad = Integer.parseInt(txtCantidad.getText());
                        if (cantidad <= 0) {
                            JOptionPane.showMessageDialog(null, "Cantidad inválida");
                            return;
                        }
                        double subtotal = cantidad * p.getPrecio();
                        total += subtotal;
                        modeloTabla.addRow(new Object[]{
                            p.getNombre(), cantidad, p.getPrecio(), subtotal
                        });
                        lblTotal.setText(String.format("Total: $%.2f", total));
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Ingrese una cantidad válida");
                    }
                }
            }
        });

        btnCerrar.addActionListener(e -> {
            int confirm = JOptionPane.showConfirmDialog(null, "¿Deseas salir?", "Confirmar", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        });

        btnAtras.addActionListener(e -> {
            dispose(); // Cierra solo esta ventana
            new VentanaPrincipal(); // Vuelve al menú principal
        });

        setVisible(true);
    }
}