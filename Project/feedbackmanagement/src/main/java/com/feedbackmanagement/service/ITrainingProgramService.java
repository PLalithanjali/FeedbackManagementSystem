package com.feedbackmanagement.service;

import java.util.Date;
import java.util.List;

import com.feedbackmanagement.pojo.ProgramPojo;

public interface ITrainingProgramService {
	
	public ProgramPojo createProgram(ProgramPojo program);
	
	public ProgramPojo updateProgram(ProgramPojo program);
	
	public ProgramPojo removeProgram(ProgramPojo program);
	
	public ProgramPojo viewProgram(ProgramPojo program);
	
	public List<ProgramPojo> viewAllPrograms();
	
	public List<ProgramPojo> viewAllProgramsByDate(Date startDate);
	
	public List<ProgramPojo> viewAllProgramsByFaculty(int trainerId);
	
	
}
