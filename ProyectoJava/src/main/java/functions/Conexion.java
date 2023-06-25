
package functions;

import org.sqlite.mc.SQLiteMCConfig;

import java.sql.Connection;

public class Conexion {
    public Connection conn(String databaseName, String key) {

        String urlTarget = String.format("jdbc:sqlite:file:%s.db", databaseName);

        try {

            return new SQLiteMCConfig.Builder().withKey(key).build().createConnection(urlTarget);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    
}
