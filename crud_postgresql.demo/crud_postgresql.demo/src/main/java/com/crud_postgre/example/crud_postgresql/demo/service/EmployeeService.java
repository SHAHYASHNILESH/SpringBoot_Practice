package com.crud_postgre.example.crud_postgresql.demo.service;

import java.util.List;

import com.crud_postgre.example.crud_postgresql.demo.dto.EmployeeDto;
import com.crud_postgre.example.crud_postgresql.demo.entity.Employee;

public interface EmployeeService {

	List<Employee> getAllEmployees();

	EmployeeDto getEmployeeById(Long id);

	EmployeeDto createEmployee(EmployeeDto employeeDto);

	EmployeeDto updateEmployee(EmployeeDto employeeDto,Long id);

	void deleteEmployeeById(Long id);
}
