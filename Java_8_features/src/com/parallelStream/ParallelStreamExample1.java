package com.parallelStream;

import java.util.Arrays;
import java.util.List;

public class ParallelStreamExample1 {

	public static void main(String[] args) {

		List<Integer> lst = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

		lst.stream().parallel().forEach(System.out::println);

		System.out.println();
		lst.parallelStream().forEach(System.out::println);
	}
}
