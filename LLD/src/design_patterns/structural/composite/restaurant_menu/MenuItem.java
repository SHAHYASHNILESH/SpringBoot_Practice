package design_patterns.structural.composite.restaurant_menu;

public class MenuItem implements MenuComponent {
    private String name;
    private String description;
    private double price;

    public MenuItem(String name, String description, double price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    @Override
    public void print() {
        System.out.printf("Item: %s\nDescription: %s\nPrice: $%.2f\n", name, description, price);
    }
}