package com.starPatterns;

public class DecreasingTriangle {

	public static void decreasingTriangle(int n) {

		for (int i = 1; i <= n; i++) {

			for (int j = i; j <= n; j++) {

				System.out.print("* ");

			}
			System.out.println();
		}
	}

	public static void main(String[] args) {

		int n = 5;

		decreasingTriangle(n);

	}
}
