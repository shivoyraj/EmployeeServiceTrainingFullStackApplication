package com.infy.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.dto.TrainingDetailsDTO;
import com.infy.entity.TrainingDetails;
import com.infy.exception.TrainingServiceException;
import com.infy.repository.TrainingRepository;
import com.infy.utility.LoggingAspect;

@Service
public class TrainingServiceImpl implements TrainingService {
	
	private static final Log LOGGER = LogFactory.getLog(LoggingAspect.class);

	
	@Autowired
	TrainingRepository trainingRepo;



	@Override
	public List<TrainingDetailsDTO> getTrainingDetails() throws TrainingServiceException {
		List<TrainingDetails> trainingList= (List<TrainingDetails>) trainingRepo.findAll();
		  
		  if(trainingList.isEmpty())
			  throw new TrainingServiceException("training.TRAININGS_LIST_EMPTY");
		  
		  List<TrainingDetailsDTO> tl = new ArrayList<TrainingDetailsDTO>();
		  
		  for(TrainingDetails training:trainingList) {
			  TrainingDetailsDTO trainingDTO= new TrainingDetailsDTO();
			  trainingDTO.setEmpId(training.getempId());
			  trainingDTO.setCourseCode(training.getCourseCode());
			  trainingDTO.setCourseName(training.getCourseName());
			  trainingDTO.setDateOfComplition(training.getDateOfComplition());
			  trainingDTO.setHourSpend(training.getHourSpend());
			  trainingDTO.setScore(training.getScore());
			  trainingDTO.setStatus(training.getStatus());
		      tl.add(trainingDTO);
		  }
		  
			return tl;
	}

	@Override
	public TrainingDetailsDTO getTrainingDetail(Integer empId) throws TrainingServiceException {
		Optional<TrainingDetails> courseopt=trainingRepo.findById(empId);
		TrainingDetails training = courseopt.orElseThrow(()-> new TrainingServiceException("training.TRAINING_NOT_PRESENT"));
		TrainingDetailsDTO trainingDTO= new TrainingDetailsDTO();
		  trainingDTO.setEmpId(training.getempId());
		  trainingDTO.setCourseCode(training.getCourseCode());
		  trainingDTO.setCourseName(training.getCourseName());
		  trainingDTO.setDateOfComplition(training.getDateOfComplition());
		  trainingDTO.setHourSpend(training.getHourSpend());
		  trainingDTO.setScore(training.getScore());
		  trainingDTO.setStatus(training.getStatus());
		return trainingDTO;
	}

	@Override
	public TrainingDetails addTrainingDetail(TrainingDetailsDTO trainingDTO) throws TrainingServiceException {
		  Optional<TrainingDetails> t = trainingRepo.findById(trainingDTO.getEmpId());
		   
		  if (t.isPresent())
			  throw new TrainingServiceException("training.DUPLICATE_TRAINING_FOUND");
	
		  TrainingDetails training = new TrainingDetails();
		  training.setEmpId(trainingDTO.getEmpId());
		  training.setCourseCode(trainingDTO.getCourseCode());
		  training.setCourseName(trainingDTO.getCourseName());
		  training.setDateOfComplition(trainingDTO.getDateOfComplition());
		  training.setHourSpend(trainingDTO.getHourSpend());
		  training.setScore(trainingDTO.getScore());
		  training.setStatus(trainingDTO.getStatus());
		
		  trainingRepo.save(training);
		  
			LOGGER.info("training.TRAINING_INSERTION_SUCCESSFULL");
		return training;
	}

	@Override
	public TrainingDetails updateTrainingDetail(Integer empId, TrainingDetailsDTO trainingDTO) throws TrainingServiceException {
		TrainingDetails c;
		Optional<TrainingDetails> copt = trainingRepo.findById(empId);
		if(copt.isPresent()) {
			  c = copt.get();
			  c.setCourseCode(trainingDTO.getCourseCode());
			  c.setCourseName(trainingDTO.getCourseName());
			  c.setDateOfComplition(trainingDTO.getDateOfComplition());
			  c.setHourSpend(trainingDTO.getHourSpend());
			  c.setScore(trainingDTO.getScore());
			  c.setStatus(trainingDTO.getStatus());
			  trainingRepo.save(c);
		}
		else
			  throw new TrainingServiceException("training.TRAINING_NOT_PRESENT");
		
		LOGGER.info("training.TRAINING_UPDATE_SUCCESSFULL");
		return c;
	}

	@Override
	public void deleteTrainingDetail(Integer empId) throws TrainingServiceException {
		Optional<TrainingDetails> c = trainingRepo.findById(empId);
		c.orElseThrow(()-> new TrainingServiceException("training.TRAINING_NOT_PRESENT"));
		trainingRepo.deleteById(empId);
		LOGGER.info("training.TRAINING_DELETED_SUCCESSFULL");

	}




	
	
	
}
