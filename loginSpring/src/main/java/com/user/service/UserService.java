package com.user.service;

import java.math.BigInteger;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.user.entity.UserEntity;
import com.user.repository.UserRepository;

@Service
@Transactional
public class UserService {

	@Autowired
	private UserRepository userRepository;
	

	public UserEntity register(UserEntity userEntityObj) {

		
		return userRepository.save(userEntityObj);
	}

	public UserEntity login1(UserEntity userEntityObj) {
		      String returnString = "Invalid Credentials";
		  if(userEntityObj.getId() == null || userEntityObj.getPassword() == null)
		  {
			  return null;
		  }else{
		
		try
		{
		   UserEntity userEntity = userRepository.mapping(userEntityObj.getId(),userEntityObj.getPassword());
		
		   System.out.println("Login"+userEntityObj.getId()+userEntityObj.getPassword());
		   System.out.println("Login result"+userEntity.getId()+userEntity.getPassword());
		    
		  if(userEntity == null) 
		  {
			  return null;
		  }
		  else{
		  
			  if(userEntityObj.getPassword().equals(userEntity.getPassword()))
			  {
				System.out.println("Login Successful");
			    
				return userEntity;
			   }
			   else
			   {
                
				   System.out.println("Login InSuccessful");
				    
				   return null;
			   }
		  }
		
		}
		
		catch (Exception ex)
		{
			return null;
		}
		  }
	}
	
public UserEntity addUser(UserEntity user) {
		
		return userRepository.save(user);
	}

	public List<UserEntity> viewUser() {
		
		return (List<UserEntity>) userRepository.findAll();
	}

	public Optional<UserEntity> viewUserById(BigInteger id) {
		
        Optional<UserEntity> UserObj=userRepository.findById(id);
		
		return UserObj;
	}

	public void deleteUserById(BigInteger id) {
		userRepository.deleteById(id);
		
	}

	

}
