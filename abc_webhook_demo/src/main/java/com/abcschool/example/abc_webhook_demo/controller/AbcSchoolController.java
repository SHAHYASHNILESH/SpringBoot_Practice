package com.abcschool.example.abc_webhook_demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AbcSchoolController {

	@GetMapping("/webhook/add-student/{name}")
	public String addStudent(@PathVariable String name) {

		System.out.println("Student name: " + name);
		return "Webhook received";
	}
}
