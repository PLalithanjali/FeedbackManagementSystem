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

import com.feedbackmanagement.pojo.SkillPojo;
import com.feedbackmanagement.pojo.SkillSetPojo;
import com.feedbackmanagement.pojo.TrainerPojo;
import com.feedbackmanagement.service.ITrainerManagementService;
import com.feedbackmanagement.service.SkillSetService;

@CrossOrigin
@RestController
@RequestMapping("/admin/trainer-management")

public class TrainerController {
	
	@Autowired
	ITrainerManagementService iTrainerManagementService;
	
	@Autowired
	SkillSetService skillSetService;
	
	@PostMapping("/add-trainer")
	public TrainerPojo addTrainer(@Validated @RequestBody TrainerPojo trainer) {		
		return iTrainerManagementService.addTrainer(trainer);
	}
	
	@PutMapping("/update-trainer")
	public TrainerPojo updateTrainer(@Validated @RequestBody TrainerPojo trainer) {
		return iTrainerManagementService.updateTrainer(trainer);
	}
	
	@DeleteMapping("/delete-trainer/{id}")
	public TrainerPojo removeTrainer(@PathVariable("id") int trainerId) {
		TrainerPojo trainer = new TrainerPojo();
		trainer.setTrainerId(trainerId);
		return iTrainerManagementService.removeTrainer(trainer);
	}
	
	@GetMapping("/view-trainer-byname/{name}")
	public List<SkillSetPojo> viewTrainer(@Validated @PathVariable ("name") String trainerName) {
		return skillSetService.viewTrainerByTrainerName(trainerName);
		}
	
	@GetMapping("/all-trainers")
	public List<TrainerPojo> viewAllTrainers() {
		return iTrainerManagementService.viewAllTrainers();
		}
	
	@GetMapping("/view-trainer-byskill/{skill}")
	public List<SkillSetPojo> viewAllTrainers(@Validated @PathVariable("skill") String skill) {
		return skillSetService.viewAllTrainersBySkill(skill);
		}
	
}
