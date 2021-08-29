package com.infy.dto;

import java.time.LocalDate;

public class TrainingDetailsDTO {

	private Integer EmpId;
	private String courseCode;
	private String courseName;
	private Integer score;
	private Double hourSpend;
	private LocalDate dateOfComplition;
	private String status;

	public Integer getEmpId() {
		return EmpId;
	}

	public void setEmpId(Integer empId) {
		EmpId = empId;
	}

	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public Double getHourSpend() {
		return hourSpend;
	}

	public void setHourSpend(Double hourSpend) {
		this.hourSpend = hourSpend;
	}

	public LocalDate getDateOfComplition() {
		return dateOfComplition;
	}

	public void setDateOfComplition(LocalDate dateOfComplition) {
		this.dateOfComplition = dateOfComplition;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "TrainingDetailsDTO [EmpId=" + EmpId + ", courseCode=" + courseCode + ", courseName=" + courseName
				+ ", score=" + score + ", hourSpend=" + hourSpend + ", dateOfComplition=" + dateOfComplition
				+ ", status=" + status + "]";
	}

}
