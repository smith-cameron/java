package com.codingdojo.api.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HomeController {
	@RequestMapping("/")
    public String hello() {
            return "Hello World!";
    }
	@RequestMapping("/world")
    public String world() {
            return "Class level annotations are cool too!";
    }
	@RequestMapping("/query")
    public String index(@RequestParam(value="q", required=false) String searchQuery, Model model) {
        return "You searched for: " + searchQuery;
    }
}
