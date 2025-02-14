package com.junit;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

class MyAssertTest {

	List<String> todos = Arrays.asList("AWS", "Flutter", "Azure", "DevOps");

	@Test
	void test() {

		boolean test = todos.contains("AWS");
		boolean test1 = todos.contains("AWSs");

//		fail("Not yet implemented");

		// assertEquals(expected,actual);
		assertEquals(true, test);

		// For Testing boolean values only
		assertTrue(test);

		// assertTrue(test1, "Something went wrong");
		assertFalse(test1);

		// assertNull, assertNotNull

		// Testing expected and actual arrays
		assertArrayEquals(new int[] { 1, 2 }, new int[] { 1, 2 });

		// For Testing size of list
		assertEquals(4, todos.size(), "Something went wrong");
	}

}
