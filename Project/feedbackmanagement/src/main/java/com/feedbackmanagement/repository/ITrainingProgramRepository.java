package com.feedbackmanagement.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.feedbackmanagement.entity.ProgramEntity;

@Repository
public interface ITrainingProgramRepository extends JpaRepository<ProgramEntity, Integer> {
	
	@Query(value = "select p.* from program p where p.startdate = ?1",nativeQuery = true)
	List<ProgramEntity> findAllByStartDate(Date startDate);
	
	@Query(value = "select p.* from program p where p.faculty = ?1",nativeQuery = true)
	List<ProgramEntity> findAllByFacultyId(int facultyId);
}
