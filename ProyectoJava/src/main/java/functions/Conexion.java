
package functions;
<<<<<<< HEAD

import org.sqlite.mc.SQLiteMCConfig;

import java.sql.Connection;

public class Conexion {
    public Connection conn(String databaseName, String key) {

        String urlTarget = String.format("jdbc:sqlite:file:%s.db", databaseName);

        try {

            return new SQLiteMCConfig.Builder().withKey(key).build().createConnection(urlTarget);
=======
import java.sql.*;

public class Conexion {
    public Connection conn() {

        Connection conn = null;
        try {
    
            conn = DriverManager.getConnection("jdbc:sqlite:users.db");
>>>>>>> main

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
<<<<<<< HEAD
        return null;
=======

        return conn;
>>>>>>> main
    }
    
}
