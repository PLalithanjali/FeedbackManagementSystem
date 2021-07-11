package com.feedbackmanagement.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.feedbackmanagement.entity.CourseEntity;
import com.feedbackmanagement.entity.EmployeeEntity;
import com.feedbackmanagement.entity.FeedbackEntity;
import com.feedbackmanagement.entity.ProgramEntity;
import com.feedbackmanagement.exception.FeedbackNotFoundException;
import com.feedbackmanagement.exception.ParticipantNotFoundException;
import com.feedbackmanagement.exception.ProgramNotFoundException;
import com.feedbackmanagement.pojo.CoursePojo;
import com.feedbackmanagement.pojo.EmployeePojo;
import com.feedbackmanagement.pojo.FeedbackPojo;
import com.feedbackmanagement.pojo.ProgramPojo;
import com.feedbackmanagement.repository.IFeedbackRepository;
import com.feedbackmanagement.repository.IParticipantRepository;
import com.feedbackmanagement.repository.ITrainingProgramRepository;

@Service
public class IParticipantServiceImpl implements IParticipantService{
	
	@Autowired
	IParticipantRepository iParticipantRepository;
	
	@Autowired
	IFeedbackRepository iFeedbackRepository;
	
	@Autowired
	ITrainingProgramRepository iTrainingProgramRepository;
	
	EmployeeEntity employeeEntity = new EmployeeEntity();
	ProgramEntity programEntity = new ProgramEntity();
	CourseEntity courseEntity = new CourseEntity();
	

	@Override
	public FeedbackPojo enrollParticipant(FeedbackPojo feedbackPojo) {
		FeedbackEntity feedbackEntity  = new FeedbackEntity();
		// TODO Auto-generated method stub
		BeanUtils.copyProperties(feedbackPojo.getEmployee(),employeeEntity);
		BeanUtils.copyProperties(feedbackPojo.getProgram(),programEntity);
		Optional<EmployeeEntity> employeeResult = iParticipantRepository.findById(employeeEntity.getEmployeeId());
		Optional<ProgramEntity> programResult = iTrainingProgramRepository.findById(programEntity.getProgramId());
		if(employeeResult.isEmpty()) {
			throw new ParticipantNotFoundException("Participant Not Found to Enroll!!");
		}
		else if(programResult.isEmpty()) {
			throw new ProgramNotFoundException("Program Not Found to Enroll!!");
		}
		else {
	    feedbackEntity.setEmployee(employeeResult.get());
	    feedbackEntity.setProgram(programResult.get());
		feedbackEntity = iFeedbackRepository.saveAndFlush(feedbackEntity);
		BeanUtils.copyProperties(feedbackEntity, feedbackPojo);
		BeanUtils.copyProperties(employeeResult.get(),feedbackPojo.getEmployee());
				BeanUtils.copyProperties(programResult.get(),feedbackPojo.getProgram());
				feedbackPojo.setEmployee(feedbackPojo.getEmployee());
				feedbackPojo.setProgram(feedbackPojo.getProgram());
		return feedbackPojo;
		}
	}

	@Override
	public List<EmployeePojo> viewParticipantList(int courseId) {
		// TODO Auto-generated method stub
		List<EmployeePojo> employeePojoList = (ArrayList<EmployeePojo>)(ArrayList<?>) (iParticipantRepository.findAllByCourseId(courseId));
		if(employeePojoList.isEmpty()) {
			throw new ParticipantNotFoundException("Participant Not Found for this Course");
		}
		return employeePojoList;
	}
	
	@Override
	public List<EmployeePojo> viewParticipantList() {
		// TODO Auto-generated method stub
		List<EmployeePojo> employeePojoList = (ArrayList<EmployeePojo>)(ArrayList<?>) (iParticipantRepository.findAll());
		if(employeePojoList.isEmpty()) {
			throw new ParticipantNotFoundException("Participant Not Found for this Course");
		}
		return employeePojoList;
	}

	@Override
	public EmployeePojo addParticipant(EmployeePojo employee) {
		// TODO Auto-generated method stub
		BeanUtils.copyProperties(employee, employeeEntity);
		iParticipantRepository.save(employeeEntity);
		BeanUtils.copyProperties(employeeEntity, employee);
		return employee;
	}

}
