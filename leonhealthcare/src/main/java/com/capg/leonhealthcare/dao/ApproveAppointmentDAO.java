package com.capg.leonhealthcare.dao;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.capg.leonhealthcare.entity.Appointment;
import com.capg.leonhealthcare.entity.DiagnosticCenter;
import com.capg.leonhealthcare.entity.Test;
import com.capg.leonhealthcare.entity.User;
import com.capg.leonhealthcare.repository.IAppointmentRepository;
import com.capg.leonhealthcare.repository.IDiagnosticCenterRepository;
import com.capg.leonhealthcare.repository.ITestRepository;
import com.capg.leonhealthcare.repository.IUserRepository;

@Configuration
public class ApproveAppointmentDAO implements IApproveAppointmentDAO{

	@Autowired
	IAppointmentRepository appointmentRepository;
	@Autowired
	ITestRepository testRepository;
	@Autowired
	IUserRepository userRepository;
	
	@Autowired
	IDiagnosticCenterRepository diagnosticCenterRepository;
	

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List getApprovedAppointmentList(String status) {
		appointmentRepository.automaticallyReject();
		return appointmentRepository.findAppointmentByStatus(status);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List getRejectedAppointmentList(String status) {
		appointmentRepository.automaticallyReject();
		return appointmentRepository.findAppointmentByStatus(status);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List getPendingAppointmentList(String status) {
		appointmentRepository.automaticallyReject();
		return appointmentRepository.findAppointmentByStatus(status);
	}

	

	@Override
	public int approveAppointment(BigInteger appId) {
		return appointmentRepository.approveAppointment(appId);
		
	}
	@Override
	public void disApproveAppointment(BigInteger appId) {
		appointmentRepository.disapproveAppointment(appId);
	}

	

	@SuppressWarnings("rawtypes")
	@Override
	public List join(){
		appointmentRepository.automaticallyReject();
		return appointmentRepository.joinTable();

	}
	
	@SuppressWarnings("rawtypes")
	@Override
	public List getAppointmentDetails(BigInteger id){
		appointmentRepository.automaticallyReject();
		return appointmentRepository.getAppointmentDetails(id);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List getAppointmentDetailsByUserId(String id){
		appointmentRepository.automaticallyReject();
		return appointmentRepository.getAppointmentDetailsByUserId(id);
	}
	
	
	@Override
	public List<Appointment> getAppointment() {
		appointmentRepository.automaticallyReject();
		return appointmentRepository.findAll();	
	}
	@Override
	public List<Appointment> getAppointmentById(BigInteger id) {
		appointmentRepository.automaticallyReject();
		return appointmentRepository.getAppointmentById(id);
	}


	@Override
	public List<User> findUsersWithGmailAddress(){
		return userRepository.findUsersWithGmailAddress();
	}
	@Override
    public List<User> getUser() {
        return userRepository.findAll();
    }
	@Override
	public List<User> getUserById(String id) {
		return userRepository.getUserById(id);
	}


	@Override
	public List<Test> getTestById(String id) {
		return testRepository.getTestById(id);
	}
	@Override
	public List<Test> getTest() {
		return testRepository.findAll();
	}


	@Override
	public List<DiagnosticCenter> getDiagnosticCenter() {
		return diagnosticCenterRepository.findAll();
	}
	@Override
	public List<DiagnosticCenter> getDiagnosticCenterById(String id) {
		return diagnosticCenterRepository.getCenterById(id);
	}

}
