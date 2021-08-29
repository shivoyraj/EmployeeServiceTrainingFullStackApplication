package com.infy.service;

import java.util.Arrays;

import java.util.List;
import java.util.Optional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.infy.dto.TrainingDetailsDTO;
import com.infy.entity.Employee;
import com.infy.exception.EmployeeServiceException;
import com.infy.repository.EmployeeRepository;
import com.infy.utility.LoggingAspect;


@Service
public class TrainingServiceImpl implements TrainingService {

	private static final Log LOGGER = LogFactory.getLog(LoggingAspect.class);
	
	@Autowired
	RestTemplate restTemplate;

	@Autowired
	EmployeeRepository empRepo;
	
	@Override
	public List<TrainingDetailsDTO> getTrainingDetails() throws RestClientException {
		String url = "http://localhost:8082/Infy/Trainings";
		ResponseEntity<TrainingDetailsDTO[]> responseEntity =restTemplate.getForEntity(url, TrainingDetailsDTO[].class);	
		TrainingDetailsDTO[] trainings = responseEntity.getBody();
		List<TrainingDetailsDTO> trainingsList = Arrays.asList(trainings);
        return trainingsList;
	}

	@Override
	public TrainingDetailsDTO getTrainingDetail(Integer empId) throws RestClientException, EmployeeServiceException {
		
		Optional<Employee> employee = empRepo.findById(empId);
		
		if(employee.isEmpty())
			throw new EmployeeServiceException("employee.EMPLOYEE_NOT_PRESENT");
		
		String url = "http://localhost:8082/Infy/Training/"+empId;
		ResponseEntity<TrainingDetailsDTO> responseEntity =restTemplate.getForEntity(url, TrainingDetailsDTO.class);	
		TrainingDetailsDTO trainings = responseEntity.getBody();
        return trainings;
	}

	@Override
	public String addTrainingDetail(TrainingDetailsDTO trainingDTO) throws RestClientException, EmployeeServiceException {
		
        Optional<Employee> employee = empRepo.findById(trainingDTO.getEmpId());
        String response="";
		if(!employee.isPresent())
			throw new EmployeeServiceException("employee.EMPLOYEE_NOT_PRESENT");
	
			String url = "http://localhost:8082/Infy/Training";
		    response = restTemplate.postForObject(url,trainingDTO,String.class);		
		LOGGER.info("training.TRAINING_INSERTION_SUCCESSFULL");
		return response;
	}

	@Override
	public void updateTrainingDetail(Integer empId, TrainingDetailsDTO trainingDTO)
			throws RestClientException, EmployeeServiceException {
		
		Optional<Employee> employee = empRepo.findById(empId);
		if(!employee.isPresent())
			throw new EmployeeServiceException("employee.EMPLOYEE_NOT_PRESENT");
		
		String url = "http://localhost:8082/Infy/Training/"+empId;
		restTemplate.put(url,trainingDTO,empId);
		LOGGER.info("training.TRAINING_UPDATE_SUCCESSFULL");
	}

	@Override
	public void deleteTrainingDetail(Integer empId) throws RestClientException, EmployeeServiceException {
	
		Optional<Employee> employee = empRepo.findById(empId);
		if(!employee.isPresent())
			throw new EmployeeServiceException("employee.EMPLOYEE_NOT_PRESENT");
		
		String url = "http://localhost:8082/Infy/Training/"+empId;
		restTemplate.delete(url, empId);
		LOGGER.info("training.TRAINING_DELETED_SUCCESSFULL");

	}

}
