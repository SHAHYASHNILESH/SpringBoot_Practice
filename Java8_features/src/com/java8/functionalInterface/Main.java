package com.java8.functionalInterface;

public class Main {

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		
		// SoftwareEngineer se = new SoftwareEngineer();
		// System.out.println(se.getName());

		// Employee e = () -> "Software Engineer!";
		// System.out.println(e.getName());

		// MyClass myClass = new MyClass();
		Runnable rn = () -> {
			for (int i = 0; i < 10; i++) {

				System.out.println("Hello! " + i);
			}
		};
		Thread thread = new Thread(rn);
		thread.run();
	}

}
