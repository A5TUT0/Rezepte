package Recipies;

/**
 *
 * @author Noah
 */
import java.net.URL;
import java.util.ArrayList;

public class Recipies {

    private static int autoIncrementId = 0;
    private int id;
    private String name = "";
    private String description = "";
    private ArrayList<String> ingredients = new ArrayList<String>();
    private int duration;
    private int persons;
    private URL database =  / waiting / api / database;

    public Recipies(String name, String description, int duration, int persons, String database) {
        this.id = ++autoIncrementId;
        this.name = name;
        this.description = description;
        this.duration = duration;
        this.persons = persons;
    }

    public void insert(String name, String description, int duration) {
        // Implementation
    }

    public void delete(int id) {
        // Implementation
    }

    public void replace(String name, String description, int duration) {
        // Implementation
    }

    public void filter(ArrayList<String> ingredients) {
        // Implementation
    }

    public void search(String name) {
        // Implementation
    }

    // On sortCriteria we cat chose between "ID" or "name" & ascending(True) or descending(False).
    public void sort(String sortCriteria, boolean ascending) {
        // Implementation
    }

}
