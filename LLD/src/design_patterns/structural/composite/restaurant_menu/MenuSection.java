package design_patterns.structural.composite.restaurant_menu;

import java.util.ArrayList;
import java.util.List;

public class MenuSection implements MenuComponent {
    private String sectionName;
    private List<MenuComponent> menuComponents;

    public MenuSection(String sectionName) {
        this.sectionName = sectionName;
        this.menuComponents = new ArrayList<>();
    }

    public void add(MenuComponent menuComponent) {
        // TODO: Add the menu component to the list of menu components
        menuComponents.add(menuComponent);
    }

    @Override
    public void print() {
        System.out.println("Section: " + sectionName);
        for (MenuComponent menuComponent : menuComponents) {
            // TODO: Print the details of the menu component
            menuComponent.print();
        }
    }
}
