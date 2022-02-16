package com.cameron.loginRegRevised.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.cameron.loginRegRevised.models.LoginUser;
import com.cameron.loginRegRevised.models.User;
import com.cameron.loginRegRevised.services.UserService;

@Controller
public class MainController {
	@Autowired 
	private UserService uService;
	
	@GetMapping("/")										
	public String Index(@ModelAttribute("newUser")User regUser,@ModelAttribute("newLogin")LoginUser loginUser){											
		return "index.jsp";									
	}
	@PostMapping("/register")
    public String register(@Valid @ModelAttribute("newUser") User newUser, BindingResult result, Model model, HttpSession session) {
        System.out.println(newUser.getPassword());
		User user = this.uService.register(newUser, result);
        if(result.hasErrors()) {
            model.addAttribute("newLogin", new LoginUser());
            return "index.jsp";
        }
//        System.out.println(user.getId());
        session.setAttribute("uId", user.getId());
        return "redirect:/home";
    }
    
    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, BindingResult result, Model model, HttpSession session) {
    	User user = this.uService.login(newLogin, result);
        if(result.hasErrors()) {
            model.addAttribute("newUser", new User());
            return "index.jsp";
        }
//        System.out.println(user.getId());
        session.setAttribute("uId", user.getId());
        return "redirect:/home";
    }
    @GetMapping("/home")
    public String dashboard(HttpSession session, Model viewModel) {
    	viewModel.addAttribute("currentUser", this.uService.getById((Long) session.getAttribute("uId")));
    	return "dash.jsp";
    }
    @GetMapping("/logout")
	public String logout(HttpSession session) {
			session.invalidate();
			return "redirect:/";
	}
}
