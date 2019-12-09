package com.example.demo.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.models.Monster;
import com.example.demo.models.User;
import com.example.demo.services.MonsterService;
import com.example.demo.services.UserService;

//@RequestMapping("/monsters")
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
	// GETS ALL /
	@RequestMapping("/")
	public String Index(Model viewModel) {
		List<Monster> myMonsters = this.mService.getAllMonsters();
		User theUser = this.uService.getOne(userId);
		viewModel.addAttribute("monsters", myMonsters);
		viewModel.addAttribute("user", theUser);
		return "index.jsp";
	}
	
	//@RequestMapping(value="/", method=RequestMethod.POST)
	@PostMapping("/")
	public String Create(@Valid @ModelAttribute("monster") Monster monster, BindingResult result) {
		if(result.hasErrors()) {
			// if there are validation errors:
			// we want to return DIRECTLY to the view
			return "new.jsp";
		}
		// if no errors:
		// we CREATE a monster!
		Monster newMonster = this.mService.create(monster);
		return "redirect:/" + newMonster.getId();
	}
	// NEW /news
	@RequestMapping("/new")
	public String New(@ModelAttribute("monster") Monster monster) {
		return "new.jsp";
	}
	// GET ONE /id
	@RequestMapping("/{id}")
	public String Show(@PathVariable Long id, Model viewModel) {
		Monster toShow = this.mService.getOne(id);
		if(toShow == null) {
			return "redirect:/";
		}
		viewModel.addAttribute("monster", toShow);
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
	@DeleteMapping("/{id}")
	public String Delete(@PathVariable("id") Long id) {
		// delete the monster from the db
		this.mService.delete(id);
		return "redirect:/";
	}
	//@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	@PutMapping("/{id}")
	public String Update(@Valid @ModelAttribute("monster") Monster monster, BindingResult result) {
		if(result.hasErrors()) {
			return "show.jsp";
		}
		this.mService.update(monster);
		return "redirect:/";
	}

}
