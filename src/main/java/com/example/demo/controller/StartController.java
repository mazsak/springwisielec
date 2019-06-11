package com.example.demo.controller;

import com.example.demo.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StartController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/language")
    public String language() {
        return "language";
    }

    @PostMapping("/register")
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
