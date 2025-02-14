package com.junit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

// JUnit does not gurrantee the order of execution of tests
class MyBeforeAfterTest {

	@BeforeAll
	static void beforeAll() {
		// fail("Not yet implemented");
		System.out.println("beforeAll");
	}

	@BeforeEach
	void beforeEach() {
		// fail("Not yet implemented");
		System.out.println("beforeEach");
	}

	@Test
	void test1() {
		// fail("Not yet implemented");
		System.out.println("test1");
	}

	@Test
	void test2() {
		// fail("Not yet implemented");
		System.out.println("test2");
	}

	@Test
	void test3() {
		// fail("Not yet implemented");
		System.out.println("test3");
	}

	@Test
	void test4() {
		// fail("Not yet implemented");
		System.out.println("test4");
	}

	@AfterEach
	void afterEach() {
		// fail("Not yet implemented");
		System.out.println("afterEach");
	}

	@AfterAll
	static void afterAll() {
		// fail("Not yet implemented");
		System.out.println("afterAll");
	}

}
