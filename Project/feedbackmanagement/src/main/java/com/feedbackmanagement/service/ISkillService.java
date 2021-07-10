package com.feedbackmanagement.service;

import java.util.List;

import com.feedbackmanagement.pojo.SkillPojo;

public interface ISkillService {
	
	public SkillPojo addSkill(SkillPojo skill);
	
	public SkillPojo updateSkill(SkillPojo skill);
	
	public SkillPojo removeSkill(SkillPojo skill);
	
	public List<SkillPojo> viewAllSkills();
}
