/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dbtest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author C.Augustiny_Work
 */
public class DB {
    String url = "jdbc:sqlite:my.recipes";
    
    public DB() {
        connectDatabase();
    }
    
    private boolean connectDatabase() {
        Connection connection = null;
        try {
            //Class.forName("com.mysql.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection(this.url);
            createDBStructure(connection);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return false;
        }
        return true;
    }
    
    private boolean createDBStructure(Connection connection) {
        String sql = "CREATE TABLE IF NOT EXISTS 'Recipes' ("
                + "	'id' INTEGER PRIMARY KEY,"
                + "	'name' text NOT NULL,"
                + "	'duration' INTEGER"
                + "	'personAmount' INTEGER"
                + ");";
        try (var statement = connection.createStatement()) {
            statement.execute(sql);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return false;
        }
        return true;
    }
    
   /* public boolean addRecipe(String name, ArrayList<String> ingredients, ArrayList<String> utensiles, ArrayList<String> Steps, int duration, int personAmount) {
        
    }*/
}
