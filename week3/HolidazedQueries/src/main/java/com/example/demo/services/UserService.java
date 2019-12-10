package com.example.demo.services;

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
}
