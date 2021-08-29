package com.infy.service;

import java.util.List;

import org.springframework.web.client.RestClientException;

import com.infy.dto.TrainingDetailsDTO;
import com.infy.exception.EmployeeServiceException;

public interface TrainingService {

	
	public List<TrainingDetailsDTO> getTrainingDetails() throws RestClientException;

	public TrainingDetailsDTO getTrainingDetail(Integer empId) throws RestClientException, EmployeeServiceException;
	public String addTrainingDetail(TrainingDetailsDTO trainingDTO) throws RestClientException, EmployeeServiceException;
	public void updateTrainingDetail(Integer empId,TrainingDetailsDTO trainingDTO) throws RestClientException, EmployeeServiceException;
	public void deleteTrainingDetail(Integer empId) throws RestClientException, EmployeeServiceException;
	
}
