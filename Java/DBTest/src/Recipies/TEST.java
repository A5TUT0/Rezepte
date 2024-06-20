package Recipies;

import dbtest.DB; // Importiert die DB-Klasse
import java.util.ArrayList;

public class TEST {

    private static int autoIncrementId = 0; // Automatisch inkrementierende ID für Rezepte
    private int id;
    private String name;
    private String description;
    private ArrayList<ArrayList<String>> ingredients; // Lista de ingredientes como ArrayList
    private int duration; // in Minuten
    private int persons;
    private static DB database = DB.getInstance(); // Initialisiert die Verbindung zur Datenbank
    private static ArrayList<TEST> recipesDatabase = new ArrayList<>();

    // Konstruktor zur Initialisierung eines Rezepts
    public TEST(String name, String description, int duration, int persons, ArrayList<ArrayList<String>> ingredients) {
        this.id = ++autoIncrementId;
        this.name = name;
        this.description = description;
        this.duration = duration;
        this.persons = persons;
        this.ingredients = new ArrayList<>(ingredients);
    }

    // Methode zum Einfügen eines neuen Rezepts in die Datenbank
    public static void insert(String name, String description, int duration, int persons, ArrayList<ArrayList<String>> ingredients) {
        TEST newRecipe = new TEST(name, description, duration, persons, ingredients);

        ArrayList<ArrayList<Object>> formattedIngredients = new ArrayList<>();
        for (ArrayList<String> ingredient : ingredients) {
            ArrayList<Object> formattedIngredient = new ArrayList<>(ingredient);
            formattedIngredients.add(formattedIngredient);
        }

        ArrayList<String> utensiles = new ArrayList<>(); // Lista de utensilios, ajustar según sea necesario
        ArrayList<ArrayList<String>> steps = new ArrayList<>(); // Lista de pasos, ajustar según sea necesario

        try {
            boolean success = database.addRecipe(name, formattedIngredients, utensiles, steps, duration, persons);
            if (success) {
                recipesDatabase.add(newRecipe);
                System.out.println("Receta " + name + " insertada correctamente.");
            } else {
                System.err.println("Fehler beim Einfügen des Rezepts in die Datenbank");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Methode zum Löschen eines Rezepts aus der Datenbank
    public static void delete(int id) {
        boolean success = database.deleteData("Recipes", "id", String.valueOf(id));
        if (success) {
            recipesDatabase.removeIf(recipe -> recipe.id == id);
        } else {
            System.err.println("Fehler beim Löschen des Rezepts aus der Datenbank");
        }
    }

    // Methode zum Ersetzen eines vorhandenen Rezepts in der Datenbank
    public static void replace(int id, String name, String description, int duration, int persons, ArrayList<ArrayList<String>> ingredients) {
        TEST recipe = recipesDatabase.stream().filter(r -> r.id == id).findFirst().orElse(null);
        if (recipe != null) {
            recipe.name = name;
            recipe.description = description;
            recipe.duration = duration;
            recipe.persons = persons;
            recipe.ingredients = new ArrayList<>(ingredients);

            // Hier müssen wir die Zutaten in eine Liste von Zutatennamen konvertieren
            ArrayList<ArrayList<Object>> formattedIngredients = new ArrayList<>();
            for (ArrayList<String> ingredient : ingredients) {
                ArrayList<Object> formattedIngredient = new ArrayList<>(ingredient);
                formattedIngredients.add(formattedIngredient);
            }

            // Wir aktualisieren das Rezept in der Datenbank
            boolean success = database.updateData("Recipes", "id", String.valueOf(id), "name", name);
            if (success) {
                database.updateData("Recipes", "id", String.valueOf(id), "duration", String.valueOf(duration));
                database.updateData("Recipes", "id", String.valueOf(id), "personAmount", String.valueOf(persons));
                // Actualizar los ingredientes en la base de datos también
                for (ArrayList<Object> ingredient : formattedIngredients) {
                    database.updateData("Ingredients", "name", ingredient.get(0).toString(), "name", ingredient.get(0).toString());
                }
            } else {
                System.err.println("Fehler beim Aktualisieren des Rezepts in der Datenbank");
            }
        }
    }

    // Methode zum Filtern von Rezepten nach Zutaten
    public static void filter(ArrayList<String> ingredients) {
        ArrayList<Object> recipes = database.getRecipeList("", "", "id", true);
        for (Object recipe : recipes) {
            System.out.println(recipe);
        }
    }

    // Methode zum Suchen eines Rezepts nach Namen
    public static void search(String name) {
        ArrayList<Object> recipes = database.getRecipeList("name", name, "id", true);
        for (Object recipe : recipes) {
            System.out.println(recipe);
        }
    }

    // Beim Sortieren können wir zwischen "id" oder "name" wählen & aufsteigend(True) oder absteigend(False)
    public static void sort(String sortCriteria, boolean ascending) {
        ArrayList<Object> recipes = database.getRecipeList("", "", sortCriteria, ascending);
        for (Object recipe : recipes) {
            System.out.println(recipe);
        }
    }

    // Überschreiben der toString-Methode zur Darstellung eines Rezepts als String
    @Override
    public String toString() {
        return "Recipies{"
                + "id=" + id
                + ", name='" + name + '\''
                + ", description='" + description + '\''
                + ", ingredients=" + ingredients
                + ", duration=" + duration
                + ", persons=" + persons
                + '}';
    }
}
