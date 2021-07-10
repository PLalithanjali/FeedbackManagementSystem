package com.feedbackmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.feedbackmanagement.entity.SkillEntity;

@Repository
public interface ISkillRepository  extends JpaRepository<SkillEntity, Integer>{

}
