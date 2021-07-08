package com.feedbackmanagement.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.feedbackmanagement.entity.CourseEntity;
import com.feedbackmanagement.entity.SkillEntity;
import com.feedbackmanagement.exception.SkillNotFoundException;
import com.feedbackmanagement.pojo.CoursePojo;
import com.feedbackmanagement.pojo.SkillPojo;
import com.feedbackmanagement.repository.ISkillRepository;

@Service
public class ISkillServiceImpl implements ISkillService{

	@Autowired
	ISkillRepository iSkillRepository;
	
	SkillEntity skillEntity = new SkillEntity();
	
	@Override
	public SkillPojo addSkill(SkillPojo skill) {
		// TODO Auto-generated method stub
		BeanUtils.copyProperties(skill, skillEntity);
		skillEntity = iSkillRepository.save(skillEntity);
		BeanUtils.copyProperties( skillEntity,skill);
		return skill;
	}

	@Override
	public SkillPojo updateSkill(SkillPojo skill) {
		// TODO Auto-generated method stub
		BeanUtils.copyProperties(skill, skillEntity);
		Optional<SkillEntity> result = iSkillRepository.findById(skillEntity.getSkillId());
		if(result.isEmpty()) {
			throw new SkillNotFoundException("Skill Not Found to Update");
		}
		else {
			result.get().setSkillName(skillEntity.getSkillName());
			iSkillRepository.save(result.get());
			BeanUtils.copyProperties(result.get(),skill);
			return skill;
		}
	}

	@Override
	public SkillPojo removeSkill(SkillPojo skill) {
		// TODO Auto-generated method stub
		BeanUtils.copyProperties(skill, skillEntity);
		Optional<SkillEntity> result = iSkillRepository.findById(skillEntity.getSkillId());
		if(result.isEmpty()) {
			throw new SkillNotFoundException("Skill Not Found to Delete!!");
		}
		else {
			iSkillRepository.deleteById(result.get().getSkillId());
			BeanUtils.copyProperties(result.get(),skill);
			return skill;
		}
	}

	@Override
	public List<SkillPojo> viewAllSkills() {
		// TODO Auto-generated method stub
		List<SkillPojo> skillPojoList = (ArrayList<SkillPojo>)(ArrayList<?>) (iSkillRepository.findAll());
		return skillPojoList;
	}
	
	

}
