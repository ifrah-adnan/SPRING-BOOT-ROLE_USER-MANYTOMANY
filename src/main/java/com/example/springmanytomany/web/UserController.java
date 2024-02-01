package com.example.springmanytomany.web;

import com.example.springmanytomany.entities.User;
import com.example.springmanytomany.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Dell Latitude 5420
 * IFRAH soumia
 **/
@RestController

public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("/users/{username}")
    public User user(@PathVariable String username){
    User user= userService.findUserByUsername(username);
    return  user;
    }
}
