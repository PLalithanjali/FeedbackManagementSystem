package com.feedbackmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.feedbackmanagement.pojo.SkillPojo;
import com.feedbackmanagement.service.ICourseService;
import com.feedbackmanagement.service.ISkillService;
import com.feedbackmanagement.service.ITrainerManagementService;

@CrossOrigin
@RestController
@RequestMapping("/skill")
public class SkillController {
	
	@Autowired
	ISkillService iSkillService;
	
	@PostMapping("/add-skill")
	public SkillPojo addSkill(@Validated @RequestBody SkillPojo skill) {		
		return iSkillService.addSkill(skill);
	}
	
	@PutMapping("/update-skill")
	public SkillPojo updateSkill(@Validated @RequestBody SkillPojo skill) {		
		return iSkillService.updateSkill(skill);
	}
	
	@DeleteMapping("/delete-skill/{id}")
	public SkillPojo deleteSkill(@PathVariable("id") int skillId) {	
		SkillPojo skill = new SkillPojo();
		skill.setSkillId(skillId);
		return iSkillService.removeSkill(skill);
	}
	
	@GetMapping("/all-skills")
	public List<SkillPojo> viewSkills() {		
		return iSkillService.viewAllSkills();
	}

}
