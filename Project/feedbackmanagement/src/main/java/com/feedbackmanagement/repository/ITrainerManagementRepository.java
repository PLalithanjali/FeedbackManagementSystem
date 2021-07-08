package com.feedbackmanagement.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.feedbackmanagement.entity.TrainerEntity;

@Repository
public interface ITrainerManagementRepository extends JpaRepository<TrainerEntity, Integer> {
	
}
