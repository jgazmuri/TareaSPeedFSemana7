package dao;


import modelo.Pedido;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PedidoDAO {

    public void guardar(Pedido pedido) {
        String sql = "INSERT INTO pedido (direccion, tipo, estado) VALUES (?, ?, ?)";

        Connection conexion = null;
        PreparedStatement statement = null;

        try {
            conexion = ConexionBD.conectar();
            statement = conexion.prepareStatement(sql);

            statement.setString(1, pedido.getDireccionEntrega());
            statement.setString(2, pedido.getTipo());
            statement.setString(3, pedido.getEstado().toString());

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

            try {
                if (statement != null) statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            ConexionBD.cerrarConexion(conexion);

        }
    }

}
