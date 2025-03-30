package com.collectionFramework;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.TreeSet;

public class TraverseExample {

	public static void main(String[] args) {

		ArrayList<String> names = new ArrayList<String>();

		names.add("Durgesh");
		names.add("Sitara");
		names.add("Roshni");
		names.add("Vandna");
		names.add("Vandna");
		names.add("ABC");

		// For each Loop
		System.out.println("+++++++++FOR EACH LOOP++++++++++++++");

		for (String str : names) {

			System.out.print(str + "\t" + str.length() + "\t");
			StringBuffer br = new StringBuffer(str);
			System.out.println(br.reverse());

		}

		System.out.println("+++++++++ITERATOR++++++++++++++");

		// Traversing using ITERATOR: Forward Traversing
		Iterator<String> itr = names.iterator();

		while (itr.hasNext()) {

			String next = itr.next();
			System.out.println(next);

		}

		System.out.println("++++++++++LIST ITERATOR+++++++++++++");

		// Backward traversal of collection LIST ITERATOR
		ListIterator<String> litr = names.listIterator(names.size());

		while (litr.hasPrevious()) {

			String previous = litr.previous();
			System.out.println(previous);

		}

		// Enumeration

		// For each method
		System.out.println("++++++++FOR EACH METHOD+++++++++++++");

		names.forEach(str -> {

			System.out.println(str);

		});

		System.out.println("+++++++++SORTING OF ELEMENTS(TreeSet)+++++++++++");

		TreeSet<String> set = new TreeSet<>();
		set.addAll(names);

		set.forEach(e -> {

			System.out.println(e);

		});

//        Comparable
//        Comparator

	}

}
