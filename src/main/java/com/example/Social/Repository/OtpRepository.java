package com.example.Social.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Social.Entity.Otp;

public interface OtpRepository extends JpaRepository<Otp,Long>{

	Optional<Otp> findByPhoneAndOtp(String phone, String otp);

}
