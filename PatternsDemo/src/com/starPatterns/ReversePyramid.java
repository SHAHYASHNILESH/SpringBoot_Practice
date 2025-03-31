package com.starPatterns;

public class ReversePyramid {

	public static void reversePyramid(int n) {

		for (int i = 1; i <= n; i++) {

			for (int j = 1; j < i; j++) {

				System.out.print("  ");

			}

			for (int j = i; j <= n; j++) {

				System.out.print("*   ");

			}

			System.out.println();

		}

	}

	public static void pyramid(int n) {

		for (int i = 1; i <= n; i++) {

			for (int j = i; j < n; j++) {

				System.out.print(" ");

			}

			for (int j = 1; j <= i; j++) {

				System.out.print("* ");

			}

			System.out.println();

		}

	}

	public static void main(String[] args) {

		int n = 5;

		reversePyramid(n);

		System.out.println("");

		pyramid(n);

	}
}
