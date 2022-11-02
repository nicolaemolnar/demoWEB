package com.example.demo.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.model.User;
import com.example.demo.controller.DTO.AuthDTO;
import com.example.demo.controller.DTO.UserDTO;
import com.example.demo.service.UserService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/users")
public class UserController{

    
    @Autowired
    private UserService userService;

   
    @GetMapping("")
    public List<UserDTO> getUsers(){
        List<User> users = userService.getUsers();
        List<UserDTO> usersDTO = new ArrayList<UserDTO>();
        for (User user : users){
            usersDTO.add(new UserDTO(user));
        }
        return usersDTO;
    }

    @PostMapping("")
    public ResponseEntity<String> addUser(@RequestBody AuthDTO authDTO){
        if (userService.registerUser(authDTO.getName(), authDTO.getPassword())){
            throw new ResponseStatusException(HttpStatus.CREATED, "User created successfully");
        }else {
            throw new ResponseStatusException(HttpStatus.OK, "User already exists");
        }
    }

    @PostMapping("/login")
    public boolean logIn(@RequestBody AuthDTO authDTO){
        return userService.logIn(authDTO.getName(), authDTO.getPassword());
    }
}