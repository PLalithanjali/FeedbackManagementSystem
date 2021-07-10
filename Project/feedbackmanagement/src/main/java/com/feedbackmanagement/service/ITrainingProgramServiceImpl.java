package com.feedbackmanagement.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.feedbackmanagement.entity.CourseEntity;
import com.feedbackmanagement.entity.ProgramEntity;
import com.feedbackmanagement.entity.TrainerEntity;
import com.feedbackmanagement.exception.ProgramNotFoundException;
import com.feedbackmanagement.exception.TrainerNotFoundException;
import com.feedbackmanagement.pojo.ProgramPojo;
import com.feedbackmanagement.repository.ICourseRepository;
import com.feedbackmanagement.repository.ITrainerManagementRepository;
import com.feedbackmanagement.repository.ITrainingProgramRepository;

@Service
public class ITrainingProgramServiceImpl implements ITrainingProgramService{
	
	@Autowired
	ITrainingProgramRepository iTrainingProgramRepository;
	
	@Autowired
	ICourseRepository iCourseRepository;
	
	@Autowired
	ITrainerManagementRepository iTrainerManagementRepository;
	
	ProgramEntity programEntity = new ProgramEntity();
	CourseEntity courseEntity = new CourseEntity();
	TrainerEntity trainerEntity = new TrainerEntity();

	@Override
	public ProgramPojo createProgram(ProgramPojo program) {
		// TODO Auto-generated method stub
		ProgramEntity programEntity = new ProgramEntity();
		BeanUtils.copyProperties(program.getCourse(), courseEntity);
		BeanUtils.copyProperties(program.getTrainer(), trainerEntity);
		programEntity.setCourse(courseEntity);
		programEntity.setTrainer(trainerEntity);
		BeanUtils.copyProperties(program, programEntity);
		programEntity = iTrainingProgramRepository.save(programEntity);
		Optional<CourseEntity> resultCourse  = iCourseRepository.findById(courseEntity.getCourseId());
		Optional<TrainerEntity> resultTrainer = iTrainerManagementRepository.findById(trainerEntity.getTrainerId());
		BeanUtils.copyProperties(programEntity, program);
		BeanUtils.copyProperties(resultCourse.get(), program.getCourse());
		BeanUtils.copyProperties(resultTrainer.get(), program.getTrainer());
		return program;
	}

	@Override
	public ProgramPojo updateProgram(ProgramPojo program) {
		// TODO Auto-generated method stub
		BeanUtils.copyProperties(program, programEntity);
		BeanUtils.copyProperties(program.getCourse(), courseEntity);
		BeanUtils.copyProperties(program.getTrainer(), trainerEntity);
		Optional<ProgramEntity> result = iTrainingProgramRepository.findById(programEntity.getProgramId());
		if(result.isEmpty()) {
			throw new ProgramNotFoundException("Program Not Found to Update!!");
		}
		else {
			result.get().setCourse(courseEntity);
			result.get().setStartDate(programEntity.getStartDate());
			result.get().setEndDate(programEntity.getEndDate());
			result.get().setTrainer(trainerEntity);
			result.get().setRemoved(programEntity.getRemoved());
			iTrainingProgramRepository.save(result.get());
			Optional<CourseEntity> resultCourse  = iCourseRepository.findById(courseEntity.getCourseId());
			Optional<TrainerEntity> resultTrainer = iTrainerManagementRepository.findById(trainerEntity.getTrainerId());
			BeanUtils.copyProperties(result.get(),program);
			BeanUtils.copyProperties(resultCourse.get(), program.getCourse());
			BeanUtils.copyProperties(resultTrainer.get(), program.getTrainer());
	        return program;
		}
	}

	@Override
	public ProgramPojo removeProgram(ProgramPojo program) {
		// TODO Auto-generated method stub
		BeanUtils.copyProperties(program, programEntity);
		Optional<ProgramEntity> result = iTrainingProgramRepository.findById(programEntity.getProgramId());
		if(result.isEmpty()) {
			throw new ProgramNotFoundException("Program Not Found to Delete!!");
		}
		else {
			result.get().setRemoved(1);
			programEntity = iTrainingProgramRepository.save(result.get());
			BeanUtils.copyProperties(programEntity,program);
	        return program;
		}
	}

	@Override
	public ProgramPojo viewProgram(ProgramPojo program) {
		// TODO Auto-generated method stub
		Optional<ProgramEntity> result = iTrainingProgramRepository.findById(programEntity.getProgramId());
		if(result.isEmpty()) {
			throw new ProgramNotFoundException("Program Not Found!!");
		}
		else {
			BeanUtils.copyProperties(program.getCourse(), courseEntity);
			BeanUtils.copyProperties(program.getTrainer(), trainerEntity);
			Optional<CourseEntity> resultCourse  = iCourseRepository.findById(courseEntity.getCourseId());
			Optional<TrainerEntity> resultTrainer = iTrainerManagementRepository.findById(trainerEntity.getTrainerId());
			BeanUtils.copyProperties(result.get(),program);
			BeanUtils.copyProperties(resultCourse.get(), program.getCourse());
			BeanUtils.copyProperties(resultTrainer.get(), program.getTrainer());
	        return program;
		}
	}

	@Override
	public List<ProgramPojo> viewAllPrograms() {
		// TODO Auto-generated method stub
		List<ProgramPojo> programPojoList = (ArrayList<ProgramPojo>)(ArrayList<?>) (iTrainingProgramRepository.findAll());
		return programPojoList;
	}

	@Override
	public List<ProgramPojo> viewAllProgramsByDate(Date startDate) {
		// TODO Auto-generated method stub
		List<ProgramPojo> programPojoList = (ArrayList<ProgramPojo>)(ArrayList<?>) (iTrainingProgramRepository.findAllByStartDate(startDate));
		if(programPojoList.isEmpty()) {
			throw new TrainerNotFoundException("Program Not Found for this Date!!");
		}
		return programPojoList;
	}

	@Override
	public List<ProgramPojo> viewAllProgramsByFaculty(int trainerId) {
		// TODO Auto-generated method stub
		List<ProgramPojo> programPojoList = (ArrayList<ProgramPojo>)(ArrayList<?>) (iTrainingProgramRepository.findAllByFacultyId(trainerId));
		if(programPojoList.isEmpty()) {
			throw new TrainerNotFoundException("Program Not Found for this Trainer!!");
		}
		return programPojoList;
	}

}
