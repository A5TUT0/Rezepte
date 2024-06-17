package Recipies;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Recipies {

    private static int autoIncrementId = 0;
    private int id;
    private String name;
    private String description;
    private ArrayList<String> ingredients;
    private int duration; // in minutes
    private int persons;
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
    }

    public static void delete(int id) {
        recipesDatabase.removeIf(recipe -> recipe.id == id);
    }

    public static void replace(int id, String name, String description, int duration, int persons, ArrayList<String> ingredients) {
        for (Recipies recipe : recipesDatabase) {
            if (recipe.id == id) {
                recipe.name = name;
                recipe.description = description;
                recipe.duration = duration;
                recipe.persons = persons;
                recipe.ingredients = new ArrayList<>(ingredients);
                break;
            }
        }
    }

    public static List<Recipies> filter(ArrayList<String> ingredients) {
        return recipesDatabase.stream()
                .filter(recipe -> recipe.ingredients.containsAll(ingredients))
                .collect(Collectors.toList());
    }

    public static List<Recipies> search(String name) {
        return recipesDatabase.stream()
                .filter(recipe -> recipe.name.equalsIgnoreCase(name))
                .collect(Collectors.toList());
    }

    // On sortCriteria we can choose between "id" or "name" & ascending(True) or descending(False).
    public static void sort(String sortCriteria, boolean ascending) {
        Comparator<Recipies> comparator;

        switch (sortCriteria.toLowerCase()) {
            case "id":
                comparator = Comparator.comparingInt(recipe -> recipe.id);
                break;
            case "name":
                comparator = Comparator.comparing(recipe -> recipe.name.toLowerCase());
                break;
            default:
                throw new IllegalArgumentException("Invalid sort criteria: " + sortCriteria);
        }

        if (!ascending) {
            comparator = comparator.reversed();
        }

        recipesDatabase.sort(comparator);
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
