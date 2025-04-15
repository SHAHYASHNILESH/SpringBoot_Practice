package com.streams;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.Set;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamExample2 {

	public static void main(String[] args) {

		List<Integer> lst = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 50, 100, 5);

		// Given the list of integers, find the first element of the list
		System.out.println("++++++++++++++++++++++");
		lst.stream().findFirst().ifPresent(System.out::println);

		// Given the list of integers, find the total number of elements present in
		// the list
		System.out.println("++++++++++++++++++++++");
		long count = lst.stream().count();
		System.out.println(count);

		// Given a list of integers, find the even and odd numbers that exist in the
		// list
		System.out.println("++++++++++++++++++++++");
		lst.stream().filter(x -> x % 2 == 0).forEach(System.out::println);

		System.out.println("++++++++++++++++++++++");
		lst.stream().filter(x -> x % 2 != 0).forEach(System.out::println);

		// Given a list of inteqers, find out all the numbers starting with 5
		System.out.println("++++++++++++++++++++++");
		lst.stream().filter(x -> x.toString().startsWith("5")).forEach(System.out::println);

		// How to find duplicate elements in a qiven inteqers list
		System.out.println("++++++++++++++++++++++");
		Set<Integer> tempIntegers = new HashSet<>();
		lst.stream().filter(x -> !tempIntegers.add(x)).forEach(System.out::println);

		System.out.println("++++++++++++++++++++++");
		lst.stream().collect(Collectors.groupingBy(s -> s, Collectors.counting())).entrySet().stream()
				.filter(x -> x.getValue() > 1).forEach(x -> System.out.println(x.getKey()));

		// Given a list of integers, find the maximum and minimum element present in the
		// list
		System.out.println("++++++++++++++++++++++");
		lst.stream().max(Integer::compareTo).ifPresent(System.out::println);

		System.out.println("++++++++++++++++++++++");
		lst.stream().min(Integer::compareTo).ifPresent(System.out::println);

		// Given a list of integers, sort all the elements in the list
		System.out.println("++++++++++++++++++++++");
		lst.stream().sorted().forEach(System.out::println);

		// Given a list of integers, sort all the elements in the list in descending
		// order
		System.out.println("++++++++++++++++++++++");
		lst.stream().sorted((a, b) -> b - a).forEach(System.out::println);

		// Check if the array contains duplicates
		System.out.println("++++++++++++++++++++++");
		int[] arr = { 1, 2, 3, 4, 1 };

		if (Arrays.stream(arr).distinct().count() != arr.length) {

			System.out.println("Contains duplicates");

		} else {
			System.out.println("Does not contains duplicates");
		}

		// Given a list of integers, perform square on list of elements and filter
		// numbers greater than 50
		System.out.println("++++++++++++++++++++++");
		lst.stream().map(x -> x * x).filter(x -> x > 50).forEach(System.out::println);

		// Sort the array and then convert the sorted array into stream
		System.out.println("++++++++++++++++++++++");
		Arrays.sort(arr);
		Arrays.stream(arr).forEach(System.out::println);

		// Use map to convert words to Uppercase
		System.out.println("++++++++++++++++++++++");
		String string = "Hello world everyone";
		Arrays.stream(string.split(" ")).map(s -> s.toUpperCase()).forEach(System.out::println);

		// Use map to convert words to Lowercase
		System.out.println("++++++++++++++++++++++");
		List<String> strsList = Arrays.asList("Hello", "World", "all");
		strsList.stream().map(s -> s.toLowerCase()).forEach(System.out::println);

		// Find the maximum and minimum element in the array
		System.out.println("++++++++++++++++++++++");
		Arrays.stream(arr).max().ifPresent(System.out::println);

		System.out.println("++++++++++++++++++++++");
		Arrays.stream(arr).min().ifPresent(System.out::println);

		// Concatenate Streams
		System.out.println("++++++++++++++++++++++");
		Stream<Integer> stream1 = Stream.of(1, 2, 3, 4, 5);
		Stream<Integer> stream2 = Stream.of(6, 7, 8, 9, 10);

		Stream.concat(stream1, stream2).forEach(System.out::println);

		// Print 10 random numbers
		System.out.println("++++++++++++++++++++++");
		Random random = new Random();
		Stream.generate(random::nextInt).limit(10).forEach(System.out::println);

		// Print date and time using java 8
		System.out.println("++++++++++++++++++++++");
		LocalDateTime dateTime = LocalDateTime.now();
		System.out.println(dateTime);

		// Print in dd-MM-YYYY format
		System.out.println("++++++++++++++++++++++");
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-YYYY");
		System.out.println(dateTimeFormatter.format(dateTime));

		// Checking the list is empty or not using Optional class
		// If not null, iterate through the list
		System.out.println("++++++++++++++++++++++");
		List<String> strs = null;

		Optional<List<String>> optional = Optional.ofNullable(strs);

		if (optional.isEmpty()) {

			System.out.println("List is empty");

		} else {

			for (String s : strs) {

				System.out.println(s);

			}

		}

		// Count the occurence of elements in the list
		System.out.println("++++++++++++++++++++++");
		Map<Integer, Long> map = lst.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println(map);

		// Count the occurence of a particular element in the list
		System.out.println("++++++++++++++++++++++");
		int num = 5;
		long count2 = lst.stream().filter(x -> x == num).count();
		System.out.println(count2);

		// How to find only duplicate elements with it's count from the string arraylist
		System.out.println("++++++++++++++++++++++");

		List<String> duList = Arrays.asList("a", "a", "a", "b");
		Map<String, Long> duMap = duList.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println(duMap);
		duMap.entrySet().stream().filter(x -> x.getValue() > 1).forEach(System.out::println);

		// Count the occurence of a particular element in the String arraylist
		System.out.println("++++++++++++++++++++++");
		long count3 = duList.stream().filter(x -> x.equalsIgnoreCase("A")).count();
		System.out.println(count3);

		// Count the sum of salaries of employees
		System.out.println("++++++++++++++++++++++");
		Employee e1 = new Employee("A", 30);
		Employee e2 = new Employee("B", 40);
		Employee e3 = new Employee("C", 50);
		Employee e4 = new Employee("A", 60);

		List<Employee> emps = Arrays.asList(e1, e2, e3, e4);
		double sum = emps.stream().mapToDouble(Employee::getSalary).sum();
		System.out.println(sum);

		// Count of each character in a string
		System.out.println("++++++++++++++++++++++");
		String string2 = "hello";
		Arrays.stream(string2.split("")).collect(Collectors.groupingBy(s -> s, Collectors.counting()))
				.forEach((k, v) -> System.out.println(k + " " + v));

		// Sort the list of employee objects by key
		System.out.println("++++++++++++++++++++++");
		emps.stream()
				.collect(Collectors.toMap(Employee::getName, Employee::getSalary, (e, r) -> e,
						() -> new TreeMap<>(Comparator.naturalOrder())))
				.forEach((k, v) -> System.out.println(k + " " + v));
		
		// Sort the map by value
		Map<String, Integer> unsortedMap = new HashMap<>();
		unsortedMap.put("banana", 2);
		unsortedMap.put("apple", 5);
		unsortedMap.put("orange", 3);

		System.out.println("++++++++++++++++++++++");
		Map<String, Integer> sortedByKey = unsortedMap.entrySet().stream().sorted(Map.Entry.comparingByValue())
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue,
						LinkedHashMap::new));
		System.out.println(sortedByKey);

		// Given a String, find the first non-repeated character in it
		System.out.println("++++++++++++++++++++++");
		String string3 = "hello";
		Arrays.stream(string3.split("")).collect(Collectors.groupingBy(s -> s, Collectors.counting())).entrySet()
				.stream().filter(x -> x.getValue() == 1).findFirst().ifPresent(System.out::println);

		// Find the first unique character in a string
		System.out.println("++++++++++++++++++++++");
		String string4 = "hello world";
		Arrays.stream(string4.split(""))
				.collect(Collectors.groupingBy(s -> s, LinkedHashMap::new, Collectors.counting())).entrySet().stream()
				.filter(x -> x.getValue() == 1 && !x.getKey().equals(" ")).findFirst().ifPresent(System.out::println);

		// Flatten the list of lists into a single list of fruits
		System.out.println("++++++++++++++++++++++");
		List<List<String>> lstLst = Arrays.asList(Arrays.asList("apple", "banana", "cherry"),
				Arrays.asList("mango", "apricot", "strawberry"));
		lstLst.stream().flatMap(List::stream).forEach(System.out::println);

		// Flatten the list and filter fruits starting with 'a'
		System.out.println("++++++++++++++++++++++");
		lstLst.stream().flatMap(List::stream).filter(x -> x.startsWith("a")).forEach(System.out::println);

		// Flatten the list and sort the fruits in descending order
		System.out.println("++++++++++++++++++++++");
		lstLst.stream().flatMap(List::stream).sorted((a, b) -> b.compareTo(a)).forEach(System.out::println);

		// Get the first 3 elements using limit
		System.out.println("++++++++++++++++++++++");
		lst.stream().limit(3).forEach(System.out::println);

		// Skip the first 3 elements using skip
		System.out.println("++++++++++++++++++++++");
		lst.stream().skip(3).forEach(System.out::println);

		// Filter even numbers and skip first 2 elements
		System.out.println("++++++++++++++++++++++");
		lst.stream().filter(x -> x % 2 == 0).skip(2).forEach(System.out::println);

		// In case of custom objects, we need to override the equals() and hashCode()
		// methods for getting distinct objects from a list of objects

		// List of distinct employees
		System.out.println("++++++++++++++++++++++");
		List<Employee> emps2 = Arrays.asList(new Employee("A", 30), new Employee("B", 40), new Employee("A", 30),
				new Employee("A", 30));
		emps2.stream().distinct().forEach(System.out::println);

		// Debugging a stream with the help of peek()
		System.out.println("++++++++++++++++++++++");
		lst.stream().peek(x -> System.out.println("Before: " + x)).map(x -> x * 2)
				.peek(x -> System.out.println("After: " + x)).forEach(System.out::println);

		// Given a string, find the frequency of vowels in it using stream api
		System.out.println("++++++++++++++++++++++");
		String string5 = "hello world";
		Map<String, Long> collect = Arrays.stream(string5.toLowerCase().split(""))
				.filter(x -> x.equals("a") || x.equals("e") || x.equals("i") || x.equals("o") || x.equals("u"))
				.collect(Collectors.groupingBy(s -> s, Collectors.counting()));

		System.out.println(collect);
	}
}
