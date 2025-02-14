package com.crud_postgre.example.crud_postgresql.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud_postgre.example.crud_postgresql.demo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
