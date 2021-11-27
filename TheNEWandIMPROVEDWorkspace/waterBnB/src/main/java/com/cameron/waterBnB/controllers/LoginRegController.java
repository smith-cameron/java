package com.cameron.waterBnB.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

@Controller
public class LoginRegController {
	@Autowired
	private UserService uService;
	@Autowired
	private UserValidator validator;
	
	@GetMapping("/login")
	public String login() {
		return "login.jsp";
	}
	
	@GetMapping("/register")
	public String reg(@ModelAttribute("user")User user, Model viewModel) {
		return "reg.jsp";
	} 
	
	@PostMapping("/registering")
	public String registerUser(@Valid @ModelAttribute("user")User user, BindingResult result, HttpSession session) {
		validator.validate(user, result);
		if (result.hasErrors()) {
			return "reg.jsp";
		}
		this.uService.registerUser(user);
		return "redirect:/login";
	}
	
	@PostMapping("/logging")
	public String loginUser(@RequestParam("loginEmail")String email, @RequestParam("loginPassword")String password, RedirectAttributes redirectAttrs, HttpSession session) {
		if(!this.uService.authenticateUser(email, password)) {
			redirectAttrs.addFlashAttribute("loginError", "Invalid Credantials");
			return "redirect:/login";
		}
		User user = this.uService.getByEmail(email);
		session.setAttribute("user_id", user.getId());
		return "redirect:/dash";
	}
	@GetMapping("/logOutUser")
	public String logOut(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
}
