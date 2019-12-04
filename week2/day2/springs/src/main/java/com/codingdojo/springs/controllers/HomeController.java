package com.codingdojo.springs.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String index(HttpSession session, Model model) {
		System.out.println("In home controller index");
		
		String personName = (String) session.getAttribute("name");
		
		model.addAttribute("personName", personName);
		
		System.out.println("person name from session is " + personName);
		
		return "index.jsp";
	}

	
	@RequestMapping(value="/names", method=RequestMethod.POST)
	public String create(@RequestParam("person_name") String nameFromParam, HttpSession session) {
		System.out.println("in home controller create " + nameFromParam);
		
		session.setAttribute("name", nameFromParam);
		
		return "redirect:/";
	}
}
