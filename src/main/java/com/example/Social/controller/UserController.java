package com.example.Social.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.Social.Entity.User;
import com.example.Social.Service.FileService;
import com.example.Social.Service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	public UserService service;
	
	@Autowired
	private FileService fileService;
	
	@GetMapping("/{id}") 
	public ResponseEntity<User> getUser(@PathVariable Long id) throws Exception{
        return ResponseEntity.ok(service.expect(id)); 
        		
	}
	 
	@PutMapping("/profile/{id}") 
    public String updateUser(@PathVariable Long id,MultipartFile picture) throws Exception {
		User user=service.expect(id);
		user.setImagePath(fileService.save(picture, "user/"+id));
		service.add(user);
		return "updated";
		
	}
	
	
	
}
