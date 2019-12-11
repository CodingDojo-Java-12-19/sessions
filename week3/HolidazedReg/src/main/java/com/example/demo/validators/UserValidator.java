package com.example.demo.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.example.demo.models.User;
import com.example.demo.repositories.UserRepository;

@Component
public class UserValidator implements Validator {
	
	@Autowired
	private UserRepository uRepo;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return User.class.equals(clazz);
	}
	
	@Override
	public void validate(Object target, Errors errors) {
		User user = (User)target;
		
		// Password doesn't match Confirm
		if(!user.getPasswordConfirm().equals(user.getUserPassword())) {
			errors.rejectValue("passwordConfirm", "Match", "sup no match!");
		}
		
		// Email already in database
		if(this.uRepo.existsByEmail(user.getEmail())) {
			errors.rejectValue("email", "Unique");
		}
		
		// funny validation! NO DEVON's
		if(user.getFirstName().toLowerCase().equals("devon")) {
			errors.rejectValue("firstName", "Devons");
		}
	}
}
