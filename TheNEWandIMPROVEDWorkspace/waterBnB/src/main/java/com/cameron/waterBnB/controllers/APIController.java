package com.cameron.waterBnB.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cameron.waterBnB.models.User;
import com.cameron.waterBnB.services.UserService;

@RestController
@RequestMapping("/api")
public class APIController {
	@Autowired
	private UserService uService;
	
	@RequestMapping("/users")
    public List<User> index() {
        return uService.getAll();
    }
    
    @PostMapping(value="/users")
    public User create(@RequestParam(value="email") String email, @RequestParam(value="firstName") String firstName, @RequestParam(value="lastName") String lastName, @RequestParam(value="password") String password, @RequestParam(value="confirmPassword") String confirmPassword) {
    	User newUser = new User(email, firstName, lastName, password, confirmPassword);
    	return uService.registerUser(newUser);
    }
    
    @RequestMapping("/users/{id}")
    public User show(@PathVariable("id") Long id) {
        return uService.getById(id);
    }
    @PutMapping(value="/users/{id}")
    public User update(@PathVariable("id") Long id, @RequestParam(value="email") String email, @RequestParam(value="firstName") String firstName, @RequestParam(value="lastName") String lastName, @RequestParam(value="password") String password, @RequestParam(value="confirmPassword") String confirmPassword) {
    	User thisUser = this.uService.getById(id);
    	thisUser.setEmail(email);
    	thisUser.setFirstName(firstName);
    	thisUser.setLastName(lastName);
    	thisUser.setConfirmPassword(confirmPassword);
        return this.uService.updateEntry(thisUser);
    }
    
    @DeleteMapping(value="/users/{id}")
    public void destroy(@PathVariable("id") Long id) {
    	uService.deleteById(id);
    }
}
