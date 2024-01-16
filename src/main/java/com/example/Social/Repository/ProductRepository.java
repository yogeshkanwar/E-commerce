package com.example.Social.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Social.Entity.Product;

public interface ProductRepository extends JpaRepository<Product,Long>{ 

}
