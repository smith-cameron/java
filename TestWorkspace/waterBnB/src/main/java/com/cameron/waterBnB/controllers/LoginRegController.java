package com.cameron.waterBnB.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cameron.waterBnB.models.User;
import com.cameron.waterBnB.services.UserService;
import com.cameron.waterBnB.validators.UserValidator;


public class LoginRegController {
	@Autowired
	private UserService uService;
	@Autowired
	private UserValidator validator;
	
	@GetMapping("/login")
	public String login(@ModelAttribute("user")User user, Model viewModel) {
		return "index.jsp";
	}
	
	@GetMapping("/register")
	public String reg(@ModelAttribute("user")User user, Model viewModel) {
		return "index.jsp";
	} 
	
	@PostMapping("/registering")
	public String registerUser(@Valid @ModelAttribute("user")User user, BindingResult result, HttpSession session) {
		validator.validate(user, result);
		if (result.hasErrors()) {
			return "index.jsp";
		}
		this.uService.registerUser(user);
		return "redirect:/login";
	}
	
	@PostMapping("/logging")
	public String loginUser(@RequestParam("loginEmail")String email, @RequestParam("loginPassword")String password, RedirectAttributes redirectAttrs, HttpSession session) {
		if(!this.uService.authenticateUser(email, password)) {
			redirectAttrs.addFlashAttribute("loginError", "Invalid Credantials");
			return "redirect:/guest/signIn";
		}
		User user = this.uService.getByEmail(email);
		session.setAttribute("user_id", user.getId());
		return "redirect:/dash";
	}
	
}
