package com.predicateStream;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateFunctionalInterfaceExample1 {

	public static void main(String[] args) {

		List<Car> lst = Arrays.asList(new Car("Toyota", "White", 300000), new Car("Maruti", "White", 500000),
				new Car("Honda", "Black", 600000), new Car("BMW", "White", 700000), new Car("Audi", "Black", 800000));

		System.out.println(lst);

		Predicate<Car> p1 = c -> c.getPrice() > 500000;
		Predicate<Car> p2 = c -> c.getName().contains("H");

		for (Car c : lst) {

			if (p1.test(c)) {

				System.out.println(c.getName());

			}
		}

		for (Car c : lst) {

			if (p2.test(c)) {

				System.out.println(c.getName());

			}
		}

		List<Car> collectList = lst.stream().filter(x -> x.getPrice() > 500000).collect(Collectors.toList());

		System.out.println(collectList);
		
	}
}
