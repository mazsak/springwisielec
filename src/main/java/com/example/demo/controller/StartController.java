package com.example.demo.controller;

import com.example.demo.Service.IUserService;
import com.example.demo.Service.IWordService;
import com.example.demo.models.User;
import com.example.demo.models.Word;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
public class StartController {

    @Autowired
    private IUserService userService;

    @Autowired
    private IWordService iWordService;

    private String name;
    private String word;
    private List<String> dashs;
    private int score;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/language")
    public String language(@ModelAttribute("user") @Valid User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("user", user);
            return "/login";
        }
        User userDatabase = userService.findUserByName(user.getName());
        if (userDatabase != null) {
            if (userDatabase.getPassword().equals(user.getPassword())) {
                return "language";
            }
        }
        return "login";
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @GetMapping("/login")
    public String loginGet(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute("user") @Valid User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("user", user);
            return "/register";
        }
        userService.add(user);

        return "login";
    }

    @GetMapping("/addword")
    public String addword(Model model) {
        model.addAttribute("word", new Word());
        return "addword";
    }

    @GetMapping("/game")
    public String game(@Value("lang") String lang, Model model) {
        String language;
        if (lang.equals("eng"))
            language = "English";
        else
            language = "Polish";

        List<Word> words = iWordService.findByLanguage(language);

        Random rand = new Random();

        int index = rand.nextInt(words.size() - 1);


        word = words.get(index).getWord();

        dashs = new ArrayList<>();

        for (int i = 0; i < words.get(index).getWord().length(); i++) {
            dashs.add(" _ ");
        }

        score = 10;

        model.addAttribute("dashs", dashs);
        model.addAttribute("score", score);

        return "game";
    }

    @GetMapping("/gameloop")
    public String gameloop(@RequestParam("letter") String letter, Model model) {

        boolean isLetter = false;

        for (int i = 0; i < word.length(); i++) {
            System.out.println("dupa1  " + letter.charAt(0) + " " + word);
            if (word.charAt(i) == letter.charAt(0)) {
                dashs.set(i, String.valueOf(letter.charAt(0)));

                isLetter = true;
            }
        }

        if (isLetter) {
            score += 2;
        } else {
            score -= 2;
        }

        model.addAttribute("dashs", dashs);
        model.addAttribute("score", score);

        return "game";
    }

}
