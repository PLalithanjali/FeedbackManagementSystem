package com.feedbackmanagement.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.feedbackmanagement.entity.CourseEntity;
import com.feedbackmanagement.exception.CourseNotFoundException;
import com.feedbackmanagement.pojo.CoursePojo;
import com.feedbackmanagement.repository.ICourseRepository;

@Service
public class ICourseServiceImpl implements ICourseService{
	
	@Autowired
	ICourseRepository iCourseRepository;
	
	CourseEntity courseEntity = new CourseEntity();

	@Override
	public CoursePojo addCourse(CoursePojo course) {
		// TODO Auto-generated method stub
		BeanUtils.copyProperties(course, courseEntity);
		courseEntity = iCourseRepository.save(courseEntity);
		BeanUtils.copyProperties(courseEntity,course);
		return course;
	}

	@Override
	public CoursePojo updateCourse(CoursePojo course) {
		// TODO Auto-generated method stub
		BeanUtils.copyProperties(course, courseEntity);
		Optional<CourseEntity> result = iCourseRepository.findById(courseEntity.getCourseId());
		if(result.isEmpty()) {
			throw new CourseNotFoundException("Course Not Found to Update!!");
		}
		else {
			result.get().setCourseName(courseEntity.getCourseName());
			result.get().setCourseDescription(courseEntity.getCourseDescription());
			result.get().setNoOfDays(courseEntity.getNoOfDays());
			result.get().setRemoved(courseEntity.getRemoved());
			iCourseRepository.save(result.get());
			BeanUtils.copyProperties(result.get(),course);
			return course;
		}
	}

	@Override
	public CoursePojo removeCourse(CoursePojo course) {
		// TODO Auto-generated method stub
		BeanUtils.copyProperties(course, courseEntity);
		Optional<CourseEntity> result = iCourseRepository.findById(courseEntity.getCourseId());
		if(result.isEmpty()) {
			throw new CourseNotFoundException("Course Not Found To Delete!!");
		}
		else {
			result.get().setRemoved(1);
			iCourseRepository.save(result.get());
			BeanUtils.copyProperties(result.get(),course);
			return course;
		}
	}

	@Override
	public CoursePojo viewCourse(CoursePojo course) {
		// TODO Auto-generated method stub
		BeanUtils.copyProperties(course, courseEntity);
		Optional<CourseEntity> result = iCourseRepository.findById(courseEntity.getCourseId());
		if(result.isEmpty()) {
			throw new CourseNotFoundException("Course Not found!!");
		}
		else {
			BeanUtils.copyProperties(result.get(),course);
			return course;
		}
	}

	@Override
	public List<CoursePojo> viewAllCourses() {
		// TODO Auto-generated method stub
		List<CoursePojo> employeePojoList = (ArrayList<CoursePojo>)(ArrayList<?>) (iCourseRepository.findAll());
		return employeePojoList;
	}

}
