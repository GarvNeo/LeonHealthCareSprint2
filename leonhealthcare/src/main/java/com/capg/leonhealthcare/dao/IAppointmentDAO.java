package com.capg.leonhealthcare.dao;

import java.math.BigInteger;
import java.util.List;

import com.capg.leonhealthcare.entity.Appointment;

public interface IAppointmentDAO {

	int cancelAppointmentById( BigInteger app_id);
	List<Appointment> showAppointments();
	Appointment saveAppointments(Appointment app);
	
}
