package com.starPatterns;

public class DiamondPattern {

	public static void diamondPattern(int n) {

		for (int i = 1; i < n; i++) {

			for (int j = i; j < n; j++) {

				System.out.print(" ");

			}

			for (int j = 1; j < i; j++) {

				System.out.print("*");

			}

			for (int j = 1; j <= i; j++) {

				System.out.print("*");

			}
			System.out.println();
		}

		for (int i = 1; i <= n; i++) {

			for (int j = 1; j < i; j++) {

				System.out.print(" ");

			}

			for (int j = i; j < n; j++) {

				System.out.print("*");

			}

			for (int j = i; j <= n; j++) {

				System.out.print("*");

			}
			System.out.println();
		}

	}

	public static void main(String[] args) {

		int n = 5;

		diamondPattern(n);

	}
}
