package com.crud_postgre.example.crud_postgresql.demo.mapper;

import com.crud_postgre.example.crud_postgresql.demo.dto.EmployeeDto;
import com.crud_postgre.example.crud_postgresql.demo.entity.Employee;

public class EmployeeMapper {

	public static EmployeeDto mapToEmployeeDto(Employee employee) {

		return new EmployeeDto(employee.getId(), employee.getfName(), employee.getlName(), employee.getEmail());

	}

	public static Employee mapToEmployee(EmployeeDto employeeDto) {

		return new Employee(employeeDto.getId(), employeeDto.getfName(), employeeDto.getlName(),
				employeeDto.getEmail());

	}
}
