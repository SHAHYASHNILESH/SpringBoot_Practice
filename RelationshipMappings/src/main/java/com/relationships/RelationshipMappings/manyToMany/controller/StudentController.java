package com.relationships.RelationshipMappings.manyToMany.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.relationships.RelationshipMappings.manyToMany.entity.Student;
import com.relationships.RelationshipMappings.manyToMany.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	private StudentService studentService;

	@GetMapping("/students")
	public List<Student> getStudents() {

		return studentService.getStudents();

	}

	@PostMapping("/students")
	public Student addStudent(@RequestBody Student student) {

		return studentService.addStudent(student);

	}
}
