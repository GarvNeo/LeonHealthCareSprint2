package com.capg.leonhealthcare.service;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.capg.leonhealthcare.controller.AppointmentController;
import com.capg.leonhealthcare.dao.AppointmentDAOService;
import com.capg.leonhealthcare.entity.Appointment;
import com.capg.leonhealthcare.repository.IAppointmentRepository;

@Service
public class AppointmentService implements IAppointmentService{

	@Autowired
	private AppointmentDAOService appointmentDAOService; 
	

	/**************************************** Making of appointment***************************** ***************************/
	
	public Appointment saveAppointmentss(Appointment app) {
		
		
		if(checkSlotAvailibility(app.getDateTime()))
		{
			return appointmentDAOService.saveAppointments(app);
		}
		else
		{
			return null;
		}
	}

	/******************************Making a search or updation ***************************/
	

	public Appointment appointmentSearchUpdateById(Appointment new_appointment,String choice)
	{
		List<Appointment> appointment = appointmentDAOService.showAppointments();
		
		for(Appointment old_appointment : appointment)
		{
			if(old_appointment.getAppointmentId().equals(new_appointment.getAppointmentId()))
			{
				if (choice.equals("Search") )
				{
					return old_appointment;	
				}
				else if(choice.equals("Update"))
				{
					old_appointment.setCenterId(new_appointment.getCenterId());
					old_appointment.setDateTime(new_appointment.getDateTime());
					old_appointment.setStatus(new_appointment.getStatus());
					old_appointment.setTestId(new_appointment.getTestId());
					old_appointment.setUserId(new_appointment.getUserId());
					
					return  appointmentDAOService.saveAppointments(old_appointment);
				}
			}
		}
		return null;
	}
	
	
	/******************************Checking whether slot is available or not ***************************/
	
	public boolean checkSlotAvailibility(Timestamp dateTimeCurrent)
	{
		
		List<Appointment> appointment = appointmentDAOService.showAppointments();
		
		for(Appointment old_appointment : appointment)
		{
			if(old_appointment.getDateTime().equals(dateTimeCurrent))
			{
				return false;
			}
		}
		return true;
	}

	

	/*********************************Fetching of complete list **************************************************/
	
	public List<Appointment> showAllAppointments()
	{	
		return appointmentDAOService.showAppointments();
	}
	
	/*********************************Deleting of complete list **************************************************/
	
	public int cancelAppointmentById( BigInteger app_id)
	{	
		return appointmentDAOService.cancelAppointmentById(app_id);
	}
	

	
}
