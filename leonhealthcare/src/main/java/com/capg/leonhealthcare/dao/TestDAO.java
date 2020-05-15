package com.capg.leonhealthcare.dao;

import java.util.List;

import com.capg.leonhealthcare.entity.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.capg.leonhealthcare.repository.ITestRepository;


@Component
public class TestDAO implements  ITestDAO{

	@Autowired
    private ITestRepository repository;

	@Override
	public List<Test> getAllTests() {
		return repository.findAll();
	}
	@Override
	public List<Test> getTest(String id){
		return repository.getTestById(id);		
	}
	
	@Override
	public List<Test> getAllTestOfCenter(String id){
		return repository.getAllTestOfCenter(id);		
	}
	@Override
	public int deleteTest(String id){
		return repository.deleteTestById(id);		
	}
	@Override
	public Test addTest(Test test) {
		return repository.save(test);
	}
	
	
}