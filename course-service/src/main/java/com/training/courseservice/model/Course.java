package com.training.courseservice.model;

import javax.persistence.Column;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//@Data
//@NoArgsConstructor
//@AllArgsConstructor
@Entity
//@Table(name="STUD")
public class Course {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO) //Sequence ID automatically
	private long courseId;
	private String courseName;
	private int creditNo;
	
	@Column(name="stud_grade")
	private String grade;

	public Course(String courseName, int creditNo, String grade) {
		//super();
//		this.courseId = courseId;
		this.courseName = courseName;
		this.creditNo = creditNo;
		this.grade = grade;
	}

	public long getCourseId() {
		return courseId;
	}

	public void setCourseId(long courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public int getCreditNo() {
		return creditNo;
	}

	public void setCreditNo(int creditNo) {
		this.creditNo = creditNo;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}
	
}