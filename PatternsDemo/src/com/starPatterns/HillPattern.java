package com.starPatterns;

public class HillPattern {

	public static void increasingHillPattern(int n) {

		for (int i = 1; i <= n; i++) {

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
	}

	public static void decreasingHillPattern(int n) {

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

		increasingHillPattern(n);
		System.out.println();
		decreasingHillPattern(n);

	}
}
