package com.crud.example.crud_demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.crud.example.crud_demo.entity.Student;
import com.crud.example.crud_demo.repository.StudentRepository;

@RestController
public class StudentController {

	@Autowired
	private StudentRepository studentRepository;

	private static final Logger logger = LoggerFactory.getLogger(StudentController.class);

	// Get all students
	@RequestMapping(value = "students", method = RequestMethod.GET)

	public List<Student> getAllStudents() {

		logger.info("I am inside list all students method");
		List<Student> allStudents = studentRepository.findAll();

		return allStudents;
	}

	// Get specific student by roll no
	// @RequestMapping(value = "students/{rollno}/{name}", method =
	// RequestMethod.GET)
	@RequestMapping(value = "students/{rollno}", method = RequestMethod.GET)
	public Student getSpecificStudentById(@PathVariable int rollno) {

		Student student = studentRepository.findById(rollno).get();
		// Student student1 = studentRepository.findByName(name);

		return student;

	}

//	@RequestMapping(value = "students/{name}", method = RequestMethod.GET)
//	public Student getSpecificStudentByName(@PathVariable String name) {
//
//		Student student = studentRepository.findByName(name);
//
//		return student;
//
//	}

	@RequestMapping(value = "students/add", method = RequestMethod.POST)
	@ResponseStatus(code = HttpStatus.CREATED)
	public void addStudent(@RequestBody Student student) {

		studentRepository.save(student);

	}

	@RequestMapping(value = "students/update/{rollno}", method = RequestMethod.PUT)
	public Student updateStudent(@PathVariable int rollno) {

		Student student = studentRepository.findById(rollno).get();

		student.setName("Max Well");
		student.setPercentage(70);

		studentRepository.save(student);
		return student;

	}

	@RequestMapping(value = "students/delete/{rollno}", method = RequestMethod.DELETE)
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public String deleteStudent(@PathVariable int rollno) {

		studentRepository.deleteById(rollno);

//		Student student = studentRepository.findById(rollno).get();
//		studentRepository.delete(student);

		return "Student deleted successfully!";

	}
}
