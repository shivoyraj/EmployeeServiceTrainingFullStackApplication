package com.infy.utility;

import org.apache.commons.logging.Log;

import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;

import com.infy.exception.AssetServiceException;
import com.infy.exception.EmployeeServiceException;

@Component
@Aspect
public class LoggingAspect {
	private static final Log LOGGER = LogFactory.getLog(LoggingAspect.class);

	@AfterThrowing(pointcut = "execution(* com.infy.service.EmployeeServiceImpl.*(..))", throwing = "exception")
	public void logEmployeeException(EmployeeServiceException exception) {
		LOGGER.error(exception.getMessage(), exception);
	}
	
	@AfterThrowing(pointcut = "execution(* com.infy.service.EmployeeServiceImpl.*(..))", throwing = "exception")
	public void logEmployeeAssetException(AssetServiceException exception) {
		LOGGER.error(exception.getMessage(), exception);
	}

	@AfterThrowing(pointcut = "execution(* com.infy.service.AssetServiceImpl.*(..))", throwing = "exception")
	public void logAssetException(AssetServiceException exception) {
		LOGGER.error(exception.getMessage(), exception);
	}
	
	@AfterThrowing(pointcut = "execution(* com.infy.service.TrainingServiceImpl.*(..))", throwing = "exception")
	public void logTrainingException(RestClientException exception) {
		LOGGER.error(exception.getMessage(), exception);
	}

}
