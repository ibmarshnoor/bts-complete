package com.ibm.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.employee.entity.Employee;
import com.ibm.employee.repo.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	EmployeeRepository employeeRepository;

	public String createEmployee(Employee employee) {
		
		Employee savedEmployee= employeeRepository.save(employee);
		return savedEmployee.getId() ;
	}

	public List<Employee> getEmployees() {
		return employeeRepository.findAll();
	}

}
