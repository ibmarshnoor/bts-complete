package com.ibm.employee;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.employee.entity.Employee;
import com.ibm.employee.service.EmployeeService;

@RestController
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;

	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping("/employee")
	String createEmployee(@RequestBody @Valid Employee employee, BindingResult bindingResult) {
		validateModel(bindingResult);
		System.out.println(employee);
		return employeeService.createEmployee(employee);

	}

	/**
	 * method that returns all the employees in the db
	 * 
	 * @param employeeId
	 * @return all employees in db
	 */
	@GetMapping("/employee")
	List<Employee> getEmployees() {
		return employeeService.getEmployees();
	}

	/**
	 * method that returns matching employee
	 * 
	 * @param employeeId
	 * @return null or matching employee
	 */
	@GetMapping("/employee/{id}")
	Optional<Employee> getEmployee(@PathVariable("id") String employeeId) {
//		System.out.println(employee);
		return employeeService.getEmployee(employeeId);
	}

	@PutMapping("/employee/{id}")
	void updateEmployee(@RequestBody @Valid Employee employee, BindingResult bindingResult,
			@PathVariable("id") String employeeId) {
		validateModel(bindingResult);
		System.out.println(employeeId);
		employee.setId(employeeId);
		employeeService.updateEmployee(employee);
	}

	private void validateModel(Errors bindingResult) {
		if (bindingResult.hasErrors()) {
			throw new IllegalArgumentException("Something went wrong.Please retry");
		}
	}
}