package com.feedbackmanagement.service;

import java.util.List;

import com.feedbackmanagement.pojo.FeedbackPojo;

public interface IFeedbackService {

	public FeedbackPojo addFeedback(FeedbackPojo feedback);

	public FeedbackPojo updateFeedback(FeedbackPojo feedback);

	public List<FeedbackPojo> viewTrainerFeedback(int trainerId);

	public List<FeedbackPojo> viewProgramFeedback(int programId);
	
	public List<FeedbackPojo> findAllDefaultersReport();
}
