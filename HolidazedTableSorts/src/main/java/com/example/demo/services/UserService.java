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
	public User getOneByEmail(String email) {
		return this.uRepo.findByEmail(email);
	}
	public User registerUser(User user) {
		// generates a hash
		String hashed = BCrypt.hashpw(user.getUserPassword(), BCrypt.gensalt());
		// setting the hashed password on the users's password field
		user.setPassword(hashed);
		// now we are going to commit the user /w hashed password to the db
		return this.uRepo.save(user);
	}
	public boolean authenticateUser(String email, String password) {
		// make sure the user loggin in is WHO THEY SAY THEY ARE
		User user = this.uRepo.findByEmail(email);
		// is the email sent from the form in the db??
		if(user == null) {
			return false;
		}
		return BCrypt.checkpw(password, user.getPassword());
	}
}
