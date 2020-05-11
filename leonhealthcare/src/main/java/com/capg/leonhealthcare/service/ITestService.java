package com.capg.leonhealthcare.service;

import java.util.List;

import com.capg.leonhealthcare.entity.Test;

public interface ITestService{

	List<Test> getAllTest();

	List<Test> getTests(String id);

	public int deleteTests(String id);

	public Test addTests(Test test);

}