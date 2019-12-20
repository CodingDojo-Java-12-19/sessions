package com.example.demo.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.models.Ability;
import com.example.demo.models.Monster;
import com.example.demo.models.User;
import com.example.demo.services.MonsterService;
import com.example.demo.services.UserService;

@RequestMapping("/monsters")
@Controller
public class MonsterController {
	
	@Autowired
	private MonsterService mService;
	@Autowired
	private UserService uService;
	

	// @app.route('/')
	// GETS ALL /monsters
	@RequestMapping("")
	public String Index(Model viewModel, HttpSession sesh) {
		Long userId = (Long)sesh.getAttribute("userId");
		// make sure someone is ACKSHULLY logged in
		if(userId == null) {
			return "redirect:/";
		}
		
		List<Monster> myMonsters = this.mService.getAllMonsters();
		viewModel.addAttribute("monsters", myMonsters);
		User theUser = this.uService.getOne(userId);
		viewModel.addAttribute("user", theUser);
		return "/monsters/index.jsp";
	}
	
	//@RequestMapping(value="/", method=RequestMethod.POST)
	// POSTS TO /monsters
	@PostMapping("")
	public String Create(@Valid @ModelAttribute("monster") Monster monster, BindingResult result) {
		if(result.hasErrors()) {
			// if there are validation errors:
			// we want to return DIRECTLY to the view
			return "/monsters/new.jsp";
		}
		// if no errors:
		// we CREATE a monster!
		Monster newMonster = this.mService.create(monster);
		return "redirect:/monsters/" + newMonster.getId();
	}
	// NEW /news
	@RequestMapping("/new")
	public String New(@ModelAttribute("monster") Monster monster) {
		return "/monsters/new.jsp";
	}
	// GET ONE /id
	@RequestMapping("/{id}")
	public String Show(@PathVariable Long id, Model viewModel, @ModelAttribute("ability") Ability ability) {
		Monster toShow = this.mService.getOne(id);
		if(toShow == null) {
			return "redirect:/monsters";
		}
		viewModel.addAttribute("monster", toShow);
		return "/monsters/show.jsp";
	}
	@RequestMapping("/like/{id}")
	public String likeTheMonster(@PathVariable("id") Long id, HttpSession sesh) {
		Long userId = (Long)sesh.getAttribute("userId");
		// make sure someone is ACKSHULLY logged in
		if(userId == null) {
			return "redirect:/";
		}
		
		User thisUser = this.uService.getOne(userId);
		Monster thisMonster = this.mService.getOne(id);
		this.mService.likeUser(thisMonster, thisUser);
		return "redirect:/monsters";
	}
	
	@RequestMapping("/dislike/{id}")
	public String dislikeTheMonster(@PathVariable("id") Long id, HttpSession sesh) {
		Long userId = (Long)sesh.getAttribute("userId");
		// make sure someone is ACKSHULLY logged in
		if(userId == null) {
			return "redirect:/";
		}
		User thisUser = this.uService.getOne(userId);
		Monster thisMonster = this.mService.getOne(id);
		this.mService.dislikeUser(thisMonster, thisUser);
		return "redirect:/monsters";
	}
	@DeleteMapping("/{id}")
	public String Delete(@PathVariable("id") Long id) {
		// delete the monster from the db
		this.mService.delete(id);
		return "redirect:/monsters";
	}
	//@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	@PutMapping("/{id}")
	public String Update(@Valid @ModelAttribute("monster") Monster monster, BindingResult result) {
		if(result.hasErrors()) {
			return "/monsters/show.jsp";
		}
		this.mService.update(monster);
		return "redirect:/monsters";
	}
	
	@GetMapping("/search")
	public String SearchByName(@RequestParam("search") String search, Model viewModel, HttpSession sesh) {
		Long userId = (Long)sesh.getAttribute("userId");
		// make sure someone is ACKSHULLY logged in
		if(userId == null) {
			return "redirect:/";
		}
		
		List<Monster> filteredMonsters = this.mService.getMonstersByName(search);
		viewModel.addAttribute("monsters", filteredMonsters);
		User theUser = this.uService.getOne(userId);
		viewModel.addAttribute("user", theUser);
		return "/monsters/index.jsp";
	}
	@GetMapping("/sort/{query}")
	public String Sort(@PathVariable("query") String query, Model viewModel, HttpSession sesh) {
		Long userId = (Long)sesh.getAttribute("userId");
		User thisUser = this.uService.getOne(userId);
		viewModel.addAttribute("user", thisUser);
		viewModel.addAttribute("monsters", this.mService.getMonstersSortBy(query));
		return "/monsters/index.jsp";
	}
	@GetMapping("/order")
	public String OrderByPower(Model viewModel, HttpSession sesh) {
		Long userId = (Long)sesh.getAttribute("userId");
		// make sure someone is ACKSHULLY logged in
		if(userId == null) {
			return "redirect:/";
		}
		
		viewModel.addAttribute("monsters", this.mService.getMonstersOrderByTotalPower());
		User theUser = this.uService.getOne(userId);
		viewModel.addAttribute("user", theUser);
		return "/monsters/index.jsp";
	}
	
	// TODO Make Ability Controller!!
	@PostMapping("/abilities")
	public String CreateAbility(@Valid @ModelAttribute("ability") Ability ability, BindingResult result, Model viewModel) {
		if(result.hasErrors()) {
			viewModel.addAttribute("monster", ability.getMonster());
			return "/monsters/show.jsp";
		}
		this.mService.createAbility(ability);
		return "redirect:/monsters/" + ability.getMonster().getId();
	}

}
