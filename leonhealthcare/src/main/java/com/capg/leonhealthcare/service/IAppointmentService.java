package com.capg.leonhealthcare.service;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.List;

import com.capg.leonhealthcare.entity.Appointment;

public interface IAppointmentService {

	  Appointment saveAppointmentss(Appointment app); 
	 
	  boolean checkSlotAvailibility(Timestamp dateTimeCurrent);
		
	  List<Appointment> showAllAppointments();
	  
	  public Appointment appointmentSearchUpdateById(Appointment new_appointment,String choice);
}
