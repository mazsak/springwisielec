package com.example.demo.Service;


import com.example.demo.models.Word;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WordService implements IWordService {

    @Autowired
    private IWordRepo iWordRepo;

    @Override
    public boolean add(Word word) {

        Word check = iWordRepo.save(word);
        if(check!=null){
            return true;
        }
        return false;
    }

    @Override
    public List<Word> findAll() {
        return (List<Word>) iWordRepo.findAll();
    }

}
