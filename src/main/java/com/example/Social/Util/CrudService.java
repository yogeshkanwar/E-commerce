package com.example.Social.Util;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public abstract class CrudService<T> {
	
	protected JpaRepository<T,Long> repository;
	
	public CrudService(JpaRepository<T,Long> repository) {
		this.repository=repository;
	}
	
	public T add(T type){
		return repository.save(type);
	}
	
	public Optional<T> getById(Long id){
		return repository.findById(id);
	}
	
	public T expect(Long id) throws Exception{
		Optional<T> optional=getById(id);
		if(!optional.isPresent())
			throw new Exception("Invalid id");
		
		return optional.get(); 		
	}

}
