package com.defaultStaticMethods;

public interface C extends A, B {

//	@Override
//	void show();
	
	@Override
	default void show() {
		System.out.println("Collision solved");
	}
}
