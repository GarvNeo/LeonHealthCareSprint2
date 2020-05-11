package com.capg.leonhealthcare.service;

import java.util.List;

import com.capg.leonhealthcare.entity.DiagnosticCenter;


public interface ICenterService{

	List<DiagnosticCenter> getAllCenter();

	List<DiagnosticCenter> getCenters(String id);

	public int deleteCenters(String id);

	public DiagnosticCenter addCenters(DiagnosticCenter center);

}