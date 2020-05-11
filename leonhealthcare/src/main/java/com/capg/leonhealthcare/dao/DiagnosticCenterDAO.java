package com.capg.leonhealthcare.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.capg.leonhealthcare.entity.DiagnosticCenter;
import com.capg.leonhealthcare.repository.IDiagnosticCenterRepository;


@Component
public class DiagnosticCenterDAO implements IDiagnosticCenterDAO{
	

		@Autowired
	    private IDiagnosticCenterRepository repository;

		@Override
		public List<DiagnosticCenter> getAllCenters() {
			return repository.findAll();
		}
		@Override
		public List<DiagnosticCenter> getCenter(String id){
			return repository.getCenterById(id);		
		}
		@Override
		public int deleteCenter(String id){
			
		return	repository.deleteCenterById(id);	
			
		}
		
		@Override
		public DiagnosticCenter addCenter(DiagnosticCenter center) {
			return repository.save(center);
		}
	
	}


