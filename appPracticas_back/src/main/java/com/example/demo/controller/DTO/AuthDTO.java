package com.example.demo.controller.DTO;

import com.example.demo.model.User;

public class AuthDTO{
    private String name;
    private String password;

    public AuthDTO(String name, String password){
        this.name = name;
        this.password = password;
    }

    public String getName(){ return this.name; }

    public String getPassword(){ return this.password; }

    public void setName(String name){ this.name = name; }

    public void setPassword(String password){ this.password = password; }

    public User toUser(){
        return new User(this.name, this.password);
    }
}