package com.infy.service;

import java.util.List;


import com.infy.dto.TrainingDetailsDTO;
import com.infy.entity.TrainingDetails;
import com.infy.exception.TrainingServiceException;

public interface TrainingService {

	
	public List<TrainingDetailsDTO> getTrainingDetails() throws TrainingServiceException;

	public TrainingDetailsDTO getTrainingDetail(Integer empId) throws TrainingServiceException;
	public TrainingDetails addTrainingDetail(TrainingDetailsDTO trainingDTO) throws TrainingServiceException;
	public TrainingDetails updateTrainingDetail(Integer empId,TrainingDetailsDTO trainingDTO) throws TrainingServiceException;
	public void deleteTrainingDetail(Integer empId) throws TrainingServiceException;
	
}
