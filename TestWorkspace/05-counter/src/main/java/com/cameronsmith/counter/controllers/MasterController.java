package com.cameronsmith.counter.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MasterController {
	public Integer getCount(HttpSession session){
        if(session.getAttribute("count") == null) {
            session.setAttribute("count", 0);
        }
         return (Integer) session.getAttribute("count");
    }
	
	public void setCount(HttpSession session, Integer currentCount) {
		session.setAttribute("count", currentCount);
	}
	
	@GetMapping("/")
	public String index(HttpSession session) {
		Integer count = getCount(session);
		count +=1;
		setCount(session, count);
		return "index.jsp";
	}
	
	@GetMapping("/counter")
	public String count(HttpSession session, Model viewModel){
		Integer currentCount = (Integer) session.getAttribute("count");
		viewModel.addAttribute("count", currentCount);
        return "counter.jsp";
    }
	
	@GetMapping("/reset")
	public String reset(HttpSession session) {
		session.invalidate();
		return "redirect:/counter";
	}
	
	@GetMapping("/twice")
	public String index2(HttpSession session) {
		Integer count = (Integer) session.getAttribute("count");
		count +=2;
		setCount(session, count);
		return "index.jsp";
	}
}
