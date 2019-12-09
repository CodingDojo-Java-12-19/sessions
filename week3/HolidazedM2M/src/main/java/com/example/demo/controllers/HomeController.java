package com.example.demo.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.models.Monster;
import com.example.demo.models.User;
import com.example.demo.services.MonsterService;
import com.example.demo.services.UserService;

@Controller
public class HomeController {
	private MonsterService mService;
	private UserService uService;
	// temporary "session" id for a user
	private static Long userId = 1L;
	
	public HomeController(MonsterService service, UserService uService) {
		this.mService = service;
		this.uService = uService;
	}
	// @app.route('/')
	@RequestMapping("/")
	public String Index(Model viewModel) {
		List<Monster> myMonsters = this.mService.getAllMonsters();
		User theUser = this.uService.getOne(userId);
		viewModel.addAttribute("monsters", myMonsters);
		viewModel.addAttribute("user", theUser);
		return "index.jsp";
	}
	@RequestMapping("/{id}")
	public String Show(@PathVariable Long id, Model viewModel) {
		Monster monster = this.mService.getOne(id);
		if(monster == null) {
			return "redirect:/";
		}
		viewModel.addAttribute("monster", monster);
		return "show.jsp";
	}
	@RequestMapping("/like/{id}")
	public String likeTheMonster(@PathVariable("id") Long id) {
		User thisUser = this.uService.getOne(userId);
		Monster thisMonster = this.mService.getOne(id);
		this.mService.likeUser(thisMonster, thisUser);
		return "redirect:/";
	}
	
	@RequestMapping("/dislike/{id}")
	public String dislikeTheMonster(@PathVariable("id") Long id) {
		User thisUser = this.uService.getOne(userId);
		Monster thisMonster = this.mService.getOne(id);
		this.mService.dislikeUser(thisMonster, thisUser);
		return "redirect:/";
	}

}
