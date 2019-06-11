package com.example.demo.controller;


import com.example.demo.Service.IWordRepo;
import com.example.demo.Service.IWordService;
import com.example.demo.models.Word;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    @Autowired
    private IWordService iWordService;

    @GetMapping(value = "/word", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    List<Word> getWords() {
        return iWordService.findAll();
    }


}
