package com.assessment.crud_assessment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.assessment.crud_assessment.entity.Employee;
import com.assessment.crud_assessment.exception.ResourceNotFoundException;
import com.assessment.crud_assessment.repository.EmployeeRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EmployeeService {

//	private static final Logger logger = LoggerFactory.getLogger(EmployeeService.class);

	@Autowired
	private EmployeeRepository employeeRepo;

	public List<Employee> getAllEmployees() throws ResourceNotFoundException {

		List<Employee> allEmployees = employeeRepo.findAll();

		if (allEmployees.isEmpty()) {
			throw new ResourceNotFoundException("Employees Not Found");
		}

		return allEmployees;

	}

	@Cacheable(value = "employees", key = "#id")
	public Employee getEmployeeById(Long id) throws ResourceNotFoundException {

		return employeeRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee Not Found"));
	}

	public Employee addEmployee(Employee employee) {

		log.info("Adding employee in db");
		log.warn("Adding employee in db");
		log.error("Adding employee in db");
		log.debug("Adding employee in db");
		log.trace("Adding employee in db");

		return employeeRepo.save(employee);

	}

	@CachePut(value = "employees", key = "#id")
	public Employee updateEmployee(Long id, Employee employee) throws ResourceNotFoundException {

		Employee e = employeeRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee Not Found"));

		e.setName(employee.getName());
		e.setEmail(employee.getEmail());
		e.setDepartment(employee.getDepartment());

		return employeeRepo.save(e);

	}

	@CacheEvict(value = "employees", key = "#id")
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