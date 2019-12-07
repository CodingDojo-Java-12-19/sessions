package com.example.demo.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.models.Monster;
import com.example.demo.services.MonsterService;

@Controller
public class HomeController {
	private MonsterService mService;
	public  HomeController(MonsterService service) {
		this.mService = service;
	}
	// @app.route('/')
	@RequestMapping("/")
	public String Index(Model viewModel) {
		List<Monster> myMonsters = this.mService.getAllMonsters();
		viewModel.addAttribute("monsters", myMonsters);
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
}
