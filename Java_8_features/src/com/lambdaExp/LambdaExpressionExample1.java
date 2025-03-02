package com.lambdaExp;

interface Anonymous {
	void show();

}

public class LambdaExpressionExample1 {

	public static void main(String[] args) {

		Anonymous obj1 = new Anonymous() {

			public void show() {

				System.out.println("Hello from Anonymous class");
			}
		};

		obj1.show();

		Anonymous obj2 = () -> System.out.println("Hello from Lambda Expression");

		obj2.show();
	}
}
