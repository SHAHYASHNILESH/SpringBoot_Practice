package com.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamExample1 {

	public static void main(String[] args) {

		// 5 Ways to create a stream
		List<String> arr = Arrays.asList("S", "A", "B");
		Stream<String> stream1 = arr.stream();

		String[] strs = { "A", "C", "B" };
		Stream<String> stream2 = Arrays.stream(strs);

		Stream<Integer> stream3 = Stream.of(1, 2, 3);

		Stream<Integer> stream4 = Stream.iterate(0, n -> n + 1).limit(10);

		Stream<String> stream5 = Stream.generate(() -> "hello").limit(10);

		// Stream Operations
		List<Integer> list = Arrays.asList(1, 2, 3, 455, 666, 8, 9, 0, 2, 10);
		List<Integer> filteredList = list.stream().filter(x -> x % 2 == 0).collect(Collectors.toList());
		System.out.println(filteredList);

		List<Integer> mappedList = filteredList.stream().map(x -> x / 2).collect(Collectors.toList());
		System.out.println(mappedList);

		List<Integer> distinctList = list.stream().filter(x -> x % 2 == 0).map(x -> x / 2).distinct()
				.collect(Collectors.toList());
		System.out.println(distinctList);

		List<Integer> sortedList = list.stream().filter(x -> x % 2 == 0).map(x -> x / 2).distinct()
				.sorted((a, b) -> b - a).collect(Collectors.toList());
		System.out.println(sortedList);

		List<Integer> sortedListNew = list.stream().filter(x -> x % 2 == 0).map(x -> x / 2).distinct()
				.sorted((a, b) -> b - a).limit(4).skip(1).peek(x -> System.out.println(x)).collect(Collectors.toList());
		System.out.println(sortedListNew);

		// Terminal Operations
		int min = Stream.iterate(0, x -> x + 1).limit(101).filter(x -> x % 2 == 0).map(x -> x / 2).distinct()
				.min((a, b) -> a - b).get();

		System.out.println(min);

		int max = Stream.iterate(0, x -> x + 1).limit(101).filter(x -> x % 2 == 0).map(x -> x / 20).distinct()
				.peek(System.out::println).max((a, b) -> a - b).get();

		System.out.println(max);

		long count = Stream.iterate(0, x -> x + 1).limit(101).filter(x -> x % 2 == 0).map(x -> x / 20).distinct()
				.count();

		System.out.println(count);
		
		
		// Parallel Stream
		List<Integer> list1 = Arrays.asList(1, 2, 3, 455, 666, 8, 9, 0, 2, 10);
		Stream<Integer> parallelStream = list1.parallelStream();

	}
}
