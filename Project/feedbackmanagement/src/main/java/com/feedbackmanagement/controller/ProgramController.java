package com.feedbackmanagement.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
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
import com.feedbackmanagement.service.ITrainingProgramService;

@CrossOrigin
@RestController
@RequestMapping("/program")

public class ProgramController {
	
	@Autowired
	ITrainingProgramService iTrainingProgramService;
	
	@PostMapping("/add-program")
	public ProgramPojo createProgram(@Validated @RequestBody ProgramPojo program) {	
		return iTrainingProgramService.createProgram(program);
		}
	
	@PutMapping("/update-program")
	public ProgramPojo updateProgram(@Validated @RequestBody ProgramPojo program) {
		return iTrainingProgramService.updateProgram(program);
	}
	
	@DeleteMapping("/delete-program/{id}")
	public ProgramPojo removeProgram(@PathVariable("id") int programId) {
		ProgramPojo program = new ProgramPojo();
		program.setProgramId(programId);
		return iTrainingProgramService.removeProgram(program);
	}
	
	@GetMapping("/all-programs")
	public List<ProgramPojo> viewAllPrograms() {
		return iTrainingProgramService.viewAllPrograms();
	}
	
	@GetMapping("/view-program/{programId}")
	public ProgramPojo viewProgram(@PathVariable("programId") ProgramPojo program){
		return iTrainingProgramService.viewProgram(program);
	}
	
	@GetMapping("/program-bydate/{date}")
	public List<ProgramPojo> viewAllProgramsByDate(@Validated @PathVariable("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date startDate) {
		return iTrainingProgramService.viewAllProgramsByDate(startDate);
	}
	
	@GetMapping("/program-byfaculty/{faculty}")
	public List<ProgramPojo> viewAllProgramsByFaculty(@Validated @PathVariable("faculty") int faculty) {
		return iTrainingProgramService.viewAllProgramsByFaculty(faculty);
	}

}
