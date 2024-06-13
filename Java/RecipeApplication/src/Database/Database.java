/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database;
import java.io.FileNotFoundException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;  
import java.sql.Statement;
import java.sql.Connection;
import java.util.ArrayList;


/**
 *
 * @author C.Augustiny_Work
 */
public class Database {
    
    String url = "jdbc:sqlite:my.recipes";
    
    public Database() {
        connectDatabase();
    }
    
    private boolean connectDatabase() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(this.url);
            createDBStructure(connection);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return false;
        }
        return true;
    }
    
    private boolean createDBStructure(Connection connection) {
        String sql = "CREATE TABLE IF NOT EXISTS warehouses ("
                + "	id INTEGER PRIMARY KEY,"
                + "	name text NOT NULL,"
                + "	capacity REAL"
                + ");";
        try (var statement = connection.createStatement()) {
            statement.execute(sql);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return false;
        }
        return true;
    }
    
    public boolean addRecipe(String name, ArrayList<String> ingredients, ArrayList<String> utensiles, ArrayList<String> Steps, int duration, int personAmount) {
        
    }
    
}
