package com.spendit.user.api.controller;

import com.spendit.user.api.exception.InvalidValueException;
import com.spendit.user.api.model.User;
import com.spendit.user.api.service.UserService;
import com.spendit.user.api.util.UserValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {

    private final UserService userService;

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/user")
    public ResponseEntity<Void> saveUser(@RequestBody User user) {
        LOGGER.info("Saving User.");

        String email = user.getEmail();
        String username = user.getUsername();
        String password = user.getPassword();
        if (!UserValidator.isValidEmail(email)) {
            throw new InvalidValueException("Invalid email. Please enter the email in the format abc@abc.com.");
        }
        else if (!UserValidator.isValidUsername(username)) {
            throw new InvalidValueException("Invalid username. Please only use alphanumeric characters.");
        }
        else if (!UserValidator.isValidPassword(password)) {
            throw new InvalidValueException("Password length should be greater than 6 characters.");
        }
        userService.save(user);

        LOGGER.info("User saved successfully.");
        return ResponseEntity.ok().build();
    }
}
