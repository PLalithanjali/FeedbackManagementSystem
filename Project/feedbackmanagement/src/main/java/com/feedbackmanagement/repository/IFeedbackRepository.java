package com.feedbackmanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.feedbackmanagement.entity.FeedbackEntity;

@Repository
public interface IFeedbackRepository extends JpaRepository<FeedbackEntity, Integer>{
	
	@Query(value = "select f.* from feedback f where f.program_id in (select p.program_id from program p where p.trainer_id = ?1)"
			,nativeQuery = true)
	List<FeedbackEntity> findAllByTrainerId(int trainerId);
	
	@Query(value="select f.* from feedback f where f.program_id = ?1",nativeQuery = true)
	List<FeedbackEntity> findAllByProgramId(int programId);
	
	@Query(value="select f.* from feedback f where f.feedbackcriteria1 = '0'",nativeQuery = true)
	List<FeedbackEntity> findAllDefaultersReport();
}
