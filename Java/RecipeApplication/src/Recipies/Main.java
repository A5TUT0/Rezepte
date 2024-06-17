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
        ArrayList<String> ingredients = new ArrayList<>();
        ingredients.add("Flour");
        ingredients.add("Sugar");

        Recipies.insert("Cake", "A delicious cake", 60, 4, ingredients);
    }
}
