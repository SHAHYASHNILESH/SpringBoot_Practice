package com.relationships.RelationshipMappings.manyToMany.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.relationships.RelationshipMappings.manyToMany.entity.Student;
import com.relationships.RelationshipMappings.manyToMany.repo.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;

	public Student addStudent(Student student) {

		return studentRepository.save(student);

	}

	public List<Student> getStudents() {

		return studentRepository.findAll();

	}
}
