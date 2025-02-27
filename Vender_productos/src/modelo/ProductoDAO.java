package Modelo;

import Controlador.ConexionToDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAO {

    ConexionToDB conexion = new ConexionToDB();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public List listar() {
        String sql = "select * from productos";
        List<Producto> lista = new ArrayList<>();

        try {
            con = conexion.ConectarBaseDeDatos();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Producto producto = new Producto();
                producto.setId(rs.getInt(1));
                producto.setNombre(rs.getString(2));
                producto.setDescripcion(rs.getString(3));
                producto.setCategoria(rs.getString(4));
                producto.setPrecio(rs.getDouble(5));
                lista.add(producto);
            }

        } catch (SQLException e) {
            System.out.println("Error al listar: " + e);
        }
        return lista;
    }

    public void Agregar(Producto producto) {
        String sql = "INSERT INTO productos (nombre, descripción, categoria, precio) VALUES (?,?,?,?)";
        try {
            con = conexion.ConectarBaseDeDatos();
            ps = con.prepareStatement(sql);

            ps.setString(1, producto.getNombre());
            ps.setString(2, producto.getDescripcion());
            ps.setString(3, producto.getCategoria());
            ps.setDouble(4, producto.getPrecio());
            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error al agregar la clase ProductoDAO.");
        }
    }

}
