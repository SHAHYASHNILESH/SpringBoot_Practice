package design_patterns.creational.builder;

public class WithBuilderPattern {
	public static void main(String[] args) {
		House house = new House.HouseBuilder("Concrete", "Wood", "Tiles").setSwimmingPool(true).build();
		System.out.println(house);
	}
}
