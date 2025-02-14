package com.junit;

public class MyMath {

	// {1,2,3}=> 1+2+3=6
	public int calSum(int[] arr) {

		int sum = 0;

		for (int num : arr) {

			sum += num;

		}

		return sum;

	}
}
