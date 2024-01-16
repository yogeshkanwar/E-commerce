package com.example.Social.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import com.example.Social.DTO.RegistrationDTO;
import com.example.Social.Entity.User;
import com.example.Social.Service.OtpService;
import com.example.Social.Service.UserService;

@RestController
@RequestMapping("/register")
public class RegistrationController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	OtpService otpService;

	
	@PostMapping
	public ResponseEntity<User> register(@RequestBody RegistrationDTO dto ) throws Exception{
		if(dto.getPhone()!=null && dto.getOtp()!= null) {
		     Boolean valid = otpService.validateOtp(dto); 
		    if(!valid) { 
		        return new ResponseEntity("Invalid OTP", HttpStatus.BAD_REQUEST); 
		    }
		    
		}
	     User user=dto.toEntity();  
		 userService.add(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
					 
	}
		
	

}
