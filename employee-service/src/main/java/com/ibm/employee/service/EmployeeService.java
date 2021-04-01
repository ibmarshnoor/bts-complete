package com.ibm.employee.service;

import java.util.List;
import java.util.Optional;

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
	public List<Employee> getEmployee() {
		return employeeRepository.findAll();
	}
	
	public void updateEmployee(Employee employee) {
		employeeRepository.save(employee);
	}

	public Optional<Employee> getEmployee(String employeeId) {
		return employeeRepository.findById(employeeId);
	}

}
