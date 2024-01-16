package com.example.Social.Service;

import org.springframework.stereotype.Service;
import com.example.Social.Entity.Product;
import com.example.Social.Repository.ProductRepository;
import com.example.Social.Util.CrudService;

@Service
public class ProductService extends CrudService<Product>{
	
	private ProductRepository productRepository; 

	public ProductService(ProductRepository repository) {
		super(repository);
		this.repository=repository;
	}
	
	

}
