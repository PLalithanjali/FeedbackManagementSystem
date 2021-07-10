package com.feedbackmanagement.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.feedbackmanagement.entity.SkillEntity;
import com.feedbackmanagement.entity.SkillSetEntity;
import com.feedbackmanagement.entity.TrainerEntity;
import com.feedbackmanagement.exception.SkillSetNotFoundException;
import com.feedbackmanagement.exception.TrainerNotFoundException;
import com.feedbackmanagement.pojo.SkillSetPojo;
import com.feedbackmanagement.pojo.TrainerPojo;
import com.feedbackmanagement.repository.SkillSetRepository;

@Service
public class SkillSetServiceImpl implements SkillSetService {
	
	@Autowired
	SkillSetRepository skillSetRepository;
	
	SkillEntity skillEntity = new SkillEntity();
	TrainerEntity trainerEntity = new TrainerEntity();
	SkillSetEntity skillSetEntity = new SkillSetEntity();

	@Override
	public List<SkillSetPojo> viewTrainerByTrainerName(String trainerName) {
		// TODO Auto-generated method stub
		List<SkillSetPojo> trainerPojoList = (ArrayList<SkillSetPojo>)(ArrayList<?>) (skillSetRepository.viewTrainerByTrainerName(trainerName));
		if(trainerPojoList.isEmpty()) {
			throw new TrainerNotFoundException("Trainer Not Found!!");
		}
		return trainerPojoList;
	}

	@Override
	public List<SkillSetPojo> viewAllTrainersBySkill(String skill) {
		// TODO Auto-generated method stub
		List<SkillSetPojo> trainerPojoList = (ArrayList<SkillSetPojo>)(ArrayList<?>) (skillSetRepository.viewAllTrainersBySkill(skill));
		if(trainerPojoList.isEmpty()) {
			throw new TrainerNotFoundException("Trainer Not Found for this Skill!!");
		}
        return trainerPojoList;
	}

	@Override
	public SkillSetPojo addSkillSet(SkillSetPojo skillSet) {
		// TODO Auto-generated method stub
		SkillSetEntity skillSetEntity = new SkillSetEntity();
		BeanUtils.copyProperties(skillSet.getSkill(), skillEntity);
		BeanUtils.copyProperties(skillSet.getTrainer(), trainerEntity);
		skillSetEntity.setSkill(skillEntity);
		skillSetEntity.setTrainer(trainerEntity);
		BeanUtils.copyProperties(skillSet, skillSetEntity);
		skillSetEntity = skillSetRepository.save(skillSetEntity);
		BeanUtils.copyProperties(skillSetEntity, skillSet);
		BeanUtils.copyProperties(skillEntity,skillSet.getSkill());
		BeanUtils.copyProperties(trainerEntity,skillSet.getTrainer());
		return skillSet;
	}

	@Override
	public SkillSetPojo updateSkillSet(SkillSetPojo skillSet) {
		SkillSetEntity skillSetEntity = new SkillSetEntity();
		BeanUtils.copyProperties(skillSet.getSkill(), skillEntity);
		BeanUtils.copyProperties(skillSet.getTrainer(), trainerEntity);
		BeanUtils.copyProperties(skillSet, skillSetEntity);
		Optional<SkillSetEntity> result = skillSetRepository.findById(skillSetEntity.getSkillSetId());
		if(result.isEmpty()) {
			throw new SkillSetNotFoundException("SkillSet Not Found to Update!!");
		}
		// TODO Auto-generated method stub
		result.get().setSkill(skillEntity);
		result.get().setTrainer(trainerEntity);
		skillSetEntity = skillSetRepository.save(result.get());
		BeanUtils.copyProperties(result.get(),skillSet);
		BeanUtils.copyProperties(skillEntity,skillSet.getSkill());
		BeanUtils.copyProperties(trainerEntity,skillSet.getTrainer());
		return skillSet;
	}

	@Override
	public SkillSetPojo removeSkillSet(SkillSetPojo skillSet) {
		// TODO Auto-generated method stub
		SkillSetEntity skillSetEntity = new SkillSetEntity();
		BeanUtils.copyProperties(skillSet, skillSetEntity);
		Optional<SkillSetEntity> result = skillSetRepository.findById(skillSetEntity.getSkillSetId());
		if(result.isEmpty()) {
			throw new SkillSetNotFoundException("SkillSet Not Found to Delete!!");
		}
		skillSetRepository.delete(result.get());
		BeanUtils.copyProperties(result.get(),skillSet);
		return skillSet;
	}

}
