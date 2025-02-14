package com.example.mockito.mockito_demo.business;

public class SomeBusinessImpl {

	private DataService dataService;

	public SomeBusinessImpl(DataService dataService) {
		super();
		this.dataService = dataService;
	}

	public int findtheGreatestFromAllData() {

		int[] data = dataService.retrieveAllData();

		int maxi = 0;

		for (int val : data) {

			if (maxi < val)
				maxi = val;

		}

		return maxi;

	}
}

interface DataService {

	int[] retrieveAllData();

}