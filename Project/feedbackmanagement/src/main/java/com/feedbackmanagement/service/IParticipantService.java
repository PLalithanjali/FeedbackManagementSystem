package com.feedbackmanagement.service;

import java.util.List;

import com.feedbackmanagement.pojo.CoursePojo;
import com.feedbackmanagement.pojo.EmployeePojo;
import com.feedbackmanagement.pojo.FeedbackPojo;
import com.feedbackmanagement.pojo.ProgramPojo;

public interface IParticipantService {
	
	public FeedbackPojo enrollParticipant(FeedbackPojo feedbackPojo);
	
	public EmployeePojo addParticipant(EmployeePojo employee);

	public List<EmployeePojo> viewParticipantList(int courseId);

	public List<EmployeePojo> viewParticipantList();
}
