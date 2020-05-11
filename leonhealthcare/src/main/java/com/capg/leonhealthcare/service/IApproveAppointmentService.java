package com.capg.leonhealthcare.service;

import java.math.BigInteger;
import java.util.List;

import com.capg.leonhealthcare.entity.Appointment;
import com.capg.leonhealthcare.entity.DiagnosticCenter;
import com.capg.leonhealthcare.entity.Test;
import com.capg.leonhealthcare.entity.User;

public interface IApproveAppointmentService {

	public List<Appointment> getRejectedAppointmentList();
	public List<Appointment> getPendingAppointmentList();
	public List<Appointment> getApprovedAppointmentList();
	
	@SuppressWarnings("rawtypes")
	public List getAppointmentDetails(BigInteger id);
	
	public List<Appointment> getAppointment();
	public List<Appointment> getAppointmentById(BigInteger id);
	
	public void approveAppointment(String appId);
	public void disApproveAppointment(String appId);
	
	public List<User> getUser();
	public List<User> getUserById(String id);

	public List<User> findUsersWithGmailAddress();
	
	@SuppressWarnings("rawtypes")
	public List join();//allAppointmentdetails
	
	public List<Test> getTestById(String id);
	public List<Test> getTest();
	
	public List<DiagnosticCenter> getDiagnosticCenter();
	public List<DiagnosticCenter> getDiagnosticCenterById(String id);
	@SuppressWarnings("rawtypes")
	List getAppointmentDetailsByUserId(String id);
	
}