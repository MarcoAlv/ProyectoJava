
package functions;
import java.sql.*;

public class Conexion {
    public Connection conn() {

        Connection conn = null;
        try {
    
            conn = DriverManager.getConnection("jdbc:sqlite:users.db");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return conn;
    }
    
}
