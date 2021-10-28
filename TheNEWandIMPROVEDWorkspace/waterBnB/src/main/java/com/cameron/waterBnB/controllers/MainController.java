package com.cameron.waterBnB.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.cameron.waterBnB.services.UserService;

@Controller
public class MainController {
	@Autowired
	private UserService uService;
	
	@GetMapping("/")
	public String index() {
		return "redirect:/dash";
	}
	@GetMapping("/dash")
	public String dashboard(HttpSession session, Model viewModel) {
		return "dash.jsp";
	}
}
