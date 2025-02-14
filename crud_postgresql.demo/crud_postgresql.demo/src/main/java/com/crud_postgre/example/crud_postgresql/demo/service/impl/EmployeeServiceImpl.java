package com.crud_postgre.example.crud_postgresql.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud_postgre.example.crud_postgresql.demo.dto.EmployeeDto;
import com.crud_postgre.example.crud_postgresql.demo.entity.Employee;
import com.crud_postgre.example.crud_postgresql.demo.mapper.EmployeeMapper;
import com.crud_postgre.example.crud_postgresql.demo.repository.EmployeeRepository;
import com.crud_postgre.example.crud_postgresql.demo.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepo;

	@Override
	public EmployeeDto createEmployee(EmployeeDto employeeDto) {

		// TODO Auto-generated method stub
		Employee employee = EmployeeMapper.mapToEmployee(employeeDto);

		return EmployeeMapper.mapToEmployeeDto(employeeRepo.save(employee));

	}

	@Override
	public EmployeeDto getEmployeeById(Long id) {

		// TODO Auto-generated method stub
		Employee employee = employeeRepo.findById(id).get();
		return EmployeeMapper.mapToEmployeeDto(employee);

	}

	@Override
	public List<Employee> getAllEmployees() {

		// TODO Auto-generated method stub
		return employeeRepo.findAll();

	}

	@Override
	public EmployeeDto updateEmployee(EmployeeDto employeeDto,Long id) {
		
		// TODO Auto-generated method stub
		Employee employee=employeeRepo.findById(id).get();
		
		employee.setfName(employeeDto.getfName());
		employee.setlName(employeeDto.getlName());
		employee.setEmail(employeeDto.getEmail());
		
		//Employee employee = EmployeeMapper.mapToEmployee(employeeDto);

		return EmployeeMapper.mapToEmployeeDto(employeeRepo.save(employee));

	}

	@Override
	public void deleteEmployeeById(Long id) {

		// TODO Auto-generated method stub
		employeeRepo.deleteById(id);

	}

}
