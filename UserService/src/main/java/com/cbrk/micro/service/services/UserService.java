package com.cbrk.micro.service.services;

import com.cbrk.micro.service.entities.User;

import java.util.List;

//User Operations
public interface UserService {


    //Create New User
    User saveUser(User user);

    //Find all users
    List<User> getAllUsers();

    //Find user by ID
    User findUser(String Id);

    //TODO - Update, Delete methods



}
