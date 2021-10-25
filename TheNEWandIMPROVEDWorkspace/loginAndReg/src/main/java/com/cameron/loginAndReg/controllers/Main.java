package com.cameron.loginAndReg.controllers;

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

import com.cameron.loginAndReg.models.User;
import com.cameron.loginAndReg.services.UserService;
import com.cameron.loginAndReg.validators.UserValidator;

@Controller
public class Main {
	@Autowired
	private UserService uService;
	@Autowired
	private UserValidator validator;
	
	@GetMapping("/")										
	public String Index(@ModelAttribute("user")User thisUser){											
		return "index.jsp";								
		}
	
	@PostMapping("/register")
	public String registerUser(@Valid @ModelAttribute("user")User user, BindingResult result, HttpSession session) {
		validator.validate(user, result);
		System.out.println("Pass: "+user.getPassword());
		System.out.println("ConfPass: "+user.getConfirmPassword());
		if (result.hasErrors()) {
			return "index.jsp";
		}
		User newUser = this.uService.registerUser(user);
		session.setAttribute("user_id", newUser.getId());
		return "redirect:/landing";
	}
	@PostMapping("/login")
	public String loginUser(@RequestParam("loginEmail")String email, @RequestParam("loginPassword")String password, RedirectAttributes redirectAttrs, HttpSession session) {
		if(!this.uService.authenticateUser(email, password)) {
			redirectAttrs.addFlashAttribute("loginError", "Email or Password Invalid");
			return "redirect:/";
		}
		User user = this.uService.getByEmail(email);
		session.setAttribute("user_id", user.getId());
		return "redirect:/landing";
	}
	@GetMapping("/landing")
	public String landingPage(HttpSession session, Model viewModel) {
		Long userId = (Long)session.getAttribute("user_id");
		if(userId != null) {
			User currentUser = this.uService.getById(userId);
			viewModel.addAttribute("currentUser", currentUser);
			return "landing.jsp";
		}
		return "redirect:/";
		
	}
	@GetMapping("/logout")
	public String logout(HttpSession session) {
			session.invalidate();
			return "redirect:/";
	}
}
