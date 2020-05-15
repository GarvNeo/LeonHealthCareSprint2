package com.user.repository;

import java.math.BigInteger;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.user.entity.UserEntity;

public interface UserRepository extends CrudRepository<UserEntity, BigInteger>{

	@Query("select c from UserEntity c where c.id=?1 and c.password =?2")
	public UserEntity mapping(String id, String password);
	
	
}
