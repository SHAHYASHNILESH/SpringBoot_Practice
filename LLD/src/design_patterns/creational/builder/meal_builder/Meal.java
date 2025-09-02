package design_patterns.creational.builder.meal_builder;

public class Meal {

	private String mainDish;
	private String sideDish;
	private String drink;
	private String dessert;
	private String appetizer;

	private Meal(MealBuilder builder) {
		// TODO: Implement the Meal constructor to initialize Meal components from the
		// MealBuilder.
		this.mainDish = builder.mainDish;
		this.sideDish = builder.sideDish;
		this.drink = builder.drink;
		this.dessert = builder.dessert;
		this.appetizer = builder.appetizer;
	}

	public static synchronized Meal getInstance(MealBuilder builder) {
		// TODO: Return a new instance of Meal using the provided MealBuilder
		return new Meal(builder);
	}

	public void printMealSummary() {
		System.out.println("Main Dish: " + mainDish);
		System.out.println("Side Dish: " + sideDish);
		System.out.println("Drink: " + drink);
		System.out.println("Dessert: " + dessert);
		System.out.println("Appetizer: " + appetizer);
	}
}