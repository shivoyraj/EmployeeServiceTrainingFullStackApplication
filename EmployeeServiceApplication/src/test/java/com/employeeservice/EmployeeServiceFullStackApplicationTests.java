package com.employeeservice;

import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

import com.infy.EmployeeServiceFullStackApplication;

@SpringBootTest(classes=EmployeeServiceFullStackApplication.class)
@SpringBootConfiguration
class EmployeeServiceFullStackApplicationTests {

	@Test
	void contextLoads() {
	}
	
	@Test
	public void test() {
		System.out.println("working");
	}

}
