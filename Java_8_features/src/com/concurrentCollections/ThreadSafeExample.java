package com.concurrentCollections;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ThreadSafeExample {

	public static void main(String[] args) {

		List<String> sList = new CopyOnWriteArrayList<>();
		sList.add("Hello");
		sList.add("World");
		sList.add("Java");
		sList.add("Programming");
		sList.add("Language");
		sList.add("Collection");
		sList.add("Framework");
		sList.add("List");
		sList.add("Set");
		sList.add("Map");
		sList.add("Queue");

		Runnable t1 = () -> {
			for (String s : sList) {
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
			sList.add("Z");
			sList.add("Z1");
			sList.add("Z2");
		};

		new Thread(t2).start();
		new Thread(t1).start();
	}
}
