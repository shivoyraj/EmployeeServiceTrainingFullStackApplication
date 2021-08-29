package com.infy.utility;

import java.time.LocalDateTime;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.RestClientException;

import com.infy.exception.AssetServiceException;
import com.infy.exception.EmployeeServiceException;

@RestControllerAdvice
public class ExceptionControllerAdvice {
	@Autowired
	Environment environment;
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorInfo> exceptionHandler(Exception exception) {
		ErrorInfo error = new ErrorInfo();
		error.setErrorMessage(environment.getProperty("General.EXCEPTION_MESSAGE"));
		error.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		error.setTimestamp(LocalDateTime.now());
		return new ResponseEntity<ErrorInfo>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	@ExceptionHandler(EmployeeServiceException.class)
	public ResponseEntity<ErrorInfo> employeeServiceException(EmployeeServiceException exception) {
		ErrorInfo error = new ErrorInfo();
		error.setErrorMessage(environment.getProperty(exception.getMessage()));
		error.setTimestamp(LocalDateTime.now());
		error.setErrorCode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ErrorInfo>(error, HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(AssetServiceException.class)
	public ResponseEntity<ErrorInfo> assetServiceException(AssetServiceException exception) {
		ErrorInfo error = new ErrorInfo();
		error.setErrorMessage(environment.getProperty(exception.getMessage()));
		error.setTimestamp(LocalDateTime.now());
		error.setErrorCode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ErrorInfo>(error, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(RestClientException.class)
	public ResponseEntity<ErrorInfo> employeeServiceException(RestClientException exception) {
		ErrorInfo error = new ErrorInfo();
		
		    String str= exception.getMessage().toString();
		    String[] arr1 = str.split(":",4);
	        String s =arr1[2];
	        String[] arr2=s.split(",");
	        String s2=arr2[0];
	        String s3=s2.substring(1,s2.length()-1);
		    
		error.setErrorMessage(s3);
		error.setTimestamp(LocalDateTime.now());
		error.setErrorCode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ErrorInfo>(error, HttpStatus.NOT_FOUND);
	}
}

