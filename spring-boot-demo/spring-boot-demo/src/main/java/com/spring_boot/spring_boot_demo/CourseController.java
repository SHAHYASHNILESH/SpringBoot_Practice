package com.spring_boot.spring_boot_demo;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {

	// /courses
	// Course: id, name, author

	@RequestMapping("/courses")
	public List<Course> retrieveAllCourses() {

		return Arrays.asList(new Course(1, "Learn AWS", "ABC"), new Course(2, "Learn DevOps", "ABC"),
				new Course(3, "Learn Azure", "ABC"), new Course(4, "Learn GCP", "ABC"));
	}
}
