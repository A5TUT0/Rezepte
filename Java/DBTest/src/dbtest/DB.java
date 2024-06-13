/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dbtest;

import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author C.Augustiny_Work
 */
public class DB {
    String url = "jdbc:sqlite:rezepte.db";
    Connection connection = null;
    
    public DB() {
        connectDatabase();
    }
    
    private boolean connectDatabase() {
        try {
            //Class.forName("com.mysql.jdbc.Driver").newInstance();
            this.connection = DriverManager.getConnection(this.url);
            createDBStructure();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return false;
        }
        return true;
    }
    
    private boolean createDBStructure() {
        String recipeTable = "CREATE TABLE IF NOT EXISTS 'Recipes' ("
                + "	'id' INTEGER PRIMARY KEY,"
                + "	'name' text NOT NULL,"
                + "	'duration' INTEGER,"
                + "	'personAmount' INTEGER"
                + ");";
        String ingredientsTable = "create table if not EXISTS \"Ingredients\" ("
                + "	\"id\" int not NULL PRIMARY KEY,"
                + "	\"name\" varchar(30) not null"
                + ");";
        String utensilesTable = "create table if not exists \"Utensiles\" ("
                + "	\"id\" int not NULL PRIMARY KEY,"
                + "	\"name\" varchar(30) not null"
                + ");";
        String stepsTable = "create table if not exists \"Steps\" ("
                + "	\"id\" int not NULL PRIMARY KEY,"
                + "	\"name\" varchar(30) not null,"
                + "	\"description\" varchar(500)"
                + ");";
        String recipeIngredientsTable = "create table if not exists \"Recipes_Ingredients\" ("
                + "	\"recipe_id\" int not null,"
                + "	\"ingredient_id\" int not null,"
                + "	\"amount\" int not null,"
                + "	\"unit\" varchar(10),"
                + "	FOREIGN KEY (\"recipe_id\") REFERENCES \"Recipes\"(\"id\"),"
                + "	FOREIGN KEY (\"ingredient_id\") REFERENCES \"Ingredients\"(\"id\")"
                + ");";
        String recipeUtensilesTable = "create table if not exists \"Utensiles_Recipes\" ("
                + "	\"recipe_id\" int not null,"
                + "	\"utensile_id\" int not null,"
                + "	FOREIGN KEY (\"recipe_id\") REFERENCES \"Recipes\"(\"id\"),"
                + "	FOREIGN KEY (\"utensile_id\") REFERENCES \"Utensiles\"(\"id\")"
                + ");";
        String recipeStepsTable = "create table if not exists \"Steps_Recipes\" ("
                + "	\"recipe_id\" int not null,"
                + "	\"step_id\" int not null,"
                + "	FOREIGN KEY (\"recipe_id\") REFERENCES \"Recipes\"(\"id\"),"
                + "	FOREIGN KEY (\"step_id\") REFERENCES \"Steps\"(\"id\")"
                + ");";
        try (var statement = this.connection.createStatement()) {
            statement.execute(recipeTable);
            statement.execute(ingredientsTable);
            statement.execute(utensilesTable);
            statement.execute(stepsTable);
            statement.execute(recipeIngredientsTable);
            statement.execute(recipeUtensilesTable);
            statement.execute(recipeStepsTable);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return false;
        }
        return true;
    }
    
   public boolean addRecipe(String name, ArrayList<String> ingredients, ArrayList<String> utensiles, ArrayList<String> Steps, int duration, int personAmount) {
        String insertRecipe = "INSERT INTO \"Recipes\" (\"name\", \"duration\", \"personAmount\") VALUES (\""+ name + "\", \"" + duration+ "\", \"" + personAmount + "\");";
        /*String insertSteps = "";
        String insertIngredients = "";
        String insertUtensiles = "";*/
        try (var statement = this.connection.createStatement()) {
            statement.execute(insertRecipe);
            /*statement.execute(insertSteps);
            statement.execute(insertIngredients);
            statement.execute(insertUtensiles);*/
            return true;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return false;
        }
    }
   
   public ArrayList<Object> selectRecipe(String query) {
        try{
            ArrayList<Object> result = new ArrayList<Object>();
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()) {
                result.add(rs.getString("name"));
                result.add(rs.getInt("id"));
            }
            return result;
        } catch(SQLException e) {
            System.err.println(e.getMessage());
            return null;
        }
    }
}
