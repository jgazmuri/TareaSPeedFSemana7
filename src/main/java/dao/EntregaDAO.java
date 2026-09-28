package dao;

import modelo.Entrega;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date;
import java.sql.Time;

public class EntregaDAO {

    public void guardar(Entrega entrega) {
        String sql = "INSERT INTO entrega (id_pedido, id_repartidor, fecha, hora) VALUES (?, ?, ?, ?)";

        Connection conexion = null;
        PreparedStatement statement = null;

        try {
            conexion = ConexionBD.conectar();
            statement = conexion.prepareStatement(sql);

            statement.setInt(1, entrega.getPedido().getId());
            statement.setInt(2, entrega.getRepartidor().getId());
            statement.setDate(3, Date.valueOf(entrega.getFecha()));
            statement.setTime(4, Time.valueOf(entrega.getHora()));

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