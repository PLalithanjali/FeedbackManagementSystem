package com.feedbackmanagement.exception;

public class SkillSetNotFoundException extends RuntimeException{
	
	String msg;

	public SkillSetNotFoundException(String msg) {
		super();
		this.msg = msg;
	}

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return super.getMessage();
	}

}
