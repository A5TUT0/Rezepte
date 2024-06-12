/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database;
import java.sql.DriverManager;
import java.sql.SQLException;
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
        try (var conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                var meta = conn.getMetaData();
                createDBStructure();
                return true;
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return false;
        }
        return false;
    }
    
    private boolean createDBStructure() {
        
    }
    
    public boolean addRecipe(String name, ArrayList<String> ingredients, ArrayList<String> utensiles, ArrayList<String> Steps, int duration, int personAmount) {
        
    }
    
}
