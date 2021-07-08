package com.feedbackmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.feedbackmanagement.pojo.CoursePojo;
import com.feedbackmanagement.pojo.FeedbackPojo;
import com.feedbackmanagement.pojo.ProgramPojo;
import com.feedbackmanagement.service.IFeedbackService;

@CrossOrigin
@RestController
@RequestMapping("/feedback")
public class FeedbackController {
	
	@Autowired
	IFeedbackService iFeedbackService;
	
	@GetMapping("/feedback-report-program/{programId}")
	public List<FeedbackPojo> viewProgramFeedback(@PathVariable("programId") int programId) {
		return iFeedbackService.viewProgramFeedback(programId);
	}
	
	@GetMapping("/feedback-report-trainer/{trainerId}")
	public List<FeedbackPojo> viewProgramFeedback3(@PathVariable("trainerId") int trainerId) {
		return iFeedbackService.viewTrainerFeedback(trainerId);
	}
	
	@PutMapping("/participant/update-feedback")
	public FeedbackPojo updateFeedback(@RequestBody FeedbackPojo feedback) {
		return iFeedbackService.updateFeedback(feedback);
	}
	
	@PostMapping("/participant/add-feedback")
	public FeedbackPojo addFeedback(@RequestBody FeedbackPojo feedback) {
		return iFeedbackService.addFeedback(feedback);
	}
	
	@GetMapping("/trainer/feedback-report-defaulters")
	public List<FeedbackPojo> findAllDefaultersReport() {
		return iFeedbackService.findAllDefaultersReport();
	}



}
