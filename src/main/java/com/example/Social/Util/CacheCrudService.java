package com.example.Social.Util;

import java.util.Optional;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public abstract class CacheCrudService<T> extends CrudService<T>{
    
	public CacheCrudService(JpaRepository<T, Long> repository) {
		super(repository);
	}
	
	@Override
	public Optional<T> getById(Long id) {
		return super.getById(id);
	}
	
	@Override
	public T expect(Long id) throws Exception {
		return super.expect(id);
	} 
	
	@Override
	@CacheEvict(value="crud-list",key = "user")
	public T add(T type){  
		return super.add(type);
	}
	
	
	
	

}
