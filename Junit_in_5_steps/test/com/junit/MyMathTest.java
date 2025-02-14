package com.junit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MyMathTest {

	private MyMath math = new MyMath();

	@Test
	void calSum_FourMemberArray() {

		// Absence of failure is success
		// Test condition or assert

		// System.out.println(math.calSum(new int[] { 1, 2, 3, 4 }));
		assertEquals(10, math.calSum(new int[] { 1, 2, 3, 4 }));

	}

	@Test
	void calSum_ZeroMemberArray() {

		// Absence of failure is success
		// Test condition or assert

		// System.out.println(math.calSum(new int[] {}));
		assertEquals(0, math.calSum(new int[] {}));

	}

}
