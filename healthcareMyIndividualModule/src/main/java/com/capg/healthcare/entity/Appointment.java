package com.capg.healthcare.entity;

import java.math.BigInteger;
import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Appointment {

	@Id
	@GeneratedValue
	private BigInteger appointmentId;
	
	private String userId;
	private Timestamp dateTime;
	private String testId;
	private String centerId;
	@Column(columnDefinition = "varchar(255) default 'pending'")
	private String status;
	
	public BigInteger getAppointmentId() {
		return appointmentId;
	}
	public void setAppointmentId(BigInteger appointmentId) {
		this.appointmentId = appointmentId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Timestamp getDateTime() {
		return dateTime;
	}
	public void setDateTime(Timestamp dateTime) {
		this.dateTime = dateTime;
	}
	public String getTestId() {
		return testId;
	}
	public void setTestId(String testId) {
		this.testId = testId;
	}
	public String getCenterId() {
		return centerId;
	}
	public void setCenterId(String centerId) {
		this.centerId = centerId;
	}

	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public Appointment() {}
	
	public Appointment(String userId, Timestamp dateTime, String testId, String centerId,
			String status) {
		super();
		this.userId = userId;
		this.dateTime = dateTime;
		this.testId = testId;
		this.centerId = centerId;
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "Appointment [appointmentId=" + appointmentId + ", userId=" + userId + ", dateTime=" + dateTime
				+ ", testId=" + testId + ", centerId=" + centerId + ", status=" + status + "]";
	}
	
}
