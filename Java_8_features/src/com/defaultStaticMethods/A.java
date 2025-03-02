package com.defaultStaticMethods;

public interface A {
	
	default void show() {
		System.out.println("I am A");
	};
}
