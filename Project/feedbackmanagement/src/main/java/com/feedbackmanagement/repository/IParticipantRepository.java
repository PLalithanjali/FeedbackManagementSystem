package com.feedbackmanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.feedbackmanagement.entity.EmployeeEntity;

@Repository
public interface IParticipantRepository extends JpaRepository<EmployeeEntity, Integer> {
	
	@Query(value = "select e.* from employee e where e.employee_id \r\n"
			+ "	in(select f.participant_id from feedback f where f.program_id in(select p.program_id from program p where p.course_id = ?1))",nativeQuery = true)
	List<EmployeeEntity> findAllByCourseId(int courseId);
	
	@Query(value="select e.* from employee e where e.employee_name = ?1",nativeQuery = true)
	EmployeeEntity findByUserName(String username);
}
