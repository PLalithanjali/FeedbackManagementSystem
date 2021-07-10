package com.feedbackmanagement.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.feedbackmanagement.entity.TrainerEntity;
import com.feedbackmanagement.exception.FeedbackNotFoundException;
import com.feedbackmanagement.exception.TrainerNotFoundException;
import com.feedbackmanagement.pojo.TrainerPojo;
import com.feedbackmanagement.repository.ITrainerManagementRepository;

@Service
public class ITrainerManagementServiceImpl implements ITrainerManagementService{

	@Autowired
    ITrainerManagementRepository iTrainerManagementRepository;
    
    TrainerEntity trainerEntity = new TrainerEntity();

    @Override
    public TrainerPojo addTrainer(TrainerPojo trainer) {
        BeanUtils.copyProperties(trainer, trainerEntity);
        trainerEntity = iTrainerManagementRepository.save(trainerEntity);
        BeanUtils.copyProperties(trainerEntity,trainer);
        return trainer;
    }

    @Override
    public TrainerPojo updateTrainer(TrainerPojo trainer) {
        BeanUtils.copyProperties(trainer, trainerEntity);
        Optional<TrainerEntity> result = iTrainerManagementRepository.findById(trainerEntity.getTrainerId());
        if(result.isEmpty()) {
        	throw new TrainerNotFoundException("Trainer Not Found to Update!!");
        }
        else {
        	result.get().setTrainerName(trainerEntity.getTrainerName());
        	trainerEntity = iTrainerManagementRepository.save(result.get());
        	BeanUtils.copyProperties(trainerEntity,trainer);
            return trainer; 
        }    
    }
    
    @Override
    public TrainerPojo removeTrainer(TrainerPojo trainer) {
    	BeanUtils.copyProperties(trainer, trainerEntity);
		Optional<TrainerEntity> result = iTrainerManagementRepository.findById(trainerEntity.getTrainerId());
		if(result.isEmpty()) {
			throw new TrainerNotFoundException("Trainer Not Found to Delete!!");
		}
		else {
			iTrainerManagementRepository.deleteById(result.get().getTrainerId());
			BeanUtils.copyProperties(trainerEntity,trainer);
			return trainer;
		}
    } 

    @Override
    public List<TrainerPojo> viewAllTrainers() {
        List<TrainerPojo> trainerPojoList = (ArrayList<TrainerPojo>)(ArrayList<?>) (iTrainerManagementRepository.findAll());
        return trainerPojoList;
	}

}
