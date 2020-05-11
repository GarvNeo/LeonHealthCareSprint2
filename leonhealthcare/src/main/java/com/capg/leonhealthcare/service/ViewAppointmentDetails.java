 package com.capg.leonhealthcare.service;






import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.leonhealthcare.dao.IViewAppointmentDetailsDAO;


 
@Service
public class ViewAppointmentDetails implements IViewAppointmentDetails{
 
	@Autowired
	IViewAppointmentDetailsDAO dao;

	
	@SuppressWarnings("rawtypes")
	@Override
	public List viewAppointmentDetail(String UserId) {
		return dao.viewAppointmentDetails(UserId);
	}
}
	
	
