package vista;

import dao.RepartidorDAO;
import modelo.Repartidor;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.awt.GridLayout;

public class VentanaRegistroRepartidor extends JFrame {

    public VentanaRegistroRepartidor() {
        setTitle("SpeedFast - Registrar Repartidor");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(2, 2, 10, 10));

        JLabel labelNombre = new JLabel("Nombre:");
        JTextField campoNombre = new JTextField();

        JButton botonGuardar = new JButton("Guardar");

        add(labelNombre);
        add(campoNombre);
        add(new JLabel());
        add(botonGuardar);

        botonGuardar.addActionListener(e -> {
            String nombre = campoNombre.getText();

            if (nombre.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Debes completar el nombre.");
                return;
            }

            Repartidor nuevoRepartidor = new Repartidor(0, nombre);
            RepartidorDAO repartidorDAO = new RepartidorDAO();
            boolean exito = repartidorDAO.guardar(nuevoRepartidor);

            if (exito) {
                JOptionPane.showMessageDialog(this, "Repartidor guardado en la base de datos.");
                campoNombre.setText("");
            } else {
                JOptionPane.showMessageDialog(this, "Error: no se pudo guardar el repartidor.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        setVisible(true);
    }
}