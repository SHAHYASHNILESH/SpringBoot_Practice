package design_patterns.creational.factory;

public class Bus implements Transport {
	@Override
	public void deliver() {
		System.out.println("Deliver by bus");
	}
}
