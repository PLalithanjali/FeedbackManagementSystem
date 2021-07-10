package com.feedbackmanagement.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="trainer_skill")
public class SkillSetEntity {
	
	@Id
	@Column(name = "skillset_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int skillSetId;
	
	@ManyToOne
	@JoinColumn(name = "trainer_id")
	private TrainerEntity trainer;
	
	@ManyToOne
	@JoinColumn(name = "skill_id")
	private SkillEntity skill;

	public int getSkillSetId() {
		return skillSetId;
	}

	public void setSkillSetId(int skillSetId) {
		this.skillSetId = skillSetId;
	}

	public TrainerEntity getTrainer() {
		return trainer;
	}

	public void setTrainer(TrainerEntity trainer) {
		this.trainer = trainer;
	}

	public SkillEntity getSkill() {
		return skill;
	}

	public void setSkill(SkillEntity skill) {
		this.skill = skill;
	}

	public SkillSetEntity(int skillSetId, TrainerEntity trainer, SkillEntity skill) {
		super();
		this.skillSetId = skillSetId;
		this.trainer = trainer;
		this.skill = skill;
	}

	public SkillSetEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

}
