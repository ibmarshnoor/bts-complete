package com.ibm.employee.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.ibm.employee.entity.Employee;
import com.ibm.employee.repo.EmployeeRepository;



class EmployeeServiceTest {

	@Test
	void testCreateEmployee() {
		EmployeeService employeeService=new EmployeeService();
		EmployeeRepository dummyRepo= new DummyEmployeeRepository();
		employeeService.setEmployeeRepository(dummyRepo);
		Employee employee =new Employee();
		String employeeId=employeeService.createEmployee(employee);
		assertNotNull(employeeId);
	}
	@Test
	void testUpdateEmployee() {
		EmployeeService employeeService=new EmployeeService();
		EmployeeRepository dummyRepo= new DummyEmployeeRepository();
		employeeService.setEmployeeRepository(dummyRepo);
		Employee employee =new Employee();
		String employeeId=employeeService.createEmployee(employee);
		assertNotNull(employeeId);
		
	}
//	@Test
//	void testGetEmployee() {
//		fail("Not yet implemented");
//}

//	@Test
//	void testGetEmployee() {
//		EmployeeService EmployeeService = new EmployeeService();
//		EmployeeRepository dummyRepo = new DummyEmployeeRepository();
//		employeeService.setEmployeeRepository(dummyRepo);
//		Employee employee = new Employee();
//		List<Employee> employeeId = employeeService.getEmployee();
//		
//	}
//
//	@Test
//	void testUpdateEmployee() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testGetEmployeeString() {
//  }
//	void testGetEmployee() {
//		fail("Not yet implemented");
//	}

}
