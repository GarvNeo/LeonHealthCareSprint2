package com.capg.healthcare.dao;

import java.math.BigInteger;
import java.util.List;

import com.capg.healthcare.entity.Appointment;
import com.capg.healthcare.entity.User;

public interface IAppointmentDAO {

	int cancelAppointmentById( BigInteger app_id);
	List<Appointment> showAppointments();
	Appointment saveAppointments(Appointment app);
	
	User saveUserAppointments(User app) ;
}
