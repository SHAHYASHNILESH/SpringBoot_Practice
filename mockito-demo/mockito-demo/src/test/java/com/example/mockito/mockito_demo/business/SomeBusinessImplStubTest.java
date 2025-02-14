package com.example.mockito.mockito_demo.business;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SomeBusinessImplStubTest {

	@Test
	void findtheGreatestFromAllData_basicScenario() {

		// fail("Not yet implemented");
		DataService dataServiceStub = new DataServiceStub();

		SomeBusinessImpl someBusinessImpl = new SomeBusinessImpl(dataServiceStub);

		int findtheGreatestFromAllData = someBusinessImpl.findtheGreatestFromAllData();
		System.out.println(findtheGreatestFromAllData);

		assertEquals(25, findtheGreatestFromAllData);

	}

}

class DataServiceStub implements DataService {

	@Override
	public int[] retrieveAllData() {
		// TODO Auto-generated method stub
		return new int[] { 25, 15, 5, 2 };
	}

}
