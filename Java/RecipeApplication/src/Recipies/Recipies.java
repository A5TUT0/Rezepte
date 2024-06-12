/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Recipies;

import java.util.ArrayList; // import the ArrayList class

/**
 *
 * @author Noah
 */


public class Recipies {
    
    private static int autoIncrementId = 0;
    private int id;
    private String Name = "";
    private String Description = "";
    private ArrayList<String> Ingredients = new ArrayList<String>(); // Create an Arraylist obejt
    private int Duration = "";
    private int Persons = "";

    public void Recipies(String Name, String Description, int Duration, int Persons) {
        this.id = ++autoIncrementId;
        this.Name = Name;
        this.Description = Description;
        this.Duration = Duration;
        this.Persons = Persons;
    }

    private void insrt(Name, Description, Duration) {

    }

    private void delete(id) {

    }

    private void replace(Name, Description, Duration) {

    }

    private void filter(Ingredients) {

    }

    private void search(Name) {

    }

    private void sort(Name, Ingredients, Persons) {

    }
}
