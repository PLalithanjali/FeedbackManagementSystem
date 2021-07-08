package com.feedbackmanagement.exception;

public class CourseNotFoundException extends RuntimeException {
	
	String msg;

	public CourseNotFoundException(String msg) {
		super();
		this.msg = msg;
	}

	@Override
	public String getMessage() {
		return msg;
		// TODO Auto-generated constructor stub
	}
	
	
	

}
