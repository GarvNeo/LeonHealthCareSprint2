package com.capg.healthcare.service;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.List;

import com.capg.healthcare.entity.Appointment;
import com.capg.healthcare.entity.User;

public interface IAppointmentService {

	  Appointment saveAppointmentss(Appointment app); 
	 
	  boolean checkSlotAvailibility(Timestamp dateTimeCurrent, String iestId, String centerId);
		
	  List<Appointment> showAllAppointments();
	  
	  Appointment appointmentSearchUpdateById(Appointment new_appointment,String choice);
	  
	  int cancelAppointmentById( BigInteger app_id);

	  User saveUserAppointments(User app);
}
