package com.example.mockito.mockito_demo.business;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class SomeBusinessImplMockTest {

	@Mock
	private DataService dataServiceMock;

	@InjectMocks
	private SomeBusinessImpl someBusinessImpl;

	@Test
	void findtheGreatestFromAllData_basicScenario() {

		// fail("Not yet implemented");
		// DataService dataServiceMock = mock(DataService.class);

		// dataServiceMock.retrieveAllData()=>new int [] {25,15,5};
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] { 25, 15, 5 });

		// SomeBusinessImpl someBusinessImpl = new SomeBusinessImpl(dataServiceMock);

		System.out.println(someBusinessImpl.findtheGreatestFromAllData());

		assertEquals(25, someBusinessImpl.findtheGreatestFromAllData());

	}

}
