package com.feedbackmanagement.exception;

public class TrainerNotFoundException extends RuntimeException {

	String msg;

	public TrainerNotFoundException(String msg) {
		super();
		this.msg = msg;
	}

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return msg;
	}
	
}
