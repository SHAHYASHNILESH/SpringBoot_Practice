package com.java8.staticMethods;

interface A {

	static void sayHello() {

		System.out.println("Hello world!!");

	}

	default void sayBye() {

		System.out.println("Bye!!");
	}
}

public class MyClass implements A {

	public static void main(String[] args) {
		MyClass m = new MyClass();
		m.sayBye();
		A.sayHello();

	}
}
