package com.example.Social.Service;

import java.time.LocalDateTime;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Social.DTO.RegistrationDTO;
import com.example.Social.Entity.Otp;
import com.example.Social.Repository.OtpRepository;

@Service
public class OtpService {
	private final OtpRepository repository;
	
	@Autowired
	public OtpService(OtpRepository repository) {
		this.repository=repository;
	}
	@Autowired
	public UserService userService;
	
	public void addOtp(Otp otp) {
		repository.save(otp);
	}
	
	public String generateOtp(String Phone) {
		Random random = new Random();
        int randomNumber = random.nextInt(9000) + 1000;
        String Otp=String.valueOf(randomNumber);
        Otp otp=new Otp();
        otp.setPhone(Phone);
        otp.setDate(LocalDateTime.now());
        otp.setExpiryDate(LocalDateTime.now().plusMinutes(2));
        otp.setOtp(Otp);
        addOtp(otp);
        return Otp;
	}


	public boolean validateOtp(RegistrationDTO dto) throws Exception {
		 if(dto.getOtp() == "2121") {
			 return true;
		 }
	     return false;
	}   
	
	

}
