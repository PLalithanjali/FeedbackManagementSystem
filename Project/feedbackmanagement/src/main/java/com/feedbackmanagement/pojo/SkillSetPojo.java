package com.feedbackmanagement.pojo;

import javax.validation.constraints.NotNull;

public class SkillSetPojo {
	
	@NotNull(message = "SkillSet Id cannot be null")
	private int skillSetId;
	
	@NotNull(message = "Trainer cannot be null")
	private TrainerPojo trainer;
	
	@NotNull(message = "Skill cannot be null")
	private SkillPojo skill;

	public int getSkillSetId() {
		return skillSetId;
	}

	public void setSkillSetId(int skillSetId) {
		this.skillSetId = skillSetId;
	}

	public TrainerPojo getTrainer() {
		return trainer;
	}

	public void setTrainer(TrainerPojo trainer) {
		this.trainer = trainer;
	}

	public SkillPojo getSkill() {
		return skill;
	}

	public void setSkill(SkillPojo skill) {
		this.skill = skill;
	}

	public SkillSetPojo(int skillSetId, TrainerPojo trainer, SkillPojo skill) {
		super();
		this.skillSetId = skillSetId;
		this.trainer = trainer;
		this.skill = skill;
	}

	public SkillSetPojo() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "SkillSetPojo [skillSetId=" + skillSetId + ", trainer=" + trainer + ", skill=" + skill + "]";
	}

}
