package com.login_register.example.login_registration.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.login_register.example.login_registration.dto.EmployeeRequest;
import com.login_register.example.login_registration.dto.LoginRequest;
import com.login_register.example.login_registration.entity.Employee;
import com.login_register.example.login_registration.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	public Employee registerEmployee(EmployeeRequest employeeRequest) {

		Employee employee = new Employee();

		employee.setEmployee_name(employeeRequest.getEmployee_name());
		employee.setEmployee_email(employeeRequest.getEmployee_email());
		employee.setEmployee_password(this.passwordEncoder.encode(employeeRequest.getEmployee_password()));

		employeeRepository.save(employee);

		return employee;

	}

	public String loginEmployee(LoginRequest loginRequest) {

		System.out.println("Searching for employee with email: " + loginRequest.getEmployeeEmail());

		Employee employee = employeeRepository.findByEmployeeEmail(loginRequest.getEmployeeEmail());
		if (employee != null) {

			boolean isMatch = this.passwordEncoder.matches(loginRequest.getEmployeePassword(),
					employee.getEmployee_password());

			if (isMatch) {
				return "Employee Logged in Successfully";
			} else {
				return "Invalid Login Credentials";

			}
		}

		else {
			return "User Not Found!";
		}

	}
}
