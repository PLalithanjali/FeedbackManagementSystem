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

import com.feedbackmanagement.pojo.CoursePojo;
import com.feedbackmanagement.pojo.CoursePojo;
import com.feedbackmanagement.service.ICourseService;

@CrossOrigin
@RestController
@RequestMapping("/admin/course")
public class CourseController {
	
	@Autowired
	ICourseService iCourseService;
	
	@PostMapping("/add-course")
	public CoursePojo addCourse(@Validated @RequestBody CoursePojo course) {		
		return iCourseService.addCourse(course);
	}
	
	@PutMapping("/update-course")
	public CoursePojo updateCourse(@Validated @RequestBody CoursePojo course) {
		return iCourseService.updateCourse(course);
	}
	
	@DeleteMapping("/delete-course/{id}")
	public CoursePojo removeCourse(@PathVariable("id") int courseId) {
		CoursePojo course = new CoursePojo();
		course.setCourseId(courseId);
		return iCourseService.removeCourse(course);
	}
	
	@GetMapping("/all-courses")
	public List<CoursePojo> viewAllCourses() {
		return iCourseService.viewAllCourses();
	}
	
	@GetMapping("/view-course")
	public CoursePojo viewCourse(@RequestBody CoursePojo course) {
		return iCourseService.viewCourse(course);
	}

}
