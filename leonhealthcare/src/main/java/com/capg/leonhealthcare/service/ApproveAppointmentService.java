package com.capg.leonhealthcare.service;

import java.math.BigInteger;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.leonhealthcare.dao.IApproveAppointmentDAO;
import com.capg.leonhealthcare.entity.Appointment;
import com.capg.leonhealthcare.entity.DiagnosticCenter;
import com.capg.leonhealthcare.entity.Test;
import com.capg.leonhealthcare.entity.User;



@Service
public class ApproveAppointmentService implements IApproveAppointmentService{

	@Autowired
	IApproveAppointmentDAO appointmentDAO;


	@Override
	public List<Appointment> getApprovedAppointmentList() {
		String status="approved";
		return appointmentDAO.getApprovedAppointmentList(status);
	}
	
	@Override
	public List<Appointment> getRejectedAppointmentList() {
		String status="rejected";
		return appointmentDAO.getRejectedAppointmentList(status);
	}
	
	@Override
	public List<Appointment> getPendingAppointmentList() {
		String status = "pending";
		return appointmentDAO.getPendingAppointmentList(status);
	}

	

	@Override
	public void approveAppointment(String appId) {
		appointmentDAO.approveAppointment(appId);
		
	}
	@Override
	public void disApproveAppointment(String appId) {
		appointmentDAO.disApproveAppointment(appId);
	}

	

	@SuppressWarnings("rawtypes")
	@Override
	public List join(){
		return appointmentDAO.join();

	}
	
	@SuppressWarnings("rawtypes")
	@Override
	public List getAppointmentDetails(BigInteger id){
		return appointmentDAO.getAppointmentDetails(id);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List getAppointmentDetailsByUserId(String id){
		return appointmentDAO.getAppointmentDetailsByUserId(id);
	}
	

	@Override
	public List<Appointment> getAppointment() {
		return appointmentDAO.getAppointment();	
	}
	
	@Override
	public List<Appointment> getAppointmentById(BigInteger id) {
		return appointmentDAO.getAppointmentById(id);
	}


	@Override
	public List<User> findUsersWithGmailAddress(){
		return appointmentDAO.findUsersWithGmailAddress();
	}
	@Override
    public List<User> getUser() {
        return appointmentDAO.getUser();
    }
	@Override
	public List<User> getUserById(String id) {
		return appointmentDAO.getUserById(id);
	}


	@Override
	public List<Test> getTestById(String id) {
		return appointmentDAO.getTestById(id);
	}
	@Override
	public List<Test> getTest() {
		return appointmentDAO.getTest();
	}


	@Override
	public List<DiagnosticCenter> getDiagnosticCenter() {
		return appointmentDAO.getDiagnosticCenter();
	}
	@Override
	public List<DiagnosticCenter> getDiagnosticCenterById(String id) {
		return appointmentDAO.getDiagnosticCenterById(id);
	}

}
