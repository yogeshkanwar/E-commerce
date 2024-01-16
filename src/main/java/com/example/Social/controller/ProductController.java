package com.example.Social.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.example.Social.Entity.Product;
import com.example.Social.Service.FileService;
import com.example.Social.Service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
	 
	@Autowired
	private ProductService service;
	
	@Autowired
	private FileService fileService;
	  
	@PostMapping
	public ResponseEntity<Product> addProduct(@RequestBody Product p){
		Product product=new Product();
		product.setName(p.getName());
		product.setBrand(p.getBrand());
		product.setPrice(p.getPrice());
		service.add(product); 
		return ResponseEntity.ok().body(product);
		
	}
	
	@PutMapping("/image/{id}")
	public ResponseEntity<Product> uploadImage(@PathVariable Long id,@RequestParam MultipartFile image) throws Exception{
		Product product=service.expect(id);
		product.setImagePath(fileService.save(image, "product/"+id));
		service.add(product);
		
		return ResponseEntity.ok().body(product);

	}
	
	

}
