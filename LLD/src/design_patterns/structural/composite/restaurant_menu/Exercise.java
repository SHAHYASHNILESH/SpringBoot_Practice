package design_patterns.structural.composite.restaurant_menu;

import java.util.Scanner;

public class Exercise {

    // Do not modify the run method. It facilitates the menu creation process by gathering user input for various sections and items.
    public void run() {

        Scanner sc = new Scanner(System.in);

        String appetizersSectionName = sc.nextLine();
        String mainCoursesSectionName = sc.nextLine();
        String dessertsSectionName = sc.nextLine();
        String seaFoodSectionName = sc.nextLine();

        MenuSection appetizers = new MenuSection(appetizersSectionName);
        MenuSection mainCourses = new MenuSection(mainCoursesSectionName);
        MenuSection desserts = new MenuSection(dessertsSectionName);
        MenuSection seafood = new MenuSection(seaFoodSectionName);

        for (int i = 0; i < 2; i++) {
            String name = sc.nextLine();
            String description = sc.nextLine();
            double price = sc.nextDouble();
            sc.nextLine();

            // TODO: Create a new MenuItem for the appetizer using the provided name, description, and price
            MenuItem appetizer = new MenuItem(name, description, price);

            // TODO: Add the newly created appetizer to the appetizers menu section
            appetizers.add(appetizer);

        }

        // Get user input for main courses
        for (int i = 0; i < 2; i++) {
            String name = sc.nextLine();
            String description = sc.nextLine();
            double price = sc.nextDouble();
            sc.nextLine();

            // TODO: Create a new MenuItem for the main course using the provided name, description, and price
            MenuItem mainCourse = new MenuItem(name, description, price);

            // TODO: Add the newly created main course to the mainCourses menu section
            mainCourses.add(mainCourse);

        }

        // Get user input for desserts
        for (int i = 0; i < 2; i++) {
            String name = sc.nextLine();
            String description = sc.nextLine();
            double price = sc.nextDouble();
            sc.nextLine();

            // TODO: Create a new MenuItem for the dessert using the provided name, description, and price
            MenuItem dessert = new MenuItem(name, description, price);

            // TODO: Add the newly created dessert to the desserts menu section
            desserts.add(dessert);

        }

        mainCourses.add(seafood);

        MenuSection fullMenu = new MenuSection("Restaurant Menu");

        // TODO: Add the appetizers section to the full menu
        fullMenu.add(appetizers);

        // TODO: Add the main courses section to the full menu
        fullMenu.add(mainCourses);

        // TODO: Add the desserts section to the full menu
        fullMenu.add(desserts);

        System.out.println("\nFull Menu:");

        // TODO: Print the full menu contents
        fullMenu.print();


        sc.close();
    }
}
