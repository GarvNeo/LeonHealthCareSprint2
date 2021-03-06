package com.capg.leonhealthcare.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.leonhealthcare.exception.ResourceNotFoundException;
import com.capg.leonhealthcare.service.IViewAppointmentDetails;


@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
 
public class ViewAppointmentController {

	@Autowired
	IViewAppointmentDetails app_details;
	
	@SuppressWarnings("rawtypes")
	@RequestMapping("/getAppointmentDetails/{userID}") 
    public List getAppointmentDetails (@PathVariable String userID)throws ResourceNotFoundException
	{
		System.out.println("Yet here we are");
		List list=app_details.viewAppointmentDetail(userID);
		if (list == null)
		{
		    		throw new ResourceNotFoundException("No user records are available for you "+userID);
		}
		return list;		
	} 
} 
    
