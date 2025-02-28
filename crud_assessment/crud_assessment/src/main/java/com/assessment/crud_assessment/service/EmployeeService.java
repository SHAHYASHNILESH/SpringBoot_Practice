package com.assessment.crud_assessment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.assessment.crud_assessment.entity.Employee;
import com.assessment.crud_assessment.exception.ResourceNotFoundException;
import com.assessment.crud_assessment.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepo;

	public List<Employee> getAllEmployees() throws ResourceNotFoundException {

		List<Employee> allEmployees = employeeRepo.findAll();

		if (allEmployees.isEmpty()) {
			throw new ResourceNotFoundException("Employees Not Found");
		}

		return allEmployees;

	}

	public Employee getEmployeeById(Long id) throws ResourceNotFoundException {

		return employeeRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee Not Found"));
	}

	public Employee addEmployee(Employee employee) {

		return employeeRepo.save(employee);

	}

	public Employee updateEmployee(Long id, Employee employee) throws ResourceNotFoundException {

		Employee e = employeeRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee Not Found"));

		e.setName(employee.getName());
		e.setEmail(employee.getEmail());
		e.setDepartment(employee.getDepartment());

		return employeeRepo.save(e);

	}

	public void deleteEmployee(Long id) throws ResourceNotFoundException {

		Employee e = employeeRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee Not Found"));
		employeeRepo.delete(e);

	}

	public List<Employee> sortEmployeesBasedOnField(String field) throws ResourceNotFoundException {

		List<Employee> allEmployees = employeeRepo.findAll(Sort.by(Sort.Direction.ASC, field));

		if (allEmployees.isEmpty()) {
			throw new ResourceNotFoundException("No Data Found");
		}

		return allEmployees;

	}

	public Page<Employee> getEmployeeWithPagination(int offset, int pageSize) throws ResourceNotFoundException {

		Page<Employee> allEmployees = employeeRepo.findAll(PageRequest.of(offset, pageSize));

		if (allEmployees.isEmpty()) {
			throw new ResourceNotFoundException("No Data Found");
		}

		return allEmployees;

	}

	public Page<Employee> getEmployeeWithPaginationAndSorting(int offset, int pageSize, String field)
			throws ResourceNotFoundException {

		Page<Employee> allEmployees = employeeRepo
				.findAll(PageRequest.of(offset, pageSize).withSort(Sort.Direction.ASC, field));

		if (allEmployees.isEmpty()) {
			throw new ResourceNotFoundException("No Data Found");
		}

		return allEmployees;

	}

	public List<Employee> getEmployeeByDepartment(String dept) throws ResourceNotFoundException {

		List<Employee> employeeByDepartment = employeeRepo.findEmployeeByDepartment(dept);

		if (employeeByDepartment.isEmpty()) {
			throw new ResourceNotFoundException("Employees Not Found");
		}

		return employeeByDepartment;

	}
}