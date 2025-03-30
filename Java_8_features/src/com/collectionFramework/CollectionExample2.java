package com.collectionFramework;

import java.util.HashMap;

public class CollectionExample2 {
	public static void main(String[] args) {

		HashMap<String, Integer> courses = new HashMap<>();

		// Adding Elements
		courses.put("Core Java", 4000);
		courses.put("Basic Python", 3500);
		courses.put("Spring", 8000);
		courses.put("Android", 4000);
		courses.put("Android", 6000);
		courses.put("PHP", 2414);

		System.out.println(courses);

//        courses.forEach((e1,e2)->{
//            System.out.println(e1+"=>"+e2);
//        });

		courses.forEach((key, value) -> {

			System.out.print(key);
			System.out.print("=>");
			System.out.println(value);
			System.out.println();

		});

		// entry set
		// key set

		System.out.println(courses.get("Core Java"));

	}

}