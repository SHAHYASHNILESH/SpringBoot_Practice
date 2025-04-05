package com.assessment.crud_assessment.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.assessment.crud_assessment.entity.Employee;
import com.assessment.crud_assessment.exception.ResourceNotFoundException;
import com.assessment.crud_assessment.repository.EmployeeRepository;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceTest {

	@Mock
	private EmployeeRepository employeeRepo;

	@InjectMocks
	private EmployeeService employeeService;

	@Test
	void getAllEmployeesTest() throws ResourceNotFoundException {

		List<Employee> employees = new ArrayList<>();
		employees.add(new Employee((long) 1, "Rahul", "rahul@gmail.com", "IT"));
		employees.add(new Employee((long) 2, "Rahul", "rahul@gmail.com", "IT"));
		employees.add(new Employee((long) 3, "Rahul", "rahul@gmail.com", "IT"));

		when(employeeRepo.findAll()).thenReturn(employees);

		assertEquals(3, employeeService.getAllEmployees().size());
		verify(employeeRepo).findAll();

	}

	@Test
	void getAllEmployeeThrowExceptionTest() throws ResourceNotFoundException {

		when(employeeRepo.findAll()).thenReturn(Collections.emptyList());

		assertThrows(ResourceNotFoundException.class, () -> {
			employeeService.getAllEmployees();
		});
		verify(employeeRepo).findAll();

	}

	@Test
	void getEmployeeByIdTest() throws ResourceNotFoundException {

		Optional<Employee> emp = Optional.ofNullable(new Employee((long) 1, "Rahul", "rahul@gmail.com", "IT"));
		when(employeeRepo.findById(1L)).thenReturn(emp);

		assertEquals(emp, Optional.ofNullable(employeeService.getEmployeeById(1L)));
		verify(employeeRepo).findById(1L);

	}

	@Test
	void getEmployeeByIdThrowExceptionTest() throws ResourceNotFoundException {

		when(employeeRepo.findById(1L)).thenReturn(Optional.empty());

		assertThrows(ResourceNotFoundException.class, () -> {
			employeeService.getEmployeeById(1L);
		});

		verify(employeeRepo).findById(1L);

	}

	@Test
	void addEmployeeTest() {

		Employee employee = new Employee((long) 1, "Rahul", "rahul@gmail.com", "IT");
		when(employeeRepo.save(employee)).thenReturn(employee);

		assertEquals(employee, employeeService.addEmployee(employee));
		verify(employeeRepo).save(employee);

	}

	@Test
	void deleteEmployeeTest() throws ResourceNotFoundException {

		Optional<Employee> employee = Optional.ofNullable(new Employee((long) 1, "Rahul", "rahul@gmail.com", "IT"));

		when(employeeRepo.findById(1L)).thenReturn(employee);

		employeeService.deleteEmployee(1L);
		verify(employeeRepo, times(1)).delete(employee.get());

	}

	@Test
	void deleteEmployeeThrowExceptionTest() throws ResourceNotFoundException {

		when(employeeRepo.findById(1L)).thenReturn(Optional.empty());

		assertThrows(ResourceNotFoundException.class, () -> {
			employeeService.deleteEmployee(1L);
		});

		verify(employeeRepo).findById(1L);
		verify(employeeRepo, never()).delete(any());

	}

	@Test
	void updateEmployeeTest() throws ResourceNotFoundException {

		Optional<Employee> employee = Optional.ofNullable(new Employee((long) 1, "Rahul", "rahul@gmail.com", "IT"));

		when(employeeRepo.findById(1L)).thenReturn(employee);

		employee.get().setName("abx");
		employee.get().setEmail("abc@gmail.com");
		employee.get().setDepartment("ut");

		when(employeeRepo.save(employee.get())).thenReturn(employee.get());

		assertEquals(employee.get(), employeeService.updateEmployee(1L, employee.get()));
		verify(employeeRepo).findById(1L);
		verify(employeeRepo).save(employee.get());

	}

	@Test
	void updateEmployeeThrowExceptionTest() throws ResourceNotFoundException {

		Employee employee = new Employee();

		when(employeeRepo.findById(1L)).thenReturn(Optional.empty());

		assertThrows(ResourceNotFoundException.class, () -> {
			employeeService.updateEmployee(1L, employee);
		});

		verify(employeeRepo).findById(1L);
		verify(employeeRepo, never()).save(any());

	}

}
