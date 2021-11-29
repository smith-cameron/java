package com.cameronsmith.thecode.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class MasterController {
//	private Boolean codeInput(String input) {
//		return input.equals("bushido");
//	}
	@GetMapping("/")
	public String index(){
		return "index.jsp";
	}
	@PostMapping("/inputForm")
	public String form(@RequestParam(value="input")String input, RedirectAttributes errors) {
		if(input.equals("bushido")) {
			return "redirect:/code";			
		}
		errors.addFlashAttribute("error", "That is not The Way");
		return "redirect:/";
	}
	@GetMapping("/code")
	public String code() {
		return "code.jsp";
	}
}
