package com.feedbackmanagement.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "skill")
public class SkillEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="skill_id")
	private int skillId;

	@Column(name="skill_name")
	private String skillName;
	
	@ManyToMany(fetch=FetchType.LAZY,mappedBy="skills")
	private Set<TrainerEntity> trainers = new HashSet<TrainerEntity>();

	@Override
	public String toString() {
		return "SkillEntity [skillId=" + skillId + ", skillName=" + skillName + "]";
	}

	public SkillEntity(int skillId, String skillName) {
		super();
		this.skillId = skillId;
		this.skillName = skillName;
	}

	public SkillEntity() {
		super();
		// TODO Auto-generated constructor stub
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
}
