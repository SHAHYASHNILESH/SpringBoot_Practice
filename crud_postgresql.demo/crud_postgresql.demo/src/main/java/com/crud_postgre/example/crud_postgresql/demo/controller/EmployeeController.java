package com.crud_postgre.example.crud_postgresql.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.crud_postgre.example.crud_postgresql.demo.dto.EmployeeDto;
import com.crud_postgre.example.crud_postgresql.demo.entity.Employee;
import com.crud_postgre.example.crud_postgresql.demo.mapper.EmployeeMapper;
import com.crud_postgre.example.crud_postgresql.demo.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/employees")
	public List<Employee> getAllEmployees() {

		return employeeService.getAllEmployees();

	}

	@GetMapping("/employees/{id}")
	public EmployeeDto getEmployeeById(@PathVariable Long id) {

		return employeeService.getEmployeeById(id);

	}

	@PostMapping("/employees")
	@ResponseStatus(value = HttpStatus.CREATED)
	public EmployeeDto createEmployee(@RequestBody Employee employee) {

		return employeeService.createEmployee(EmployeeMapper.mapToEmployeeDto(employee));

	}

	@PutMapping("/employees/{id}")
	public EmployeeDto updateEmployee(@RequestBody Employee employee, @PathVariable Long id) {

		return employeeService.updateEmployee(EmployeeMapper.mapToEmployeeDto(employee), id);

	}

	@DeleteMapping("/employees/{id}")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public String deleteEmployeeById(@PathVariable Long id) {

		employeeService.deleteEmployeeById(id);

		return "Employee Deleted successfully!!";

	}
}
