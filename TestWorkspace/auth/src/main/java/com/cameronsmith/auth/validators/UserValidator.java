package com.cameronsmith.auth.validators;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.cameronsmith.auth.models.User;

public class UserValidator implements Validator {
    
    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }
    
    @Override
    public void validate(Object object, Errors errors) {
        User user = (User) object;
        if (!user.getPasswordConfirmation().equals(user.getPassword())) {
            errors.rejectValue("passwordConfirmation", "Match");
        }         
    }

}
