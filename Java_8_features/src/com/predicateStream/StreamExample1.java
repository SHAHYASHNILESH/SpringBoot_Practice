package com.predicateStream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamExample1 {

	public static void main(String[] args) {

		IntStream.range(1, 11).forEach(x -> System.out.println(x));
		System.out.println();

		IntStream.range(1, 11).forEach(System.out::println);

		System.out.println();
		IntStream num = IntStream.iterate(2, x -> x + 1);
		num.limit(5).forEach(System.out::println);

		System.out.println();
		Long count1 = Stream.of(10, 20, 30, 2, 1, 55, 6).filter(x -> x > 20).count();
		System.out.println(count1);

		System.out.println();
		Stream.of("Java", "Javascript", "Go", "Dart", "Junit").filter(x -> x.contains("J")).map(String::toUpperCase)
				.forEach(x -> System.out.println(x));

		System.out.println();
		Stream.generate(Math::random).limit(8).forEach(System.out::println);

		System.out.println();
		List<String> collectLst1 = Arrays.asList("Java", "Javascript", "Go", "Dart", "Junit").stream()
				.filter(x -> x.contains("J")).collect(Collectors.toList());
		collectLst1.forEach(System.out::println);

		System.out.println();
		Set<String> collectLst2 = Arrays.asList("Java", "Javascript", "Go", "Dart", "Junit", "Java").stream()
				.filter(x -> x.contains("J")).collect(Collectors.toSet());
		collectLst2.forEach(System.out::println);

		System.out.println();
		List<Student> students = new ArrayList<>();

		students.add(new Student("Raj", 45, Subjects.SCIENCE));
		students.add(new Student("Karan", 34, Subjects.LITERATURE));
		students.add(new Student("Ram", 67, Subjects.MATHS));

		System.out.println(students.stream().collect(Collectors.toMap(Student::getName, Student::getSub)));

		System.out.println();
		List<Student> studentsNew = new ArrayList<>();

		studentsNew.add(new Student("Raj", 45, Subjects.SCIENCE));
		studentsNew.add(new Student("Raj", 34, Subjects.LITERATURE));
		studentsNew.add(new Student("Ram", 67, Subjects.MATHS));
		studentsNew.add(new Student("Kiran", 89, Subjects.SCIENCE));

		Map<String, List<Subjects>> mp = new HashMap<>();
		studentsNew.stream().forEach(student -> {
			mp.computeIfAbsent(student.getName(), x -> new ArrayList<Subjects>()).add(student.getSub());
		});

		System.out.println(mp);

		System.out.println();
		List<String> lst1 = Arrays.asList("A", "B");
		List<String> lst2 = Arrays.asList("C", "X");
		List<String> lst3 = Arrays.asList("E", "F", "G");

		List<String> list = Stream.of(lst1, lst2, lst3).flatMap(List::stream).collect(Collectors.toList());
		System.out.println(list);

		System.out.println();
		Map<String, List<Integer>> map = new LinkedHashMap<>();
		map.put("one", Arrays.asList(1, 2, 3));
		map.put("two", Arrays.asList(3, 4, 5));

		System.out.println(map.values().stream().flatMap(List::stream).collect(Collectors.toList()));
	}
}
