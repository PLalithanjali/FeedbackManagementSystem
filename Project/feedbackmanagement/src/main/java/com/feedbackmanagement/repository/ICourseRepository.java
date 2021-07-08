package com.feedbackmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.feedbackmanagement.entity.CourseEntity;

@Repository
public interface ICourseRepository extends JpaRepository<CourseEntity, Integer>{
	
}
