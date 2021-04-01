package com.ibm.employee.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import com.ibm.employee.entity.Employee;
import com.ibm.employee.repo.EmployeeRepository;

class EmployeeServiceTest {

	@Test
	void testCreateEmployee() {
		EmployeeService employeeService=new EmployeeService();
		Employee employee=new Employee();
		EmployeeRepository dummyRepo=new DummyEmployeeRepository();
		employeeService.setEmployeeRepository(dummyRepo);
		String employeeId=employeeService.createEmployee(employee);
		assertNotNull(employeeId);
		
	}

//	@Test
//	void testGetEmployees() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testGetEmployee() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testUpdateEmployee() {
//		fail("Not yet implemented");
//	}

}
