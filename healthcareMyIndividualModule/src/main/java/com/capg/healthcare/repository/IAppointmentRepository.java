package com.capg.healthcare.repository;
import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.capg.healthcare.entity.*;


@Repository
public interface IAppointmentRepository extends JpaRepository<Appointment,BigInteger>{
	
	@Transactional
	@Modifying
	@Query("delete from Appointment a where a.appointmentId=?1")
	public int deleteAppointment(BigInteger id);
}
