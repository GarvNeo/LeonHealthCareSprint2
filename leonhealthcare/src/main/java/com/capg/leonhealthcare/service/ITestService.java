package com.capg.leonhealthcare.service;

import java.util.List;

import com.capg.leonhealthcare.entity.Test;

public interface ITestService{

	List<Test> getAllTest();

	List<Test> getTests(String id);

	int deleteTests(String id);

    Test addTests(Test test);

    List<Test> getAllTestOfCenter(String id);
}