package com.example.junit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GreetingImplTest {

	private Greeting greeting;

	@Before
	public void setUp() {
		System.out.println("Setup");
		greeting = new GreetingImpl();
	}

	@Test
	public void greetingShouldReturnValidOutput() {

//		String greet = new GreetingImpl().greet("Junit");

		System.out.println("greetingShouldReturnValidOutput");
		String greet = greeting.greet("Junit");

		assertNotNull(greet);
		assertEquals("Hello Junit", greet);

	}

	@Test(expected = IllegalArgumentException.class)
	public void greetingShouldThrowException_For_NameNull() {

		System.out.println("greetingShouldThrowException_For_NameNull");
//		new GreetingImpl().greet(null);
		greeting.greet(null);

	}

	@Test(expected = IllegalArgumentException.class)
	public void greetingShouldThrowException_For_NameBlank() {

		System.out.println("greetingShouldThrowException_For_NameBlank");
//		new GreetingImpl().greet("");
		greeting.greet("");

	}

	@After
	public void tearDown() {
		System.out.println("tearDown");
		greeting = null;
	}

}
