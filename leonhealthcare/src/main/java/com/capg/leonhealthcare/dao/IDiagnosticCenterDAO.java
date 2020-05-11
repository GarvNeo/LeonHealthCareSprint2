package com.capg.leonhealthcare.dao;
import java.util.List;

import com.capg.leonhealthcare.entity.DiagnosticCenter;

public interface IDiagnosticCenterDAO {
	
	List<DiagnosticCenter> getAllCenters();

	List<DiagnosticCenter> getCenter(String id);

	int deleteCenter(String id);

	DiagnosticCenter addCenter(DiagnosticCenter center);

}
