package com.feedbackmanagement.pojo;

import javax.validation.constraints.NotNull;

public class EmployeePojo {
	
	@NotNull(message = "Employee Id cannot be null")
	private int employeeId;
	
	@NotNull(message = "Employee Name cannot be null")
	private String employeeName;
	
	@NotNull(message = "Employee Password cannot be null")
	private String employeePassword;
	
	@NotNull(message = "Employee Role cannot be null")
	private String employeeRole;

	public EmployeePojo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EmployeePojo(int employeeId, String employeeName, String employeePassword, String employeeRole) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.employeePassword = employeePassword;
		this.employeeRole = employeeRole;
	}

	public EmployeePojo(String username, String password) {
		// TODO Auto-generated constructor stub
		this.employeeName = username;
		this.employeePassword = username;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmployeePassword() {
		return employeePassword;
	}

	public void setEmployeePassword(String employeePassword) {
		this.employeePassword = employeePassword;
	}

	public String getEmployeeRole() {
		return employeeRole;
	}

	public void setEmployeeRole(String employeeRole) {
		this.employeeRole = employeeRole;
	}

	@Override
	public String toString() {
		return "EmployeePojo [employeeId=" + employeeId + ", employeeName=" + employeeName + ", employeePassword="
				+ employeePassword + ", employeeRole=" + employeeRole + "]";
	}
	
}
