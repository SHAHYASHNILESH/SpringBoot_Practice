package com.demo.junit5.hellojunit5;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
public class GreetingImplTest {

	private Greeting greeting;

	@BeforeEach
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

	@Test
	public void greetingShouldThrowException_For_NameNull() {

		System.out.println("greetingShouldThrowException_For_NameNull");
//		new GreetingImpl().greet(null);
//		greeting.greet(null);
		Assertions.assertThrows(IllegalArgumentException.class, () -> greeting.greet(null));
	}

	@Test
	public void greetingShouldThrowException_For_NameBlank() {

		System.out.println("greetingShouldThrowException_For_NameBlank");
//		new GreetingImpl().greet("");
//		greeting.greet("");
		Assertions.assertThrows(IllegalArgumentException.class, () -> greeting.greet(""));
	}

	@AfterEach
	public void tearDown() {
		System.out.println("tearDown");
		greeting = null;
	}

}
