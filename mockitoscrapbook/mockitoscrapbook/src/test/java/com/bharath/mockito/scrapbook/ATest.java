package com.bharath.mockito.scrapbook;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ATest {

	private A a;

	@Mock
	B b;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		a = new A(b);
	}

	@Test
	public void usesVoidMethodShouldCallVoid() throws Exception {

		a.usesVoidMethod();
		// doNothing().when(b).voidmethod();
		// assertEquals(1, a.usesVoidMethod());
		verify(b).voidmethod();

	}

	@Test
	public void usesVoidMethodShouldCallVoidUsingDoNothing() throws Exception {

		// a.usesVoidMethod();
		doNothing().when(b).voidmethod();
		assertEquals(1, a.usesVoidMethod());
		verify(b).voidmethod();

	}

	@Test
	public void usesVoidMethodShouldThrowException() throws Exception {

		// a.usesVoidMethod();
		doThrow(Exception.class).when(b).voidmethod();
		assertThrows(Exception.class, () -> a.usesVoidMethod());

	}

	@Test
	public void usesVoidMethodTestConsecutiveCalls() throws Exception {

		// a.usesVoidMethod();
		doNothing().doThrow(Exception.class).when(b).voidmethod();
		assertEquals(1, a.usesVoidMethod());
		assertThrows(Exception.class, () -> a.usesVoidMethod());

	}
}
