package com.login_register.example.login_registration.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(length = 45)
	private int employee_id;
	@Column(length = 255)
	private String employee_name;
	@Column(name = "employee_email", length = 255)
	private String employeeEmail;
	@Column(length = 255)
	private String employee_password;

	public Employee() {

	}

	public Employee(String employee_name, String employee_email, String password) {
		this.employee_name = employee_name;
		this.employeeEmail = employee_email;
		this.employee_password = password;
	}

	public int getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}

	public String getEmployee_name() {
		return employee_name;
	}

	public void setEmployee_name(String employee_name) {
		this.employee_name = employee_name;
	}

	public String getEmployee_email() {
		return employeeEmail;
	}

	public void setEmployee_email(String employee_email) {
		this.employeeEmail = employee_email;
	}

	public String getEmployee_password() {
		return employee_password;
	}

	public void setEmployee_password(String employee_password) {
		this.employee_password = employee_password;
	}

	@Override
	public String toString() {
		return "Employee [employee_id=" + employee_id + ", employee_name=" + employee_name + ", employee_email="
				+ employeeEmail + ", employee_password=" + employee_password + "]";
	}

}
