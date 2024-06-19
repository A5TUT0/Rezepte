/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dbtest;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 *
 * @author C.Augustiny_Work
 */
public class Main {
    public static void main(String args[]) {
        DB db = new DB();
        ArrayList<String> ingredients = new ArrayList();
        ArrayList<String> utensiles = new ArrayList();
        ArrayList<ArrayList<String>> steps = new ArrayList<>();
        ArrayList<String> step1 = new ArrayList();
        ArrayList<String> step2 = new ArrayList();
        
        // Steps
        step1.add("Wasser einfüllen");
        step1.add("Wasser aus dem Wasserhahn in das Glas einfüllen.");
        step2.add("Würzen");
        step2.add("Pizzagewürz in das Wasser legen und wieder rausnehmen");
        steps.add(step1);
        steps.add(step2);
        // Ingredients
        ingredients.add("Wasser");
        ingredients.add("Pizzagewürz");
        
        // Untensiles
        utensiles.add("Glas");
        utensiles.add("Wasserhahn");
        db.addRecipe("Pizza Wasser", ingredients, utensiles, steps, 0, 1);
        /*System.out.println("getList" + db.getRecipeList("", "", "id", true));
        System.out.println("getData" + db.getRecipeData(1));
        System.out.println("update" + db.updateData("recipes", "id", "949184", "name", "Rice"));
        System.out.println("delete" + db.deleteData("recipes", "id", "3"));*/
    }
}
