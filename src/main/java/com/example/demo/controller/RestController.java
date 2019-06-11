package com.example.demo.controller;


import com.example.demo.Service.IWordRepo;
import com.example.demo.Service.IWordService;
import com.example.demo.models.Word;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.spel.ast.NullLiteral;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    @Autowired
    private IWordService iWordService;

    @GetMapping(value = "/word", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    List<Word> addWord(@RequestParam (required = false) String word, @RequestParam (required = false) String language) {

        if(word != null && language != null){
            if(language.equals("eng"))
                language = "English";
            else
                language = "Polish";
        iWordService.add(new Word(word, language));
        }

        return iWordService.findAll();
    }

}

