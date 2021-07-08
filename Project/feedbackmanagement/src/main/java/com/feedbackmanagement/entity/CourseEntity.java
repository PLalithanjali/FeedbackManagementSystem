package com.feedbackmanagement.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.lang.NonNull;

import com.sun.istack.NotNull;

@Entity
@Table(name = "course")
public class CourseEntity {
	
	@Id
	@Column(name = "course_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int courseId;
	
	@Column(name = "course_name")
	private String courseName;
	
	@Column(name = "course_desc")
	private String courseDescription;
	
	@Column(name = "noofdays")
	private int noOfDays;
	
	@Column(name = "removed")
	private int removed;
	
	@OneToMany(mappedBy = "course")
	 private List<ProgramEntity> programs = new ArrayList<ProgramEntity>();


	public CourseEntity() {
		super();
		// TODO Auto-generated constructor stub
	}



	public CourseEntity(int courseId, String courseName, String courseDescription, int noOfDays, int removed) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.courseDescription = courseDescription;
		this.noOfDays = noOfDays;
		this.removed = removed;
	}
	



	public CourseEntity(String courseName, String courseDescription, int noOfDays, int removed) {
		super();
		this.courseName = courseName;
		this.courseDescription = courseDescription;
		this.noOfDays = noOfDays;
		this.removed = removed;
	}



	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCourseDescription() {
		return courseDescription;
	}

	public void setCourseDescription(String courseDescription) {
		this.courseDescription = courseDescription;
	}

	public int getNoOfDays() {
		return noOfDays;
	}

	public void setNoOfDays(int noOfDays) {
		this.noOfDays = noOfDays;
	}

	public int getRemoved() {
		return removed;
	}

	public void setRemoved(int removed) {
		this.removed = removed;
	}

	@Override
	public String toString() {
		return "CourseEntity [courseId=" + courseId + ", courseName=" + courseName + ", courseDescription="
				+ courseDescription + ", noOfDays=" + noOfDays + ", removed=" + removed + "]";
	}
	
		
}
