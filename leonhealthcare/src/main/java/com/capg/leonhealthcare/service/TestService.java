package com.capg.leonhealthcare.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.leonhealthcare.dao.ITestDAO;
import com.capg.leonhealthcare.entity.Test;

@Service
public class TestService implements ITestService{

	@Autowired 
	ITestDAO dao;
	@Override
	public List<Test> getAllTest() {
		return dao.getAllTests();
	}

	@Override
	public List<Test> getTests(String id) {
		return dao.getTest(id);
	}

	@Override
	public int deleteTests(String id) {
		return dao.deleteTest(id);
	}

	@Override
	public Test addTests(Test test) {
		return dao.addTest(test);
	}

	
}
