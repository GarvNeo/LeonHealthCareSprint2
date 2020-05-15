package com.capg.healthcare.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.capg.healthcare.entity.User;


@Repository
public interface IUserRepository extends JpaRepository<User,String>{

	@Query("select u from User u where u.userName like '%@gmail.com'")
	List<User> findUsersWithGmailAddress();
	
	@Query("select u from User u where u.userId=?1")
	public List<User> getUserById(String id);
}
