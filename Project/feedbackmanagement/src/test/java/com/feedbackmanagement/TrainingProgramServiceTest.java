package com.feedbackmanagement;




import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.feedbackmanagement.entity.ProgramEntity;
import com.feedbackmanagement.entity.TrainerEntity;
import com.feedbackmanagement.exception.CourseNotFoundException;
import com.feedbackmanagement.exception.ProgramNotFoundException;
import com.feedbackmanagement.pojo.ProgramPojo;
import com.feedbackmanagement.repository.ITrainingProgramRepository;
import com.feedbackmanagement.service.ITrainingProgramService;
import com.feedbackmanagement.service.ITrainingProgramServiceImpl;

@SpringBootTest
public class TrainingProgramServiceTest {
	
	@InjectMocks
	ITrainingProgramService iTrainingProgramService = new ITrainingProgramServiceImpl();

	@Mock
	ITrainingProgramRepository iTrainingProgramRepository;
	
	@Test
	public void testViewAllProgram() {
		
		ProgramPojo argprogramPojo = new ProgramPojo();
		ProgramEntity programEntity = new ProgramEntity();
		List<ProgramEntity> programEntityList = new ArrayList<ProgramEntity>();
		
		argprogramPojo.setProgramId(500);
		
		programEntity.setProgramId(500);
		
		programEntityList.add(programEntity);
		
		Mockito.when(iTrainingProgramRepository.findAll()).thenReturn(programEntityList);
		
		assertEquals(false,iTrainingProgramService.viewAllPrograms().isEmpty());
		
	}
	
	
	@Test
	public void testViewAllProgramByFacultyException() {
		
		int trainerId = 500;
		ProgramEntity programEntity = new ProgramEntity();
		List<ProgramEntity> programEntityList = new ArrayList<ProgramEntity>();
		
		programEntity.setProgramId(500);
		
		programEntityList.add(programEntity);
		
		Mockito.when(iTrainingProgramRepository.findAllByFacultyId(Mockito.anyInt())).thenReturn(programEntityList);
		
		assertEquals(false,iTrainingProgramService.viewAllProgramsByFaculty(trainerId).isEmpty());
		
	}
}
