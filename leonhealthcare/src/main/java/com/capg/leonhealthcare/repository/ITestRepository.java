package com.capg.leonhealthcare.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.capg.leonhealthcare.entity.Test;

@Repository
public interface ITestRepository extends JpaRepository<Test, String>{
	
	@Query("select t from Test t where t.testId=?1")
	public List<Test> getTestById(String id);
	@Transactional
	@Modifying
	@Query("delete from Test t where t.testId=?1")
	public int deleteTestById(String id);
	
	
}
