/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Recipies;

/**
 *
 * @author Noah
 */
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        // Ejemplo de uso
        ArrayList<String> ingredients1 = new ArrayList<>();
        ingredients1.add("Tomato");
        ingredients1.add("Cheese");

        ArrayList<String> ingredients2 = new ArrayList<>();
        ingredients2.add("Potato");
        ingredients2.add("Cheese");

        insert("Tomato Soup", "A delicious tomato soup", 30, 4, ingredients1);
        insert("Cheesy Potatoes", "Baked potatoes with cheese", 45, 2, ingredients2);

        System.out.println("All Recipes:");
        recipesDatabase.forEach(System.out::println);

        System.out.println("\nSearch for 'Tomato Soup':");
        search("Tomato Soup").forEach(System.out::println);

        System.out.println("\nFilter by ingredients (Cheese):");
        filter(new ArrayList<>(List.of("Cheese"))).forEach(System.out::println);

        System.out.println("\nSort by name descending:");
        sort("name", false);
        recipesDatabase.forEach(System.out::println);
    }
}
