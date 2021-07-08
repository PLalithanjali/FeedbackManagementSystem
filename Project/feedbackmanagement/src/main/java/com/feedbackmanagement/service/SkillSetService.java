package com.feedbackmanagement.service;

import java.util.List;

import com.feedbackmanagement.pojo.SkillSetPojo;
import com.feedbackmanagement.pojo.TrainerPojo;

public interface SkillSetService {
	
	SkillSetPojo addSkillSet(SkillSetPojo skillSet);
	
	SkillSetPojo updateSkillSet(SkillSetPojo skillSet);
	
	SkillSetPojo removeSkillSet(SkillSetPojo skillSet);
	
	List<SkillSetPojo> viewTrainerByTrainerName(String trainerName);
	
	List<SkillSetPojo> viewAllTrainersBySkill(String skill);

}
