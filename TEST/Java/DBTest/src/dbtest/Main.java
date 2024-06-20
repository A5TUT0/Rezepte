package dbtest;
import java.sql.*;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
public class Main {
    public static void main(String[] args) {
        DB db = new DB();

        // Crear la estructura de la base de datos
        db.createDBStructure();

        // Agregar algunas recetas para exportar
        ArrayList<ArrayList<Object>> ingredients = new ArrayList<>();
        ArrayList<Object> ingredient = new ArrayList<>();
        ingredient.add("Salt");
        ingredient.add(1);
        ingredient.add("tsp");
        ingredients.add(ingredient);

        ArrayList<String> utensils = new ArrayList<>();
        utensils.add("Spoon");

        ArrayList<ArrayList<String>> steps = new ArrayList<>();
        ArrayList<String> step = new ArrayList<>();
        step.add("Step 1");
        step.add("Mix ingredients");
        steps.add(step);

        db.addRecipe("Test Recipe", ingredients, utensils, steps, 30, 4);

        // Exportar los datos de la tabla Recipes a un archivo CSV
        boolean exportResult = db.exportRecipesToCSV("recipes_export.csv");
        if (exportResult) {
            System.out.println("Datos exportados exitosamente a recipes_export.csv");
        } else {
            System.out.println("Error al exportar los datos.");
        }
    }
}
