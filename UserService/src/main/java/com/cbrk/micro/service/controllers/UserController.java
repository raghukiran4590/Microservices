package com.cbrk.micro.service.controllers;

import com.cbrk.micro.service.entities.User;
import com.cbrk.micro.service.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    //Create User
    @PostMapping
    public ResponseEntity<User> createUser(User user) {
        User user1 = userService.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user1);
    }

    //Get Single User
    @GetMapping({"userId"})
    public ResponseEntity<User> getSingleUser(@PathVariable String userId) {
        User user = userService.findUser(userId);
        return ResponseEntity.ok(user);
    }

    //Get All Users
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> allUsers = userService.getAllUsers();
        return ResponseEntity.ok(allUsers);
    }


}
