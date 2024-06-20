/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Recipies;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Noah
 */
public class Main {

    public static void main(String[] args) {
        // Crear ingredientes
        ArrayList<HashMap<String, String>> ingredients = new ArrayList<>();

        HashMap<String, String> ingredient1 = Recipies.createIngredient("Tomato", "2", "Cherry Tomato");
        HashMap<String, String> ingredient2 = Recipies.createIngredient("Salt", "1 tsp", "Sea Salt");

        ingredients.add(ingredient1);
        ingredients.add(ingredient2);

        // Insertar receta en la base de datos
        Recipies.insert("Tomato Salad", "A simple and delicious tomato salad", 10, 2, ingredients);
    }
}
