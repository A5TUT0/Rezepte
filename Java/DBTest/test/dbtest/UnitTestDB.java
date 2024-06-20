package dbtest;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;

public class UnitTestDB {

    private DB db;

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
       
    }

    @BeforeEach
    public void setUp() {
        db = new DB();
    }

    @AfterEach
    public void tearDown() {
        try {
            if (db.connection != null) {
                db.connection.close();
            }
            File dbFile = new File("rezepte.db");
            if (dbFile.exists()) {
                dbFile.delete();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testConnectDatabase() {
        assertNotNull(db.connection, "Connection should not be null");
    }

    @Test
    public void testCreateDBStructure() {
        assertTrue(db.createDBStructure(), "Database structure should be created");
    }

    @Test
    public void testAddRecipe() {
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

        boolean result = db.addRecipe("Test Recipe", ingredients, utensils, steps, 30, 4);
        assertTrue(result, "Recipe should be added successfully");
    }

    @Test
    public void testGetID() {
        db.addRecipe("Test Recipe", new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), 30, 4);
        int id = db.getID("Recipes", "Test Recipe");
        assertTrue(id > 0, "ID should be greater than 0");
    }
}
    