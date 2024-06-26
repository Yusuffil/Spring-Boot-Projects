package com.hoxafiy.webservices.User.validation;

import com.hoxafiy.webservices.User.User;
import com.hoxafiy.webservices.User.UserRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, String> {
    @Autowired
    private UserRepository userRepository;


    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        User inDB = userRepository.findByEmail(value);
        if (inDB != null) {
            return false;
        } else {
            return true;
        }

    }
}
