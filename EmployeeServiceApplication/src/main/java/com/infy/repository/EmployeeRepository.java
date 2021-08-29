package com.infy.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.infy.entity.Asset;
import com.infy.entity.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

	

	Optional<Employee> findByAsset(Asset a);
	

}
