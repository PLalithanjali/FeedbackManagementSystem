package com.feedbackmanagement.entity;

import java.io.Serializable;

import com.feedbackmanagement.pojo.EmployeePojo;

public class JwtResponse implements Serializable {

	private static final long serialVersionUID = -8091879091924046844L;
	private final String jwttoken;
	private EmployeePojo user;
	
	public JwtResponse(String jwttoken, EmployeePojo user) {
		super();
		this.jwttoken = jwttoken;
		this.user = user;
	}
	
	public JwtResponse() {
		super();
		this.jwttoken = "";
		
		// TODO Auto-generated constructor stub
	}




	public String getToken() {
		return this.jwttoken;
	}


	public EmployeePojo getUser() {
		return user;
	}


	public void setUser(EmployeePojo user) {
		this.user = user;
	}


	public String getJwttoken() {
		return jwttoken;
	}
	
	
}
