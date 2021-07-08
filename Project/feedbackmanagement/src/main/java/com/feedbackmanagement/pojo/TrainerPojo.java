package com.feedbackmanagement.pojo;

import javax.validation.constraints.NotNull;

public class TrainerPojo {
	
	@NotNull(message = "Trainer Id cannot be null")
	private int trainerId;
	
	@NotNull(message = "Trainer Name cannot be null")
	private String trainerName;
	
	

	public TrainerPojo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TrainerPojo(int trainerId, String trainerName) {
		super();
		this.trainerId = trainerId;
		this.trainerName = trainerName;
	}

	public int getTrainerId() {
		return trainerId;
	}

	public void setTrainerId(int trainerId) {
		this.trainerId = trainerId;
	}

	public String getTrainerName() {
		return trainerName;
	}

	public void setTrainerName(String trainerName) {
		this.trainerName = trainerName;
	}

	@Override
	public String toString() {
		return "TrainerPojo [trainerId=" + trainerId + ", trainerName=" + trainerName + "]";
	}
}
