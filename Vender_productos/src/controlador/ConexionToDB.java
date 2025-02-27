package Controlador;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.sql.DriverManager;

public class ConexionToDB {

    Connection con;

    private static final String db = "sec";
    private static final String url = "jdbc:mysql://localhost:3306/"
            + db
            + "?useUnicode=true&useSSL=false&"
            + "JDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&"
            + "serverTimezone=UTC";
    private static final String user = "root";
    private static final String passw = "juan25sql";
    private static final String driver = "com.mysql.cj.jdbc.Driver";

    public Connection ConectarBaseDeDatos() {
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, passw);
            System.out.println("Conexión exitosa con la base de datos " + db);
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("No se pudo conectar a la base de datos " + db);
            Logger.getLogger(ConexionToDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }

    public static void main(String[] args) {
        ConexionToDB conexion = new ConexionToDB();
        conexion.ConectarBaseDeDatos();
    }

}
