package com.lambdaExp;

interface Operation {
	int opt(int x, int y);

}

public class LambdaExpressionExample3 {

	public static void result(int x, int y, Operation obj) {

		System.out.println(obj.opt(x, y));

	}

	public static void main(String[] args) {

		result(5, 2, (a, b) -> a + b);
		result(5, 2, (a, b) -> a - b);
		result(5, 2, (a, b) -> a * b);
		result(5, 2, (a, b) -> a / b);

	}
}
