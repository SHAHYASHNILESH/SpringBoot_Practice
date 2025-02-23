package com.bharath.mockito.spy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

class ListTest {

	// @Spy
	@Mock
	List<String> myList = new ArrayList<String>();

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void test() {
		
//		myList.add("1");
//		myList.add("2");
		
		Mockito.when(myList.get(0)).thenReturn("Rambo");
		// Mockito.when(myList.size()).thenCallRealMethod();
		// Mockito.doReturn(3).when(myList).size();
		Mockito.when(myList.size()).thenReturn(3); // No real method call, just stubbing

		assertEquals(3, myList.size());
		assertEquals("Rambo", myList.get(0));
		// assertSame(3, myList.size());

	}

}
