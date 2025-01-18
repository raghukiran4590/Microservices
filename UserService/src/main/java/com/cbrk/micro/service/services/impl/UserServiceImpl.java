package com.cbrk.micro.service.services.impl;

import com.cbrk.micro.service.entities.User;
import com.cbrk.micro.service.exceptions.ResourceNotFoundException;
import com.cbrk.micro.service.repository.UserRepository;
import com.cbrk.micro.service.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        String randomUUID = UUID.randomUUID().toString();
        user.setUserId(randomUUID);
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User findUser(String UserId) {
        return userRepository.findById(UserId).orElseThrow(() ->
                new ResourceNotFoundException("User with the given Id is not found "+UserId));
    }
}
