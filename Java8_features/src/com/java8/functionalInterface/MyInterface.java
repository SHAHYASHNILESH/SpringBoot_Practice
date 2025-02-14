package com.java8.functionalInterface;

@FunctionalInterface
public interface MyInterface {

	public void sayHello();

	default void sayBye() {

	};

	public static void sayOk() {

	}

}
