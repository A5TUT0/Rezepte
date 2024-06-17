package Recipies;

import Database.DB; // Importa la clase DB
import java.util.ArrayList;

public class Recipies {

    private static int autoIncrementId = 0;
    private int id;
    private String name;
    private String description;
    private ArrayList<String> ingredients;
    private int duration; // in minutes
    private int persons;
    private static DB database = new DB(); // Inicializa la conexión con la base de datos
    private static ArrayList<Recipies> recipesDatabase = new ArrayList<>();

    public Recipies(String name, String description, int duration, int persons, ArrayList<String> ingredients) {
        this.id = ++autoIncrementId;
        this.name = name;
        this.description = description;
        this.duration = duration;
        this.persons = persons;
        this.ingredients = new ArrayList<>(ingredients);

    }

    public static void insert(String name, String description, int duration, int persons, ArrayList<String> ingredients) {
        Recipies newRecipe = new Recipies(name, description, duration, persons, ingredients);
        recipesDatabase.add(newRecipe);

        boolean success = database.addRecipe(name, ingredients, new ArrayList<>(), new ArrayList<>(), duration, persons);
        if (success) {
            System.out.println("Recipe added successfully");
        } else {
            System.out.println("ERROR ON ADD A RECIPIE");
        }
    }

    public static void delete(int id) {
    }

    public static void replace(int id, String name, String description, int duration, int persons, ArrayList<String> ingredients) {
    }

    public static void filter(ArrayList<String> ingredients) {
    }

    public static void search(String name) {

    }

    // On sortCriteria we can choose between "id" or "name" & ascending(True) or descending(False).
    public static void sort(String sortCriteria, boolean ascending) {
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
