package com.spring_boot.spring_boot_demo;

public class Course {
	
	private int id;
	private String cname;
	private String cauthor;
	
	public Course(int id, String cname, String cauthor) {
		super();
		this.id = id;
		this.cname = cname;
		this.cauthor = cauthor;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getCauthor() {
		return cauthor;
	}

	public void setCauthor(String cauthor) {
		this.cauthor = cauthor;
	}
	
	@Override
	public String toString() {
		return "Course [id=" + id + ", cname=" + cname + ", cauthor=" + cauthor + "]";
	}
	
}
