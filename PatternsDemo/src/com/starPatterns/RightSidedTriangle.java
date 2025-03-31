package com.starPatterns;

public class RightSidedTriangle {

	public static void rightSidedTriangle1(int n) {

		for (int i = 1; i <= n; i++) {

			// Printing spaces
			for (int j = i; j < n; j++) {

				System.out.print(" ");

			}

			// Printing stars
			for (int j = 1; j <= i; j++) {

				System.out.print("*");

			}

			System.out.println();

		}

	}

	public static void rightSidedTriangle2(int n) {

		for (int i = 1; i <= n; i++) {

			// Printing spaces
			for (int j = 1; j < i; j++) {

				System.out.print(" ");

			}

			// Printing stars
			for (int j = i; j <= n; j++) {

				System.out.print("*");

			}

			System.out.println();

		}

	}

	public static void main(String[] args) {

		int n = 5;
		rightSidedTriangle1(n);
		System.out.println();
		rightSidedTriangle2(n);

	}
}
