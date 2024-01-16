package com.example.Social.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.Social.Entity.User;

public interface UserRepository extends JpaRepository<User,Long>{
    
	@Query("SELECT u FROM User u WHERE u.email = :emailOrPhone OR u.phone = :emailOrPhone")
	Optional<User> findByEmailOrPhone(String emailOrPhone);

}
