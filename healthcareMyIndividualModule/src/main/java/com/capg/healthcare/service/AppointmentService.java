package com.capg.healthcare.service;

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

import com.capg.healthcare.controller.AppointmentController;
import com.capg.healthcare.dao.AppointmentDAOService;
import com.capg.healthcare.dao.IAppointmentDAO;
import com.capg.healthcare.entity.Appointment;
import com.capg.healthcare.entity.User;
import com.capg.healthcare.repository.IAppointmentRepository;

@Service
public class AppointmentService implements IAppointmentService{

//	@Autowired
//	private IAppointmentRepository iAppointmentRepository;
//	
	@Autowired
	private IAppointmentDAO appointmentDAOService; 
	

	/**************************************** Making of appointment***************************** ***************************/
	
	public Appointment saveAppointmentss(Appointment app) {
		
		System.out.println("inside boot service");
		if(checkSlotAvailibility(app.getDateTime(),app.getTestId(), app.getCenterId()))
		{
			System.out.println("inside boot service2");
			
			return appointmentDAOService.saveAppointments(app);
		}
		else
		{
			return null;
		}
	}

	/******************************Making a search or updation ***************************/
	

	public Appointment appointmentSearchUpdateById(Appointment new_appointment, String choice)
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
	
	public boolean checkSlotAvailibility(Timestamp dateTimeCurrent,String testId, String centerId)
	{

		System.out.println("inside boot check slot");	
		List<Appointment> appointment = appointmentDAOService.showAppointments();
		

		System.out.println("inside boot check slot2");
		
		for(Appointment old_appointment : appointment)
		{
			if(old_appointment.getDateTime().equals(dateTimeCurrent))
			{
				if(old_appointment.getTestId().equals(testId))
				{
					if(old_appointment.getCenterId().equals(centerId))
					{
						return false;
					}
				}
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
	

	
    public User saveUserAppointments(User app) {
		
			return appointmentDAOService.saveUserAppointments(app);
		
	}
}
