package com.defaultStaticMethods;

public interface Vehicles {

	void horn();

	default void speedMeter() {
		System.out.println("Speed Meter");
	}
	
	static void speedMeter1() {
		System.out.println("Speed Meter1");
	}

}
