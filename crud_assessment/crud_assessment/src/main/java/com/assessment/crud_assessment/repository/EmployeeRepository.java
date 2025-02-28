package com.assessment.crud_assessment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.assessment.crud_assessment.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	@Query(nativeQuery = true, value = "SELECT * FROM EMPLOYEE WHERE department=:department")
	public List<Employee> findEmployeeByDepartment(@Param("department") String department);
}
