package vista;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.GridLayout;

public class VentanaPrincipal extends JFrame {

    public VentanaPrincipal() {
        setTitle("SpeedFast - Menu Principal");
        setSize(400, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(4, 1, 10, 10));

        JButton botonRegistrar = new JButton("Registrar Pedido");
        JButton botonRegistrarRepartidor = new JButton("Registrar Repartidor");
        JButton botonVerPedidos = new JButton("Ver Pedidos");
        JButton botonSalir = new JButton("Salir");

        add(botonRegistrar);
        add(botonRegistrarRepartidor);
        add(botonVerPedidos);
        add(botonSalir);

        botonRegistrar.addActionListener(e -> new VentanaRegistroPedido());
        botonRegistrarRepartidor.addActionListener(e -> new VentanaRegistroRepartidor());
        botonVerPedidos.addActionListener(e -> new VentanaListaPedidos());
        botonSalir.addActionListener(e -> System.exit(0));

        setVisible(true);
    }
}