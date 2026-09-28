package vista;

import dao.PedidoDAO;
import modelo.Pedido;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class VentanaListaPedidos extends JFrame {

    public VentanaListaPedidos() {
        setTitle("SpeedFast - Lista de Pedidos");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        String[] columnas = {"ID", "Direccion", "Tipo", "Estado"};
        DefaultTableModel modelo = new DefaultTableModel(columnas, 0);

        PedidoDAO pedidoDAO = new PedidoDAO();
        List<Pedido> pedidos = pedidoDAO.listarTodos();

        for (Pedido p : pedidos) {
            Object[] fila = {p.getId(), p.getDireccionEntrega(), p.getTipo(), p.getEstado()};
            modelo.addRow(fila);
        }

        JTable tabla = new JTable(modelo);
        JScrollPane scroll = new JScrollPane(tabla);

        add(scroll);

        setVisible(true);
    }
}