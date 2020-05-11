package com.capg.leonhealthcare.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.capg.leonhealthcare.entity.DiagnosticCenter;

@Repository
public interface IDiagnosticCenterRepository extends JpaRepository<DiagnosticCenter,String>{

	@Query("select c from DiagnosticCenter c where c.centerId=?1")
	public List<DiagnosticCenter> getCenterById(String id);
	@Transactional
	@Modifying
	@Query("delete from DiagnosticCenter c where c.centerId=?1")
	public int deleteCenterById(String id);
			
}
