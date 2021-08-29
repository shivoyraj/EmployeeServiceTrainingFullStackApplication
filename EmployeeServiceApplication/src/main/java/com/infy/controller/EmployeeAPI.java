package com.infy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infy.dto.EmployeeDTO;
import com.infy.entity.Employee;
import com.infy.exception.AssetServiceException;
import com.infy.exception.EmployeeServiceException;
import com.infy.service.EmployeeService;

@CrossOrigin
@RestController
@RequestMapping(value = "/InfyEmployee")
public class EmployeeAPI {

	@Autowired
	Environment environment;

	@Autowired
	private EmployeeService employeeservice;

	@GetMapping("/employees")
	public ResponseEntity<List<EmployeeDTO>> getEmployees() throws EmployeeServiceException {

		List<EmployeeDTO> empList = this.employeeservice.getEmployees();
		return new ResponseEntity<>(empList, HttpStatus.OK);

	}

	@GetMapping(value = "/employee/{employeeId}")
	public ResponseEntity<EmployeeDTO> getEmployee(@PathVariable Integer employeeId) throws EmployeeServiceException {
		EmployeeDTO employee = employeeservice.getEmployee(employeeId);
		return new ResponseEntity<>(employee, HttpStatus.OK);
	}

	@PostMapping(value = "/employee")
	public ResponseEntity<String> addEmployee(@RequestBody EmployeeDTO employee) throws EmployeeServiceException, AssetServiceException {
		EmployeeDTO e = employeeservice.addEmployee(employee);
		
		return new ResponseEntity<>(environment.getProperty("employee.EMPLOYEE_INSERTION_SUCCESSFULL"),
				HttpStatus.OK);
	}

	@PutMapping(value = "/employee/{employeeId}")
	public ResponseEntity<String> updateEmployee(@PathVariable Integer employeeId, @RequestBody EmployeeDTO employee)
			throws EmployeeServiceException, AssetServiceException {
		employeeservice.updateEmployee(employeeId, employee);
		return new ResponseEntity<>(environment.getProperty("employee.EMPLOYEE_UPDATE_SUCCESSFULL"),
				HttpStatus.OK);

	}

	@DeleteMapping(value = "/employee/{employeeId}")
	public ResponseEntity<String> deleteEmployee(@PathVariable Integer employeeId) throws EmployeeServiceException {
		employeeservice.deleteEmployee(employeeId);
		return new ResponseEntity<>(environment.getProperty("employee.EMPLOYEE_DELETED_SUCCESSFULL"),
				HttpStatus.OK);
	}

}
