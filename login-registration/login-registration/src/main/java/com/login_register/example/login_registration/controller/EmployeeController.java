package com.login_register.example.login_registration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.login_register.example.login_registration.dto.EmployeeRequest;
import com.login_register.example.login_registration.dto.LoginRequest;
import com.login_register.example.login_registration.entity.Employee;
import com.login_register.example.login_registration.service.EmployeeService;

@RestController
@CrossOrigin
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@PostMapping("/register")
	@ResponseStatus(value = HttpStatus.CREATED)
	public Employee register(@RequestBody EmployeeRequest employeeRequest) {

		return employeeService.registerEmployee(employeeRequest);

	}

	@PostMapping("/login")
	public String login(@RequestBody LoginRequest loginRequest) {

		return employeeService.loginEmployee(loginRequest);

	}

}
