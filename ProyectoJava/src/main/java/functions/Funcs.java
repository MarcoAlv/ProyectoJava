package functions;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Funcs {
    public void cls() {
        
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public void CreateDataBase() {

        try {
            Conexion cc = new Conexion();
            Connection cn = cc.conn();

            Statement statement = cn.createStatement();
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS usersdata (id INTEGER PRIMARY KEY, user_name VARCHAR(255), password VARCHAR(255))");
            statement.executeUpdate("INSERT INTO usersdata values(1, 'admin', 'adminPassword')");
            statement.executeUpdate("INSERT INTO usersdata values(2, 'Paola', 'ContraseñaPaola')");
            statement.executeUpdate("INSERT INTO usersdata values(3, 'Marcos', 'ContraseñaMarcos')");
        } catch (SQLException e) {
            Logger.getLogger(Funcs.class.getName()).log(Level.SEVERE, null, e);
        }



    }

    public boolean userValidation(String user, String password) {

        try {
            Conexion cc = new Conexion();
            Connection cn = cc.conn();

            PreparedStatement ps = cn.prepareStatement("SELECT password FROM usersdata WHERE user_name = ?");

            ps.setString(1, user);
            ResultSet rs = ps.executeQuery();

            if (password.equals(rs.getString("password"))) {
                return true;
            } else {    
                return false;
            }

        } catch (SQLException e) {
            Logger.getLogger(Funcs.class.getName()).log(Level.SEVERE, null, e);
        }

        return false;

    }

    

}
