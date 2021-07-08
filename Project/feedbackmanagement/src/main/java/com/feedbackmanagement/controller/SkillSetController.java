package com.feedbackmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.feedbackmanagement.pojo.SkillSetPojo;
import com.feedbackmanagement.service.SkillSetService;

@CrossOrigin
@RestController
@RequestMapping("/skillset")
public class SkillSetController {
	
	@Autowired
	SkillSetService skillSetService;
	
	@PostMapping("/add-skillset")
	public SkillSetPojo addSkillSet(@Validated @RequestBody SkillSetPojo skillSet) {
		return skillSetService.addSkillSet(skillSet);
	}
	
	@PutMapping("/update-skillset")
	public SkillSetPojo updateSkillSet(@Validated @RequestBody SkillSetPojo skillSet) {
		return skillSetService.updateSkillSet(skillSet);
	}
	
	@DeleteMapping("/delete-skillset")
	public SkillSetPojo removeSkillSet(@RequestBody SkillSetPojo skillSet) {
		return skillSetService.removeSkillSet(skillSet);
	}
	
}
