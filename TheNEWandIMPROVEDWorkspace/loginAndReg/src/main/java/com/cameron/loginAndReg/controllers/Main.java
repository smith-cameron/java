package com.cameron.loginAndReg.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.cameron.loginAndReg.models.User;
import com.cameron.loginAndReg.services.UserService;

@Controller
public class Main {
	@Autowired
	private UserService uService;
	
	@GetMapping("/")										
	public String Index(@ModelAttribute("user")User thisUser){											
		return "index.jsp";								
		}

}
