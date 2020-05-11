package com.capg.leonhealthcare.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.capg.leonhealthcare.repository.IAppointmentRepository;






@Component
public class ViewAppointmentDetailsDAO implements IViewAppointmentDetailsDAO{

	@Autowired 
	IAppointmentRepository  appointmentRepository;
	
	@SuppressWarnings("rawtypes")
	@Override
	public List viewAppointmentDetails(String UserId) {
		// TODO Auto-generated method stub
		return appointmentRepository.findAppointmentDetailsByUserID (UserId);
	}


	
	
}
