package com.infy.repository;

import org.springframework.data.repository.CrudRepository;

import com.infy.entity.TrainingDetails;

public interface TrainingRepository extends CrudRepository<TrainingDetails,Integer> {

}
