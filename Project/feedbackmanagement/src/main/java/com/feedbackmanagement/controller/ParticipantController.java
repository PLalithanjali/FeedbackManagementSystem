package com.feedbackmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.feedbackmanagement.pojo.CoursePojo;
import com.feedbackmanagement.pojo.EmployeePojo;
import com.feedbackmanagement.pojo.FeedbackPojo;
import com.feedbackmanagement.pojo.ProgramPojo;
import com.feedbackmanagement.service.IParticipantService;

@CrossOrigin
@RestController
@RequestMapping("/participant/")
public class ParticipantController {
	
	@Autowired
	IParticipantService iParticipantService;
	
	@GetMapping("/all-participants/{id}")
	public List<EmployeePojo> viewParticipantList(@PathVariable ("id") int courseId) {
		return iParticipantService.viewParticipantList(courseId);
	}
	
	@GetMapping("/all-participants")
	public List<EmployeePojo> viewParticipantList() {
		return iParticipantService.viewParticipantList();
	}
	
	@PostMapping("/enroll-participant")
	public FeedbackPojo enrollParticipant(@Validated @RequestBody FeedbackPojo feedbackPojo) {
		return iParticipantService.enrollParticipant(feedbackPojo);
	}
	
	@PostMapping("/add-participant")
	public EmployeePojo addParticipant(@Validated @RequestBody EmployeePojo employee) {
		return iParticipantService.addParticipant(employee);
	}
}
