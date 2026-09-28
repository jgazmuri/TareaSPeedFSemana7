package vista;

import dao.PedidoDAO;
import modelo.Pedido;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.awt.GridLayout;

public class VentanaRegistroPedido extends JFrame {

    public VentanaRegistroPedido() {
        setTitle("SpeedFast - Registrar Pedido");
        setSize(350, 220);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(3, 2, 10, 10));

        JLabel labelDireccion = new JLabel("Direccion:");
        JTextField campoDireccion = new JTextField();

        JLabel labelTipo = new JLabel("Tipo:");
        String[] tipos = {"Comida", "Encomienda", "Express"};
        JComboBox<String> comboTipo = new JComboBox<>(tipos);

        JButton botonGuardar = new JButton("Guardar");

        add(labelDireccion);
        add(campoDireccion);
        add(labelTipo);
        add(comboTipo);
        add(new JLabel());
        add(botonGuardar);

        botonGuardar.addActionListener(e -> {
            String direccion = campoDireccion.getText();
            String tipo = (String) comboTipo.getSelectedItem();

            if (direccion.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Debes completar la direccion.");
                return;
            }

            Pedido nuevoPedido = new Pedido(0, direccion, tipo);
            PedidoDAO pedidoDAO = new PedidoDAO();
            pedidoDAO.guardar(nuevoPedido);

            JOptionPane.showMessageDialog(this, "Pedido guardado en la base de datos.");
            campoDireccion.setText("");
        });

        setVisible(true);
    }
}