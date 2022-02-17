package com.cameronsmith.exam.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cameronsmith.exam.models.Idea;
import com.cameronsmith.exam.models.User;
import com.cameronsmith.exam.services.IdeaService;
import com.cameronsmith.exam.services.UserService;
import com.cameronsmith.exam.validators.UserValidator;

@RestController
public class MainController {
	@Autowired
	private UserService uService;
	@Autowired
	private IdeaService iService;
	@Autowired
	private UserValidator validator;
	
	@GetMapping("/")
	public String loginAndReg(@ModelAttribute("user")User user) {
		return "loginReg.jsp";
	}
	@PostMapping("/register")
	public String registerUser(@Valid @ModelAttribute("user")User user, BindingResult result, HttpSession session) {
		validator.validate(user, result);
		if (result.hasErrors()) {
			return "loginReg.jsp";
		}
		User newUser = this.uService.registerUser(user);
		session.setAttribute("user_id", newUser.getId());
		return "redirect:/welcome";
	}
	@PostMapping("/login")
	public String loginUser(@RequestParam("loginEmail")String email, @RequestParam("loginPassword")String password, RedirectAttributes redirectAttrs, HttpSession session) {
		if(!this.uService.authenticateUser(email, password)) {
			redirectAttrs.addFlashAttribute("loginError", "Invalid Credantials");
			return "redirect:/";
		}
		User user = this.uService.getByEmail(email);
		session.setAttribute("user_id", user.getId());
		return "redirect:/welcome";
	}
	@GetMapping("/welcome")
	public String allEvents( HttpSession session, Model viewModel) {
		Long userId = (Long)session.getAttribute("user_id");
		if(userId == null) {
			return "redirect:/";
		}
		User currentUser = this.uService.getById(userId);
		viewModel.addAttribute("currentUser", currentUser);
		List<Idea> allIdeas = this.iService.getAll();
		viewModel.addAttribute("allIdeas", allIdeas);
		return "index.jsp";
	}
	@GetMapping("/logOutUser")
	public String logOut(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	@GetMapping("/idea/new")
	public String newIdea(@ModelAttribute("idea")Idea ideaInput, HttpSession session, Model viewModel) {
		Long userId = (Long)session.getAttribute("user_id");
		User currentUser = this.uService.getById(userId);
		viewModel.addAttribute("currentUser", currentUser);
		return "create.jsp";
	}
	@PostMapping("/idea/new")
	public String createIdea(@Valid @ModelAttribute("idea")Idea ideaInput, BindingResult result, HttpSession session, Model viewModel) {
		Long userId = (Long)session.getAttribute("user_id");
		User currentUser = this.uService.getById(userId);
		viewModel.addAttribute("currentUser", currentUser);
		if (result.hasErrors()) {
			return "create.jsp";
		}
		this.iService.createEntry(ideaInput);
		return "redirect:/welcome";
	}
	@GetMapping("/idea/{id}/like")
	public String like(@PathVariable("id")Long ideaId, HttpSession session) {
		Long userId = (Long)session.getAttribute("user_id");
		User currentUser = this.uService.getById(userId);
		Idea ideaToLike = this.iService.getById(ideaId);
		this.iService.like(ideaToLike, currentUser);
		return "redirect:/welcome";
	}
	@GetMapping("/idea/{id}/unLike")
	public String unLike(@PathVariable("id")Long ideaId, HttpSession session) {
		Long userId = (Long)session.getAttribute("user_id");
		User currentUser = this.uService.getById(userId);
		Idea ideaToLike = this.iService.getById(ideaId);
		this.iService.unlike(ideaToLike, currentUser);
		return "redirect:/welcome";
	}
	@GetMapping("/idea/{id}/info")
	public String info(@PathVariable("id")Long ideaId, Model viewModel, HttpSession session) {
		Idea ideaToShow = this.iService.getById(ideaId);
		viewModel.addAttribute("idea", ideaToShow);
		List<User> usersWhoLikeThisIdea = this.iService.getById(ideaId).getUsersWhoLike();
		viewModel.addAttribute("likers", usersWhoLikeThisIdea);
		Long userId = (Long)session.getAttribute("user_id");
		User currentUser = this.uService.getById(userId);
		viewModel.addAttribute("currentUser", currentUser);
		return "info.jsp";
	}
	@GetMapping("/idea/{id}/edit")
	public String edit(@PathVariable("id")Long ideaId,@ModelAttribute("idea")Idea ideaInput, Model viewModel, HttpSession session) {
		Idea ideaToEdit = this.iService.getById(ideaId);
		Long userId = (Long)session.getAttribute("user_id");
		User currentUser = this.uService.getById(userId);
		User ideaCreator = ideaToEdit.getIdeaCreator();
		if(ideaCreator != currentUser) {
			return "redirect:/welcome";
		}
		viewModel.addAttribute("thisIdea", ideaToEdit);
		return "edit.jsp";
	}
	@PostMapping("/idea/{id}/edit")
	public String editIdea(@Valid @ModelAttribute("idea")Idea ideaInput, BindingResult result, @PathVariable("id")Long ideaId, Model viewModel, HttpSession session) {
		Idea ideaToEdit = this.iService.getById(ideaId);
		viewModel.addAttribute("thisIdea", ideaToEdit);
		if (result.hasErrors()) {
			viewModel.addAttribute("thisIdea", ideaToEdit);
			return "edit.jsp";
		}
		this.iService.createEntry(ideaInput);
		return "redirect:/welcome";
	}
	@GetMapping("/idea/high")
	public String highLikes( Model viewModel, HttpSession session){
		List<Idea> popular = this.iService.ideasByLikesDesc();
		viewModel.addAttribute("popular", popular);
		Long userId = (Long)session.getAttribute("user_id");
		User currentUser = this.uService.getById(userId);
		viewModel.addAttribute("currentUser", currentUser);
		return "high.jsp";
	}
	@GetMapping("/idea/low")
	public String lowLikes( Model viewModel, HttpSession session){
		List<Idea> unpopular = this.iService.ideasByLikesAsc();
		viewModel.addAttribute("unpopular", unpopular);
		Long userId = (Long)session.getAttribute("user_id");
		User currentUser = this.uService.getById(userId);
		viewModel.addAttribute("currentUser", currentUser);
		return "low.jsp";
	}
	@GetMapping("/idea/{id}/delete")
	public String deleteIdea(@PathVariable("id")Long ideaId, HttpSession session) {
		Idea ideaToEdit = this.iService.getById(ideaId);
		Long userId = (Long)session.getAttribute("user_id");
		User currentUser = this.uService.getById(userId);
		User ideaCreator = ideaToEdit.getIdeaCreator();
		if(ideaCreator != currentUser) {
			return "redirect:/welcome";
		}
		this.iService.deleteById(ideaId);
		return "redirect:/welcome";
	}
}