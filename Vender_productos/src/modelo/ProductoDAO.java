package Modelo;

// importación de la clase de conexión y las clases necesarias para trabajar con la base de datos
import Controlador.ConexionToDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAO {

    ConexionToDB conexion = new ConexionToDB();
    
    // variables para la conexión, consultas y almacenamiento de resultados
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    // método para obtener la lista de todos los productos en la base de datos
    public List<Producto> listar() {
        List<Producto> lista = new ArrayList<>();
        con = conexion.ConectarBaseDeDatos();

        if (con == null) {
            System.err.println("No se pudo establecer la conexión con la base de datos.");
            return lista;
        }

        String sql = "SELECT * FROM productos";

        try (PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                lista.add(new Producto(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("descripcion"),
                        rs.getString("categoria"),
                        rs.getDouble("precio")
                ));
            }
        } catch (SQLException e) {
            System.err.println("Error al listar productos: " + e.getMessage());
        }
        return lista;
    }

    // método para agregar un nuevo producto a la base de datos
    public void Agregar(Producto producto) {
        String sql = "INSERT INTO productos (nombre, descripcion, categoria, precio) VALUES (?,?,?,?)";
        try {
            con = conexion.ConectarBaseDeDatos();
            ps = con.prepareStatement(sql);

            ps.setString(1, producto.getNombre());
            ps.setString(2, producto.getDescripcion());
            ps.setString(3, producto.getCategoria());
            ps.setDouble(4, producto.getPrecio());
            ps.executeUpdate();

            System.out.println("Producto agregado correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al agregar el registro: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // método para actualizar un producto que existe en la base de datos
    public void Actualizar(Producto producto) {
        String sql = "UPDATE productos SET nombre=?, descripcion=?, categoria=?, precio=? WHERE ID=?";
        try {
            con = conexion.ConectarBaseDeDatos();
            ps = con.prepareStatement(sql);

            ps.setString(1, producto.getNombre());
            ps.setString(2, producto.getDescripcion());
            ps.setString(3, producto.getCategoria());
            ps.setDouble(4, producto.getPrecio());
            ps.setInt(5, producto.getId());

            ps.executeUpdate();
            System.out.println("Registro actualizado correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al actualizar el registro: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // método para eliminar un producto de la base de datos
    public void Eliminar(int id) {
        String sql = "DELETE FROM productos WHERE id = ?";
        try (Connection con = conexion.ConectarBaseDeDatos(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al eliminar producto: " + e.getMessage());
        }
    }

}
