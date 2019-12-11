package com.example.demo.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.models.Monster;
import com.example.demo.models.User;
import com.example.demo.services.UserService;
import com.example.demo.validators.UserValidator;

@Controller
public class HomeController {
	@Autowired
	private UserService uService;
	@Autowired 
	private UserValidator validator;
	
	@GetMapping("/")
	public String Index(@ModelAttribute("user") User user) {
		return "home/index.jsp";
	}
	
	@PostMapping("")
	public String Create(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession sesh) {
		validator.validate(user, result);
		if(result.hasErrors()) {
			// if there are validation errors:
			// we want to return DIRECTLY to the view
			return "/home/index.jsp";
		}
		User newUser = this.uService.registerUser(user);
		// we can now set newUser.getId() in session!
		sesh.setAttribute("userId", newUser.getId());
		return "redirect:/monsters";
	}
}
