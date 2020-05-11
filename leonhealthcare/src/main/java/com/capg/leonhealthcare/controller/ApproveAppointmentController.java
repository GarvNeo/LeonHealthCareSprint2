package com.capg.leonhealthcare.controller;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.leonhealthcare.entity.Appointment;
import com.capg.leonhealthcare.entity.DiagnosticCenter;
import com.capg.leonhealthcare.entity.Test;
import com.capg.leonhealthcare.entity.User;
import com.capg.leonhealthcare.service.IApproveAppointmentService;


@RestController
public class ApproveAppointmentController {

	@Autowired
	IApproveAppointmentService approveAppointmentService;
	
	@GetMapping("/user")
    public List<User> getUser() {
        return approveAppointmentService.getUser();
    }
	@GetMapping("/user/{id}")
    public List<User> getUserById(@PathVariable String id) {
        return approveAppointmentService.getUserById(id);
    }
//	@GetMapping("/test")
//    public List<Test> getTest() {
//        return approveAppointmentService.getTest();
//    }
//	@GetMapping("/test/{id}")
//    public List<Test> getTestById(@PathVariable String id) {
//        return approveAppointmentService.getTestById(id);
//    }
	@RequestMapping("/appointment")
    public List<Appointment> getAppointment() {
        return approveAppointmentService.getAppointment();
    }
	@RequestMapping("/appointment/{id}")
    public List<Appointment> getAppointmentById(@PathVariable BigInteger id) {
        return approveAppointmentService.getAppointmentById(id);
    }
//	@RequestMapping("/center")
//    public List<DiagnosticCenter> getgetDiagnosticCenter() {
//        return approveAppointmentService.getDiagnosticCenter();
//    }
//	@RequestMapping("/center/{id}")
//    public List<DiagnosticCenter> getDiagnosticCenterById(@PathVariable String id) {
//        return approveAppointmentService.getDiagnosticCenterById(id);
//    }
//	
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/list")
    public List<Appointment> getAppointmentDetails() {
		return approveAppointmentService.join();
	}
	
	@RequestMapping("/userWithEmail")
    public List<User> getQuery() {
        return approveAppointmentService.findUsersWithGmailAddress();
    }
	
	@RequestMapping("/approveAppointment/{appId}")
	public String approveAppointment(@PathVariable String appId){
		approveAppointmentService.approveAppointment(appId);
		return "Appointment approved";
	}
	@RequestMapping("/rejectAppointment/{appId}")
	public String rejectAppointment(@PathVariable String appId){
		approveAppointmentService.disApproveAppointment(appId);
		return "Appointment rejected";
	}
	
	@SuppressWarnings("rawtypes")
	@RequestMapping("/allAppointment")
	public List getAllAppointment(){
		return approveAppointmentService.join();		
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/allAppointment/{id}")
	public List<Appointment> getAppointmentDetailsById(@PathVariable BigInteger id){
		return approveAppointmentService.getAppointmentDetails(id);		
	}	
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/allAppointment/user/{id}")
	public List<Appointment> getAppointmentDetailsByUserId(@PathVariable String id){
		return approveAppointmentService.getAppointmentDetailsByUserId(id);		
	}	
	
	@RequestMapping("/approved")
	public List<Appointment> getApproved(){
		List<Appointment> approvedList=approveAppointmentService.getApprovedAppointmentList();
		return approvedList;
	}
	
	@RequestMapping("/rejected")
	public List<Appointment> getRejected(){
		List<Appointment> rejectedList=approveAppointmentService.getRejectedAppointmentList();
		return rejectedList;
	}
	
	@RequestMapping("/pending")
	public List<Appointment> getPending(){
		List<Appointment> pendingList=approveAppointmentService.getPendingAppointmentList();
		return pendingList;
	}
	
}


