package com.feedbackmanagement;



import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.feedbackmanagement.entity.SkillSetEntity;
import com.feedbackmanagement.repository.SkillSetRepository;
import com.feedbackmanagement.service.SkillSetService;
import com.feedbackmanagement.service.SkillSetServiceImpl;

@SpringBootTest
public class SkillSetServiceTest {
	
	@InjectMocks
	SkillSetService iSkillSetService = new SkillSetServiceImpl();
	
	@Mock
	SkillSetRepository iSkillSetRepository;
	
	@Test
	public void testViewTrainerByTrainerName() {
		
		String trainerName = "John";
		SkillSetEntity skillSetEntity = new SkillSetEntity();
		List<SkillSetEntity> skillSetEntityList = new ArrayList<SkillSetEntity>();
		
		skillSetEntity.setSkillSetId(500);
		
		skillSetEntityList.add(skillSetEntity);
		
		Mockito.when(iSkillSetRepository.viewTrainerByTrainerName(trainerName)).thenReturn(skillSetEntityList);
		
		assertEquals(false,iSkillSetService.viewTrainerByTrainerName(trainerName).isEmpty());
		
	}
	
	@Test
	public void testviewAllTrainersBySkill() {
		
		String skill = "Java";
		SkillSetEntity skillSetEntity = new SkillSetEntity();
		List<SkillSetEntity> skillSetEntityList = new ArrayList<SkillSetEntity>();
		
		skillSetEntity.setSkillSetId(500);
		
		skillSetEntityList.add(skillSetEntity);
		
		Mockito.when(iSkillSetRepository.viewAllTrainersBySkill(skill)).thenReturn(skillSetEntityList);
		
		assertEquals(false,iSkillSetService.viewAllTrainersBySkill(skill).isEmpty());
		
	}
		
	

}
