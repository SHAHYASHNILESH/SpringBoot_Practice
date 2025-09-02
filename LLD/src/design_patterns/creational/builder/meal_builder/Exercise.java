package design_patterns.creational.builder.meal_builder;

import java.util.Scanner;

public class Exercise {

	// Do not modify the run method. It handles the meal construction process using
	// user input and the Builder design pattern.
	public void run() {

		Scanner sc = new Scanner(System.in);

		// Get full meal components from user
		String fullMainDish = sc.nextLine();

		String fullSideDish = sc.nextLine();

		String fullDrink = sc.nextLine();

		String fullDessert = sc.nextLine();

		String fullAppetizer = sc.nextLine();

		// TODO: Construct a full meal using MealBuilder with the provided components.
		Meal meal = new MealBuilder(fullMainDish, fullSideDish, fullDrink).setDessert(fullDessert)
				.setAppetizer(fullAppetizer).build();

		System.out.println("Full Meal Summary:");

		// TODO: Print the summary of the constructed full meal.
		meal.printMealSummary();

		// Get simple meal components from user
		String simpleMainDish = sc.nextLine();

		String simpleSideDish = sc.nextLine();

		String simpleDrink = sc.nextLine();

		// TODO: Construct a simple meal using MealBuilder with the provided components.
		Meal meal1 = new MealBuilder(simpleMainDish, simpleSideDish, simpleDrink).build();

		System.out.println("Simple Meal Summary:");

		// TODO: Print the summary of the constructed simple meal.
		meal1.printMealSummary();

		sc.close();
	}
}
