package Data;

import interfaces.filewriting;

public class Equipment implements filewriting{
    // Properties
    private String name;
    private String category;
    private int quantity;

    // Constructor
    public Equipment(String name, String category, int quantity) {
        this.name = name;
        this.category = category;
        this.quantity = quantity;
    }

    
    public String getAllAttributes() {
        String attributes = "," + name + "," + category + ","
                + String.valueOf(quantity);

        return attributes;
    }

    // Getter methods
    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public int getQuantity() {
        return quantity;
    }

    // Setter method for quantity
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // Method to display information about the equipment
    public void displayInfo() {
        System.out.println("Equipment: " + name);
        System.out.println("Category: " + category);
        System.out.println("Quantity: " + quantity);
    }
}