package com.capg.leonhealthcare.entity;

import java.math.BigInteger;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="appointment_f")
public class Appointment {

	@Id
	@GeneratedValue
	@Column(name="appointment_id")
	private BigInteger appointmentId;
	@Column(name="user_id")
	private String userId;
	@Column(name="date_time")
	private Timestamp dateTime;
	@Column(name="test_id")
	private String testId;
	@Column(name="center_id")
	private String centerId;
	@Column(columnDefinition = "varchar(255) default 'pending'")
	private String status;
	
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
	
	public BigInteger getAppointmentId() {
		return appointmentId;
	}
	public String getTestId() {
		return testId;
	}
	public void setTestId(String testId) {
		this.testId = testId;
	}
	
	public void setAppointmentId(BigInteger appointmentId) {
		this.appointmentId = appointmentId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCenterId() {
		return centerId;
	}
	public void setCenterId(String centerId) {
		this.centerId = centerId;
	}
	
}
