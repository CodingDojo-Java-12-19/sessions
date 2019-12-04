package com.codingdojo.books.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@RequestMapping("/")
	public String index() {
		
		System.out.println("Home controller index -- redirecting");
		return "redirect:/books";
	}
}
