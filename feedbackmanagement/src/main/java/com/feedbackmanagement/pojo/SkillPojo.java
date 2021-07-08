package com.feedbackmanagement.pojo;

import javax.validation.constraints.NotNull;

public class SkillPojo {

	@NotNull(message = "Skill Id cannot be null")
	private int skillId;
	
	@NotNull(message = "Skill Name cannot be null")
	private String skillName;

	public SkillPojo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SkillPojo(int skillId, String skillName) {
		super();
		this.skillId = skillId;
		this.skillName = skillName;
	}

	public int getSkillId() {
		return skillId;
	}

	public void setSkillId(int skillId) {
		this.skillId = skillId;
	}

	public String getSkillName() {
		return skillName;
	}

	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}

	@Override
	public String toString() {
		return "SkillPojo [skillId=" + skillId + ", skillName=" + skillName + "]";
	}

}
