package com.SerializationDeserialization;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Serial {

	public static void main(String[] args) throws IOException {

		Student stud = new Student("Sai", "D9Q5W@example.com", 20, "Chennai");

		FileOutputStream fos = new FileOutputStream("student.txt");

		ObjectOutputStream oos = new ObjectOutputStream(fos);

		// serialize object
		oos.writeObject(stud);

		oos.close();
		fos.close();

		System.out.println("Object state is transfered to file");
	}
}
