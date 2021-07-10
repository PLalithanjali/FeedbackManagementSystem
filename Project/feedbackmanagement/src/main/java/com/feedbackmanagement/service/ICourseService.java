package com.feedbackmanagement.service;

import java.util.List;

import com.feedbackmanagement.pojo.CoursePojo;

public interface ICourseService {
	
	public CoursePojo addCourse(CoursePojo course);

	public CoursePojo updateCourse(CoursePojo course);

	public CoursePojo removeCourse(CoursePojo course);

	public CoursePojo viewCourse(CoursePojo course);

	public List<CoursePojo> viewAllCourses();
}
