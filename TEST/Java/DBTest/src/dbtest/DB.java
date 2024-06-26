/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dbtest;

import java.sql.*;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
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

    public boolean createDBStructure() {
        String recipeTable = "CREATE TABLE IF NOT EXISTS 'Recipes' ("
                + "	'id' INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "	'name' text NOT NULL UNIQUE,"
                + "	'duration' INTEGER,"
                + "	'personAmount' INTEGER"
                + ");";
        String ingredientsTable = "create table if not EXISTS \"Ingredients\" ("
                + "	\"id\" INTEGER not NULL PRIMARY KEY AUTOINCREMENT,"
                + "	\"name\" varchar(30) not null"
                + ");";
        String utensilesTable = "create table if not exists \"Utensiles\" ("
                + "	\"id\" INTEGER not NULL PRIMARY KEY AUTOINCREMENT,"
                + "	\"name\" varchar(30) not null"
                + ");";
        String stepsTable = "create table if not exists \"Steps\" ("
                + "	\"id\" INTEGER not NULL PRIMARY KEY AUTOINCREMENT,"
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

    /*Later JDOC: 
        Steps: [name, Description]
    Ingredients: [name, amount, unit]
     */
    public boolean addRecipe(String name, ArrayList<ArrayList<Object>> ingredients, ArrayList<String> utensiles, ArrayList<ArrayList<String>> steps, int duration, int personAmount) {
        String ingredientsValues = "VALUES ";
        String utensilesValues = "VALUES ";
        String stepValues = "VALUES ";
        // Ingredients
        for (int i = 0; i <= ingredients.size() - 1; i++) {
            ingredientsValues += "(\"" + ingredients.get(i).get(0) + "\")";
            if (i != ingredients.size() - 1) {
                ingredientsValues += ", ";
            } else {
                ingredientsValues += ";";
            }
        }

        // Utensiles
        for (int i = 0; i <= utensiles.size() - 1; i++) {
            utensilesValues += "(\"" + utensiles.get(i) + "\")";
            if (i != steps.size() - 1) {
                utensilesValues += ", ";
            } else {
                utensilesValues += ";";
            }
        } // Steps
        for (int i = 0; i <= steps.size() - 1; i++) {
            stepValues += "(\"" + steps.get(i).get(0) + "\", \"" + steps.get(i).get(1) + "\")";
            if (i != steps.size() - 1) {
                stepValues += ", ";
            } else {
                stepValues += ";";
            }
        }
        String insertRecipe = "INSERT INTO \"Recipes\" (\"name\", \"duration\", \"personAmount\") VALUES (\"" + name + "\", \"" + duration + "\", \"" + personAmount + "\");";
        String insertIngredients = "INSERT INTO \"Ingredients\" (\"name\") " + ingredientsValues;
        String insertUtensiles = "INSERT INTO \"Utensiles\" (\"name\") " + utensilesValues;
        String insertSteps = "INSERT INTO \"Steps\" (\"name\", \"description\") " + stepValues;
        try (var statement = this.connection.createStatement()) {
            statement.execute(insertRecipe);
            statement.execute(insertSteps);
            statement.execute(insertIngredients);
            statement.execute(insertUtensiles);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return false;
        }

        int recipeID = getID("recipes", name);
        String recipesIngredients = "INSERT INTO \"Recipes_Ingredients\" (recipe_id, ingredient_id, amount, unit) VALUES ";
        String recipesUtensiles = "INSERT INTO \"Utensiles_Recipes\" (recipe_id, utensile_id) VALUES ";
        String recipesSteps = "INSERT INTO \"Steps_Recipes\" (recipe_id, step_id) VALUES ";
        // Recipe_Ingredient
        for (int i = 0; i <= ingredients.size() - 1; i++) {
            int ingredientId = getID("ingredients", ingredients.get(i).get(0).toString());
            recipesIngredients += "(\"" + recipeID + "\", \"" + ingredientId + "\", " + ingredients.get(i).get(1) + ", \"" + ingredients.get(i).get(2) + "\")";
            if (i != ingredients.size() - 1) {
                recipesIngredients += ", ";
            } else {
                recipesIngredients += ";";
            }
        }

        // Recipe_Utensiles
        for (int i = 0; i <= utensiles.size() - 1; i++) {
            int utensilesId = getID("utensiles", utensiles.get(i));
            recipesUtensiles += "(\"" + recipeID + "\", \"" + utensilesId + "\")";
            if (i != utensiles.size() - 1) {
                recipesUtensiles += ", ";
            } else {
                recipesUtensiles += ";";
            }
        }

        for (int i = 0; i <= steps.size() - 1; i++) {
            int stepId = getID("steps", steps.get(i).get(0));
            recipesSteps += "(\"" + recipeID + "\", \"" + stepId + "\")";
            if (i != steps.size() - 1) {
                recipesSteps += ", ";
            } else {
                recipesSteps += ";";
            }
        }

        System.out.println(recipesIngredients);
        System.out.println(recipesUtensiles);
        System.out.println(recipesSteps);
        try (var statement = this.connection.createStatement()) {
            statement.execute(recipesIngredients);
            statement.execute(recipesUtensiles);
            statement.execute(recipesSteps);
            return true;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return false;
        }
    }

    public ArrayList<Object> getRecipeList(String argument, String filter, String sort, boolean ASC) {
        String order;
        String whereStatement = "WHERE " + argument + " = \"" + filter + "\" ";
        try {
            if (ASC) {
                order = "ASC";
            } else {
                order = "DESC";
            }

            if (argument.equals("") || filter.equals("")) {
                whereStatement = "";
            }

            String query = "SELECT * FROM Recipes " + whereStatement + "ORDER BY \"" + sort + "\" " + order + ";";
            ArrayList<Object> result = new ArrayList<Object>();
            Statement stmt = this.connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                result.add(rs.getInt("id"));
                result.add(rs.getString("name"));
            }
            return result;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return null;
        }
    }

    public ArrayList<Object> getRecipeData(int id) {
        try {
            String query = "SELECT * FROM Recipes as r JOIN Recipes_Ingredients as ri on r.id = ri.recipe_id JOIN Utensiles_Recipes as ur on r.id = ur.recipe_id JOIN Steps_Recipes as sr on r.id = sr.recipe_id JOIN Steps as s on s.id = sr.step_id JOIN Utensiles as u on u.id = ur.utensile_id JOIN Ingredients as i on i.id = ri.ingredient_id WHERE r.id = " + id + ";";
            ArrayList<Object> result = new ArrayList<Object>();
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                result.add(rs.getString("name"));
                result.add(rs.getInt("id"));
                result.add(rs.getInt("personAmount"));
            }
            return result;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return null;
        }
    }

    public boolean updateData(String table, String argument, String filter, String attribute, String value) {
        try {
            String query = "UPDATE " + table + " SET " + attribute + " = \"" + value + "\" WHERE " + argument + " = " + filter + ";";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.execute();
            statement.close();
            return true;
        } catch (SQLException e) {
            // For the error "The database file is locked (database is locked)": Close the SQLiteBrowser
            System.err.println(e.getMessage());
            return false;
        }
    }

    public boolean deleteData(String table, String argument, String filter) {
        try {
            String query = "DELETE FROM " + table + " WHERE " + argument + " = " + filter + ";";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.execute();
            statement.close();
            return true;
        } catch (SQLException e) {
            // For the error "The database file is locked (database is locked)": Close the SQLiteBrowser
            System.err.println(e.getMessage());
            return false;
        }
    }

    public int getID(String table, String name) {
        try {
            String query = "SELECT * FROM \"" + table + "\" WHERE \"name\" = " + "\"" + name + "\"" + ";";
            Statement stmt = this.connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            return rs.getInt("id");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return 0;
        }
    }
    /**
     * 
     * @param fileName
     * @return 
     */
  public boolean exportRecipesToCSV(String fileName) {
        String query = "SELECT * FROM Recipes";
        try (FileWriter writer = new FileWriter(fileName);
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            ResultSetMetaData rsmd = rs.getMetaData();
            int columns = rsmd.getColumnCount();

            // Spaltenüberschriften schreiben
            for (int i = 1; i <= columns; i++) {
                writer.append(rsmd.getColumnName(i)).append(",");
            }
            writer.append("\n");

            // Zeilendaten schreiben
            while (rs.next()) {
                for (int i = 1; i <= columns; i++) {
                    writer.append(rs.getString(i)).append(",");
                }
                writer.append("\n");
            }
            writer.flush();
            return true;
        } catch (SQLException | IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
