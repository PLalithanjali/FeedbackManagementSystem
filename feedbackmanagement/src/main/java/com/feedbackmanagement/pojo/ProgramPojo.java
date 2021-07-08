package com.feedbackmanagement.pojo;

import java.util.Date;

import javax.validation.constraints.NotNull;

public class ProgramPojo {

	@NotNull(message = "Program Id cannot be null")
	private int programId;
	
	@NotNull(message = "Start Date cannot be null")
	private Date startDate;
	
	@NotNull(message = "End Date cannot be null")
	private Date endDate;
	
	@NotNull(message = "Course cannot be null")
	private CoursePojo course;
	
	@NotNull(message = "Trainer cannot be null")
	private TrainerPojo trainer;
	
	@NotNull(message = "Program Removed cannot be null")
	private int removed;

	public ProgramPojo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProgramPojo(int programId, Date startDate, Date endDate, CoursePojo course, TrainerPojo trainer,
			int removed) {
		super();
		this.programId = programId;
		this.startDate = startDate;
		this.endDate = endDate;
		this.course = course;
		this.trainer = trainer;
		this.removed = removed;
	}

	public int getProgramId() {
		return programId;
	}

	public void setProgramId(int programId) {
		this.programId = programId;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public CoursePojo getCourse() {
		return course;
	}

	public void setCourse(CoursePojo course) {
		this.course = course;
	}

	public TrainerPojo getTrainer() {
		return trainer;
	}

	public void setTrainer(TrainerPojo trainer) {
		this.trainer = trainer;
	}

	public int getRemoved() {
		return removed;
	}

	public void setRemoved(int removed) {
		this.removed = removed;
	}

	@Override
	public String toString() {
		return "ProgramPojo [programId=" + programId + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", courseId=" + course + ", trainer=" + trainer + ", removed=" + removed + "]";
	}

}
