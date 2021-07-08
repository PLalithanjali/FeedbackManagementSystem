package com.feedbackmanagement.pojo;
import javax.validation.constraints.NotNull;

public class CoursePojo {
	
	private int courseId;
	
	@NotNull(message = "Course Name cannot be null")
	private String courseName;
	
	@NotNull(message = "Course Description cannot be null")
	private String courseDescription;
	
	@NotNull(message = "Course Period cannot be null")
	private int noOfDays;
	
	@NotNull(message = "Course removed cannot be null")
	private int removed;

	public CoursePojo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CoursePojo(int courseId, String courseName, String courseDescription, int noOfDays, int removed) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.courseDescription = courseDescription;
		this.noOfDays = noOfDays;
		this.removed = removed;
	}
	
	

	public CoursePojo(@NotNull(message = "Course Name cannot be null") String courseName,
			@NotNull(message = "Course Description cannot be null") String courseDescription,
			@NotNull(message = "Course Period cannot be null") int noOfDays,
			@NotNull(message = "Course removed cannot be null") int removed) {
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
		return "CoursePojo [courseId=" + courseId + ", courseName=" + courseName + ", courseDescription="
				+ courseDescription + ", noOfDays=" + noOfDays + ", removed=" + removed + "]";
	}
	
}
