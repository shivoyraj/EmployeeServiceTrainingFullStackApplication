package com.infy.service;

import java.util.List;

import com.infy.dto.EmployeeDTO;
import com.infy.entity.Employee;
import com.infy.exception.AssetServiceException;
import com.infy.exception.EmployeeServiceException;

public interface EmployeeService {
	
	public List<EmployeeDTO> getEmployees() throws EmployeeServiceException;

	public EmployeeDTO getEmployee(Integer employeeId) throws EmployeeServiceException;
	public EmployeeDTO addEmployee(EmployeeDTO employee) throws EmployeeServiceException, AssetServiceException;
	public Employee updateEmployee(Integer empId,EmployeeDTO employee) throws EmployeeServiceException, AssetServiceException;
	public void deleteEmployee(Integer empId) throws EmployeeServiceException;

}
