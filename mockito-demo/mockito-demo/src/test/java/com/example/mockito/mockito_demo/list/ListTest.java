package com.example.mockito.mockito_demo.list;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ListTest {

	@Test
	void simpleTest() {

		List listMock = mock(List.class);
		when(listMock.size()).thenReturn(3);

		// If there is one return value, then multiple assert will check with that value
		// only
		assertEquals(3, listMock.size());
		assertEquals(3, listMock.size());
		assertEquals(3, listMock.size());
	}

	@Test
	void multipleReturns() {

		List listMock = mock(List.class);
		when(listMock.size()).thenReturn(1).thenReturn(2);

		// If there is more than one return value, then multiple assert will check
		// according to the order of return values
		assertEquals(1, listMock.size());
		assertEquals(2, listMock.size());

		// Last return value will be default for the subsequent assertEquals
		// Now, by default expected value is 2
		assertEquals(2, listMock.size());
		assertEquals(2, listMock.size());
		assertEquals(2, listMock.size());

	}

	@Test
	void specific_param() {

		List listMock = mock(List.class);
		when(listMock.get(0)).thenReturn("Some String");

		assertEquals("Some String", listMock.get(0));
		assertEquals(null, listMock.get(1));
	}

	@Test
	void generic_param() {

		List listMock = mock(List.class);
		when(listMock.get(Mockito.anyInt())).thenReturn("Some Other String");

		assertEquals("Some Other String", listMock.get(0));

	}
}
