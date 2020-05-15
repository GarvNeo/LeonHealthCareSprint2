package com.capg.healthcare.dao;

import java.math.BigInteger;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.capg.healthcare.entity.Appointment;
import com.capg.healthcare.entity.User;
import com.capg.healthcare.repository.IAppointmentRepository;
import com.capg.healthcare.repository.IUserRepository;


@Component
public class AppointmentDAOService implements  IAppointmentDAO{

	@Autowired
	private IAppointmentRepository iAppointmentRepository;
	
	@Autowired
	private IUserRepository iUserRepository;
    /* Making of appointment */
	
    public Appointment saveAppointments(Appointment app) {
	
        
		System.out.println("inside boot dao");
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
    
   public User saveUserAppointments(User app) {
	
        
		System.out.println("inside boot dao");
		return iUserRepository.save(app);
		
	}
    
}
