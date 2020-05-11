package com.capg.leonhealthcare.controller;

import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capg.leonhealthcare.entity.Appointment;
import com.capg.leonhealthcare.repository.IAppointmentRepository;
import com.capg.leonhealthcare.service.AppointmentService;

@RestController
@RequestMapping("/api")
public class AppointmentController {
	
	
	@Autowired
	private IAppointmentRepository iAppointmentRepository;
	
	@Autowired
	private AppointmentService service;
	
	/**********************************Making of appointment*************************************/

	@PostMapping("/saveAppointments")
	public String saveApppointment(@RequestBody Appointment app)
	{
		Appointment appointment = service.saveAppointmentss(app);
		if(appointment == null)
		{
			return "Oops ! Sorry, this slot is already booked, please choose another, ";
		}
		return "Hey !! Your appointment is booked, Please wait for a confirmation email";
	}

	/*******************************Showing of All the Appointments**********************************************/
	
	@RequestMapping("/showAppointments") 
	public List<Appointment> showAllAppointments(@ModelAttribute Appointment prod) 
	throws ResourceNotFoundException
	{	
		List<Appointment> appointment_list = service.showAllAppointments();
		
		if(appointment_list == null)
		{
			throw new ResourceNotFoundException("No Records Available ");
		}
		
		return appointment_list;
	}
	
	/* On clicking of update button a form with the previous data gets opened now after changing the details when submit button is pressed the same data gets binded into Appointment type object and an update request is placed here */
    
	@PostMapping("/updateAppointmentDetails/{userName}/{option}")
    public Appointment appointmentSearchUpdateById(@PathVariable(value = "userName") String userName,@PathVariable(value = "option") String option,
    		@RequestBody Appointment appointment)
    throws ResourceNotFoundException 
    {
        Appointment search_updated_appointment = service.appointmentSearchUpdateById(appointment,option);
        if(search_updated_appointment == null)
        {
        	throw new ResourceNotFoundException(userName+ "Your request of searching / updation cannot be processed, Please try Again ");
        }
        return search_updated_appointment;
    }

    @GetMapping("/deleteAppointment/{app_id}")
    public String cancelAppointmentById(@PathVariable(value = "app_id") BigInteger app_id){
         if(service.cancelAppointmentById(app_id)==1)
         {
        	 return "Deletion Successfull"; 
         }
         else{
        	 return "Deletion did not happen, may be the resource you want to delete is already deleted ";
         }
		
    }
	 
	/*********************************************Auto insertion *****************************************/
	
//	@PostMapping("/saveAppointment")
//	public List<Appointment> saveProduct(@RequestBody Appointment prod)
//	{
//		
//    	java.sql.Timestamp ts = AppointmentController.getCurrentTimeStamp() ;			
//		Appointment appointment = new Appointment("U14",ts,"Da4C12","D4CT25",0);
//		iAppointmentRepository.save(appointment);
//		
//		List<Appointment> app =iAppointmentRepository.findAll();
//		return app;
//	}
//	
	private static java.sql.Timestamp getCurrentTimeStamp()
	{
		java.util.Date today = new java.util.Date();
		return new java.sql.Timestamp(today.getTime());
	}
	
	@RequestMapping("/**") 
	public String errrors() 
	{	
		return "Your entered path is wrong i.e. URL";
	}
	
}
