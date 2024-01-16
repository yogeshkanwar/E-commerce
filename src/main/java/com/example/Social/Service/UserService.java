package com.example.Social.Service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Social.Entity.User;
import com.example.Social.Repository.UserRepository;
import com.example.Social.Util.CrudService;

@Service
public class UserService extends CrudService<User>{
	private final  UserRepository repository;

	@Autowired
	public UserService(UserRepository repository) {
		super(repository);
		this.repository=repository;
	}
	
//    @Autowired
//    private PasswordEncoder passwordEncoder;

	public void register(User user) {
		User u=new User();
		u.setEmail(user.getEmail());
		u.setPassword(user.getPassword());
		add(u);
		
	}

	public Optional<User> getByUser(String userName) {
		return repository.findByEmailOrPhone(userName); 
	}
	

	

}
