package com.mapping.example.cardinality_demo.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Mission {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String period;
	
	@ManyToMany(mappedBy = "missions")
	private List<Employee> employees;
	
	public Mission() {
		super();
		// TODO Auto-generated constructor stub
	}
}
