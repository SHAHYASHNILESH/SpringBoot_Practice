package com.assessment.crud_assessment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.assessment.crud_assessment.entity.Employee;
import com.assessment.crud_assessment.exception.ResourceNotFoundException;
import com.assessment.crud_assessment.service.EmployeeService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "Employee Management APIs", description = "Create Read Update Delete Employees")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/employees")
	@Operation(summary = "Get all Employees")
	@ApiResponse(responseCode = "200", description = "List of Employee Objects")
	public List<Employee> getAllEmployees() throws ResourceNotFoundException {

		return employeeService.getAllEmployees();

	}

	@GetMapping("/employees/sort/{field}")
	public List<Employee> sortEmployeesBasedOnField(@PathVariable String field) throws ResourceNotFoundException {

		return employeeService.sortEmployeesBasedOnField(field);

	}

	@GetMapping("/employees/dept/{dept}")
	@Operation(summary = "Get Employee by Department")
	@Parameter(description = "Department Name")
	@ApiResponse(responseCode = "200", description = "List of Employee Objects")
	public List<Employee> getEmployeeByDepartment(@PathVariable String dept) throws ResourceNotFoundException {

		return employeeService.getEmployeeByDepartment(dept);

	}

	@GetMapping("/employees/pages/{offset}/{pageSize}")
	public Page<Employee> getEmployeeWithPagination(@PathVariable int offset, @PathVariable int pageSize)
			throws ResourceNotFoundException {

		return employeeService.getEmployeeWithPagination(offset, pageSize);

	}

	@GetMapping("/employees/pages-sort/{offset}/{pageSize}/{field}")
	@Operation(summary = "Get Employee using Pagination and Sorting")
	@Parameter(description = "Offset")
	@Parameter(description = "Page Size")
	@Parameter(description = "Field")
	@ApiResponse(responseCode = "200", description = "Page of Employee Objects")
	public Page<Employee> getEmployeeWithPaginationAndSorting(@PathVariable int offset, @PathVariable int pageSize,
			@PathVariable String field) throws ResourceNotFoundException {

		return employeeService.getEmployeeWithPaginationAndSorting(offset, pageSize, field);

	}

	@GetMapping("/employees/{id}")
	@Operation(summary = "Get Employee by Id")
	@Parameter(description = "Employee Id")
	@ApiResponse(description = "Employee Object")
	public Employee getEmployeeById(@PathVariable Long id) throws ResourceNotFoundException {

		return employeeService.getEmployeeById(id);

	}

	@PostMapping("/employees")
	@Operation(summary = "Create Employee")
	@io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Employee Object")
	@ApiResponse(responseCode = "201", description = "Employee Object")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {

		Employee emp = employeeService.addEmployee(employee);

		return new ResponseEntity<>(emp, HttpStatus.CREATED);

	}

	@PutMapping("/employees/{id}")
	@Operation(summary = "Update Employee")
	@Parameter(description = "Employee Id")
	@io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Employee Object")
	@ApiResponse(responseCode = "200", description = "Employee Object")
	public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employee)
			throws ResourceNotFoundException {

		return employeeService.updateEmployee(id, employee);

	}

	@DeleteMapping("/employees/{id}")
	// @ResponseStatus(value = HttpStatus.NO_CONTENT)
	@Operation(summary = "Delete Employee by Id")
	@Parameter(description = "Employee Id")
	@ApiResponse(responseCode = "204", description = "String response")
	public ResponseEntity<?> deleteEmployee(@PathVariable Long id) throws ResourceNotFoundException {

		employeeService.deleteEmployee(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);

	}
}