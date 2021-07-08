package com.feedbackmanagement;




import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.feedbackmanagement.entity.CourseEntity;
import com.feedbackmanagement.entity.TrainerEntity;
import com.feedbackmanagement.exception.CourseNotFoundException;
import com.feedbackmanagement.exception.TrainerNotFoundException;
import com.feedbackmanagement.pojo.TrainerPojo;
import com.feedbackmanagement.repository.ITrainerManagementRepository;
import com.feedbackmanagement.service.ITrainerManagementService;
import com.feedbackmanagement.service.ITrainerManagementServiceImpl;

@SpringBootTest
public class TrainerManagementServiceTest {
	
	@InjectMocks
	ITrainerManagementService iTrainerManagementService = new ITrainerManagementServiceImpl();
	
	@Mock
	ITrainerManagementRepository iTrainerManagementRepository;
	
	@Test
	public void testAddTrainer() {
		
		TrainerPojo argTrainerPojo = new TrainerPojo();
		TrainerEntity trainerEntity = new TrainerEntity();
		
		argTrainerPojo.setTrainerName("John");
		
		trainerEntity.setTrainerId(500);
		trainerEntity.setTrainerName("John");
		
		Mockito.when(iTrainerManagementRepository.save(Mockito.any(TrainerEntity.class))).thenReturn(trainerEntity);
		
		assertEquals(500,iTrainerManagementService.addTrainer(argTrainerPojo).getTrainerId());
		
	}
	
	@Test
	public void testUpdateTrainer() {
		
		TrainerPojo argTrainerPojo = new TrainerPojo();
		TrainerEntity trainerEntity = new TrainerEntity();
		Optional<TrainerEntity> rtntrainerEntity = Optional.of(new TrainerEntity()) ;
		
		argTrainerPojo.setTrainerName("John");
		
		rtntrainerEntity.get().setTrainerName("John");
		
		trainerEntity.setTrainerId(500);
		trainerEntity.setTrainerName("Johnson");
		
		Mockito.when(iTrainerManagementRepository.findById(Mockito.anyInt())).thenReturn(rtntrainerEntity);
		
		Mockito.when(iTrainerManagementRepository.save(Mockito.any(TrainerEntity.class))).thenReturn(trainerEntity);
		
		assertEquals("Johnson",iTrainerManagementService.updateTrainer(argTrainerPojo).getTrainerName());
		
	}
	
	@Test
	public void testRemoveTrainer() {
		
		TrainerPojo argTrainerPojo = new TrainerPojo();
		Optional<TrainerEntity> rtntrainerEntity = Optional.empty();
		
		argTrainerPojo.setTrainerId(500);
		
		Mockito.when(iTrainerManagementRepository.findById(Mockito.anyInt())).thenReturn(rtntrainerEntity);
		
		Exception exception = assertThrows(TrainerNotFoundException.class, () -> iTrainerManagementService.removeTrainer(argTrainerPojo));
		
		assertEquals("Trainer Not Found to Delete!!",exception.getMessage());
		
	}
	
	@Test
	public void testViewAllTrainers() {
		
		TrainerEntity trainerEntity = new TrainerEntity();
		List<TrainerEntity> trainerEntityList = new ArrayList<TrainerEntity>();
		
		trainerEntity.setTrainerId(500);
		trainerEntity.setTrainerName("John");
		
		trainerEntityList.add(trainerEntity);
		
		Mockito.when(iTrainerManagementRepository.findAll()).thenReturn(trainerEntityList);
		
		assertEquals(false,iTrainerManagementService.viewAllTrainers().isEmpty());
		
	}
	

}
