package com.feedbackmanagement.exception;

public class ProgramNotFoundException extends RuntimeException {
	
	String msg;

	public ProgramNotFoundException(String msg) {
		super();
		this.msg = msg;
	}

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return super.getMessage();
	}

}
