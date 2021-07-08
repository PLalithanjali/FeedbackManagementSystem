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
import com.feedbackmanagement.exception.CourseNotFoundException;
import com.feedbackmanagement.pojo.CoursePojo;
import com.feedbackmanagement.repository.ICourseRepository;
import com.feedbackmanagement.service.ICourseService;
import com.feedbackmanagement.service.ICourseServiceImpl;

@SpringBootTest
public class CourseServiceTest {
	
	@InjectMocks
	ICourseServiceImpl iCourseService;
	
	@Mock
	ICourseRepository iCourseRepository;
	
	@Test
	public void testAddCourse() {
		CoursePojo argcoursePojo = new CoursePojo();
		CourseEntity rtncourseEntity = new CourseEntity();
		
		argcoursePojo.setCourseName("Java");
		argcoursePojo.setNoOfDays(20);
	
		rtncourseEntity.setNoOfDays(20);
		rtncourseEntity.setCourseId(500);
		rtncourseEntity.setCourseName("Java");
		
		Mockito.when(iCourseRepository.save(Mockito.any(CourseEntity.class))).thenReturn(rtncourseEntity);
		
		assertEquals(500,iCourseService.addCourse(argcoursePojo).getCourseId());
	}
	
	@Test
	public void testUpdateCourseException() {
		
		CoursePojo argcoursePojo = new CoursePojo();
		Optional<CourseEntity> courseEntity = Optional.empty();
		
		argcoursePojo.setCourseName("Java");
		argcoursePojo.setCourseId(500);
		argcoursePojo.setNoOfDays(20);
		argcoursePojo.setRemoved(0);
		argcoursePojo.setCourseDescription("Java Programming");
		
		Mockito.when(iCourseRepository.findById(Mockito.anyInt())).thenReturn(courseEntity);
		
		Exception exception = assertThrows(CourseNotFoundException.class, () -> iCourseService.updateCourse(argcoursePojo));
		
		assertEquals("Course Not Found to Update!!",exception.getMessage());
		
	}
	
	@Test
	public void testRemoveCourse() {
		CoursePojo argcoursePojo = new CoursePojo();
		CourseEntity rtncourseEntity = new CourseEntity();
		Optional<CourseEntity> courseEntity = Optional.of(new CourseEntity());
		
		argcoursePojo.setCourseName("Java");
		argcoursePojo.setRemoved(0);
		
		rtncourseEntity.setRemoved(0);
		rtncourseEntity.setCourseId(500);
		rtncourseEntity.setCourseName("Java");
		
		courseEntity.get().setCourseName("Java");
		courseEntity.get().setCourseId(500);
		courseEntity.get().setRemoved(0);
		
		
		Mockito.when(iCourseRepository.findById(Mockito.anyInt())).thenReturn(courseEntity);
		
		assertEquals(1,iCourseService.removeCourse(argcoursePojo).getRemoved());
		
		
	}
	
	@Test
	public void testViewCourse() {
		
		CoursePojo argcoursePojo = new CoursePojo();
		Optional<CourseEntity> courseEntity = Optional.of(new CourseEntity());
		
		argcoursePojo.setCourseId(500);
		
		courseEntity.get().setCourseName("Java");
		courseEntity.get().setCourseId(500);
		courseEntity.get().setRemoved(0);
		
		Mockito.when(iCourseRepository.findById(Mockito.anyInt())).thenReturn(courseEntity);
		
		assertEquals("Java",iCourseService.viewCourse(argcoursePojo).getCourseName());
		
	}
	
	
	@Test
	public void testViewAllCourses() {
		
		CoursePojo argcoursePojo = new CoursePojo();
		CourseEntity courseEntity = new CourseEntity();
		List<CourseEntity> courseEntityList = new ArrayList<CourseEntity>();
		
		argcoursePojo.setCourseName("Java");
		
		courseEntity.setCourseName("Java");
		courseEntity.setCourseId(500);
		courseEntity.setRemoved(0);
		
		courseEntityList.add(courseEntity);
		
		Mockito.when(iCourseRepository.findAll()).thenReturn(courseEntityList);
		
		assertEquals(false,iCourseService.viewAllCourses().isEmpty());
		
	}

}
