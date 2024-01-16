package com.example.Social.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import com.example.Social.Entity.User;
import com.example.Social.Model.LoginModel;
import com.example.Social.Service.OtpService;
import com.example.Social.Service.UserService;

@RestController
public class AuthenticationController {
	
	private static final int ResponseEntity = 0;

	@Autowired
	private UserService userService;
	
	@Autowired
	private OtpService otpService;
	
	@PostMapping("/login")
	public ResponseEntity<User> login(@RequestBody LoginModel user) throws Exception{
		if(user.getPassword()==null) {
			return handleOtpLogin(user);
		}
		else
			return passwordLogin(user);		
	}

	private ResponseEntity<User> passwordLogin(LoginModel user) {
		// TODO Auto-generated method stub
		return null;
	}

	private ResponseEntity handleOtpLogin(LoginModel user) throws Exception{
		Optional<User> userOptional = userService.getByUser(user.getPhone());
		if(!userOptional.isPresent()) {
           return new ResponseEntity<>("Phone not registered", HttpStatus.NOT_FOUND);
		}
		
		User userSaved=userOptional.get();
		if(user.getOtp()==null) {
			otpService.generateOtp(user.getPhone());
	        return new ResponseEntity<>("otp Sent", HttpStatus.OK);
		}
		
		else if(!user.getOtp().equals("2121")) {
	           return new ResponseEntity<>("invalid Otp", HttpStatus.NOT_FOUND); 
		}
		else
        return new ResponseEntity<>(userSaved, HttpStatus.OK); 

	}
	
	
	

}
