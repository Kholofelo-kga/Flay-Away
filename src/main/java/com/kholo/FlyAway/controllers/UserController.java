package com.kholo.FlyAway.controllers;
import com.kholo.FlyAway.models.User;
import com.kholo.FlyAway.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/users/all")
    public String getAllUsers(Model model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "users";
    }

  
}