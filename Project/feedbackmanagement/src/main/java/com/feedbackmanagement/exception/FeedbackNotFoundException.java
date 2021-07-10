package com.feedbackmanagement.exception;

public class FeedbackNotFoundException extends RuntimeException{
	
	String msg;

	public FeedbackNotFoundException(String msg) {
		super();
		this.msg = msg;
	}

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return msg;
	}
	
	

}
