package com.feedbackmanagement;



import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.feedbackmanagement.entity.EmployeeEntity;
import com.feedbackmanagement.pojo.EmployeePojo;
import com.feedbackmanagement.repository.IParticipantRepository;
import com.feedbackmanagement.service.IParticipantService;
import com.feedbackmanagement.service.IParticipantServiceImpl;

@SpringBootTest
public class ParticipantServiceTest {
	
	@Mock
	IParticipantRepository iParticipantRepository;
	
	@InjectMocks
	IParticipantService iPartcipantService = new IParticipantServiceImpl();

	@Test
	public void testViewParticipantList() {
		
		int courseId = 500;
		EmployeeEntity employeeEntity = new EmployeeEntity();
		List<EmployeeEntity> employeeEntityList = new ArrayList<EmployeeEntity>();
		
		employeeEntity.setEmployeeId(500);
		
		employeeEntityList.add(employeeEntity);
		
		Mockito.when(iParticipantRepository.findAllByCourseId(courseId)).thenReturn(employeeEntityList);
		
		assertEquals(false,iPartcipantService.viewParticipantList(courseId).isEmpty());
		
		
	}
}
