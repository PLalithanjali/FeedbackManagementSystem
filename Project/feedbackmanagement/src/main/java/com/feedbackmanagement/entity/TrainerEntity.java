package com.feedbackmanagement.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "trainer")
public class TrainerEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "trainer_id")
	private int trainerId;
	
	@Column(name = "trainer_name")
	private String trainerName;
	
	@OneToMany(mappedBy = "trainer")
	private List<ProgramEntity> programs = new ArrayList<ProgramEntity>();
	
	@ManyToMany
	@JoinTable(name = "trainer_skill", joinColumns = { @JoinColumn(name = "trainer_id") }, inverseJoinColumns = { @JoinColumn(name = "skill_id") })
	private List<SkillEntity> skills = new ArrayList<SkillEntity>();
	

	public TrainerEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TrainerEntity(int trainerId, String trainerName) {
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
		return "TrainerEntity [trainerId=" + trainerId + ", trainerName=" + trainerName + "]";
	}
	
}
