package functions;

import java.security.SecureRandom;
import java.util.Random;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Arrays;


public class Func {


    public static final Random random = new SecureRandom();
    public static Conexion connector;
    public static Connection connectionUsersDataBase = null;
    public static Statement statement;


    static {
        connector = new Conexion();
        connectionUsersDataBase = connector.conn("file", "Key");
    }

    public void cls() {
        
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void createUsersDatabase() {

        try {

            statement = connectionUsersDataBase.createStatement();
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS usersData (id INTEGER PRIMARY KEY," +
                    " name VARCHAR(255), last_name VARCHAR(255), user_name VARCHAR(255)," +
                    " password VARCHAR(255), age INTEGER, cellphone_number INTEGER, url VARCHAR(255))");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    public boolean createUser(int id, String name, String last_name, String user_name,
                              String password, int age, int cell, String url) {

        try {

            String sqlQuery = "INSERT INTO usersData values(?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement ps = connectionUsersDataBase.prepareStatement(sqlQuery);
            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setString(3, last_name);
            ps.setString(4, user_name);
            ps.setString(5, password);
            ps.setInt(6, age);
            ps.setInt(7, cell);
            ps.setString(8, url);

            ps.executeUpdate();

            return true;

        } catch (SQLException e) {
            Logger.getLogger(Func.class.getName()).log(Level.SEVERE, null, e);
        }
        return false;
    }

    public static int getMaxId(String table) {

        ResultSet rs;
        try {
            PreparedStatement ps = connectionUsersDataBase.prepareStatement(String
                    .format("SELECT MAX(id) FROM %s", table));
            rs = ps.executeQuery();
            return rs.getInt(1) + 1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean userValidation(String user, String password) {

        try {
            PreparedStatement ps = connectionUsersDataBase.prepareStatement("SELECT password FROM usersData WHERE user_name = ?");

            ps.setString(1, user);
            ResultSet rs = ps.executeQuery();

            return password.equals(rs.getString("password"));

        } catch (SQLException e) {
            Logger.getLogger(Func.class.getName()).log(Level.SEVERE, null, e);
        }

        return true;

    }

    public boolean optionValidator(int opt, int range) {
        return (opt >= 1 && opt <= range);
    }

    public static String passwordGen(int[] options, String all, int length) {

        String[] data = new String[4];

        data[0] ="abcdefghijklmnopqrstuvwxyz";
        data[1] ="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        data[2] ="!@#$%^&*()_+-={}[]|\\:;\"'<>,.?/";
        data[3] ="0123456789";

        StringBuilder password = new StringBuilder();
        int selected = Arrays.stream(options).sum();

        for (int i = 0; i < 4; i++) {

            if (options[i] == 1) {
                password.append(getRandomCharacter(data[i]));
            }

        }

        for (int i = selected; i < length; i++) {
            password.append(getRandomCharacter(all));
        }

        // Mezcla los caracteres para que no estén en orden predecible

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(length);
            char temp = password.charAt(i);
            password.setCharAt(i, password.charAt(randomIndex));
            password.setCharAt(randomIndex, temp);
        }

        return password.toString();
    }

    private static Object getRandomCharacter(String characterSet) {
        int randomIndex = random.nextInt(characterSet.length());
        return characterSet.charAt(randomIndex);
    }


    public String[][] ReadCSV(String pathname){
        try{
            File getFile = new File(pathname);
            Scanner reader = new Scanner(getFile);
            List<String[]> readFile = new ArrayList<>();
            while (reader.hasNext()){
                readFile.add(reader.next().split(","));
            }
            String [][] retornoCSV = new String [readFile.size()][];
            readFile.toArray(retornoCSV);
            return retornoCSV;
        }
        catch (FileNotFoundException e){
            System.out.println("Archivo csv no encontrado...");
            return null;
        }
    }

}


