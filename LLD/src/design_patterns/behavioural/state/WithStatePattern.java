package design_patterns.behavioural.state;

//State Interface
interface TransportationMode1 {
	int calcETA();

	String getDirection();
}

class Car implements TransportationMode1 {
	@Override
	public int calcETA() {
		System.out.println("Calculating ETA (Car)");
		return 3; // Example ETA for car
	}

	@Override
	public String getDirection() {
		return "Directions for driving";
	}
}

class Cycling implements TransportationMode1 {
	@Override
	public int calcETA() {
		System.out.println("Calculating ETA (Cycling)");
		return 5; // Example ETA for cycling
	}

	@Override
	public String getDirection() {
		return "Directions for cycling";
	}
}

class Train implements TransportationMode1 {
	@Override
	public int calcETA() {
		System.out.println("Calculating ETA (Train)");
		return 7; // Example ETA for train
	}

	@Override
	public String getDirection() {
		return "Directions for train route";
	}
}

class Walking implements TransportationMode1 {
	@Override
	public int calcETA() {
		System.out.println("Calculating ETA (Walking)");
		return 10; // Example ETA for walking
	}

	@Override
	public String getDirection() {
		return "Directions for walking";
	}
}

class DirectionService1 {
	TransportationMode1 transportationMode;

	public DirectionService1(TransportationMode1 transportationMode) {
		this.transportationMode = transportationMode;
	}

	public void setTransportationMode(TransportationMode1 mode) {
		this.transportationMode = mode;
	}

	// delegating the work current state's concrete class
	public int getETA() {
		return transportationMode.calcETA();
	}

	public String getDirection() {
		return transportationMode.getDirection();
	}
}

public class WithStatePattern {
	public static void main(String[] args) {
		DirectionService1 service = new DirectionService1(new Car());
		service.setTransportationMode(new Cycling());

		System.out.println("ETA: " + service.getETA());
		System.out.println("Direction: " + service.getDirection());

	}
}
