package com.example.demo.Service;

import com.example.demo.models.Word;

import java.util.List;

public interface IWordService {
    boolean add(Word student);
    List<Word> findAll();
}
