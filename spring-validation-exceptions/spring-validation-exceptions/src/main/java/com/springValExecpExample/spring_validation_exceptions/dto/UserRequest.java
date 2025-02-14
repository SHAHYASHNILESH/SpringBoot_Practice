package com.springValExecpExample.spring_validation_exceptions.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class UserRequest {

	@NotNull(message = "Username should not be null")
	private String name;
	@NotNull(message = "Address should not be null")
	private String address;
	@Email(message = "Email is not valid")
	private String email;
	@Min(value = 18, message = "Age should be greater than 18")
	@Max(value = 60, message = "Age should be less than 60")
	private int age;
	private double salary;

	public UserRequest() {
		super();
	}

	public UserRequest(String name, String address, String email, int age, double salary) {
		super();
		this.name = name;
		this.address = address;
		this.email = email;
		this.age = age;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "UserRequest [name=" + name + ", address=" + address + ", email=" + email + ", age=" + age + ", salary="
				+ salary + "]";
	}
}
