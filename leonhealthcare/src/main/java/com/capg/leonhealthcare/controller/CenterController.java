package com.capg.leonhealthcare.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.leonhealthcare.entity.DiagnosticCenter;
import com.capg.leonhealthcare.service.ICenterService;


@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
public class CenterController {
    @Autowired
    private ICenterService service;
//   ******************************************** Adding Center ******************************
    @PostMapping("/add_center")
    public DiagnosticCenter createCenter(@RequestBody DiagnosticCenter center) {
        
        return service.addCenters(center);
    }
    
    @RequestMapping("/show_centers") 
	public List<DiagnosticCenter> showAllAppointments(@ModelAttribute DiagnosticCenter prod) 
	throws ResourceNotFoundException
	{	
		List<DiagnosticCenter> center_list = service.getAllCenter();
		System.out.println("yes inside ");
		if(center_list == null)
		{
			throw new ResourceNotFoundException("No Records Available ");
		}
		
		return center_list;
	}
    
//	******************************************** View center By Id *****************************
    @GetMapping("/view_center_by_id/{id}")
    public List<DiagnosticCenter> getCenterById(@PathVariable String id) 
    		throws ResourceNotFoundException{
    		List<DiagnosticCenter> list = service.getCenters(id);
    if(list ==null) 
    	{
    	throw new ResourceNotFoundException("No Center Found By Such ID");
    	}
    return list;
    }
    
//	********************************************* Delete Center By Id *************************************
    
    @GetMapping("/delete_center_by_id/{id}")
    public String deleteCenterById(@PathVariable(value = "id") String id){
        int res = service.deleteCenters(id);
        System.out.println("Hey their.....");
        if(res == 1) 
        {
        	return "Center deleted successfully";
        }
        else
        	return "deletion not successful";
    }
    
}
