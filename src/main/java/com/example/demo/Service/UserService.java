package com.example.demo.Service;

import models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {
    @Autowired
    private IUserRepo iUserRepo;

    @Override
    public boolean add(User user) {

        User check = iUserRepo.save(user);
        if(check!=null){
            return true;
        }
        return false;
    }

    @Override
    public List<User> findAll() {
        return (List<User>) iUserRepo.findAll();
    }

    @Override
    public User findUserByName(String name) {
        return iUserRepo.findUserByName(name);
    }
}
