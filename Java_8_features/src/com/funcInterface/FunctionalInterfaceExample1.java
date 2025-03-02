package com.funcInterface;

@FunctionalInterface
interface Anonymous {
	void show();

	static void print() {
		System.out.println("Hello I am static method");
	}

	default void display() {

		System.out.println("Hello I am default method");
	}
}

@FunctionalInterface
interface Anonymous1 {
	void printNumber(int x, int y);

	static void print() {
		System.out.println("Hello I am static method");
	}

	default void display() {

		System.out.println("Hello I am default method");
	}
}

@FunctionalInterface
interface Anonymous2 {
	int addNumbers(int x, int y);

	static void print() {
		System.out.println("Hello I am static method");
	}

	default void display() {

		System.out.println("Hello I am default method");
	}
}

public class FunctionalInterfaceExample1 {

	public static void main(String[] args) {

		Anonymous obj1 = () -> System.out.println("Hello from Functional Interface");
		obj1.show();

		Anonymous1 obj2 = (a, b) -> {
			System.out.println(a + b);
		};
		obj2.printNumber(2, 5);

		Anonymous2 obj3 = (a, b) -> {
			return a + b;
		};
		int res = obj3.addNumbers(2, 5);
		System.out.println(res);

	}
}
