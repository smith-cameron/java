package com.cameron.passGenerator.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.cameron.passGenerator.models.Password;
import com.cameron.passGenerator.services.PasswordService;

@Controller
public class MainController {
	@Autowired
	public PasswordService pService;
	
	@GetMapping("/")
	public String index(@ModelAttribute("password")Password password) {
		return "index.jsp";
	}
	@PostMapping("/create")
	public String generate(@ModelAttribute("password")Password password) {
		String newPass = this.pService.randomString(8);
		System.out.println("Controller: "+newPass);
		this.pService.create(newPass);
		return "redirect:/";
	}
	
}
