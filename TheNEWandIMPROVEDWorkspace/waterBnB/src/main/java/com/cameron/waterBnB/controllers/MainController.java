package com.cameron.waterBnB.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.cameron.waterBnB.models.User;
import com.cameron.waterBnB.services.UserService;

@Controller
public class MainController {
	@Autowired
	private UserService uService;
	
	
	
	@GetMapping("/")
	public String index(HttpSession session, Model viewModel) {
		session.setAttribute("user_id", 0);
		int userId = (int)session.getAttribute("user_id");
		viewModel.addAttribute("currentUserId", userId);
		return "search.jsp";
	}
	@GetMapping("/dash")
	public String dashboard(HttpSession session, Model viewModel) {
		User currentUser = this.uService.getById((Long)session.getAttribute("user_id"));
		viewModel.addAttribute("user", currentUser);
		return "dash.jsp";
	}
}
