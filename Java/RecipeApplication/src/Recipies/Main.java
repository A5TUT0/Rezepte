/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Recipies;

import java.util.ArrayList;

/**
 *
 * @author Noah
 */
public class Main {

    public static void main(String[] args) {
        // Crear ingredientes
        ArrayList<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(new Ingredient("Tomato", "2", "None"));
        ingredients.add(new Ingredient("Cheese", "100g", "None"));
        ingredients.add(new Ingredient("Basil", "5 leaves", "None"));

        // Insertar receta
        Recipies.insert("Caprese Salad", "A simple Italian salad", 10, 2, ingredients);
    }
}
