package com.java8.defaultMethods;

interface Parent {

	default void sayHello() {

		System.out.println("Hello world!!");

	}
}

class Child implements Parent {

	@Override
	public void sayHello() {
		// TODO Auto-generated method stub
		System.out.println("Child says Hello world!");

	}

}

public class MyClass {

	public static void main(String[] args) {
		Child c = new Child();
		c.sayHello();
	}
}
