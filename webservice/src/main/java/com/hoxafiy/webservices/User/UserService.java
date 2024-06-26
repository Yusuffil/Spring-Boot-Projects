package com.hoxafiy.webservices.User;

import com.hoxafiy.webservices.User.exception.NotUniqueEmailException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public void save(User user) {
        try {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            user.setActivationToken(UUID.randomUUID().toString());

            userRepository.save(user);
        }
        catch (DataIntegrityViolationException ex){
            throw new NotUniqueEmailException();
        }

    }
}
