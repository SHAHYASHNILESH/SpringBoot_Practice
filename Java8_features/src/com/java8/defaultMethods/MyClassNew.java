package com.java8.defaultMethods;

interface A {

	default void sayHello() {

		System.out.println("Hello from interface A");
	}
}

interface B {

	default void sayHello() {

		System.out.println("Hello from interface B");
	}
}

// In case of multiple inheritance, if there are two interfaces with same method and some class is trying to implement both of them, then the compiler will get confused on which interface mathod to run. 
public class MyClassNew implements A, B {

	public static void main(String[] args) {

		MyClassNew m = new MyClassNew();
		m.sayHello();

	}

	// One solution is to override the method of any interface
	@Override
	public void sayHello() {
		// TODO Auto-generated method stub
		A.super.sayHello();

	}
}
