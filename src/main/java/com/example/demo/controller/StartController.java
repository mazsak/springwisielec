package com.example.demo.controller;

import com.example.demo.Service.IUserService;
import com.example.demo.Service.UserService;
import com.example.demo.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class StartController{

    @Autowired
    private IUserService userService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/language")
    public String language(@ModelAttribute("user") @Valid User user, BindingResult result, Model model) {
        if (result.hasErrors()){
            model.addAttribute("user", user);
            return "/login";
        }
        userService.add(user);
        return "language";
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/login")
    public String login(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }
}
