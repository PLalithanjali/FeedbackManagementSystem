package com.feedbackmanagement.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "program")
public class ProgramEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "program_id")
	private int programId;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "startdate")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date startDate;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "enddate")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date endDate;
	
	@ManyToOne
	@JoinColumn(name = "course_id")
	private CourseEntity course;
	
	
	@ManyToOne
	@JoinColumn(name = "faculty")
	private TrainerEntity trainer;
	

	@Column(name = "removed")
	private int removed;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "feedback", joinColumns = { @JoinColumn(name = "program_id") }, inverseJoinColumns = { @JoinColumn(name = "participant_id") })
	private List<EmployeeEntity> employees = new ArrayList<EmployeeEntity>();
	

	public ProgramEntity() {
		super();
		// TODO Auto-generated constructor stub
	}


	public ProgramEntity(int programId, Date startDate, Date endDate, CourseEntity course, TrainerEntity trainer,
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


	public CourseEntity getCourse() {
		return course;
	}


	public void setCourse(CourseEntity course) {
		this.course = course;
	}


	public TrainerEntity getTrainer() {
		return trainer;
	}


	public void setTrainer(TrainerEntity trainer) {
		this.trainer = trainer;
	}


	public int getRemoved() {
		return removed;
	}


	public void setRemoved(int removed) {
		this.removed = removed;
	}


	public List<EmployeeEntity> getEmployees() {
		return employees;
	}


	public void setEmployees(List<EmployeeEntity> employees) {
		this.employees = employees;
	}


	@Override
	public String toString() {
		return "ProgramEntity [programId=" + programId + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", course=" + course + ", trainer=" + trainer + ", removed=" + removed + ", employees=" + employees
				+ "]";
	}
	
	
}
