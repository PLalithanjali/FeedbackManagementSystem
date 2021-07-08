package com.feedbackmanagement.exception;

public class ParticipantNotFoundException extends RuntimeException {
	
	String msg;

	public ParticipantNotFoundException(String msg) {
		super();
		this.msg = msg;
	}

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return msg;
	}
	
	
}
