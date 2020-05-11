package com.capg.leonhealthcare.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.capg.leonhealthcare.entity.Test;
import com.capg.leonhealthcare.service.ITestService;

@RestController
public class TestController {
    @Autowired
    private ITestService service;

    @PostMapping("/add")
    public String createTest(@RequestBody Test test) 
    {
    	Test obj=service.addTests(test);
    	if(obj == null)
    	{
    		return "Oops... No Test is created!!";
    	}
    return "Test added successfully!!";
    }
    
    @GetMapping("/test")
    public List <Test> getAllTests()throws ResourceNotFoundException {
        List<Test> list= service.getAllTest();
        if(list == null)
        {
        	throw new ResourceNotFoundException("Oops... No Test found!!");
        }
        return list;
    }
    
    @GetMapping("/test/{id}")
    public List<Test> getTestById(@PathVariable String id)throws ResourceNotFoundException{
        List<Test> list= service.getTests(id);
        if(list == null)
        {
        	throw new ResourceNotFoundException("No Test found by Id---->Check the Id you have entered!!");
        }
        return list;
    }

    @GetMapping("/delete/{id}")
    public String deleteTestById(@PathVariable String id){
        int res = service.deleteTests(id);
        if(res == 1) 
        {
        	return "Center deleted successfully";
        }
        else
        	return "deletion not successful";
		
    }
      
}
