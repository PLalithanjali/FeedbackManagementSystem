package com.feedbackmanagement.pojo;

import javax.validation.constraints.NotNull;

public class FeedbackPojo {
	
	@NotNull(message = "Feedback Id cannot be null")
	private int feedbackId;
	@NotNull(message = "Employee cannot be null")
	private EmployeePojo employee;
	@NotNull(message = "Program cannot be null")
	private ProgramPojo program;
	private int feedbackCriteria1;
	private int feedbackCriteria2;
	private int feedbackCriteria3;
	private int feedbackCriteria4;
	private int feedbackCriteria5;
	private String comments;
	private String suggestions;

	public FeedbackPojo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FeedbackPojo(int feedbackId, EmployeePojo employee, ProgramPojo program, int feedbackCriteria1,
			int feedbackCriteria2, int feedbackCriteria3, int feedbackCriteria4, int feedbackCriteria5, String comments,
			String suggestions) {
		super();
		this.feedbackId = feedbackId;
		this.employee = employee;
		this.program = program;
		this.feedbackCriteria1 = feedbackCriteria1;
		this.feedbackCriteria2 = feedbackCriteria2;
		this.feedbackCriteria3 = feedbackCriteria3;
		this.feedbackCriteria4 = feedbackCriteria4;
		this.feedbackCriteria5 = feedbackCriteria5;
		this.comments = comments;
		this.suggestions = suggestions;
	}

	public int getFeedbackId() {
		return feedbackId;
	}

	public void setFeedbackId(int feedbackId) {
		this.feedbackId = feedbackId;
	}

	public EmployeePojo getEmployee() {
		return employee;
	}

	public void setEmployee(EmployeePojo employee) {
		this.employee = employee;
	}

	public ProgramPojo getProgram() {
		return program;
	}

	public void setProgram(ProgramPojo program) {
		this.program = program;
	}

	public int getFeedbackCriteria1() {
		return feedbackCriteria1;
	}

	public void setFeedbackCriteria1(int feedbackCriteria1) {
		this.feedbackCriteria1 = feedbackCriteria1;
	}

	public int getFeedbackCriteria2() {
		return feedbackCriteria2;
	}

	public void setFeedbackCriteria2(int feedbackCriteria2) {
		this.feedbackCriteria2 = feedbackCriteria2;
	}

	public int getFeedbackCriteria3() {
		return feedbackCriteria3;
	}

	public void setFeedbackCriteria3(int feedbackCriteria3) {
		this.feedbackCriteria3 = feedbackCriteria3;
	}

	public int getFeedbackCriteria4() {
		return feedbackCriteria4;
	}

	public void setFeedbackCriteria4(int feedbackCriteria4) {
		this.feedbackCriteria4 = feedbackCriteria4;
	}

	public int getFeedbackCriteria5() {
		return feedbackCriteria5;
	}

	public void setFeedbackCriteria5(int feedbackCriteria5) {
		this.feedbackCriteria5 = feedbackCriteria5;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getSuggestions() {
		return suggestions;
	}

	public void setSuggestions(String suggestions) {
		this.suggestions = suggestions;
	}

	@Override
	public String toString() {
		return "FeedbackPojo [feedbackId=" + feedbackId + ", employeeId=" + employee + ", programId="
				+ program + ", feedbackCriteria1=" + feedbackCriteria1 + ", feedbackCriteria2=" + feedbackCriteria2
				+ ", feedbackCriteria3=" + feedbackCriteria3 + ", feedbackCriteria4=" + feedbackCriteria4
				+ ", feedbackCriteria5=" + feedbackCriteria5 + ", comments=" + comments + ", suggestions=" + suggestions
				+ "]";
	}
}
