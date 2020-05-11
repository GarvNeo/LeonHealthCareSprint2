package com.capg.leonhealthcare.dao;

import java.util.List;

import com.capg.leonhealthcare.entity.*;

public interface ITestDAO {

	List<Test> getAllTests();

	List<Test> getTest(String id);

	int deleteTest(String id);

	Test addTest(Test test);

	
}
