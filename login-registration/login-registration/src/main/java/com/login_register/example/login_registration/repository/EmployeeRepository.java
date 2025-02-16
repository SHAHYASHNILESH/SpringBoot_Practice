package com.login_register.example.login_registration.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.login_register.example.login_registration.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	// Optional<Employee> findOneByEmailAndPassword(String email, String password);
	Employee findByEmployeeEmail(String email);

}
