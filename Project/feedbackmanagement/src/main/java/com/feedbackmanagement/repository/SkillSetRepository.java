package com.feedbackmanagement.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.feedbackmanagement.entity.SkillSetEntity;
import com.feedbackmanagement.entity.TrainerEntity;

public interface SkillSetRepository extends JpaRepository<SkillSetEntity, Integer> {
	
	@Query(value = "select ts.* from trainer_skill ts where ts.trainer_id in (select t.trainer_id from trainer t where t.trainer_name = ?1)"
			,nativeQuery = true)
	List<SkillSetEntity> viewTrainerByTrainerName(String trainerName);
	
	@Query(value = "select ts.* from trainer_skill ts where ts.skill_id in (select s.skill_id from skill s where s.skill_name = ?1)"
			,nativeQuery = true)
	List<SkillSetEntity> viewAllTrainersBySkill(String skill);

}
