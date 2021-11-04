package com.cameron.loginAndReg.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import com.cameron.loginAndReg.models.User;
import com.cameron.loginAndReg.repositories.UserRepo;

@Component
public class UserValidator {
	@Autowired
	private UserRepo uRepo;
	
	public boolean supports(Class<?> clazz) {
		return User.class.equals(clazz);
	}
	public void validate(Object target, Errors errors) {
		User user = (User) target;
		if(!user.getPassword().equals(user.getConfirmPassword())) {
			errors.rejectValue("password", "Match", "Passwords Do Not Match.");
		}
		if(this.uRepo.existsByEmail(user.getEmail())) {
			errors.rejectValue("email", "unique", "Please Login.");
		}
	}

}
