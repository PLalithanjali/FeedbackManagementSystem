package com.feedbackmanagement.service;

import java.util.List;

import com.feedbackmanagement.pojo.TrainerPojo;

public interface ITrainerManagementService {
	
	public TrainerPojo addTrainer(TrainerPojo trainer);

	public TrainerPojo updateTrainer(TrainerPojo trainer);

	public TrainerPojo removeTrainer(TrainerPojo trainer);

	public List<TrainerPojo> viewAllTrainers();
}
