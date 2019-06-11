package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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
}
