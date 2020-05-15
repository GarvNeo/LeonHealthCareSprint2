package com.capg.leonhealthcare.entity;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="diagnostic_center_f")
public class DiagnosticCenter {

	@Id
	@Column(name="center_id")
	private String centerId;
	@Column(name="center_name")
	private String centerName;
	@Column(name="contact_no")
	private BigInteger contactNo;
	private String address;
	/*private List<Test> listOfTests;
	private List<Appointment> appointmentList;
	*/
	
	public BigInteger getContactNo() {
		return contactNo;
	}
	public void setContactNo(BigInteger contactNo) {
		this.contactNo = contactNo;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCenterId() {
		return centerId;
	}
	public void setCenterId(String centerId) {
		this.centerId = centerId;
	}
	public String getCenterName() {
		return centerName;
	}
	public void setCenterName(String centerName) {
		this.centerName = centerName;
	}
	
}
