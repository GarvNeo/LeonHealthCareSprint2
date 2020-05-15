package com.capg.leonhealthcare.dao;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.capg.leonhealthcare.entity.Appointment;
import com.capg.leonhealthcare.repository.IAppointmentRepository;

@Component
public class AppointmentDAOService implements  IAppointmentDAO{

	@Autowired
	private IAppointmentRepository iAppointmentRepository;
	
    /* Making of appointment */
	
    public Appointment saveAppointments(Appointment app) {
		
		return iAppointmentRepository.save(app);
		
	}
    
    /* Fetching list of all appointments */
	
    public List<Appointment> showAppointments()
	{	
		List<Appointment> app = iAppointmentRepository.findAll();
		
		return app;
	}
    
    /* Deleting an appointment */
	
    public int cancelAppointmentById( BigInteger app_id)
	{	
		return iAppointmentRepository.deleteAppointment(app_id);
	}
    
}
