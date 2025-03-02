package com.defaultStaticMethods;

public class DefaultStaticMethodsExample1 {

	public static void main(String[] args) {

		Vehicles c = new Car();
		c.horn();
		c.speedMeter();
		Vehicles.speedMeter1();

		Vehicles b = new Bike();
		b.horn();
		b.speedMeter();
		Vehicles.speedMeter1();

		new Bike().show();

	}
}
