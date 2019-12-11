package com.example.demo.services;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.example.demo.models.User;
import com.example.demo.repositories.UserRepository;

@Service
public class UserService {
	private UserRepository uRepo;
	public UserService(UserRepository repo) {
		this.uRepo = repo;
	}
	public User getOne(Long id) {
		return this.uRepo.findById(id).orElse(null);
	}
	public User registerUser(User user) {
		String hashed = BCrypt.hashpw(user.getUserPassword(), BCrypt.gensalt());
		user.setPassword(hashed);
		return this.uRepo.save(user);
	}
	public boolean authenticateUser(String email, String password) {
		
		User user = this.uRepo.findByEmail(email);
		if(user == null) {
			return false;
		}
		return BCrypt.checkpw(password, user.getPassword());
	}
}
