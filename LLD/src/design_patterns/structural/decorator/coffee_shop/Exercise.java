package design_patterns.structural.decorator.coffee_shop;

import java.util.Scanner;

public class Exercise {

    // Do not modify the run method. It is designed to demonstrate the usage of the Decorator pattern for customizing coffee with various ingredients.
    public void run(){

        Scanner sc = new Scanner(System.in);

        Coffee coffee = new BasicCoffee();

        boolean addMoreIngredients = true;

        while (addMoreIngredients) {

            String choices = sc.nextLine();
            String[] ingredients = choices.split(" ");

            for (String choice : ingredients) {

                switch (choice) {
                    case "1":
                        // TODO: Complete the implementation for adding Milk to the coffee.
                        coffee=new Milk(coffee);
                        break;
                    case "2":
                        // TODO: Complete the implementation for adding Sugar to the coffee.
                        coffee=new Sugar(coffee);
                        break;
                    case "3":
                        // TODO: Complete the implementation for adding Whipped Cream to the coffee.
                        coffee=new WhippedCream(coffee);
                        break;
                    case "4":
                        addMoreIngredients = false;
                        break;
                    default:
                        System.out.println("Invalid choice: " + choice);
                        break;
                }
            }

            if (!addMoreIngredients) {
                break;
            }
        }

        System.out.println("Final Coffee Description: " + coffee.getDescription());
        System.out.println("Total Cost: $" + coffee.getCost());

        sc.close();
    }
}

