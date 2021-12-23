package com.shawna.its_project.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import com.shawna.its_project.models.User;


@Component
public class UserValidator {

    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }
	
    public void validate(Object object, Errors errors) {
        User user = (User) object;
        
        if (!user.getPasswordConfirmation().equals(user.getPassword())) {
            // 3
            errors.rejectValue("passwordConfirmation", "Match");
        }         
    }
}
