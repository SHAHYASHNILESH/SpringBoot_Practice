package com.bharath.maven.calculator.calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

public class CalculatorImplTest {

	private final Calculator c = new CalculatorImpl();

	// Using @CsvSource (simpler approach)
	@ParameterizedTest
	@CsvSource({ "-1, 2, 1", "1, 2, 3", "6, 7, 13" })
	void addShouldReturnAResult(int num1, int num2, int expectedResult) {
		assertEquals(expectedResult, c.add(num1, num2));
	}

	// Alternative: Using @MethodSource (if you want to use lists)
	static Stream<Arguments> provideTestData() {
		return Stream.of(Arguments.of(-1, 2, 1), Arguments.of(1, 2, 3), Arguments.of(6, 7, 13));
	}

	@ParameterizedTest
	@MethodSource("provideTestData")
	void addShouldReturnAResultWithMethodSource(int num1, int num2, int expectedResult) {
		assertEquals(expectedResult, c.add(num1, num2));
	}
}
