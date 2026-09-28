package dao;

import modelo.Repartidor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RepartidorDAO {

    public List<Repartidor> listarTodos() {
        String sql = "SELECT * FROM repartidor";
        List<Repartidor> repartidores = new ArrayList<>();

        Connection conexion = null;
        PreparedStatement statement = null;
        ResultSet resultado = null;

        try {
            conexion = ConexionBD.conectar();
            statement = conexion.prepareStatement(sql);
            resultado = statement.executeQuery();

            while (resultado.next()) {
                int id = resultado.getInt("id");
                String nombre = resultado.getString("nombre");

                Repartidor repartidor = new Repartidor(id, nombre);
                repartidores.add(repartidor);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultado != null) resultado.close();
                if (statement != null) statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            ConexionBD.cerrarConexion(conexion);
        }

        return repartidores;
    }

    public void guardar(Repartidor repartidor) {
        String sql = "INSERT INTO repartidor (nombre) VALUES (?)";

        Connection conexion = null;
        PreparedStatement statement = null;

        try {
            conexion = ConexionBD.conectar();
            statement = conexion.prepareStatement(sql);

            statement.setString(1, repartidor.getNombre());

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