package com.example.demo.controller.DTO;

import com.example.demo.model.User;

public class UserDTO{
    private long _id;
    private String _name;

    public UserDTO(User user){
        this._id = user.getID();
        this._name = user.getName();
    }

    public long getID(){ return this._id; }

    public String getName(){ return this._name; }
}