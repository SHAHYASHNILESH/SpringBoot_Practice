package com.defaultStaticMethods;

public class Bike implements Vehicles,C {

	@Override
	public void horn() {
		// TODO Auto-generated method stub
		System.out.println("Bike Horn");
	}

	@Override
	public void speedMeter() {
		// TODO Auto-generated method stub
		System.out.println("Overrided Default Speed Meter");
	}
}
