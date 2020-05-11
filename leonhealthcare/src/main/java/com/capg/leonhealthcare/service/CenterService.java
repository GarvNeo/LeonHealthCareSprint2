package com.capg.leonhealthcare.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.leonhealthcare.dao.IDiagnosticCenterDAO;
import com.capg.leonhealthcare.entity.DiagnosticCenter;


@Service
public class CenterService implements ICenterService{

	@Autowired
    private IDiagnosticCenterDAO dao;

	@Override
	public List<DiagnosticCenter> getAllCenter() {
		return dao.getAllCenters();
	}
	@Override
	public List<DiagnosticCenter> getCenters(String id){
		return dao.getCenter(id);		
	}
	@Override
	public int deleteCenters(String id){
		return dao.deleteCenter(id);		
	}
	
	@Override
	public DiagnosticCenter addCenters(DiagnosticCenter center) {
		return dao.addCenter(center);
	}
	
}
