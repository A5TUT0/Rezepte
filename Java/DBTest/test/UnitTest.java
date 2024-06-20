/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
import dbtest.DB;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author AST
 */
public class DBTest {
    private DB db;

    @Before
    public void setUp() {
        db = new DB();
    }

    @After
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
        assertNotNull("Connection should not be null", db.connection);
    }

    @Test
    public void testCreateDBStructure() {
        assertTrue("Database structure should be created", db.createDBStructure());
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
        assertTrue("Recipe should be added successfully", result);
    }

    @Test
    public void testGetID() {
        db.addRecipe("Test Recipe", new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), 30, 4);
        int id = db.getID("Recipes", "Test Recipe");
        assertTrue("ID should be greater than 0", id > 0);
    }
}
