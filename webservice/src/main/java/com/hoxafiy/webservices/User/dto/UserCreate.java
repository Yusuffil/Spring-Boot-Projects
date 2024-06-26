package com.hoxafiy.webservices.User.dto;

import com.hoxafiy.webservices.User.User;
import com.hoxafiy.webservices.User.validation.UniqueEmail;
import jakarta.validation.constraints.*;

public record UserCreate(

@Size(min=4, max = 255)
String username,

@NotBlank
@Email
@UniqueEmail
String email,

@Size(min=8,max = 255)
@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).*$", message = "{hoaxify.constraint.password.pattern}")
String password

) {
        public User toUser(){
              User user = new User();
              user.setEmail(email);
              user.setPassword(password);;
              user.setUsername(username);
              return user;
        }

}
