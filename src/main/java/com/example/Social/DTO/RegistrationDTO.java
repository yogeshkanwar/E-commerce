package com.example.Social.DTO;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import com.example.Social.Entity.User;
@Component
public class RegistrationDTO {
	private String phone;
	private String email;
	private String password;
	private String confirmPassword;
	private String Otp;
	
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	public String getOtp() {
		return Otp;
	}
	public void setOtp(String otp) {
		Otp = otp;
	}
	
	public User toEntity() {
	        User userEntity = new User();
	        userEntity.setPhone(phone);
	        userEntity.setCretedDate(LocalDateTime.now());
	        return userEntity;
	    }

}

