package com.defaultStaticMethods;

public interface B {

	default void show() {
		System.out.println("I am B");
	};
}
