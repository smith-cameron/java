package com.cameronsmith.secrets.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cameronsmith.secrets.models.Secret;
import com.cameronsmith.secrets.models.User;
import com.cameronsmith.secrets.services.SecretService;
import com.cameronsmith.secrets.services.UserService;
import com.cameronsmith.secrets.validators.UserValidator;

@Controller
public class MainController {
	@Autowired 
	private UserService uService;
	@Autowired
	private UserValidator validator;
	@Autowired
	private SecretService sService;
	
	
	@GetMapping("/")
	public String index(@ModelAttribute("user")User user) {
		return "index.jsp";
	}
	@PostMapping("/register")
	public String registerUser(@Valid @ModelAttribute("user")User user, BindingResult result, HttpSession session) {
		validator.validate(user, result);
		if (result.hasErrors()) {
			return "index.jsp";
		}
		User newUser = this.uService.registerUser(user);
		session.setAttribute("user_id", newUser.getId());
		return "redirect:/secrets";
	}
	@PostMapping("/login")
	public String loginUser(@RequestParam("loginEmail")String email, @RequestParam("loginPassword")String password, RedirectAttributes redirectAttrs, HttpSession session) {
		if(!this.uService.authenticateUser(email, password)) {
			redirectAttrs.addFlashAttribute("loginError", "Invalid Credantials");
			return "redirect:/";
		}
		User user = this.uService.getByEmail(email);
		session.setAttribute("user_id", user.getId());
		return "redirect:/secrets";
	}
	@GetMapping("/secrets")
	public String dashboard(@ModelAttribute("secret")Secret sInput, HttpSession session, Model viewModel) {
		Long userId = (Long)session.getAttribute("user_id");
		if(userId == null) {
			return "redirect:/";
		}
		User currentUser = this.uService.getById(userId);
		viewModel.addAttribute("user", currentUser);
		List<Secret> recent = this.sService.recentSecrets();
		viewModel.addAttribute("recent", recent);
		return "welcome.jsp";
	}
	@PostMapping("/secrets/new")
	public String newEvent(@Valid @ModelAttribute("secret")Secret sInput, BindingResult result, HttpSession session, Model viewModel) {
		Long userId = (Long)session.getAttribute("user_id");
		User currentUser = this.uService.getById(userId);
		List<Secret> recent = this.sService.recentSecrets();
		viewModel.addAttribute("user", currentUser);
		viewModel.addAttribute("recent", recent);
		if (result.hasErrors()) {
			viewModel.addAttribute("user", currentUser);
			viewModel.addAttribute("recent", recent);
			return "welcome.jsp";
		}
		this.sService.createEntry(sInput);
		return "redirect:/secrets";
	}
	
	@GetMapping("/logOutUser")
	public String logOut(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	@DeleteMapping("/secrets/{id}/delete")
	public String deleteEvent(@PathVariable("id")Long secretId) {
		this.sService.deleteById(secretId);
		return "redirect:/secrets";
	}
	@GetMapping("/secrets/{id}/like")
	public String likeSecret(@PathVariable("id")Long secretId, HttpSession session) {
		Long userId = (Long)session.getAttribute("user_id");
		User currentUser = this.uService.getById(userId);
		Secret secretToLike = this.sService.getEntryById(secretId);
		this.sService.likeSecret(secretToLike, currentUser);
		return "redirect:/secrets";
	}
	@GetMapping("/secrets/{id}/unLike")
	public String unLikeSecret(@PathVariable("id")Long secretId, HttpSession session) {
		Long userId = (Long)session.getAttribute("user_id");
		User currentUser = this.uService.getById(userId);
		Secret secretToLike = this.sService.getEntryById(secretId);
		this.sService.unlikeSecret(secretToLike, currentUser);
		return "redirect:/secrets";
	}
	@GetMapping("/secrets/popular")
	public String OrderedByLikes(HttpSession session, Model viewModel) {
		Long userId = (Long)session.getAttribute("user_id");
		User currentUser = this.uService.getById(userId);
		List<Secret> allPopularSecrets = this.sService.secretsByLikes();
		viewModel.addAttribute("popular", allPopularSecrets);
		viewModel.addAttribute("user", currentUser);
		return "popularity.jsp";
	}
	@DeleteMapping("/secrets/popular/{id}/delete")
	public String deleteEvent2(@PathVariable("id")Long secretId) {
		this.sService.deleteById(secretId);
		return "redirect:/secrets/popular";
	}
	@GetMapping("/secrets/popular/{id}/like")
	public String likeSecret2(@PathVariable("id")Long secretId, HttpSession session) {
		Long userId = (Long)session.getAttribute("user_id");
		User currentUser = this.uService.getById(userId);
		Secret secretToLike = this.sService.getEntryById(secretId);
		this.sService.likeSecret(secretToLike, currentUser);
		return "redirect:/secrets/popular";
	}
	@GetMapping("/secrets/popular/{id}/unLike")
	public String unLikeSecret2(@PathVariable("id")Long secretId, HttpSession session) {
		Long userId = (Long)session.getAttribute("user_id");
		User currentUser = this.uService.getById(userId);
		Secret secretToLike = this.sService.getEntryById(secretId);
		this.sService.unlikeSecret(secretToLike, currentUser);
		return "redirect:/secrets/popular";
	}
}
