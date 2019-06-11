package com.example.demo.Service;

import com.example.demo.models.User;

import java.util.List;

public interface IUserService {
    boolean add(User student);
    List<User> findAll();
    User findUserByName(String indeks);
}
