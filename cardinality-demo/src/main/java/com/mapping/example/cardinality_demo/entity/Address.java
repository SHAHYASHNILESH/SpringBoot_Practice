package com.mapping.example.cardinality_demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String streetName;
	private String houseNumber;
	private String zipCode;

	@OneToOne
	@JoinColumn(name = "employee_id")
	private Employee employee;

	public Address() {
		super();
	}

	public Address(int id, String streetName, String houseNumber, String zipCode, Employee employee) {
		super();
		this.id = id;
		this.streetName = streetName;
		this.houseNumber = houseNumber;
		this.zipCode = zipCode;
		this.employee = employee;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getHouseNumber() {
		return houseNumber;
	}

	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", streetName=" + streetName + ", houseNumber=" + houseNumber + ", zipCode="
				+ zipCode + ", employee=" + employee + "]";
	}
}
