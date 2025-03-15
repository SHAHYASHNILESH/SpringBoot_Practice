package com.concurrentCollections;

import java.util.Arrays;
import java.util.List;

public class NonThreadSafeExample {

	public static void main(String[] args) {

		List<String> lStrings = Arrays.asList("A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O",
				"P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z");

		Runnable t1 = () -> {
			for (String s : lStrings) {
				System.out.println(s);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};

		Runnable t2 = () -> {
			lStrings.add("Z");
			lStrings.add("Z1");
			lStrings.add("Z2");
		};

		new Thread(t1).start();
		new Thread(t2).start();
	}
}
