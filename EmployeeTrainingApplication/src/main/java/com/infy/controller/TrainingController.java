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

import com.infy.dto.TrainingDetailsDTO;
import com.infy.exception.TrainingServiceException;
import com.infy.service.TrainingService;

@CrossOrigin
@RestController
@RequestMapping("/Infy")
public class TrainingController {

	@Autowired
	Environment environment;

	@Autowired
	private TrainingService trainingService;

	@GetMapping("/Trainings")
	public ResponseEntity<List<TrainingDetailsDTO>> getTrainings() throws TrainingServiceException {

		List<TrainingDetailsDTO> trainingDetailsList = this.trainingService.getTrainingDetails();
		return new ResponseEntity<>(trainingDetailsList, HttpStatus.OK);

	}

	@GetMapping(value = "/Training/{empId}")
	public ResponseEntity<TrainingDetailsDTO> getTraining(@PathVariable Integer empId) throws TrainingServiceException {
		TrainingDetailsDTO training = trainingService.getTrainingDetail(empId);
		return new ResponseEntity<>(training, HttpStatus.OK);
	}

	@PostMapping(value = "/Training")
	public ResponseEntity<String> addTraining(@RequestBody TrainingDetailsDTO training) throws TrainingServiceException {
		trainingService.addTrainingDetail(training);
		return new ResponseEntity<>(environment.getProperty("training.TRAINING_INSERTION_SUCCESSFULL"),
				HttpStatus.OK);
	}

	@PutMapping(value = "/Training/{empId}")
	public ResponseEntity<String> updateTraining(@PathVariable Integer empId, @RequestBody TrainingDetailsDTO training)
			throws TrainingServiceException {
		trainingService.updateTrainingDetail(empId, training);
		return new ResponseEntity<>(environment.getProperty("training.TRAINING_UPDATE_SUCCESSFULL") ,
				HttpStatus.OK);

	}

	@DeleteMapping(value = "/Training/{empId}")
	public ResponseEntity<String> deleteTraining(@PathVariable Integer empId) throws TrainingServiceException {
       		trainingService.deleteTrainingDetail(empId);
		return new ResponseEntity<>(environment.getProperty("training.TRAINING_DELETED_SUCCESSFULL") ,
				HttpStatus.OK);
	}
	
}
