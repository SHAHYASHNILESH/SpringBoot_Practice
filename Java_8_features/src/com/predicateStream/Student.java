package com.predicateStream;

public class Student {

	private String name;
	private double marks;
	private Subjects sub;

	public Student(String name, double marks, Subjects sub) {
		this.name = name;
		this.marks = marks;
		this.sub = sub;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getMarks() {
		return marks;
	}

	public void setMarks(double marks) {
		this.marks = marks;
	}

	public Subjects getSub() {
		return sub;
	}

	public void setSub(Subjects sub) {
		this.sub = sub;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", marks=" + marks + ", sub=" + sub + "]";
	}
}
