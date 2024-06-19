package Recipies;

public class Ingredient {

    private String name;
    private String quantity;
    private String alternative;

    public Ingredient(String name, String quantity, String alternative) {
        this.name = name;
        this.quantity = quantity;
        this.alternative = alternative;
    }

    // Getters and setters for name, quantity, and alternative
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getAlternative() {
        return alternative;
    }

    public void setAlternative(String alternative) {
        this.alternative = alternative;
    }
}
