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
        ArrayList<String> steps = new ArrayList();
        ingredients.add("Wasser");
        steps.add("Wasser einfüllen");
        utensiles.add("Glas");
        //db.addRecipe("Wasser", ingredients, utensiles, steps, 0, 1);
        System.out.println("getList" + db.getRecipeList("id", "1"));
        System.out.println("getData" + db.getRecipeData(1));
    }
}
