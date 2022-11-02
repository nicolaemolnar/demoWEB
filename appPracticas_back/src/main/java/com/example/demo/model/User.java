package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import javax.persistence.Id;

@Entity
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String password;

    public User(){}

    public User(String name, String password){
        this.name = name;
        this.password = password;
    }

    public long getID(){ return this.id; }

    public String getName(){ return this.name; }

    public String getPassword(){ return this.password; }

    public long setID(long id) { return this.id = id; }

    public String setName(String name){ return this.name = name; }

    public String setPassword(String password){ return this.password = password; }

    public boolean logIn(String password){
        return this.password.equals(password);
    }

    public String toString(){
        return "ID: " + this.id + " Name: " + this.name + " Password: *********";
    }
}