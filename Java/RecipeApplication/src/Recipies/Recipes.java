package Recipies;

import java.util.ArrayList;

public class Recipies {

    private static int autoIncrementId = 0;
    private int id;
    private String Name = "";
    private String Description = "";
    private ArrayList<String> Ingredients = new ArrayList<String>();
    private int Duration;
    private int Persons;

    public Recipies(String Name, String Description, int Duration, int Persons) {
        this.id = ++autoIncrementId;
        this.Name = Name;
        this.Description = Description;
        this.Duration = Duration;
        this.Persons = Persons;
    }

    public void insert(String Name, String Description, int Duration) {
        // Implementación
    }

    public void delete(int id) {
        // Implementación
    }

    public void replace(String Name, String Description, int Duration) {
        // Implementación
    }

    public void filter(Ingredients) {
        // Implementación
    }

    public void search(String Name) {
        // Implementación
    }

    // On sortCriteria we cat chose between "ID" or "Name" & ascending(True) or descending(False).
    public void sort(String sortCriteria, boolean ascending, ) {  
        // Implementación
    }

}
