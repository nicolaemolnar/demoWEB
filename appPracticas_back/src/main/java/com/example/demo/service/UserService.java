package com.example.demo.service;

import com.example.demo.repository.UserRepository;
import com.example.demo.model.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public boolean registerUser(String name, String password){
        //TODO: Cambiar a Optional (Dani :V)
        User saved = null;
        if (userRepository.findByName(name) == null){
            saved = userRepository.save(new User(name, password));
        }
        return saved != null;
    }

    public boolean logIn(String name, String password){
        User target = userRepository.findByName(name);

        if (target != null){
            return target.logIn(password);
        }
        return false;
    }

    public List<User> getUsers(){
        return userRepository.findAll();
    }

}
