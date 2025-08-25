package design_patterns.creational.factory;

public class TransportService {
	public static void main(String[] args) {
		// Direct create objects
		Transport car = new Car();
		car.deliver();
		Transport bike = new Bike();
		bike.deliver();
		// add a bus object
		Transport bus = new Bus();
		bus.deliver();
	}
}