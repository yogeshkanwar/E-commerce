package com.example.Social.Service;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

	public List<Product> getAllProduct(Integer page, Integer size) {
		Sort sort = Sort.by("id").descending();
	    Pageable pageable = PageRequest.of(page, size,sort);
	    Page<Product> productPage = repository.findAll(pageable);
	    return productPage.getContent(); 
	}
	
	

}
