package com.feedbackmanagement.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.feedbackmanagement.entity.FeedbackEntity;
import com.feedbackmanagement.exception.FeedbackNotFoundException;
import com.feedbackmanagement.pojo.FeedbackPojo;
import com.feedbackmanagement.repository.IFeedbackRepository;

@Service
public class IFeedbackServiceImpl implements IFeedbackService {

	@Autowired
	IFeedbackRepository iFeedbackRepository;
	
	FeedbackEntity feedbackEntity = new FeedbackEntity();

	@Override
	public FeedbackPojo addFeedback(FeedbackPojo feedback) {
		// TODO Auto-generated method stub
		BeanUtils.copyProperties(feedback, feedbackEntity);
		feedbackEntity = iFeedbackRepository.save(feedbackEntity);
		BeanUtils.copyProperties(feedbackEntity, feedback);
		return feedback;

	}

	@Override
	public FeedbackPojo updateFeedback(FeedbackPojo feedback) {
		// TODO Auto-generated method stub
		BeanUtils.copyProperties(feedback, feedbackEntity);

		Optional<FeedbackEntity> result = iFeedbackRepository.findById(feedbackEntity.getFeedbackId());

		if (result.isEmpty()) {
			throw new FeedbackNotFoundException("Feedback Not Found to Update");
		}
		else {
			result.get().setFeedbackCriteria1(feedbackEntity.getFeedbackCriteria1());
			result.get().setFeedbackCriteria2(feedbackEntity.getFeedbackCriteria2());
			result.get().setFeedbackCriteria3(feedbackEntity.getFeedbackCriteria3());
			result.get().setFeedbackCriteria4(feedbackEntity.getFeedbackCriteria4());
			result.get().setFeedbackCriteria5(feedbackEntity.getFeedbackCriteria5());
			result.get().setComments(feedbackEntity.getComments());
			result.get().setSuggestions(feedbackEntity.getSuggestions());
			feedbackEntity = iFeedbackRepository.save(result.get());
			BeanUtils.copyProperties(feedbackEntity, feedback);

			return feedback;
		}
	}

	@Override
	public List<FeedbackPojo> viewTrainerFeedback(int trainerId) {
		// TODO Auto-generated method stub
		List<FeedbackPojo> feedbackPojoList = (ArrayList<FeedbackPojo>) (ArrayList<?>) (iFeedbackRepository
				.findAllByTrainerId(trainerId));
		if(feedbackPojoList.isEmpty()) {
			throw new FeedbackNotFoundException("Feedback Not Found for this Trainer");
		}
		return feedbackPojoList;

	}

	@Override
	public List<FeedbackPojo> viewProgramFeedback(int programId) {
		// TODO Auto-generated method stub
		List<FeedbackPojo> feedbackPojoList = (ArrayList<FeedbackPojo>) (ArrayList<?>) (iFeedbackRepository
				.findAllByProgramId(programId));
		if(feedbackPojoList.isEmpty()) {
			throw new FeedbackNotFoundException("Feedback Not Found for this Program");
		}
		return feedbackPojoList;
	}
	
	@Override
	public List<FeedbackPojo> findAllDefaultersReport() {
		// TODO Auto-generated method stub
		List<FeedbackPojo> feedbackPojoList = (ArrayList<FeedbackPojo>) (ArrayList<?>) (iFeedbackRepository
				.findAllDefaultersReport());
		if(feedbackPojoList.isEmpty()) {
			throw new FeedbackNotFoundException("Feedback Defaulters Report Not Found");
		}
		return feedbackPojoList;
	}

}
