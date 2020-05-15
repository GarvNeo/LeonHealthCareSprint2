package com.capg.healthcare.controller;

import java.math.BigInteger;
import com.capg.healthcare.entity.*;
import java.text.SimpleDateFormat;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capg.healthcare.entity.Appointment;
import com.capg.healthcare.repository.IAppointmentRepository;
import com.capg.healthcare.service.AppointmentService;
import com.capg.healthcare.service.IAppointmentService;

@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RequestMapping("/api")
public class AppointmentController {
	
	
	@Autowired
	private IAppointmentService service;
	
	/**********************************Making of appointment*************************************/

	@PostMapping("/saveAppointments")
	public String saveApppointment(@RequestBody Appointment app)
	{
		System.out.println("in boot");
		Appointment appointment = service.saveAppointmentss(app);
		if(appointment == null)
		{
			return "Oops ! Sorry, this slot is already booked, please choose another, ";
		}
		return "Hey !! Your appointment is booked, Please wait for a confirmation email";
	}

	/*******************************Showing of All the Appointments**********************************************/
	
	@RequestMapping("/showAppointments") 
	public List<Appointment> showAllAppointments() 
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
        	throw new ResourceNotFoundException(userName+ "Your request of searching / updation cannot be processed\n as no such data exist, Please try Again with valid data id");
        }
        return search_updated_appointment;
    }

    @GetMapping("/deleteAppointment/{app_id}")
    public String cancelAppointmentById(@PathVariable(value = "app_id")BigInteger app_id){
         if(service.cancelAppointmentById(app_id)==1)
         {
        	 return "Deletion Successfull"; 
         }
         else{
        	 return "Deletion did not happen, may be the resource you want to delete is already deleted or doesn't exixted at all";
         }
    }
	 
	/*********************************************Invalid request handling *****************************************/
	

	@PostMapping("/saveUser")
	public String UserEntity(@RequestBody User app)
	{
		System.out.println("in boot");
		System.out.println("in boot"+ app.getUserId()+" "+app.getEmailId()+" "+app.getUserName()+" "+app.getUserPassword()+" "+app.getUserRole()+" "+app.getContactNo() );
		
		User userEntity = service.saveUserAppointments(app);
		if(userEntity == null)
		{
			return "Oops ! Your rehistraion failed, please choose another, ";
		}
		return "Hey! you are registered, Please wait for a confirmation email";
	}

	@GetMapping("/**")
    public String invalidRequest(){
        return "It seems lik you have entered the URL incorrectly"; 	
    }

}
