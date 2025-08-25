package design_patterns.creational.factory;

public class Car implements Transport {
	@Override
	public void deliver() {
		System.out.println("Deliver by car");
	}
}