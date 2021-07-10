package com.feedbackmanagement;



import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.feedbackmanagement.entity.FeedbackEntity;
import com.feedbackmanagement.entity.TrainerEntity;
import com.feedbackmanagement.pojo.FeedbackPojo;
import com.feedbackmanagement.repository.IFeedbackRepository;
import com.feedbackmanagement.service.IFeedbackService;
import com.feedbackmanagement.service.IFeedbackServiceImpl;

@SpringBootTest
public class FeedbackServiceTest {

	@InjectMocks
	IFeedbackService ifeedbackService = new IFeedbackServiceImpl();

	@Mock
	IFeedbackRepository ifeedbackRepository;
	
	@Test
	public void testUpdateFeedback() {
		
		FeedbackPojo argFeedbackPojo = new FeedbackPojo();
		FeedbackEntity feedbackEntity = new FeedbackEntity();
		Optional<FeedbackEntity> rtnFeedbackEntity = Optional.of(new FeedbackEntity());
		
		argFeedbackPojo.setComments("good");
		
		feedbackEntity.setComments("good Training");
		
		rtnFeedbackEntity.get().setComments("good");

		Mockito.when(ifeedbackRepository.findById(Mockito.anyInt())).thenReturn(rtnFeedbackEntity);
		
		Mockito.when(ifeedbackRepository.save(Mockito.any(FeedbackEntity.class))).thenReturn(feedbackEntity);
		
		assertEquals("good Training",ifeedbackService.updateFeedback(argFeedbackPojo).getComments());
		
	}
	
	
	@Test
	public void testViewTrainerFeedback() {
		
		int trainerId = 500;
		FeedbackEntity feedbackEntity = new FeedbackEntity();
		List<FeedbackEntity> feedbackEntityList = new ArrayList<FeedbackEntity>();
	
		feedbackEntity.setComments("good");
		
		feedbackEntityList.add(feedbackEntity);

		Mockito.when(ifeedbackRepository.findAllByTrainerId(Mockito.anyInt())).thenReturn(feedbackEntityList);
		
		assertEquals(false,ifeedbackService.viewTrainerFeedback(trainerId).isEmpty());
		
	}
	
	@Test
	public void testViewProgramFeedback() {
		
		int programId = 500;
		FeedbackEntity feedbackEntity = new FeedbackEntity();
		List<FeedbackEntity> feedbackEntityList = new ArrayList<FeedbackEntity>();
	
		feedbackEntity.setComments("good");
		
		feedbackEntityList.add(feedbackEntity);

		Mockito.when(ifeedbackRepository.findAllByProgramId(Mockito.anyInt())).thenReturn(feedbackEntityList);
		
		assertEquals(false,ifeedbackService.viewProgramFeedback(programId).isEmpty());
		

	}

}
