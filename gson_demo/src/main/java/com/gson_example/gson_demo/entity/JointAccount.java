package com.gson_example.gson_demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class JointAccount {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long leadId;
	private String name;
	private String address;
	private int age;
	private String gender;

	public JointAccount() {
		super();
	}

	public JointAccount(Long leadId, String name, String address, int age, String gender) {
		super();
		this.leadId = leadId;
		this.name = name;
		this.address = address;
		this.age = age;
		this.gender = gender;
	}

	public Long getLeadId() {
		return leadId;
	}

	public void setLeadId(Long leadId) {
		this.leadId = leadId;
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

	public int getAge() {
		return age;

	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "JointAccount [leadId=" + leadId + ", name=" + name + ", address=" + address + ", age=" + age
				+ ", gender=" + gender + "]";
	}

}
