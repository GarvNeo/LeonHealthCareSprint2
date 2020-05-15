package com.user.controller;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.user.entity.UserEntity;
import com.user.exception.UserNotFoundException;
import com.user.repository.UserRepository;
import com.user.service.UserService;


@RestController
@RequestMapping("/accounts")
@CrossOrigin(origins="http://localhost:4200", maxAge = 3600)
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	UserRepository userRepo;
		
	@RequestMapping(method = RequestMethod.POST,value = "/register")
	public UserEntity register(@RequestBody UserEntity userEntityObj){
		System.out.println("registration details added : "+userEntityObj.getPhone());
		
	//	UserEntity appointment = 
//		System.out.println("yess");
//		if(appointment == null)
//		{
//			return "Oops ! Sorry, this slot is already booked, please choose another, ";
//		}
//		return "Hey !! Your appointment is booked, Please wait for a confirmation email";

		
		
		
		return userService.register(userEntityObj);
		
		
	}
	
	
	@PostMapping("/login")
	public UserEntity login(@RequestBody UserEntity auth)
	{
//		UserEntity ue = userRepo.mapping(auth.getEmail(),auth.getPassword());
//		if (ue == null)
//		{
//			System.out.println("False");
//			return false;
//		}
//		System.out.println("true");
//		return true;
		System.out.println("doing"+auth);
		return userService.login1(auth) ;
		
	}
	
	
	
	@GetMapping("/all")
	public Iterable<UserEntity> all()
	{
		return userRepo.findAll();
	}
	
	@PostMapping("/AddingProducts")
	public UserEntity index(@RequestBody UserEntity user)
	{
		
		
		return userService.addUser(user);
	}
	
	@GetMapping("/DisplayingDetails")
	public List<UserEntity> viewUser(){
		return userService.viewUser();	

	}
	
	
	@GetMapping("/userById/{id}")
	public Optional<UserEntity> findOne(@PathVariable("id") BigInteger id)throws UserNotFoundException
	{
		Optional<UserEntity> b = userService.viewUserById(id);
		if (!b.isPresent())
			throw new UserNotFoundException("this is an invalid id !!");
		return b;
	}
	
	
	@GetMapping("/delete/{id}")
	  void delete(@PathVariable("id") BigInteger id) {
	     userService.deleteUserById(id);
                                                                                                                                       
	  }
	
	
	@PutMapping("/userUpdate/{id}")
    public ResponseEntity<UserEntity> updateUser(@PathVariable(value="id") BigInteger id, @RequestBody UserEntity user) throws UserNotFoundException
    {
	       UserEntity users= userRepo.findById(id).orElseThrow(()-> new UserNotFoundException("inavlid id"));
			   
			   
			   users.setEmail(user.getEmail());
			   users.setName(user.getName());
			   users.setPassword(user.getPassword());
			   users.setPhone(user.getPhone());
			   users.setType(user.getType());
			   final UserEntity updatedUser=userRepo.save(users);
			   
	         return  ResponseEntity.ok(updatedUser);
    }
	
}