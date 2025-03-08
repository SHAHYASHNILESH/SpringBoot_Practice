package com.relationships.RelationshipMappings.manyToMany.entity;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;

	@ManyToMany(mappedBy = "enrolledStudents")
	private Set<Subjects> enrolledSubjects = new HashSet<>();

	public Student() {
		super();
	}

	public Student(Long id, String name, Set<Subjects> enrolledSubjects) {
		super();
		this.id = id;
		this.name = name;
		this.enrolledSubjects = enrolledSubjects;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Subjects> getEnrolledSubjects() {
		return enrolledSubjects;
	}

	public void setEnrolledSubjects(Set<Subjects> enrolledSubjects) {
		this.enrolledSubjects = enrolledSubjects;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", enrolledSubjects=" + enrolledSubjects + "]";
	}

}
