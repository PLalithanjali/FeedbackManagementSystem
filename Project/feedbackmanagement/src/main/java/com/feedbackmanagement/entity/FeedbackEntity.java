package com.feedbackmanagement.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "feedback")
public class FeedbackEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "feedback_id")
	private int feedbackId;
	
	@ManyToOne
	@JoinColumn(name = "participant_id")
	private EmployeeEntity employee;
	
	@ManyToOne
	@JoinColumn(name = "program_id")
	private ProgramEntity program;

	@Column(name = "feedbackcriteria1")
	private int feedbackCriteria1;
	
	@Column(name = "feedbackcriteria2")
	private int feedbackCriteria2;
	
	@Column(name = "feedbackcriteria3")
	private int feedbackCriteria3;
	
	@Column(name = "feedbackcriteria4")
	private int feedbackCriteria4;
	
	@Column(name = "feedbackcriteria5")
	private int feedbackCriteria5;
	
	@Column(name = "comments")
	private String comments;
	
	@Column(name = "suggestions")
	private String suggestions;

	public FeedbackEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getFeedbackId() {
		return feedbackId;
	}

	public void setFeedbackId(int feedbackId) {
		this.feedbackId = feedbackId;
	}

	public EmployeeEntity getEmployee() {
		return employee;
	}

	public void setEmployee(EmployeeEntity employee) {
		this.employee = employee;
	}

	public ProgramEntity getProgram() {
		return program;
	}

	public void setProgram(ProgramEntity program) {
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

	public FeedbackEntity(int feedbackId, EmployeeEntity employee, ProgramEntity program, int feedbackCriteria1,
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

	@Override
	public String toString() {
		return "FeedbackEntity [feedbackId=" + feedbackId + ", employee=" + employee + ", program=" + program
				+ ", feedbackCriteria1=" + feedbackCriteria1 + ", feedbackCriteria2=" + feedbackCriteria2
				+ ", feedbackCriteria3=" + feedbackCriteria3 + ", feedbackCriteria4=" + feedbackCriteria4
				+ ", feedbackCriteria5=" + feedbackCriteria5 + ", comments=" + comments + ", suggestions=" + suggestions
				+ "]";
	}

	
	
}
