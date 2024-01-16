package com.example.Social.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Social.Entity.User;

public interface UserRepository extends JpaRepository<User,Long>{

}
