package Recipies;

import Database.DB; // Importiert die DB-Klasse
import java.util.ArrayList;

public class Recipies {

    private static int autoIncrementId = 0; // Automatisch inkrementierende ID für Rezepte
    private int id;
    private String name;
    private String description;
    private ArrayList<Ingredient> ingredients;
    private int duration; // in Minuten
    private int persons;
    private static DB database = new DB(); // Initialisiert die Verbindung zur Datenbank
    private static ArrayList<Recipies> recipesDatabase = new ArrayList<>();

    public Recipies(String name, String description, int duration, int persons, ArrayList<Ingredient> ingredients) {
        this.id = ++autoIncrementId;
        this.name = name;
        this.description = description;
        this.duration = duration;
        this.persons = persons;
        this.ingredients = new ArrayList<>(ingredients);
    }

    public static void insert(String name, String description, int duration, int persons, ArrayList<Ingredient> ingredients) {
        Recipies newRecipe = new Recipies(name, description, duration, persons, ingredients);

        // Hier müssen wir die Zutaten in eine Liste von Zutatennamen konvertieren
        ArrayList<String> ingredientNames = new ArrayList<>();
        for (Ingredient ingredient : ingredients) {
            ingredientNames.add(ingredient.getName());
        }

        try {
            // Wir fügen das Rezept in die Datenbank ein
            boolean success = database.addRecipe(name, ingredientNames, new ArrayList<>(), new ArrayList<>(), duration, persons);
            if (success) {
                recipesDatabase.add(newRecipe);
            } else {
                System.err.println("Fehler beim Einfügen des Rezepts in die Datenbank");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void delete(int id) {
        boolean success = database.deleteData("Recipes", "id", String.valueOf(id));
        if (success) {
            recipesDatabase.removeIf(recipe -> recipe.id == id);
        } else {
            System.err.println("Fehler beim Löschen des Rezepts aus der Datenbank");
        }
    }

    public static void replace(int id, String name, String description, int duration, int persons, ArrayList<Ingredient> ingredients) {
        Recipies recipe = recipesDatabase.stream().filter(r -> r.id == id).findFirst().orElse(null);
        if (recipe != null) {
            recipe.name = name;
            recipe.description = description;
            recipe.duration = duration;
            recipe.persons = persons;
            recipe.ingredients = new ArrayList<>(ingredients);

            // Hier müssen wir die Zutaten in eine Liste von Zutatennamen konvertieren
            ArrayList<String> ingredientNames = new ArrayList<>();
            for (Ingredient ingredient : ingredients) {
                ingredientNames.add(ingredient.getName());
            }

            // Wir aktualisieren das Rezept in der Datenbank
            boolean success = database.updateData("Recipes", "id", String.valueOf(id), "name", name);
            if (success) {
                database.updateData("Recipes", "id", String.valueOf(id), "duration", String.valueOf(duration));
                database.updateData("Recipes", "id", String.valueOf(id), "personAmount", String.valueOf(persons));
            } else {
                System.err.println("Fehler beim Aktualisieren des Rezepts in der Datenbank");
            }
        }
    }

    public static void filter(ArrayList<String> ingredients) {
        ArrayList<Object> recipes = database.getRecipeList("", "", "id", true);
        for (Object recipe : recipes) {
            System.out.println(recipe);
        }
    }

    public static void search(String name) {
        ArrayList<Object> recipes = database.getRecipeList("name", name, "id", true);
        for (Object recipe : recipes) {
            System.out.println(recipe);
        }
    }

    // Beim Sortieren können wir zwischen "id" oder "name" wählen & aufsteigend(True) oder absteigend(False).
    public static void sort(String sortCriteria, boolean ascending) {
        ArrayList<Object> recipes = database.getRecipeList("", "", sortCriteria, ascending);
        for (Object recipe : recipes) {
            System.out.println(recipe);
        }
    }

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
