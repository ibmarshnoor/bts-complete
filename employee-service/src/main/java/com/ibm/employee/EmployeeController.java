package com.ibm.employee;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
	@GetMapping("/employee")
	List<Employee> getEmployees(){
		return employeeService.getEmployees();
	}

	private void validateModel(Errors bindingResult) {
		if (bindingResult.hasErrors()) {
			throw new IllegalArgumentException("Something went wrong");
		}

	}

}