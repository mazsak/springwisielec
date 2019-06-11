package com.example.demo.Service;


import com.example.demo.models.Word;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IWordRepo extends CrudRepository<Word, Long> {
}