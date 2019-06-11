package com.example.demo.Service;

import models.User;

import java.util.List;

public interface IUserService {
    boolean add(User student);
    List<User> findAll();
    User findUserByName(String indeks);
}
